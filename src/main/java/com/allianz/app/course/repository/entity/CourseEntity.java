package com.allianz.app.course.repository.entity;

import com.allianz.app.student.repository.entity.StudentEntity;
import com.querydsl.core.annotations.QueryEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@QueryEntity
@Document(collection = "course")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CourseEntity {

    @Id
    String id;
    String name;
    String learningTime;
    String status;

}
