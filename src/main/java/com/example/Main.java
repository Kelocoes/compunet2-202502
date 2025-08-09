package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.example.service.GameService;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        HolaMundo holaMundo = (HolaMundo) context.getBean("HolaMundo");
        System.out.println(holaMundo.getMensaje());

        GameService gameService = (GameService) context.getBean("GameService");
        System.out.println("Available games: " + gameService.getGames());

        GameService gameService1 = (GameService) context.getBean("GameService");
        
        System.out.println("Are gameService1 and gameService2 different instances? " + (gameService != gameService1));

        ((ClassPathXmlApplicationContext) context).close();
    }
}