package com.pet.restserviceMySQL.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pet.restserviceMySQL.entity.Pet;
import com.pet.restserviceMySQL.repositories.PetRepository;

import javassist.tools.web.BadHttpRequest;

@RestController
@RequestMapping("/pets")
public class PetController {
    @Autowired
    private PetRepository repository;

    @GetMapping
    public Iterable<Pet> findAll() {
        return repository.findAll();
    }

/*
    @GetMapping(path = "/{name}")
    public Pet find(@PathVariable("name") String name) {
        return repository.findOne(Pet);
    }
*/

    @PostMapping(consumes = "application/json")
    public Pet create(@RequestBody Pet pet) {
        return repository.save(pet);
    }

/*    @DeleteMapping(path = "/{name}")
    public void delete(@PathVariable("name") String name) {
        repository.delete(name);
    }

    @PutMapping(path = "/{name}")
    public Pet update(@PathVariable("name") String name, @RequestBody Pet pet) throws BadHttpRequest {
        if (repository.exists(name)) {
            Pet.setName(name);
            return repository.save(pet);
        } else {
            throw new BadHttpRequest();
        }
    }*/
}
