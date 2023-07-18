package com.securitydemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService(){

        UserDetails admin = User.withUsername("soumik")
                .password(passwordEncoder().encode("soumik"))
                .roles("ADMIN")
                .build();

        UserDetails normal = User.withUsername("adidas")
                .password(passwordEncoder().encode("adidas"))
                .roles("NORMAL")
                .build();

        return new InMemoryUserDetailsManager(admin, normal);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.csrf()
                .disable()
                .authorizeHttpRequests()
                .requestMatchers("/student/{name}")
                .hasRole("NORMAL")
                .requestMatchers("/home/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin();

        return httpSecurity.build();
    }
}
