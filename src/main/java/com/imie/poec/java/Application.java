package com.imie.poec.java;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

import com.imie.poec.java.spring.AnimalRepository;
import com.imie.poec.java.thread.HelpThread;

@SpringBootApplication
@Configuration
public class Application {

    @Autowired
    private AnimalRepository animalRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

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
