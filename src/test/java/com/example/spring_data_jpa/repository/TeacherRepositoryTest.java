package com.example.spring_data_jpa.repository;

import com.example.spring_data_jpa.entity.Course;
import com.example.spring_data_jpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher ()
    {
        Course java = Course.builder()
                .title("JAVA")
                .credit(8)
                .build();
        Course collections = Course.builder()
                .title("Collections")
                .credit(8)
                .build();
        Course exceptionHandling = Course.builder()
                .title("ExceptionHandling")
                .credit(8)
                .build();


        Teacher teacher = Teacher.builder()
                .firstName("Durga")
                .lastName("M")
//                .courseList(List.of(java,collections,exceptionHandling))
                .build();
        teacherRepository.save(teacher);
    }

}