package com.internet.base.application.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity(name = "Users")
@Table(name = "users")
@NamedQuery(name = "Users.findAll", query = "SELECT c FROM Users c")
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Lob
	private String name;
	@Lob
	private String surname;

	@Lob
	private String email;


	public Users() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

	public Users(Long id) {
		this.id = id;
	}

	public Users(Long id, String name, String surname, String email) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.email = email;
	}

	

}
