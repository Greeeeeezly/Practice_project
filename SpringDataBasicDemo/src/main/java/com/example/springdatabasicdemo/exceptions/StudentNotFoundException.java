package com.example.springdatabasicdemo.exceptions;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(Integer id) {
        super("Could not find student " + id);
    }
}