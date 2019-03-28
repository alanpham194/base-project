package com.travala.authentication.interceptors;

import com.travala.authentication.exceptions.AuthenticateException;
import commons.client.AuthenHelper;
import commons.dto.UserDTO;
import commons.utils.Messages;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashSet;

@Component
public class AuthenticateInterceptor implements HandlerInterceptor {

    private Logger logger = Logger.getLogger(AuthenticateInterceptor.class);
    @Autowired
    private AuthenHelper authenHelper;
    @Value("${API_KEY}")
    private String apiKey;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //check if url is private
        if (request.getRequestURL().toString().contains("private")) {
            String api_key = request.getHeader("api-key");
            if (api_key == null || !api_key.equals(apiKey)) {
                throw new AuthenticateException(Messages.UNAUTHOZIRED);
            }
            return true;
        }

        if ((request.getRequestURL().toString().endsWith("referral") || request.getRequestURL().toString().endsWith("referral/")) && request.getMethod().equals("GET")) {
            String token = request.getHeader("authorization");
            if (token == null) {
                throw new AuthenticateException(Messages.UNAUTHOZIRED);
            }
            UserDTO userDTO = authenHelper.authenticate(token);
            if (userDTO == null) {
                throw new AuthenticateException(Messages.UNAUTHOZIRED);
            }
            request.setAttribute("user_id", userDTO.getUserId());
        }

        if (request.getRequestURL().toString().contains("smart/request") && (request.getMethod().equals("GET") || request.getMethod().equals("POST"))
                || request.getRequestURL().toString().contains("user-smart-info")) {

//            Enumeration<String> hNames = request.getHeaderNames();
//            while (hNames.hasMoreElements()) {
//                String header = hNames.nextElement();
//
//                System.out.println("Header Name:" + header);
//                Logger.getLogger(AuthenticateInterceptor.class).info("Header Name:" + header);
//            }
            String token = request.getHeader("authorization");
//            HttpH
            if (token == null) {
                logger.info("authorization Not Found ===============");
                throw new AuthenticateException(Messages.UNAUTHOZIRED);
            }
            UserDTO userDTO = authenHelper.authenticate(token);
            if (userDTO == null) {
                logger.info("User Not Found ===============");
                throw new AuthenticateException(Messages.UNAUTHOZIRED);
            }
            request.setAttribute("user_id", userDTO.getUserId());
            request.setAttribute("user_name", userDTO.getFirstName());
            request.setAttribute("user_email", userDTO.getEmail());
        }
        return true;
    }

    private HashSet<String> authenticateURL() {
        HashSet<String> urls = new HashSet<>();
        urls.add("referral");
        return urls;
    }
}
