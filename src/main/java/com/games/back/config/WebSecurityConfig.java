package com.games.back.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.games.back.security.CustomUserDetailsService;

@Configuration
@EnableMethodSecurity
public class WebSecurityConfig {
    @Bean
    public UserDetailsService userDetailsService() {
        return new CustomUserDetailsService();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
            .authorizeHttpRequests(authz -> authz
                .requestMatchers("/mvc/public/**").permitAll()
                .requestMatchers("/mvc/auth/login", "/css/**", "/js/**").permitAll()
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/mvc/auth/login")           // URL personalizada para mostrar login
                .loginProcessingUrl("/mvc/auth/login")  // URL que procesa el login
                .defaultSuccessUrl("/mvc/users", true)  // Redirección después del login exitoso
                .failureUrl("/mvc/auth/login?error")    // Redirección en caso de error
                .usernameParameter("username") // Nombre del campo username
                .passwordParameter("password") // Nombre del campo password
                .permitAll()
            )
            .logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/mvc/auth/login?logout")
                .permitAll()
            )
            .build();
    }
}
