package com.travala.authentication.interceptors;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.ContentCachingResponseWrapper;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

@Component
public class LoggingInterceptor implements HandlerInterceptor {

    private final Logger logger = Logger.getLogger(LoggingInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info(String.format("%s : %s", request.getMethod(), request.getRequestURL().toString()));
        logger.info("Params: " + new ObjectMapper().writeValueAsString(request.getParameterMap()));
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.info(String.format("RESTPONSE %s : %s ", request.getMethod(), request.getRequestURL().toString()));

        if (request.getMethod().equals("OPTIONS")) {
            response.setStatus(HttpStatus.OK.value());
        }
//        else {
//            logger.info(request.getMethod() + ":" + request.getRequestURL());
//            logger.info("with autho:" + request.getHeader("authorization"));
//        }
        logger.info(String.format("Response Code: %s", response.getStatus()));

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        logger.info(String.format("Response : %s", getResponsePayload(response)) + " with status:" + response.getStatus());

    }

    private String getResponsePayload(HttpServletResponse response) {
        ContentCachingResponseWrapper wrapper = WebUtils.getNativeResponse(response, ContentCachingResponseWrapper.class);
        if (wrapper != null) {

            byte[] buf = wrapper.getContentAsByteArray();
            if (buf.length > 0) {
                int length = Math.min(buf.length, 5120);
                try {
                    String response_payload = new String(buf, 0, length, wrapper.getCharacterEncoding());

                    logger.info("response_payload:" + response_payload);

                    return response_payload;
                } catch (UnsupportedEncodingException ex) {
                    logger.error(ex.getMessage(), ex);
                    // NOOP
                }
            }
        }
//        else {
//            logger.info("wrapper is null --> status = " + response.getStatus());
//        }

        return "[unknown]";
    }

}
