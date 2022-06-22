package com.amsadminapi.entity;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {

    @Id
    private Long id;

    private String firstName;
    private String lastName;

}