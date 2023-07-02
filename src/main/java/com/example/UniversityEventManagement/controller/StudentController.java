package com.example.UniversityEventManagement.controller;

import com.example.UniversityEventManagement.model.Department;
import com.example.UniversityEventManagement.model.Student;
import com.example.UniversityEventManagement.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @PostMapping("/add-student")
    private ResponseEntity<String> addStudent(@Valid @RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @GetMapping("/get-all-student")
    private ResponseEntity<List<Student>> getAllStudent() {
        return studentService.getAllStudent();
    }

    @PutMapping("/update-stuedent-department")
    private ResponseEntity<String> updateStudentDepartment(@RequestParam Department department, @RequestParam int studentId) {
        return studentService.updateStudentDepartment(department, studentId);
    }

    @DeleteMapping("/delete-student")
    private ResponseEntity<String> deleteStudent(@RequestParam int studentId) {
        return studentService.deleteStudent(studentId);
    }

    @GetMapping("/get-student-by-id")
    private ResponseEntity<Student> getStudentById(@RequestParam int studentId) {
        return studentService.getStudentById(studentId);
    }

}
