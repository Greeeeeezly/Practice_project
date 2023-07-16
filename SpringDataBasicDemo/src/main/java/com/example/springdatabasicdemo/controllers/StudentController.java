package com.example.springdatabasicdemo.controllers;

import com.example.springdatabasicdemo.dtos.HotelsDto;
import com.example.springdatabasicdemo.dtos.StudentDto;
import com.example.springdatabasicdemo.models.Hotels;
import com.example.springdatabasicdemo.services.HotelsService;
import com.example.springdatabasicdemo.services.StudentService;
import com.example.springdatabasicdemo.services.ToursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private HotelsService hotelsService;

    private final ToursService tourService;

    public StudentController(ToursService tourService) {
        this.tourService = tourService;
    }

    @GetMapping("/tours")
    public List<HotelsDto> getHotelsByTourId() {
        return tourService.getHotelsByTourId(1);
    }

    @GetMapping("/hotels")
    Iterable<HotelsDto> allHotels() {
        return hotelsService.getAll();
    }

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

   @GetMapping("/hotels/{id}")
   HotelsDto oneHotel(@PathVariable Integer id) throws Throwable {

        return (HotelsDto) hotelsService.findHotels(id).orElseThrow(() -> new StudentNotFoundException(id)); // Переделать

    }

    @DeleteMapping("/students/{id}")
    void deleteStudent(@PathVariable Integer id) {
        studentService.expel(id);
    }

    @DeleteMapping("/hotels/{id}")
    void deleteHotels(@PathVariable Integer id) {
        hotelsService.delete(id);
    }
}
