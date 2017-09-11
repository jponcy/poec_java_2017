package com.imie.poec.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

import com.imie.poec.java.HelpTpAscii;
import com.imie.poec.java.MyFuture;
import com.imie.poec.java.SchoolSupport;
import com.imie.poec.java.thread.HelpThread;

@SpringBootApplication
@Configuration
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

//    @Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurerAdapter() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/product").allowedOrigins("http://localhost:8080");
//            }
//        };
//    }

    // Call helpers.

    @SuppressWarnings("all")
    private static void schoolSupport() {
        SchoolSupport.exec();
    }

    @SuppressWarnings("all")
    private static void helpAscii() {
        HelpTpAscii.helpAscii();
    }

    @SuppressWarnings("all")
    private static void helpFuture() {
        MyFuture.noBlocking();
    }

    private static void helpThread() {
        HelpThread.exec();
    }
}
