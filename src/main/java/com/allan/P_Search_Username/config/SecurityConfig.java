package com.allan.P_Search_Username.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable()       // Deshabilita CSRF para pruebas POST desde Postman o curl
            .authorizeHttpRequests(auth -> auth
                .anyRequest().permitAll() // Permite acceso a todos los endpoints sin autenticación
            );
        return http.build();
    }
}
