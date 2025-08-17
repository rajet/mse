package com.mse.devops.micro_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Person {
    @Id
    private long id;
    private String name;
}
