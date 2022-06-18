package com.tpe.dao;

import java.util.List;
import com.tpe.domain.Student;

public interface StudentRepository {

	List<Student> findAll();

	List<Student> findByLastName(String name);

	Student findById(Long id);

	void create(Student student);

	void update(Student student);

	void delete(Long id);

}
