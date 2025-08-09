package com.example.servlets;

import java.io.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.HolaMundo;

import jakarta.servlet.http.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
         message = "Hello World from a Servlet!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Crear el contexto de Spring
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        // Obtener el bean
        HolaMundo hola = (HolaMundo) context.getBean("HolaMundo");
        
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Hola Mundo desde Servlet</h1>");
        out.println("<p>El siguiente mensaje es un atributo del bean: </p>");
        out.println("<p>" + hola.getMensaje() + "</p>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}
