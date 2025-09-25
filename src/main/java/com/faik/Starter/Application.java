package com.faik.Starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.faik.Configuration.GlobalProperties;

@SpringBootApplication
@ComponentScan(basePackages = {
    "com.faik.Controller", 
    "com.faik.Services", 
    "com.faik.Repository",
    "com.faik.Starter"
})
@EntityScan(basePackages = {"com.faik.Entites"})
@EnableJpaRepositories(basePackages = {"com.faik.Repository"})
@PropertySource(value = "classpath:app.properties") // İstediğim property dosyasını istediğim şekilde okutabiliyorum
@EnableConfigurationProperties(value = GlobalProperties.class)
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}