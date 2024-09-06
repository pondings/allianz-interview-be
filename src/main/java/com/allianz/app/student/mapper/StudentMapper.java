package com.allianz.app.student.mapper;

import com.allianz.app.student.model.StudentDto;
import com.allianz.app.student.repository.entity.StudentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    StudentDto toDto(StudentEntity entity);

    StudentEntity toEntity(StudentDto studentDto);

}
