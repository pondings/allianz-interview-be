package com.allianz.app.student.service;

import com.allianz.app.common.constant.Status;
import com.allianz.app.student.mapper.StudentMapper;
import com.allianz.app.student.model.StudentCriteria;
import com.allianz.app.student.model.StudentDto;
import com.allianz.app.student.repository.StudentRepository;
import com.allianz.app.student.repository.entity.QStudentEntity;
import com.allianz.app.student.repository.entity.StudentEntity;
import com.querydsl.core.BooleanBuilder;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentService {

    StudentRepository studentRepository;
    StudentMapper studentMapper;

    public List<StudentDto> getAll(StudentCriteria criteria) {
        BooleanBuilder builder = new BooleanBuilder();

        if (StringUtils.isNotEmpty(criteria.getFirstName())) {
            builder.and(QStudentEntity.studentEntity.firstName.likeIgnoreCase(String.format("%%%s%%", criteria.getFirstName())));
        }
        if (StringUtils.isNotEmpty(criteria.getLastName())) {
            builder.and(QStudentEntity.studentEntity.lastName.likeIgnoreCase(String.format("%%%s%%", criteria.getLastName())));
        }
        if (Objects.nonNull(criteria.getAge())) {
            builder.and(QStudentEntity.studentEntity.age.eq(criteria.getAge()));
        }

        builder.and(QStudentEntity.studentEntity.courses.any().status.eq(Status.ACTIVE.toString()));
        builder.and(QStudentEntity.studentEntity.status.eq(Status.ACTIVE.toString()));

        return studentRepository.findAll(builder)
                .stream()
                .map(studentMapper::toDto)
                .toList();
    }

    public StudentDto create(StudentDto studentDto) {
        log.info("[START] Create student: {}", studentDto.toString());
        return Optional.of(studentDto)
                .map(studentMapper::toEntity)
                .map(studentRepository::save)
                .map(studentMapper::toDto)
                .orElseThrow(RuntimeException::new);
    }

    public StudentDto update(String id, StudentDto dto) {
        log.info("[START] Update student: {}", dto.toString());
        StudentEntity entity = studentRepository.findById(id)
                .orElseThrow(RuntimeException::new);

        dto.setId(entity.getId());
        return Optional.of(dto)
                .map(studentMapper::toEntity)
                .map(studentRepository::save)
                .map(studentMapper::toDto)
                .orElseThrow(RuntimeException::new);
    }

    public void delete(String id) {
        studentRepository.deleteById(id);
    }

}
