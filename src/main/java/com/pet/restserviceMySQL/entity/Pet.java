package com.pet.restserviceMySQL.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import lombok.Data;

@Entity
@Data
public class Pet {

    @Id
    private String name;
    private Date birthdate;
    private String species;
    private String veterinarian;

}