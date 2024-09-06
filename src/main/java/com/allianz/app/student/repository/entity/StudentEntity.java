package com.allianz.app.student.repository.entity;

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
@Document(collection = "student")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentEntity {

    @Id
    String id;

    String firstName;
    String lastName;
    Long age;

}
