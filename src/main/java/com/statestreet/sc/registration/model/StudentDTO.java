package com.statestreet.sc.registration.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class StudentDTO {

    private String name;
    private Set<Course> courses;

}