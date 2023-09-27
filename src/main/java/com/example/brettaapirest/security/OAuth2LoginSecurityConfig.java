package com.example.brettaapirest.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@EnableWebSecurity
public class OAuth2LoginSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(c -> c
                        .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                        .disable()
                )
                .authorizeHttpRequests(authorize -> authorize
//                        .requestMatchers("/","/api/cervezas/**","/api/comidas/**","/login/**", "/error").permitAll()
//                        .anyRequest().authenticated()
                                .anyRequest().permitAll()
                )
                .oauth2Login(Customizer.withDefaults());
        return http.build();
    }
}