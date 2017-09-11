package com.imie.poec.java.spring;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends CrudRepository<Animal, Long> {
//    /** Gets all animals. */
//    public List<Animal> getAll();
}
