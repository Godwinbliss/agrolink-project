package com.agrolink.agrolink.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable) // Updated way to disable CSRF
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/ussd/**").permitAll() // Allow USSD requests to be public
                        .requestMatchers("/api/users/**").hasRole("ADMIN") // Protect user-related endpoints
                        .requestMatchers("/api/creditscore/**").authenticated() // Require authentication for credit score
                        .requestMatchers("/api/market/**").authenticated() // Require authentication for market info
                        .requestMatchers("/api/weather/**").authenticated() // Require authentication for weather alerts
                        .requestMatchers("/api/advice/**").authenticated() // Require authentication for agro-advice
                        .anyRequest().authenticated() // Any other request needs to be authenticated
                )
                .httpBasic(Customizer.withDefaults()); // Updated HTTP Basic Authentication syntax

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        // In-memory users for testing; you can replace this with a real database or external user store
        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
        userDetailsManager.createUser(
                User.withUsername("admin")
                        .password(passwordEncoder().encode("adminpassword"))
                        .roles("ADMIN")
                        .build()
        );
        userDetailsManager.createUser(
                User.withUsername("user")
                        .password(passwordEncoder().encode("userpassword"))
                        .roles("USER")
                        .build()
        );
        return userDetailsManager;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http, PasswordEncoder passwordEncoder, UserDetailsService userDetailsService) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder);

        return authenticationManagerBuilder.build();
    }
}
