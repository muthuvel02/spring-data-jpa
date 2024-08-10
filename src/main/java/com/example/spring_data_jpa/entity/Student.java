package com.example.spring_data_jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // this is used to indicating that this is table
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table( // this annotation is used to create a new table for as
        name= "tbl_student",
        uniqueConstraints = @UniqueConstraint( // this is to get a unique value form the user
                name = "email_unique",
                columnNames = "email_address"

                )
)
public class Student {
    @Id // this is indicating the studentId is a primary key
    @SequenceGenerator( // we are creating a sequence
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE, // in which we're telling them it is the sequence type
            generator = "student_sequence" // here we are using the sequence which we created.
    )
    private Long studentId;
    private String firstName;
    private String lastName;
    @Column(
            name = "email_address",
            nullable = false
    )
    private String emailId;
    @Embedded
    private Guardian guardian;


}
