package com.allianz.app.student.repository;

import com.allianz.app.student.repository.entity.StudentEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.ListQuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends MongoRepository<StudentEntity, String>, ListQuerydslPredicateExecutor<StudentEntity> {
}
