package com.example.spring_data_jpa.repository;

import com.example.spring_data_jpa.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
