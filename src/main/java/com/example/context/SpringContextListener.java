package com.example.context;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.config.AppConfig;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class SpringContextListener implements ServletContextListener {
    private AnnotationConfigApplicationContext context;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // Crear el contexto de Spring
        context = new AnnotationConfigApplicationContext(AppConfig.class);
        // Guardar el contexto en el ServletContext
        sce.getServletContext().setAttribute("springContext", context);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // Cerrar el contexto de Spring
        if (context != null) {
            context.close();
        }
    }
}