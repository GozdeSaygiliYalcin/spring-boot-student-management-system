package com.example.sms.repository;

import com.example.sms.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * jpa repository iki tane parametre alıyor birisi
 * ilgili entity diğeriyse id ye ait tip
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
