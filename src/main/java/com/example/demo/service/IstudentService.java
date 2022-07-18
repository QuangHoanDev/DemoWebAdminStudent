package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Student;

public interface IstudentService {

	public List<Student> listAll();
	
	public Student getById(int id);
	
	public boolean deleteStudentById(int id);
	
	public Student addStudent(Student student);
	
	public int updateStudent(int id, Student student);
	
	
}
