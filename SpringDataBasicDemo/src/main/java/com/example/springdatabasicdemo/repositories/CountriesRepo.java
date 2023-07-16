package com.example.springdatabasicdemo.repositories;

import com.example.springdatabasicdemo.models.Countries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountriesRepo extends JpaRepository<Countries, Integer> {
}
