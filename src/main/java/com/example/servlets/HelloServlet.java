package com.example.servlets;

import java.io.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.config.AppConfig;
import com.example.model.User;
import com.example.service.IUserService;

import jakarta.servlet.http.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/create-user")
public class HelloServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Crear el contexto de Spring
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Obtener el bean
        IUserService userService = context.getBean(IUserService.class);

        User initUser = new User(1L, "kelocoes", "kevin.rodriguez109@gmail.com", "Mi biografía");
        User savedUser = userService.save(initUser);
        
        
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Hola Mundo desde Servlet</h1>");
        out.println("<p>Usuario registrado: </p>");
        out.println("<p> Usuario: " + savedUser.getUsername() + "</p>");
        out.println("</body></html>");

        context.close();
    }

    public void destroy() {
    }
}
