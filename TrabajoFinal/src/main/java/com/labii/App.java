package com.labii;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan
public class App
{
    public static void main( String[] args )
    {
        //http://localhost:8080

        ApplicationContext context = SpringApplication.run(App.class, args);
        System.out.println( "Hello World!" );

    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();

    }

}
