package com.allianz.app.student.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentDto {

    String id;
    String firstName;
    String lastName;
    Long age;

}
