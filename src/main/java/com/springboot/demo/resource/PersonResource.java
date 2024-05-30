package com.springboot.demo.resource;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.springboot.demo.entity.PersonEntity;
import com.springboot.demo.rest.PersonRepository;
import jakarta.websocket.server.PathParam;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.web.JsonPath;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/persons")
public class PersonResource {

    private final PersonRepository personRepository;

    @Autowired
    public PersonResource(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello Person Welcome to Java World!";
    }

    @GetMapping
    public List<Document> getPersons() {
        return personRepository.getAllPersons();
    }

    @PostMapping
    public String addPerson(@RequestBody PersonEntity person) {
        return personRepository.add(person);
    }

    @PutMapping("/anniversary/{id}")
    public long anniversaryPerson(@PathVariable String id) {
        return personRepository.anniversaryPerson(id);
    }

    @DeleteMapping("/{id}")
    public long deletePerson(@PathVariable String id) {
        return personRepository.deletePersonById(id);
    }


    @DeleteMapping("/byObjectId/{objectId}")
    public long deletePersonByObjectId(@PathVariable String objectId) {
        return personRepository.deletePersonByObjectId(objectId);
    }


}


