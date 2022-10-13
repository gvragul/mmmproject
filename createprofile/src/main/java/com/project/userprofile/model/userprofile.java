package com.project.userprofile.model;
import java.sql.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "userprofile")
public class userprofile {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	public userprofile(Long id, String name, String surname, String username, String email, Long contactno, Date dob,
			String gender, String city) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.username = username;
		this.email = email;
		this.contactno = contactno;
		this.dob = dob;
		this.gender = gender;
		this.city = city;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getemail() {
		return email;
	}
	public void setemail(String email) {
		this.email = email;
	}
	public Long getcontactno() {
		return contactno;
	}
	public void setcontactno(Long contactno) {
		this.contactno = contactno;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Column(name = "name")
	private String name;
	@Column(name = "sur_name")
	private String surname;
	@Column(name = "user_name")
	private String username;
	@Column(name = "email")
	private String email;
	@Column(name = "contactno")
	private Long contactno;
	@Column(name = "date_of_birth")
	private Date dob;
	@Column(name = "gender")
	private String gender;
	@Column(name = "city")
	private String city;
	
	public userprofile() {}
}
