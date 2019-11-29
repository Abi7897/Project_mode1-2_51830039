package com.patient.model.persistance;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "patient_table1")
public class Patient {
	@Id
	@GeneratedValue
	private int id;
	@NotEmpty(message="name can not be left blank")
	private String name;
	@NotEmpty(message="city can not be left blank")
	private String city;
	private int age;
	@NotEmpty(message="phoneno can not be null")
	private String phoneno;
	private int roomno;

	public Patient() {
		super();
	}

	public Patient(String name, String city, int age, String phoneno, int roomno) {

		this.name = name;
		this.city = city;
		this.age = age;
		this.phoneno = phoneno;
		this.roomno = roomno;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public int getRoomno() {
		return roomno;
	}

	public void setRoomno(int roomno) {
		this.roomno = roomno;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", city=" + city + ", age=" + age + ", phoneno=" + phoneno
				+ ", roomno=" + roomno + "]";
	}

}
