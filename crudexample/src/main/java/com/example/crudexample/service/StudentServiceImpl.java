package com.example.crudexample.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crudexample.model.Student;
import com.example.crudexample.repo.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService
{
	StudentRepository studentRepo;
	@Autowired
	public StudentServiceImpl(StudentRepository studentRepo) {
		this.studentRepo = studentRepo;
	}
	@Override
	public Student saveStud(Student student) {
		// TODO Auto-generated method stub
		return studentRepo.save(student);
	}
	@Override
	public Student findid(Integer id) {
		// TODO Auto-generated method stub
		Optional<Student> obj=studentRepo.findById(id);
		return obj.get();
	}
	@Override
	public Student updateStud(Student student) {
		// TODO Auto-generated method stub
		Student st=studentRepo.findById(student.getId()).get();
		st.setName(student.getName());
		st.setAddress(student.getAddress());
		st.setContact(student.getContact());
		st.setEmail(student.getEmail());
		
		Student stud=studentRepo.save(st);
		return stud;	}
	@Override
	public void deleteStud(Integer id) {
		// TODO Auto-generated method stub
		studentRepo.deleteById(id);
	}
	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return studentRepo.findAll();
	}
}
	
