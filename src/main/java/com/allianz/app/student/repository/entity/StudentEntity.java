package com.allianz.app.student.repository.entity;

import com.allianz.app.course.repository.entity.CourseEntity;
import com.querydsl.core.annotations.QueryEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Getter
@Setter
@QueryEntity
@Document(collection = "student")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentEntity {

    @Id
    String id;

    String firstName;
    String lastName;
    Long age;
    String status;

    @DocumentReference
    List<CourseEntity> courses;

}
