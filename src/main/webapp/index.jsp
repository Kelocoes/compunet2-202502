<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="org.springframework.context.annotation.AnnotationConfigApplicationContext" %>
<%@ page import="com.example.config.AppConfig" %>
<%@ page import="com.example.service.IUserService" %>
<%@ page import="com.example.model.User" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Spring Example</title>
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/index.css">
</head>
<body>
    <h1>Ejemplo de Spring desde JSP</h1>
    
    <%
        // Crear el contexto de Spring
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Obtener el bean
        IUserService userService = context.getBean(IUserService.class);

        User initUser = new User(1L, "kelocoes", "kevin.rodriguez109@gmail.com", "Mi biografía");
        User savedUser = userService.save(initUser);
    %>
    
    <p>Usuario guardado:</p>
    <ul>
        <li>ID: <%= savedUser.getId() %></li>
        <li>Nombre: <%= savedUser.getUsername() %></li>
        <li>Email: <%= savedUser.getEmail() %></li>
        <li>Biografía: <%= savedUser.getBio() %></li>
    </ul>
</body>
</html>
