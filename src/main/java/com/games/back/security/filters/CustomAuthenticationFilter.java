package com.games.back.security.filters;

import java.io.IOException;

import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomAuthenticationFilter extends OncePerRequestFilter {

    private static final Logger logger = LoggerFactory.getLogger(CustomAuthenticationFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        logger.info("Request received: {} {}", request.getMethod(), request.getRequestURI());

        Boolean flag = true;

        if (flag) {
            filterChain.doFilter(request, response);
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            logger.info("Response sent: status={}", httpResponse.getStatus());
        } else {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
            logger.warn("Unauthorized access attempt: {} {}", request.getMethod(), request.getRequestURI());
        }
    }
}
