package com.example.crudexample.service;

import java.util.List;

import com.example.crudexample.model.Student;

public interface StudentService 
{
	Student saveStud(Student student);
	Student findid(Integer id);
	Student updateStud(Student student);
	void deleteStud(Integer id);
	List<Student> getAllStudents();
}
