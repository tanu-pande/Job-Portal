package com.example.jobportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.jobportal.repository")
@EntityScan(basePackages = "com.example.jobportal.model")  // 👈 Add this line
public class JobportalApplication {
    public static void main(String[] args) {
        SpringApplication.run(JobportalApplication.class, args);
    }
}
