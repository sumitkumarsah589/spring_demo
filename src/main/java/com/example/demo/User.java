package com.example.demo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4699201014521278881L;
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String age;
	private String gender;

	public synchronized int getId() {
		return id;
	}

	public synchronized void setId(int id) {
		this.id = id;
	}

	public synchronized String getName() {
		return name;
	}

	public synchronized void setName(String name) {
		this.name = name;
	}

	public synchronized String getAge() {
		return age;
	}

	public synchronized void setAge(String age) {
		this.age = age;
	}

	public synchronized String getGender() {
		return gender;
	}

	public synchronized void setGender(String gender) {
		this.gender = gender;
	}
}
