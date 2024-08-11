package com.example.spring_data_jpa.repository;

import com.example.spring_data_jpa.entity.Guardian;
import com.example.spring_data_jpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@SpringBootTest
//@DataJpaTest normally we should use this coz once the test is done it will flex the data it won't impact on the database,
    //but in our case it should impact the database, so we are going with the @SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent()
    {
        Student student = Student.builder()
                .emailId("karthi@gmail.com")
                .firstName("Karthi")
                .lastName("v")
//                .guardianEmail("vel@gmail.com")
//                .guardianMobile("9922334433")
//                .guardianName("Vel")
                .build();
        studentRepository.save(student);
    }
    @Test
    public void printAllStudent() {
        List<Student> studentList = studentRepository.findAll();

        System.out.println("studentList = " + studentList);

    }
    @Test
    public void printStudentWithGuardian() {
        Guardian guardian = Guardian.builder()
                .email("kumar@gmail.com")
                .name("Kumar")
                .mobile("9948339200")
                .build();

        Student student = Student.builder()
                .emailId("ganesh01@gmail.com")
                .firstName("Ganesh")
                .lastName("K")
                .guardian(guardian)
                .build();
        studentRepository.save(student);
        // the above example for parent child relationship
    }
    @Test
    public void findByFirstName()
    {
        List<Student> students = studentRepository.findByFirstName("karthi"); // custom method
        System.out.println("students = " + students);
    }
    @Test
    public void findByFirstNameContaining()
    {
        List<Student> students = studentRepository.findByFirstNameContaining("Mu"); // custom method
        System.out.println("students = " + students);
    }
@Test
    public void printStudentByEmailAddress ()
    {
        Student student = studentRepository.getStudentByEmailAddress("muthuvel@gmail.com");
        System.out.println("student = " + student);
    }
    @Test
    public void printStudentByEmailAddressNative ()
    {
        Student student = studentRepository.getStudentByEmailAddress("muthuvel@gmail.com");
        System.out.println("student = " + student);
    }
    @Test
    public void getStudentByEmailAddressNativeNamedParam ()
    {
        Student student = studentRepository.getStudentByEmailAddress("muthuvel@gmail.com");
        System.out.println("student = " + student);
    }
    @Test
    public void updateStudentNameByEmailId ()
    {
        studentRepository.updateStudentNameByEmailId("MuthuGanesh", "ganesh@gmail.com");
    }




}