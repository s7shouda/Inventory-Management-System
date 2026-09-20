package com.mm_projects.InventoryManagementSystem.exception;

import com.mm_projects.InventoryManagementSystem.dot.Response;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;

@Component
@RequiredArgsConstructor // to make constructor for objectMapper

//AccessDeniedHandler is an interface from spring security
public class CustomAccessDenial implements AccessDeniedHandler {


    // to map our error dto to json
    private final ObjectMapper objectMapper;



    @Override
    public void handle(@NonNull HttpServletRequest request, //the request which the client send
                       HttpServletResponse response, // the response which will back to the client
                       AccessDeniedException accessDeniedException)
            throws IOException, ServletException {

        // here we build the body of our error dto
        Response errorResponse = Response.builder()
                .status(HttpStatus.FORBIDDEN.value()) // FORBIDDEN for unauthorized access
                .message(accessDeniedException.getMessage()) // get the message of the illegal access
                .build();

        // here you specify the format of the response witch is [json]
        response.setContentType("application/json");
        // and here you specify the code of the error response
        response.setStatus(HttpStatus.FORBIDDEN.value());
        // here there are two important steps
        // 1. objectMapper.writeValueAsString(errorResponse) -> mapping the error to JSON as string
        // 2. response.getWriter().write -> writing this JSON in the response using .getWriter().write
        response.getWriter().write(objectMapper.writeValueAsString(errorResponse));
    }
}
