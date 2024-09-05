package com.allianz.app.student.service;

import com.allianz.app.student.mapper.StudentMapper;
import com.allianz.app.student.model.StudentDto;
import com.allianz.app.student.repository.StudentRepository;
import com.allianz.app.student.repository.entity.StudentEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentService {

    StudentRepository studentRepository;
    StudentMapper studentMapper;

    public List<StudentDto> getAll() {
        return studentRepository.findAll()
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
