package com.example.UniversityEventManagement.service;

import com.example.UniversityEventManagement.model.Department;
import com.example.UniversityEventManagement.model.Student;
import com.example.UniversityEventManagement.repository.StudentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepo studentRepo;

    public ResponseEntity<String> addStudent(Student student) {
        studentRepo.save(student);
        return new ResponseEntity<>("Student Saved Successfully", HttpStatus.CREATED);
    }

    public ResponseEntity<List<Student>> getAllStudent() {
        List<Student> studentList = studentRepo.findAll();
        return new ResponseEntity<>(studentList, HttpStatus.OK);
    }

    public ResponseEntity<String> updateStudentDepartment(Department department, int studentId) {
        if (studentRepo.existsById(studentId)) {
            Student student = studentRepo.findById(studentId).get();
            student.setDepartment(department);
            return new ResponseEntity<>("student department is updated successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Student with the following id is not foung", HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<String> deleteStudent(int studentId) {
        if (studentRepo.existsById(studentId)) {
            studentRepo.deleteById(studentId);
            return new ResponseEntity<>("student is deleted successfully", HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>("Student with the following id is not present", HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Student> getStudentById(int studentId) {
        Student student = null;
        if (studentRepo.existsById(studentId)) {
            student = studentRepo.findById(studentId).get();
            return new ResponseEntity<>(student, HttpStatus.OK);
        }
        return new ResponseEntity<>(student, HttpStatus.NOT_FOUND);
    }
}
