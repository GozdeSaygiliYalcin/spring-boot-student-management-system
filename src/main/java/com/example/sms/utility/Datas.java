package com.example.sms.utility;

import com.example.sms.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class Datas {

    private List<Student> studentList;

    public List<Student> getStudentList() {
        studentList = new ArrayList<>();
        studentList.add(Student.builder()
                        .firstName("gozde")
                        .lastName("saygili")
                        .email("saygiligozde@gmail.com")
                .build());
        studentList.add(Student.builder()
                .firstName("boncuk")
                .lastName("saygili")
                .email("boncuk@gmail.com")
                .build());
        return studentList;
    }
}
