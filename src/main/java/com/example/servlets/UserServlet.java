package com.example.servlets;

import java.io.*;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.config.AppConfig;
import com.example.model.User;
import com.example.service.IUserService;

import jakarta.servlet.http.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.*;

@WebServlet(name = "userServlet", value = "/user")
public class UserServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Crear el contexto de Spring
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Obtener el bean
        IUserService userService = context.getBean(IUserService.class);

        User savedUser = userService.getUserById(1L);
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Hola Mundo desde Servlet</h1>");
        out.println("<p>Usuario encontrado! </p>");
        out.println("<p> Id: " + savedUser.getId() + "</p>");
        out.println("<p> Usuario: " + savedUser.getUsername() + "</p>");
        out.println("</body></html>");

        context.close();
    }

    public void destroy() {
    }
}
