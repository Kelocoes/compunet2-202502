package com.example.servlets;

import java.io.*;
import java.util.logging.Logger;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "reportServlet", value = "/report")
public class ReportServlet extends HttpServlet{

    Logger logger = Logger.getLogger(ServletTest.class.getName());
    
    public void init() {
        logger.warning("Se ha inicializado el Servlet");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        
        response.setContentType("text/html");

        PrintWriter print = response.getWriter();
        print.println("<html>");
        print.println("<body>");
        print.println("<h1>Datos importantes</h1>");
        print.println("<p>Información 1</p>");
        print.println("<p>Información 2</p>");
        print.println("<p>Información 3</p>");
        print.println("<p>Información 4</p>");
        print.println("</body>");
        print.println("</html>");
    }

    public void doPost() {

    }
    
}
