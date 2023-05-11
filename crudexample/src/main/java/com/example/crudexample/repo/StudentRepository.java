package com.example.crudexample.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.crudexample.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>
{

}
