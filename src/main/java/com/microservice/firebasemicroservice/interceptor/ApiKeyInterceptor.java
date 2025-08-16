package com.microservice.firebasemicroservice.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@Component
public class ApiKeyInterceptor implements HandlerInterceptor {
    private static final String API_KEY_HEADER = "X-API-KEY";
    private static final String API_KEY = "f68a2c4e-7e91-49e6-a812-921bd49a66a5";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        String apiKey = request.getHeader(API_KEY_HEADER);
        if(API_KEY.equals(apiKey)){
            return true;
        }
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getWriter().write("Unauthorized - Invalid API Key");
        return false;
    }
    
}
