package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.beans.BeanA;
import com.example.model.Game;
import com.example.model.User;
import com.example.services.IGameService;
import com.example.services.IUserService;

@Configurable
@ComponentScan(basePackages = "com.example")
@PropertySource("classpath:application.properties")
public class MainApplication {
    public static void main(String[] args) {
        /* Instancia del contexto */
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(MainApplication.class);

        /* Obtencion de la dependencia/objecto de la clase BeanA */
        BeanA bean = (BeanA) context.getBean("beanA");
        System.out.println(bean.getMessage());

        IGameService gameService = (IGameService) context.getBean("gameServiceImpl");
        IGameService gameService1 = (IGameService) context.getBean("gameServiceImpl");
        IUserService userService = (IUserService) context.getBean("userServiceImpl");

        User miUsuario = new User(1L, "JohnDoe", "john.doe@example.com", "");
        Game miJuego = new Game(1L, "Warframe", "Es un juego de grindeo", miUsuario.getId());

        userService.save(miUsuario);
        gameService.save(miJuego);

        List<Game> juegos = gameService.findAll();

        for (Game juego : juegos) {
            System.out.println(juego.toString());
            for (User usuario : userService.findAll()) {
                if (usuario.getId().equals(juego.getCreatedById())) {
                    System.out.println("Registrado por: " + usuario.getUsername());
                }
            }
        }

        context.close();
    }
}
