package profile.one2one.model;

import java.sql.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "createprofile")
public class createprofile {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	public createprofile(Integer id, String name, String surname, String username, String interest, String aboutme, Date dob,
			String gender, String city) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.username = username;
		this.interest = interest;
		this.aboutme = aboutme;
		this.dob = dob;
		this.gender = gender;
		this.city = city;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	public String getInterest() {
		return interest;
	}
	public void setInterest(String interest) {
		this.interest = interest;
	}
	public String getAboutme() {
		return aboutme;
	}
	public void setAboutme(String aboutme) {
		this.aboutme = aboutme;
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
	@Column(name = "interest")
	private String interest;
	@Column(name = "aboutme")
	private String aboutme;
	@Column(name = "date_of_birth")
	private Date dob;
	@Column(name = "gender")
	private String gender;
	@Column(name = "city")
	private String city;
	
	public createprofile() {}
}

