package com.pet.restserviceMySQL.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.pet.restserviceMySQL.entity.Pet;

@RepositoryRestResource(exported = false)
public interface PetRepository extends JpaRepository<Pet, String>{
}
