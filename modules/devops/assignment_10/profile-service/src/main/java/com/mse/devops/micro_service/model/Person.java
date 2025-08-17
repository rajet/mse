package com.mse.devops.micro_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Person {
    @Id
    private Long id;
    private String name;
    private Integer age;
    private String gender;
}
