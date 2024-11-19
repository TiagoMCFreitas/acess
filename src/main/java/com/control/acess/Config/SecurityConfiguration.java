package com.control.acess.Config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    public static final String [] ENDPOINTS_WITH_AUTHENTICATION_NOT_REQUIRED = {
            "/api/usuario/",
            "/api/usuario/login",

    };
    public static final String [] ENDPOINTS_WITH_AUTHENTICATION_REQUIRED = {
            "/api/usuario/profile"
    };

    public static final String[] ENPOINTS_USUARIO ={
            "/api/usuario/profile",

    };
    // Endpoints que só podem ser acessador por usuários com permissão de cliente
    public static final String [] ENDPOINTS_GERENTE = {
            "/api/usuario/profile",
            "/api/usuario/lista"
    };

    // Endpoints que só podem ser acessador por usuários com permissão de administrador
    public static final String [] ENDPOINTS_ADMIN = {
            "/api/usuario/profile",
            "/api/usuario/lista",
            "/api/usuario/alterar"
    };

    @Bean
    public DefaultSecurityFilterChain securityFilterChain(HttpSecurity httpSecurity, UserAuthenticationFilter userAuthenticationFilter) throws Exception {
        return httpSecurity
                .csrf(csrf -> csrf.disable()) // Desativa CSRF com a nova API
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // Configura a política de sessão como stateless
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(ENDPOINTS_WITH_AUTHENTICATION_NOT_REQUIRED).permitAll()
                        .requestMatchers(ENDPOINTS_WITH_AUTHENTICATION_REQUIRED).authenticated()
                        .requestMatchers(ENDPOINTS_ADMIN).hasRole("ADMIN")
                        .requestMatchers(ENDPOINTS_GERENTE).hasRole("GERENTE")
                        .requestMatchers(ENPOINTS_USUARIO).hasRole("USUARIO")
                        .anyRequest().denyAll())
                .addFilterBefore(userAuthenticationFilter, UsernamePasswordAuthenticationFilter.class) // Adiciona o filtro customizado
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
