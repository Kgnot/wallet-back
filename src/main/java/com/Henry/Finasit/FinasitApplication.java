package com.Henry.Finasit;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.session.SessionAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.Henry"}, exclude = {SessionAutoConfiguration.class})
@EnableJpaRepositories(basePackages = "com.Henry.dao")
@EntityScan(basePackages = "com.Henry.entities")
public class FinasitApplication {

    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.configure()
                .filename(".env")
                .load();

        dotenv.entries().forEach(e -> System.setProperty(e.getKey(), e.getValue()));
        // No agregar a entorno de producción

        SpringApplication.run(FinasitApplication.class, args);
    }
}
