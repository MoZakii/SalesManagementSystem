package com.Mohamed.SalesManagementSystem.security;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.PrintWriter;

@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json");
        PrintWriter writer = response.getWriter();

        String errorMessage = "Unauthorized: ";
        if (authException.getMessage() != null && authException.getMessage().contains("expired")) {
            errorMessage += "Token expired";
        } else {
            errorMessage += "Invalid token";
        }

        writer.println(errorMessage);

    }
}