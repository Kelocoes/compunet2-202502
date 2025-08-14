<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="org.springframework.context.support.ClassPathXmlApplicationContext" %>
<%@ page import="com.example.beans.BeanA" %>
<%@ page import="com.example.model.Game" %>
<%@ page import="com.example.services.IGameService" %>
<%@ page import="java.util.List" %>

<html>
<body> 
<h2>Hello World!</h2>

<%
    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        /* Obtencion de la dependencia/objecto de la clase BeanA */
        BeanA bean = (BeanA) context.getBean("beanA");
        System.out.println(bean.getMessage());

        IGameService gameService = (IGameService) context.getBean("gameService");

        Game miJuego = new Game(1L, "Warframe", "Es un juego de grindeo");

        gameService.save(miJuego);

        List<Game> juegos = gameService.findAll();
%>

    <h3>Lista de Juegos:</h3>
    <ul>
        <%
        for (Game juego : juegos) {
            out.println("<li>" + juego.getName() + ": " + juego.getDescription() + "</li>");
        }
        %>
    </ul>
</body>
</html> 
