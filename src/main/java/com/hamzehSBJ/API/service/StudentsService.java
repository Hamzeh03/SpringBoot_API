package com.hamzehSBJ.API.service;


import com.hamzehSBJ.API.model.Student;
import com.hamzehSBJ.API.repo.StudentsRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentsService {

    private final StudentsRepo studentsRepo;

    public StudentsService(StudentsRepo studentsRepo) {
        this.studentsRepo = studentsRepo;
    }

    public List<Student> getAll(){
        return studentsRepo.findAll();
    }

    public Student getById(int id){
        return studentsRepo.findById(id).orElse(null);
    }

    public Student create(Student student){
        return studentsRepo.save(student);
    }

    public Student update(int id , Student student){
        return studentsRepo.findById(id).map(s -> {
            s.setName(student.getName());
            s.setEmail(student.getEmail());
            s.setGPA(student.getGPA());
            return studentsRepo.save(s);
        }).orElse(null);
    }

    public void delete (int id){
        studentsRepo.deleteById(id);
    }

    public List<Student> search(Double gpa) {
        if (gpa != null) {
            return studentsRepo.findByGPA(gpa);
        }
        return List.of();
    }


}
