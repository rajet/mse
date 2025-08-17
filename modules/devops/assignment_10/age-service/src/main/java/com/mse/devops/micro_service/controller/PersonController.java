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

    @PostMapping("/{id}/age")
    public ResponseEntity<Person> saveAge(@PathVariable Long id, @RequestBody Integer age) {
        Person person = personRepository.findById(id).orElse(new Person());
        person.setAge(age);
        return ResponseEntity.ok(personRepository.save(person));
    }

    @GetMapping("/{id}/age")
    public ResponseEntity<Integer> getAge(@PathVariable Long id) {
        return personRepository.findById(id)
                .map(Person::getAge)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
