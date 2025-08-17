package com.mse.devops.micro_service.service;

import com.mse.devops.micro_service.dto.CompleteProfile;
import com.mse.devops.micro_service.repository.PersonRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProfileService {
    private final PersonRepository personRepository;
    private final RestTemplate restTemplate;

    ProfileService(PersonRepository personRepository, RestTemplate restTemplate) {
        this.personRepository = personRepository;
        this.restTemplate = restTemplate;
    }

    public CompleteProfile getCompleteProfile(Long id) {
        CompleteProfile profile = new CompleteProfile();
        profile.setId(id);

        try {
            String name = restTemplate.getForObject(
                    "http://localhost:8081/api/persons/{id}/name",
                    String.class,
                    id
            );
            profile.setName(name);
        } catch (Exception e) {
            // Handle error
        }

        try {
            Integer age = restTemplate.getForObject(
                    "http://localhost:8082/api/persons/{id}/age",
                    Integer.class,
                    id
            );
            profile.setAge(age);
        } catch (Exception e) {
            // Handle error
        }

        personRepository.findById(id).ifPresent(person -> {
            profile.setGender(person.getGender());
        });

        return profile;
    }
}
