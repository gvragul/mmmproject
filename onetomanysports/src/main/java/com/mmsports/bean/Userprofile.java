package com.mmsports.bean;
import java.math.BigInteger;
import java.sql.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "userprofile")
public class Userprofile {
	
	public Userprofile(Long userid, String name, String surname, String username, String email, Date dob, String gender,
			String city, BigInteger phoneno) {
		super();
		this.userid = userid;
		this.name = name;
		this.surname = surname;
		this.username = username;
		this.email = email;
		this.dob = dob;
		this.gender = gender;
		this.city = city;
		this.phoneno = phoneno;
	}

	public Long getUserId() {
		return userid;
	}

	public void setUserId(Long userid) {
		this.userid = userid;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public BigInteger getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(BigInteger phoneno) {
		this.phoneno = phoneno;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userId")
	private Long userid;
	@NotNull
	@NotBlank
	@Size(min = 3, max = 20, message = "enter proper  name")
	@Column(name = "name")
	private String name;
	@Column(name = "sur_name")
	private String surname;
	@NotNull
	@NotBlank
	@Size(min = 4, max = 15, message = "enter proper username")
	@Column(name = "user_name")
	private String username;
	@NotNull
	@NotBlank	
	@Column(name = "email")
	private String email;
	@Column(name = "date_of_birth")
	private Date dob;
	@Column(name = "gender")
	private String gender;
	@NotNull
	@NotBlank
	@Column(name = "city")
	private String city;
	@Column(name="phoneno")
	private BigInteger phoneno;
	@JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sports_userid")
    private Sports sports;
	
	public Userprofile() {}

	public Sports getSports() {
		return sports;
	}

	public void setSports(Sports sports) {
		this.sports = sports;
	}
	 @Override
	    public String toString() {
	        return "user [id=" + userid + ", name=" + username + "]";
	    }

	
}
