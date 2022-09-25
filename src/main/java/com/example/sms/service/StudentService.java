package com.example.sms.service;

import com.example.sms.entity.Student;

import java.util.List;

/**
 * bu kısım controllere yapılacak
 * işi aktarmmadan önce işi tanımladığımız interface
 */
public interface StudentService {

    List<Student> getAllStudents();

    Iterable<Student> saveAll(Iterable<Student> entities);

    Student saveStudent(Student student);

    Student getStudentById(Long id);

    Student updateStudent(Student student);

    void deleteStudentById(Long id);
}
