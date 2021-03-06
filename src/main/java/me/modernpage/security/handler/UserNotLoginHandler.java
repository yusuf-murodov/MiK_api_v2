package me.modernpage.security.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.modernpage.utils.ResponseUtils;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Component
public class UserNotLoginHandler implements AuthenticationEntryPoint {
    private final ObjectMapper objectMapper;

    public UserNotLoginHandler(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }


    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException e) throws IOException, ServletException {
        ResponseUtils.responseJson(response, ResponseUtils.response(
                401, "Unauthorized access: " + e.getMessage(), null), objectMapper);
    }
}
