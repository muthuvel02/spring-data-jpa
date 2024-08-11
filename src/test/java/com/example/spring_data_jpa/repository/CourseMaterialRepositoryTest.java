package com.example.spring_data_jpa.repository;

import com.example.spring_data_jpa.entity.Course;
import com.example.spring_data_jpa.entity.CourseMaterial;
import lombok.ToString;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CourseMaterialRepositoryTest {
    @Autowired
    private CourseMaterialRepository repository;
@Test
    public void saveCourseMaterialWithCourse (){
        Course course = Course.builder()
                .title("SpringBoot")
                .credit(9)
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.springBoot.com")
                .course(course)
                .build();

        repository.save(courseMaterial);
    }
@Test
 public void printOnlyCourseMaterial(){
     List<CourseMaterial> materials = repository.findAll();
     System.out.println("materials = " + materials);
 }
}