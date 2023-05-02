package com.local;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/request")
public class RequestServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("Method : " + req.getMethod());
        resp.getWriter().println("Query String : " + req.getQueryString());
        resp.getWriter().println("Request URI : " + req.getRequestURI());
        resp.getWriter().println("Context Path : " + req.getContextPath());
        resp.getWriter().println("Servlet Path : " + req.getServletPath());

        // output
        // Method : GET
        // Query String : null
        // Request URI : /request
        // Context Path :
        // Servlet Path : /request
    }
}
