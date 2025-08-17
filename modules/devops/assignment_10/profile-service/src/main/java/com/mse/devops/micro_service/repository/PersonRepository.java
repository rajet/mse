package com.mse.devops.micro_service.repository;

import com.mse.devops.micro_service.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
