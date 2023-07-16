package com.example.springdatabasicdemo.controllers;

import com.example.springdatabasicdemo.dtos.HotelsDto;
import com.example.springdatabasicdemo.models.Hotels;
import com.example.springdatabasicdemo.services.ToursService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class ToursController {
    private final ToursService tourService;

    public ToursController(ToursService tourService) {
        this.tourService = tourService;
    }

    @GetMapping("/tours/{id}")
    public List<HotelsDto> getHotelsByTourId(@PathVariable Integer id) {
        return tourService.getHotelsByTourId(id);
    }
    @GetMapping("/{id}")
    public Integer getid(@PathVariable Integer id) {
        return id;
    }

}
