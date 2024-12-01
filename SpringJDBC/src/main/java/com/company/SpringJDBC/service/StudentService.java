package com.company.SpringJDBC.service;

import com.company.SpringJDBC.model.Student;
import com.company.SpringJDBC.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {


    private StudentRepo studentRepo;

    public StudentRepo getStudentRepo() {
        return studentRepo;
    }

    @Autowired
    public void setStudentRepo(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public void addStudent(Student std){
      studentRepo.save(std);
    }

    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }
}
