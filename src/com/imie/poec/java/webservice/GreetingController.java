package com.imie.poec.java.webservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(
            @RequestParam(defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }

    @RequestMapping("/frz84fz54dz5edz5ef1r5fer/ez4dz5e4d5z4edze")
    public Greeting greeting2(
            @RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }

    @RequestMapping("/rand")
    public Rand rand() {
        return new Rand();
    }

    @RequestMapping(path = "/rand/{value}")
    public Rand randLimitMax(@PathVariable(value = "value") int max) {
        return new Rand(max);
    }

    @RequestMapping(path = "/rand/")
    public Rand randLimit(
            @RequestParam(value = "min") int max,
            @RequestParam(value = "max") int min) {
        return new Rand(max);
    }
}
