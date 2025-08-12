package com.example;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.beans.BeanA;
import com.example.model.Game;
import com.example.services.IGameService;

public class MainApplication {
    public static void main(String[] args) {
        /* Instancia del contexto */
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        /* Obtencion de la dependencia/objecto de la clase BeanA */
        BeanA bean = (BeanA) context.getBean("beanA");
        System.out.println(bean.getMessage());

        IGameService gameService = (IGameService) context.getBean("gameService");

        Game miJuego = new Game(1L, "Warframe", "Es un juego de grindeo");

        gameService.save(miJuego);

        List<Game> juegos = gameService.findAll();

        for (Game juego : juegos) {
            System.out.println(juego.toString());
        }
    }
}
