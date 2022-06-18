package com.tpe.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.tpe.domain.Student;

@Repository // aynı zamanda @component, içine bakılabilir
public class StudentRepositoryMemImpl implements StudentRepository {

	private Map<Long, Student> studentMap = new HashMap<>();

	public StudentRepositoryMemImpl() { // varitabanı ile çalışmayacağımız için consrustor
										// içinde hazır objeler oluşturuyoruz
		Student student1 = new Student();
		student1.setId(1L);
		student1.setFirstName("John");
		student1.setLastName("Coffee");
		student1.setGrade(10);
		Student student2 = new Student();
		student2.setId(2L);
		student2.setFirstName("James");
		student2.setLastName("Bond");
		student2.setGrade(11);

		Student student3 = new Student();
		student3.setId(3L);
		student3.setFirstName("Darth");
		student3.setLastName("Vader");
		student3.setGrade(9);
		Student student4 = new Student();
		student4.setId(4L);
		student4.setFirstName("Iron");
		student4.setLastName("Man");
		student4.setGrade(10);
		
		studentMap.put(student1.getId(), student1);
		studentMap.put(student2.getId(), student2);
		studentMap.put(student3.getId(), student3);
		studentMap.put(student4.getId(), student4);

	}

	@Override
	public List<Student> findAll() {

		return new ArrayList<Student>(studentMap.values());
	}

	@Override
	public List<Student> findByLastName(String lastName) {
		return studentMap.values().stream().filter(s -> s.getLastName().equals(lastName)).collect(Collectors.toList());
	}

	@Override
	public Student findById(Long id) {
		return studentMap.get(id);
	}

	@Override
	public void create(Student student) {
		student.setId(new Date().getTime());  // getTime() , Long tipi döndürdüğü için ID değişkenimi bununla set ediyorum.
		studentMap.put(student.getId(), student);

	}

	@Override
	public void update(Student student) {
		studentMap.replace(student.getId(), student);

	}

	@Override
	public void delete(Long id) {
		studentMap.remove(id);

	}

}
