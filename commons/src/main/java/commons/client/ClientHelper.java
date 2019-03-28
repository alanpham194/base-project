package commons.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import commons.dto.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.LogManager;

@Component
public class ClientHelper {

    private static final Logger logger = LoggerFactory.getLogger(ClientHelper.class);
    @Value("${private_key_payment}")
    private String secretKeyPaymentGateway;
    @Value("${private_key_user}")
    private String secretKeyUser;

    public HttpHeaders getDefaultHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("api-key", secretKeyUser);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        return headers;
    }

    public HttpHeaders getPaymentGatewayHeaders() {
        HttpHeaders headers = getDefaultHeaders();
        headers.add("authorization", "private_key " + secretKeyPaymentGateway);
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        List<MediaType> accepts = new ArrayList<>();
        accepts.add(MediaType.APPLICATION_JSON);
        headers.setAccept(accepts);

        return headers;
    }

    public <T> T callRest(String url, String method, String params, HttpEntity entity, Class<T> tClass) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters()
                .add(0, new StringHttpMessageConverter(Charset.forName("latin1")));
        if (entity == null) {
            entity = new HttpEntity<String>(getDefaultHeaders());
        }
//        else
//            entity.getHeaders().addAll(headers);
        if (params != null) {
            url += params;
        }
        logger.info("Start Rest Client URL : " + url);
        logger.info("Headers : " + entity.getHeaders().toString());
        ResponseEntity<Response<T>> response = null;
        switch (method) {
            case "GET":
                response = restTemplate.exchange(url, HttpMethod.GET, entity, new ParameterizedTypeReference<Response<T>>() {
                    @Override
                    public Type getType() {
                        Type type = super.getType();
                        if (type instanceof ParameterizedType) {
                            Type[] responseWrapperActualTypes = {tClass};
                            ParameterizedType responseWrapperType = ParameterizedTypeImpl.make(Response.class,
                                    responseWrapperActualTypes, null);
                            return responseWrapperType;
                        }
                        return type;
                    }
                });
                break;
            case "POST":
                response = restTemplate.exchange(url, HttpMethod.POST, entity, new ParameterizedTypeReference<Response<T>>() {
                    @Override
                    public Type getType() {
                        Type type = super.getType();
                        if (type instanceof ParameterizedType) {
                            Type[] responseWrapperActualTypes = {tClass};
                            ParameterizedType responseWrapperType = ParameterizedTypeImpl.make(Response.class,
                                    responseWrapperActualTypes, null);
                            return responseWrapperType;
                        }
                        return type;
                    }
                });
        }

        if (response.getStatusCode() != HttpStatus.OK) {
            logger.error("ERR : " + response.getStatusCode());
            return null;
        }
        if (response.getBody() == null || !response.getBody().isSuccess()) {
            String desc = null;
            if (response.getBody() != null && response.getBody().getError() != null) {
                desc = response.getBody().getError().getDesc();
            }
            logger.error("ERR : " + desc);
            return null;
        }
        try {
            logger.info("Response : " + new ObjectMapper().writeValueAsString(response.getBody()));
        } catch (JsonProcessingException e) {
            logger.error("Could not read response");
        } finally {
            return response.getBody().getData();
        }

    }
}
