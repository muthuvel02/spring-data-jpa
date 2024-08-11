package com.example.spring_data_jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Teacher {
    @Id
    @SequenceGenerator(
            name = "teacher_sequence",
            sequenceName = "teacher_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "teacher_sequence"
    )
    private Long teacherId;
    private String firstName;
    private String lastName;
//@OneToMany(
//        cascade = CascadeType.ALL
//
//)
//@JoinColumn( // here we are referencing the teacher_id to the course 6:15
//        name ="teacher_id",
//        referencedColumnName = "teacherId"
//)
//    private List<Course> courseList;
//// here are defining that one teacher has many courses

    // insted of using this we will use ManyToOne, which means many courses can be though by one teacher just we are reversing them go a check the course entity
}
