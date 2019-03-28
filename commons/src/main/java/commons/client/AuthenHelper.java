package commons.client;

import commons.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

@Component
public class AuthenHelper {
    @Value("${URL_AUTHENTICATE}")
    private String urlAuthentication;
    @Autowired
    private ClientHelper clientHelper;

    public UserDTO authenticate(String token) {
        HttpHeaders headers = clientHelper.getDefaultHeaders();
        headers.add("authorization", token);
        return clientHelper.callRest(urlAuthentication, "GET", "", new HttpEntity(headers), UserDTO.class);
    }
}
