package com.imie.poec.java.spring;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends CrudRepository<Animal, Long> {

    public Iterable<Animal> getByNameAndCountryAllIgnoreCase(final String name, final String country);
}
