package com.example.crudexample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crudexample.model.Student;
import com.example.crudexample.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController
{
	StudentService studentService;
	@Autowired
	public StudentController(StudentService studentService)
	{
		this.studentService=studentService;
	}

	@PostMapping(value = "/insertstud")
	public Student addStudent( @RequestBody Student std)
	{
		Student obj = studentService.saveStud(std);
		return obj;
	}
	@GetMapping(value = "/student")
	public List<Student> getAllStudents()
	{
		return studentService.getAllStudents();	
	}
	@GetMapping(value = "/student/{id}")
	public Student getStudentById(@PathVariable("id") Integer id)
	{
		Student std= studentService.findid(id);
		return std;
	}
	
	@PutMapping(value = "/{id}")
	public Student updateStudent(@PathVariable("id") Integer id, @RequestBody Student newstd)
	{
		Student st=studentService.findid(id);
		st.setName(newstd.getName());
		st.setAddress(newstd.getAddress());
		st.setContact(newstd.getContact());
		st.setEmail(newstd.getEmail());
		
		Student std=studentService.updateStud(st);
		return std;
	}
	
	@DeleteMapping(value ="/{id}" )
	public String deleteStudent(@PathVariable("id") Integer id)
	{
		Student std=studentService.findid(id);
		studentService.deleteStud(std.getId());
		return "Student with ID"+id+"is Deleted";
	}
	
}
