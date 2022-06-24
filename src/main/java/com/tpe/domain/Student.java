 package com.tpe.domain;

import java.time.LocalDateTime;

public class Student {

	private Long id;  // id değişkene primitive tip vermememizin sebebi : int vermiş olsaydık ve değeri 
	// set etmediğimizde int in defaultun değeri "0" oldugu için "0" set edecekti, ben bunu istemediğim 
	// için non-primitive tip olan Long atadım, böylelikle ,deger set edilmediğinde null ataması yapılacak.
	private String firstName;
	private String lastName;
	private Integer grade;
	private LocalDateTime createDate = LocalDateTime.now();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

}