package com.hamzehSBJ.API.repo;

import com.hamzehSBJ.API.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentsRepo extends JpaRepository<Student , Integer> {
    List<Student> findByGPA(Double gpa);
}
