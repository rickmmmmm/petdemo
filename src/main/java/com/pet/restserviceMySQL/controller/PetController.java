package com.pet.restserviceMySQL.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
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

@Slf4j
@RestController
@RequestMapping("/pets")
public class PetController {
    @Autowired
    private PetRepository repository;

    @GetMapping
    public Iterable<Pet> findAll() {
        log.debug("Find all pets");
        return repository.findAll();
    }


    @GetMapping(path = "/{name}")
    public Pet find(@PathVariable("name") String name) {
        return repository.findByName(name);
    }


    @PostMapping(consumes = "application/json")
    public Pet create(@RequestBody Pet pet) {
        return repository.save(pet);
    }

    @DeleteMapping(path = "/{name}")
    public void delete(@PathVariable("name") String name) {
        repository.deleteByName(name);
    }

    @PutMapping(path = "/{name}")
    public Pet update(@PathVariable("name") String name, @RequestBody Pet pet) throws BadHttpRequest {
        if (repository.findByName(name) != null) {
            pet.setName(name);
            return repository.save(pet);
        } else {
            throw new BadHttpRequest();
        }
    }
}
