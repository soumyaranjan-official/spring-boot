package com.devmix.student.service;

import com.devmix.student.entity.StudentEntity;

public interface StudentService {

    public StudentEntity insertStudent(StudentEntity studentEntity);
    public StudentEntity findStudentById(String id);
}
