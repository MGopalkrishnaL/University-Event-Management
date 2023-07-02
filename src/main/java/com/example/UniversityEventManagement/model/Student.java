package com.example.UniversityEventManagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Entity
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int studentId;
    @Pattern(regexp = "[A-Z][a-zA-Z]*", message = "First name must start with a capital letter")
    private String firstName;
    private String lastName;
    @Min(value = 18, message = "Age must be at least 18")
    @Max(value = 25, message = "Age must be at most 25")
    private int age;
    @Enumerated(EnumType.ORDINAL)
    private Department department;
}
