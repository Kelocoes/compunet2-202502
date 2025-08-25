package com.games.back;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.games.back.model.User;
import com.games.back.services.IUserService;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class BackApplication {

    @Autowired
    private IUserService userService;

	public static void main(String[] args) {
		SpringApplication.run(BackApplication.class, args);
	}

    @PostConstruct
    public void init() {
        System.out.println("----- Users -----");
        List<User> users = userService.findAll();

        users.forEach(user -> {
            System.out.println(user.toString());
        });
    }

    @EventListener(ApplicationReadyEvent.class)
    public void runAfterSetup() {
        System.out.println("Application is ready!");

        // Guardar un nuevo usuario
        User admin = userService.findById(1L);

        // Actualizar el usuario recién creado
        admin.setUsername("ImNotJohn96");
        admin = userService.save(admin);
        System.out.println("Updated User: " + admin);

        // Borrar el usuario con ID 1L
        try {
            userService.deleteById(1L);
            System.out.println("Deleted User with ID 1L");
        } catch (Exception e) {
            System.out.println("Error deleting User with ID 1L: " + e.getMessage());
        }

        // Listar todos los usuarios
        List<User> users = userService.findAll();
        users.forEach(user -> {
            System.out.println(user.toString());
        });
    }

}
