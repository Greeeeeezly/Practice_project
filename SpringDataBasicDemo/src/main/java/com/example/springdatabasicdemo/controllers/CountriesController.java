package com.example.springdatabasicdemo.controllers;

import com.example.springdatabasicdemo.dtos.CountriesDto;
import com.example.springdatabasicdemo.dtos.StudentDto;
import com.example.springdatabasicdemo.exceptions.CountryNotFoundException;
import com.example.springdatabasicdemo.exceptions.StudentNotFoundException;
import com.example.springdatabasicdemo.services.CountriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CountriesController {
    @Autowired
    private CountriesService countriesService;

    @PostMapping("/countries/update")
    CountriesDto updateCountry(@RequestBody CountriesDto countriesDto){
        return countriesService.register(countriesDto);
    }
    @GetMapping("/countries")
    Iterable<StudentDto> allCountries() {
        return countriesService.getAll();
    }

    @PostMapping("/countries")
    CountriesDto newCountry(@RequestBody CountriesDto countriesDto) {  return countriesService.register(countriesDto); }

    @GetMapping("/countries/{id}")
    CountriesDto oneCountry(@PathVariable Integer id) throws Throwable {
        return (CountriesDto) countriesService.findCountry(id)
                .orElseThrow(() -> new CountryNotFoundException(id));
    }

    @DeleteMapping("/countries/{id}")
    void deleteCountry(@PathVariable Integer id) {
        countriesService.delete(id);
    }
}
