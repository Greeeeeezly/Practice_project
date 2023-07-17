package com.example.springdatabasicdemo.controllers;

import com.example.springdatabasicdemo.dtos.ClientsDto;
import com.example.springdatabasicdemo.dtos.CountriesDto;
import com.example.springdatabasicdemo.dtos.StudentDto;
import com.example.springdatabasicdemo.exceptions.ClientNotFoundException;
import com.example.springdatabasicdemo.exceptions.StudentNotFoundException;
import com.example.springdatabasicdemo.models.Clients;
import com.example.springdatabasicdemo.services.ClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

public class ClientsController {
    @Autowired
    private ClientsService clientsService;

    @PostMapping("/clients/update")
    ClientsDto updateCountry(@RequestBody ClientsDto clientsDto){
        return clientsService.register(clientsDto);
    }
    @GetMapping("/clients")
    Iterable<StudentDto> allClients() {
        return clientsService.getAll();
    }

    @PostMapping("/clients")
    ClientsDto newCountry(@RequestBody ClientsDto clientsDto) {  return clientsService.register(clientsDto); }

    @GetMapping("/clients/{id}")
    ClientsDto oneCountry(@PathVariable Integer id) throws Throwable {
        return (ClientsDto) clientsService.findClient(id)
                .orElseThrow(() -> new ClientNotFoundException(id));
    }

    @DeleteMapping("/clients/{id}")
    void deleteCountry(@PathVariable Integer id) {
        clientsService.delete(id);
    }
}
