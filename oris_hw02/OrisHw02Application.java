// src/main/java/itis/oris_hw02/OrisHw02Application.java
package itis.oris_hw02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class OrisHw02Application {

    public static void main(String[] args) {
        SpringApplication.run(OrisHw02Application.class, args);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // добавляем RestTemplate для обращения к OpenWeatherMap
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
