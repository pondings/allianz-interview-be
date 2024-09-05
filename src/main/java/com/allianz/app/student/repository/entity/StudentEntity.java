package com.allianz.app.student.repository.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "student")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentEntity {

    @Id
    String id;

    String firstName;
    String lastName;
    Long age;

}
