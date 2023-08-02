package com.example.service;

import com.example.bean.Student;
import com.example.repository.StudentRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService
{
  @Autowired
  StudentRepository studentRepository;
  @Override
  public void createOrUpdate(Student s) {
    studentRepository.createOrUpdate(s);
  }
  @Override
  public Student findById(String id) {
    return studentRepository.findById(id);
  }
  @Override
  public List<Student> findAll() {
    return studentRepository.findAll();
  }
  @Override
  public void deleteById(String id) {
    studentRepository.deleteById(id);
  }
}

