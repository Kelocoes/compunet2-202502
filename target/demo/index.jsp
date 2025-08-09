<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="org.springframework.context.support.ClassPathXmlApplicationContext" %>
<%@ page import="com.example.HolaMundo" %>
<%@ page import="com.example.service.GameService" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
    <title>Spring Example</title>
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/index.css">
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
        List<String> juegos = gameService.getGames();
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