package com.example.demo.controller;

import com.example.demo.dto.IngredientPojo;
import com.example.demo.dto.PersonPojo;
import com.example.demo.service.IngredientService;
import com.example.demo.service.PersonService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/person")
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService){
        this.personService = personService;
    }

    @GetMapping
    public Flux<PersonPojo> findAll(){
        return personService.findAll();
    }
    @GetMapping("/findById/{id}")
    public Mono<PersonPojo> findById(@PathVariable("id") Long id){
        return personService.findById(id);
    }
    @PostMapping
    public Mono<PersonPojo> create(@RequestBody PersonPojo pojo){
        return personService.create(pojo);
    }
    @PutMapping
    public Mono<PersonPojo> update(@RequestBody PersonPojo pojo){
        return personService.update(pojo);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Long id){

        personService.delete(id);
    }
}
