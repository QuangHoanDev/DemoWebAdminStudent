package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repository.IStudentRepo;

@Service
public class StudentServiceImpl implements IstudentService{
	
	@Autowired
	private IStudentRepo studentRepo;

	@Override
	public List<Student> listAll() {
		// TODO Auto-generated method stub
		return studentRepo.findAll();
	}

	@Override
	public Student getById(int id) {
		// TODO Auto-generated method stub
		return studentRepo.getOne(id);
	}

	@Override
	public boolean deleteStudentById(int id) {
		// TODO Auto-generated method stub
		 studentRepo.deleteById(id);
		 return true;
	}

	@Override
	public Student addStudent(Student student) {
		// TODO Auto-generated method stub
		
		return studentRepo.save(student);
	}

	@Override
	public int updateStudent(int id, Student student) {
		// TODO Auto-generated method stub
//		studentRepo.findById(id);
		return 0;
	}

}
