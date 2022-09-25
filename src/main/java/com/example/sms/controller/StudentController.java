package com.example.sms.controller;

import static com.example.sms.constant.Api.*;
import com.example.sms.entity.Student;
import com.example.sms.service.StudentService;
import com.example.sms.utility.Datas;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
//@RequestMapping("/sms")
public class StudentController {

    /**
     * controllerde çalışabilmesi için
     * service classından nesne yaratıyoruz
     * interface olduğu için nasıl yaratıyoruz?
     */
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        super();
        this.studentService = studentService;
    }
    /**
     *
     * handler method
     * we created html to display
     * the list of students in students.html
     */
    @GetMapping(LISTSTUDENTS)
    public String listStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "students";
    }
    @GetMapping(SAVEALLSTUDENTS)
    public ResponseEntity<Void> saveAll() {
        try {
            studentService.saveAll(new Datas().getStudentList());
            System.out.println("All datas are saved successfully!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }
    @GetMapping(CREATESTUDENTFORM)
    public String createStudentForm(Model model) {
        //öğrenci kayıt alma metodu
        Student student = new Student();
        model.addAttribute("student", student);
        return "create_student";
    }
    /**
     *  //model attribute annotation used to bind
     *  form data and object directly
     */
    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        return "redirect:/students";
    }
    /**
     *path variable annotation uses to get id
     */
    @GetMapping(EDITSTUDENTFORM)
    public String editStudentForm(@PathVariable Long id, Model model) {
        model.addAttribute("student", studentService.getStudentById(id));
        return  "edit_student";
    }
    @PostMapping(UPDATESTUDENT)
    public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student,
                                Model model) {

        //get student from database by id
        Student existingStudent = studentService.getStudentById(id);
        existingStudent.setId(id); //? buna gerek yok diye düşünüyorum
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());

        /**
         * save again updated student object
         * we should redirect student page
        */
        studentService.updateStudent(existingStudent);
        return "redirect:/students";
    }
    /**
     * handler method to handle delete action
     */
    @GetMapping(DELETESTUDENT)
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudentById(id);
        return "redirect:/students";
    }
}
