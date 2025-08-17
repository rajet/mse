package com.mse.devops.micro_service.dto;

import lombok.Data;

@Data
public class CompleteProfile {
    private Long id;
    private String name;
    private Integer age;
    private String gender;
}
