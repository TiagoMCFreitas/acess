package com.control.acess.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
public class Cors  implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Permite CORS para todos os caminhos da aplicação
        registry.addMapping("/**")
                .allowedOrigins("*")  // Permite acesso apenas de localhost:4200
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // Permite apenas esses métodos
                .allowedHeaders("Authorization", "Content-Type", "Accept", "Origin")  // Especifique os headers permitidos
                .exposedHeaders("Authorization"); // Exponha o cabeçalho Authorization, se necessário//
    }


    }
