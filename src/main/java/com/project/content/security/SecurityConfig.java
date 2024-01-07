package com.project.content.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests((auth) ->
                        auth
                                .requestMatchers("/content/**", "/category/**","/video/**","/image/**")
                                .permitAll()
                                .anyRequest()
                                .authenticated()
                ).oauth2Login(Customizer.withDefaults())
                .build();

    }

}
