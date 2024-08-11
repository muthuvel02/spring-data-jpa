package com.example.spring_data_jpa.repository;

import com.example.spring_data_jpa.entity.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CourseRepositoryTest {
    @Autowired
    private CourseRepository courseRepository;
    
    @Test
    public void printAllCourse ()
    {
        List<Course> courses = courseRepository.findAll();
        System.out.println("courses = " + courses);
    }
    @Test
    public void saveCourseWithTeacher()
    {
        Teacher teacher = Teacher.builder()
                .firstName("Harry")
                .lastName("H")
                .build();

        Course course = Course.builder()
                .title("C++")
                .credit(5)
                .teacher(teacher)
                .build();
        courseRepository.save(course);
    }

    @Test
    public void saveCourseWithStudentAndTeacher() // the final one
    {
        Guardian guardian = Guardian.builder()
                .email("jack@gmail.com")
                .name("Jack")
                .mobile("9948334433")
                .build();

        Student student = Student.builder()
                .emailId("alan@gmail.com")
                .firstName("Alan")
                .lastName("raj")
                .guardian(guardian)
                .build();
        Teacher teacher = Teacher.builder()
                .firstName("DailyCodeBuffer")
                .lastName("Y")
                .build();
        Course course = Course.builder()
                .title("SpringSecurity")
                .credit(10)
                .teacher(teacher)
                .build();
        course.addStudent(student);

        courseRepository.save(course);
    }

}