package com.imie.poec.java.spring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AnimalController {

    private static final int FILL_LIMIT = 20;

    @Autowired
    private AnimalRepository repository;

    @Autowired
    private Animal nounours;

    @RequestMapping("/animal/nounours")
    public String nounours(Model model) throws Exception {
        if (this.nounours == null) {
            throw new Exception("Where is nounours?!");
        }

        model.addAttribute("entity", this.nounours);

        return "/animal/show";
    }

    @RequestMapping("/animal/{id}")
    public String show(@PathVariable Long id, Model model) {
        model.addAttribute("entity", this.repository.findOne(id));

        return "/animal/show";
    }

    @RequestMapping("/animal/search")
    public String show(@RequestParam String name, @RequestParam String country, Model model) {
        Iterable<Animal> entities = this.repository.getByNameAndCountryAllIgnoreCase(name, country);

        if (entities.iterator().hasNext()) {
            model.addAttribute("entity", entities.iterator().next());
        }

        return "/animal/show";
    }

    /** Get all animals. */
    @GetMapping("/animal")
    public String index(Model model) {
        Iterable<?> entities = this.repository.findAll();

        model.addAttribute("animals", entities);

        return "/animal/index";
    }

    @PostMapping("/animal/fill")
    public String fill(Model model) {
        List<Animal> animals = new ArrayList<>();

        for (int i = 0; i < FILL_LIMIT; ++i) {
            Animal a = new Animal();

            a.setName("Number " + i);
            a.setCountry("france" + i);
            a.setSpecies("Spe what? Idk!");

            animals.add(a);
        }

        model.addAttribute("entities", this.repository.save(animals));

        return "/animal/fill";
    }
}
