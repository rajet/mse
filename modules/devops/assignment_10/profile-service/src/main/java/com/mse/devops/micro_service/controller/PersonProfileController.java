package com.mse.devops.micro_service.controller;

import com.mse.devops.micro_service.dto.CompleteProfile;
import com.mse.devops.micro_service.model.Person;
import com.mse.devops.micro_service.repository.PersonRepository;
import com.mse.devops.micro_service.service.ProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/persons")
public class PersonProfileController {
    private final PersonRepository personRepository;
    private final ProfileService profileService;

    public PersonProfileController(PersonRepository personRepository, ProfileService profileService) {
        this.personRepository = personRepository;
        this.profileService = profileService;
    }

    @PostMapping("/{id}/gender")
    public ResponseEntity<Person> saveGender(@PathVariable Long id, @RequestBody String gender) {
        Person person = personRepository.findById(id).orElse(new Person());
        person.setId(id);
        person.setGender(gender);
        return ResponseEntity.ok(personRepository.save(person));
    }

    @GetMapping("/{id}/gender")
    public ResponseEntity<String> getGender(@PathVariable Long id) {
        return personRepository.findById(id)
                .map(Person::getGender)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompleteProfile> getCompleteProfile(@PathVariable Long id) {
        CompleteProfile profile = profileService.getCompleteProfile(id);
        return ResponseEntity.ok(profile);
    }
}
