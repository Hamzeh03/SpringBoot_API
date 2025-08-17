package com.hamzehSBJ.API.controller;


import com.hamzehSBJ.API.model.Student;
import com.hamzehSBJ.API.service.StudentsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentsController {


    private final StudentsService studentsService;

    public StudentsController(StudentsService service) {
        this.studentsService = service;
    }

    // Get all students
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentsService.getAll();
        return ResponseEntity.ok(students); // 200
    }

    // Get student by ID
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id) {
        Student student = studentsService.getById(id);
        if (student == null) {
            return ResponseEntity.notFound().build(); // 404
        }
        return ResponseEntity.ok(student); // 200
    }

    // Get GPA for Student by ID
    @GetMapping("/{id}/gpa")
    public ResponseEntity<Double> getGPAForStudentById(@PathVariable int id) {
        Student student = studentsService.getById(id);
        if (student == null) {
            return ResponseEntity.notFound().build(); // 404
        }
        return ResponseEntity.ok(student.getGPA()); // 200
    }

    // Search for student by his gpa
    @GetMapping("/search")
    public ResponseEntity<List<Student>> searchStudents(
            @RequestParam(required = false) Double gpa) {

        List<Student> results = studentsService.search(gpa);

        if (results.isEmpty()) {
            return ResponseEntity.noContent().build(); // 204 if nothing found
        }
        return ResponseEntity.ok(results); // 200 with results
    }


    // Create new student
    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student created = studentsService.create(student);
        return ResponseEntity.status(201).body(created); // 201 Created
    }

    // Update student
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student student) {
        Student updated = studentsService.update(id, student);
        if (updated == null) {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
        return ResponseEntity.ok(updated); // 200 OK
    }

    // Delete student
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable int id) {
        Student existing = studentsService.getById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
        studentsService.delete(id);
        return ResponseEntity.noContent().build(); // 204 No Content
    }
}
