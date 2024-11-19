package com.control.acess.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Cors implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")  // Permite o acesso aos endpoints da API
                .allowedOrigins("http://localhost:4200")  // Permite origem específica
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // Permite os métodos HTTP necessários
                .allowedHeaders("Authorization", "Content-Type")  // Permite cabeçalhos específicos
                .allowCredentials(true);  // Permite o envio de credenciais (cookies, headers)
    }
}
