package com.example.springdatabasicdemo.repositories;

import com.example.springdatabasicdemo.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findAllByGroupName(String groupName);
}
