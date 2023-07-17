package com.example.springdatabasicdemo.controllers;

import com.example.springdatabasicdemo.dtos.HotelsDto;
import com.example.springdatabasicdemo.dtos.StudentDto;
import com.example.springdatabasicdemo.exceptions.StudentNotFoundException;
import com.example.springdatabasicdemo.services.HotelsService;
import com.example.springdatabasicdemo.services.StudentService;
import com.example.springdatabasicdemo.services.impl.ToursServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;


    @GetMapping("/students")
    Iterable<StudentDto> all() {
        return studentService.getAll();
    }


    @PostMapping("/students")
    StudentDto newStudent(@RequestBody StudentDto newStudent) {  return studentService.register(newStudent); }

    @GetMapping("/students/{id}")
    StudentDto one(@PathVariable Integer id) throws Throwable {

        return (StudentDto) studentService.findStudent(id)
                .orElseThrow(() -> new StudentNotFoundException(id));
    }

    @DeleteMapping("/students/{id}")
    void deleteStudent(@PathVariable Integer id) {
        studentService.expel(id);
    }

}
