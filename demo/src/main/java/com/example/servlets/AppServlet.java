package com.example.servlets;

import java.io.*;
import java.util.logging.Logger;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "appServlet", value = "/app")
public class AppServlet extends HttpServlet{

    Logger logger = Logger.getLogger(ServletTest.class.getName());
    
    public void init() {
        logger.warning("Se ha inicializado el Servlet");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        
        response.setContentType("text/html");

        PrintWriter print = response.getWriter();
        print.println("<html>");
        print.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/app.css\">");
        print.println("<body>");
        print.println("<form action='app' method='POST'>");
        print.println("<input type='text' id='name' name='name' placeholder='Nombre'/>");
        print.println("<input type='text' id='age' name='age' placeholder='Edad'/>");
        print.println("<input type='submit' value='Enviar' />");
        print.println("</form>");
        print.println("</body>");
        print.println("</html>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String name = request.getParameter("name");
        String age = request.getParameter("age");

                response.setContentType("text/html");

        PrintWriter print = response.getWriter();
        print.println("<html>");
        print.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/app.css\">");
        print.println("<body>");
        print.println("<h1>Hola " + name + ", tienes " + age + "años</h1>");
        print.println("</body>");
        print.println("</html>");
    }
    
}
