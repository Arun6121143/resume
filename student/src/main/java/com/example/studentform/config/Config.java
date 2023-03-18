package com.example.studentform.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class Config {

    @Bean
    public UserDetailsService userDeatails(PasswordEncoder encoder) {
        UserDetails admin = User.withUsername("user1").password(encoder.encode("abhi321")).roles("ADMIN").build();
        // UserDetails user1 = User.withUsername("user2").password(encoder.encode("xyz321")).roles("USER").build();
        return new InMemoryUserDetailsManager(admin);

    }

    @Bean
    public SecurityFilterChain security(HttpSecurity http) throws Exception {
        return http.csrf().disable().authorizeHttpRequests().requestMatchers("/admin").authenticated().and().formLogin()
                .and()
                .authorizeHttpRequests().requestMatchers("/**").permitAll().and().build();
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}
