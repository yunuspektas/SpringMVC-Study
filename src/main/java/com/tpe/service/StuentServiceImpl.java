package com.tpe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tpe.dao.StudentRepository;
import com.tpe.domain.Student;
import com.tpe.exception.ResourceNotFoundException;

@Service // burası servis katmanı olduğu için bu annotationı kullandık,
			// içine girerseniz aslında kendisi @Component annotationı kapsadığı gözüküyor
public class StuentServiceImpl implements StudentService {

	private StudentRepository studentRepository;

	// Field, Constructor, Setter  ( dependency Injection türleri )

	@Autowired // Burada consructor injection kullanıldı.Sadece bir constructor var ise
				// Autowired koymaya gerek yok aslınd am konulmasının sebebi projeyi okuyanın daha rahat anlamasını sağlamak
	public StuentServiceImpl(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	@Override
	public List<Student> getAll() {
		return studentRepository.findAll();
	}

	@Override
	public List<Student> findStudents(String lastName) {
		return studentRepository.findByLastName(lastName);
	}

	@Override
	public Student findStudent(Long id) throws ResourceNotFoundException {
		Student student = studentRepository.findById(id);
		if (student == null) {
			throw new ResourceNotFoundException("Student not found with id:" + id);
		}
		return student;
	}

	@Override
	public void createStudent(Student student) {
		studentRepository.create(student);
	}

	@Override
	public void updateStudent(Student student) {
		studentRepository.update(student);
	}

	@Override
	public void deleteStudent(Long id) {
		studentRepository.delete(id);
	}

}
