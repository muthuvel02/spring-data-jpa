package com.example.spring_data_jpa.repository;

import com.example.spring_data_jpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    public List<Student> findByFirstName (String firstName);

    public List<Student> findByFirstNameContaining (String firstName);

    //https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html checkout to create more custom method


}
