package com.allianz.app.student.controller;

import com.allianz.app.student.model.StudentDto;
import com.allianz.app.student.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/student")
public class StudentController {

    StudentService studentService;

    @GetMapping
    public List<StudentDto> getAll() {
        return studentService.getAll();
    }

    @PostMapping
    public StudentDto create(@RequestBody StudentDto dto) {
        return studentService.create(dto);
    }

    @PutMapping("/{id}")
    public StudentDto update(@RequestBody StudentDto dto, @PathVariable String id) {
        return studentService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        studentService.delete(id);
    }

}
