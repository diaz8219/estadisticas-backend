package com.example.ESTADISTICAS_BACKEND;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class EstadisticasBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(EstadisticasBackendApplication.class, args);
	}

    /// CORS
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/") // Aplica a todos los endpoints
                        .allowedOriginPatterns("*") // Permite todos los orígenes
                        .allowedMethods("*") // Permite todos los métodos (GET, POST, PUT, DELETE, etc.)
                        .allowedHeaders("*") // Permite todos los encabezados
                        .allowCredentials(true); // Permite el envío de cookies o credenciales
            }
        };
    }

}
