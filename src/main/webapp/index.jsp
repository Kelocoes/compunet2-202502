<%-- filepath: /e:/Kevin/De Kevin/Universidad/Docencia ICESI/Computación en Internet 2/2025 02/compunet2-202502/src/main/webapp/index.jsp --%>
<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="org.springframework.context.support.ClassPathXmlApplicationContext" %>
<%@ page import="com.example.HolaMundo" %>
<%@ page import="com.example.service.GameService" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
    <title>Spring Example</title>
</head>
<body>
    <h1>Ejemplo de Spring desde JSP</h1>
    
    <%
        // Crear el contexto de Spring
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        // Obtener el bean
        HolaMundo hola = (HolaMundo) context.getBean("HolaMundo");
        
        // Obtener el mensaje del bean
        String mensaje = hola.getMensaje();

        GameService gameService = (GameService) context.getBean("GameService");
        List<String> juegos = gameService.getGames(); // Cambié getJuegos() por getGames()
    %>
    
    <p><%= mensaje %></p>

    <ul>
        <%
            for (String juego : juegos) {
        %>
            <li><%= juego %></li>
        <%
            }
        %>
    </ul>
</body>
</html>