package com.local;

import java.io.IOException;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import com.local.request.SayRequest;
import com.local.util.JsonUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/api/say-hello")
public class ApiServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SayRequest sayRequest = JsonUtil.getObjectMapper().readValue(req.getReader(), SayRequest.class);
        String sayHello = String.format("Hello %s %s", sayRequest.getFirstName(), sayRequest.getLastName());

        Map<String, String> response = Map.of("data", sayHello);
        String json = JsonUtil.getObjectMapper().writeValueAsString(response);
        resp.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        resp.getWriter().print(json);
    
    }
}
