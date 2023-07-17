package com.example.springdatabasicdemo.repositories;

import com.example.springdatabasicdemo.models.Student;
import com.example.springdatabasicdemo.models.Tours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToursRepo extends JpaRepository<Tours, Integer> {
}
