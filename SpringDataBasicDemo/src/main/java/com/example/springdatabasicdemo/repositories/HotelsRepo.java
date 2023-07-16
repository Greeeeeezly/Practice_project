package com.example.springdatabasicdemo.repositories;

import com.example.springdatabasicdemo.models.Hotels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelsRepo extends JpaRepository<Hotels, Integer> {

}
