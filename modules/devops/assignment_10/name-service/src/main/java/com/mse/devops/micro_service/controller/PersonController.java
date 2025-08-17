package com.mse.devops.micro_service.controller;

import com.mse.devops.micro_service.model.Person;
import com.mse.devops.micro_service.repository.PersonRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/persons")
public class PersonController {
    private final PersonRepository personRepository;

    PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostMapping("/{id}/name")
    public ResponseEntity<Person> saveName(@PathVariable long id, @RequestBody String name) {
        Person person = personRepository.findById(id).orElse(new Person());
        person.setId(id);
        person.setName(name);
        return ResponseEntity.ok(personRepository.save(person));
    }

    @GetMapping("/{id}/name")
    public ResponseEntity<String> getName(@PathVariable long id) {
        return personRepository.findById(id).map(Person::getName).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
