package com.arun.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Student {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
