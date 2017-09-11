package com.imie.poec.java;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.imie.poec.java.spring.Animal;
import com.imie.poec.java.spring.AnimalRepository;
import com.imie.poec.java.thread.HelpThread;

@SpringBootApplication
@Configuration
public class Application extends SpringBootServletInitializer implements CommandLineRunner {

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private Animal nounours;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean(name="nounours")
    public Animal getAnimal() {
        // return this.animalRepository.findOne(1l); // Fail => bean loaded to early.
        Animal entity = new Animal();

        entity.setName("nounours");
        entity.setCountry("China");
        entity.setSpecies("Panda");

        return entity;
    }

    @Override
    public void run(String... args) throws Exception {
//        Animal entity = new Animal();
//
//        entity.setName("nounours");
//        entity.setCountry("China");
//        entity.setSpecies("Panda");

        this.animalRepository.save(this.nounours);
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

    @SuppressWarnings("all")
    private static void helpThread() {
        HelpThread.exec();
    }
}
