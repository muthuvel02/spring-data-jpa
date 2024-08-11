package com.example.spring_data_jpa.repository;

import com.example.spring_data_jpa.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    public List<Student> findByFirstName (String firstName);

    public List<Student> findByFirstNameContaining (String firstName);

    //https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html checkout to create more custom method

    //JPQL queries it takes base on the class
    @Query("select s from Student s where s.emailId = ?1")
    Student getStudentByEmailAddress(String emailId);

    //native queries
    @Query(
            value = "SELECT * FROM tbl_student s where s.email_address = ?1",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNative(String emailId);

    //native queries Named Param
    @Query(
            value = "SELECT * FROM tbl_student s where s.email_address = :emailId",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNativeNamedParam( @Param("emailId") String emailId);

    //the example is for update fetch the data from the database
    //now we will see how to modify the data in the database
    @Modifying
    @Transactional // this is used to commit the changes which we made in the service to the database
    @Query(
            value = "update tbl_student set first_name = ?1 where email_address = ?2",
            nativeQuery = true
    )
    int updateStudentNameByEmailId( String firstName, String emailId);
}
