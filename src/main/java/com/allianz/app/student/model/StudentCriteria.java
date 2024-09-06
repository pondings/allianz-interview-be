package com.allianz.app.student.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentCriteria {

    String firstName;
    String lastName;
    Long age;

}
