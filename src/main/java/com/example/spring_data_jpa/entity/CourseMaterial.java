package com.example.spring_data_jpa.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "course") // we are removing it check the fetch.lazy type coz it will run only the child which is course materials... so we are removing it..

public class CourseMaterial {
    @Id
    @SequenceGenerator(
            name= "course_material_sequence",
            sequenceName = "course_material_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_material_sequence"
    )
    private Long courseMaterialId;
    private String url;
    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, // used to run only the child which is only course materials not course to get the course use Eager
            optional = false // which means we should add course and the course materials if we are not adding both, it will trow an error
    )
    @JoinColumn(
            name = "course_id",
            referencedColumnName = "courseId"
    )
    private Course course;

}
