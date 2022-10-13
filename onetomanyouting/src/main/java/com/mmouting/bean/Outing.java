package com.mmouting.bean;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;



	 
@Entity
@Table (name ="outing")

public class Outing {
	public Outing(Integer id, String type, String groupname, Integer membersrequired, Date date, Time time, String place,
			String location, String language, Integer budget, String gender, Integer agelimit) {
		super();
		this.id = id;
		this.type = type;
		this.groupname = groupname;
		this.membersrequired = membersrequired;
		this.date = date;
		this.time = time;
		this.place = place;
		this.location = location;
		this.language = language;
		this.budget = budget;
		this.gender = gender;
		this.agelimit = agelimit;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getGroupname() {
		return groupname;
	}
	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}
	public Integer getMembersrequired() {
		return membersrequired;
	}
	public void setMembersrequired(Integer membersrequired) {
		this.membersrequired = membersrequired;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public Integer getBudget() {
		return budget;
	}
	public void setBudget(Integer budget) {
		this.budget = budget;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Integer getAgelimit() {
		return agelimit;
	}
	public void setAgelimit(Integer agelimit) {
		this.agelimit = agelimit;
	}
	@Id
	@Column(name="Id")
	@GeneratedValue (strategy =GenerationType.AUTO)
	private Integer id;
	@NotNull
	@NotBlank
	@Column(name="Type")
	private String type;
	@NotNull
	@NotBlank
	@Size(min = 4, max = 15, message = "Groupe name need to have min 4 and max 15 characters")
	@Column(name="GroupName")
	private String groupname;
	@NotNull
	@Range(min=3,max=100)
	@Column(name="MembersRequired")
	private Integer membersrequired;
	@NotNull
	@Column(name="Date")
	private Date date;
	@NotNull
	@Column(name="Time")
	private Time time;
	@NotNull
	@NotBlank
	@Size(min = 3, max = 20, message = "enter proper place name")
	@Column(name="Place")
	private String place;
	@Column(name="Location_url")
	private String location;
	@Size(min = 4, max = 15, message = "enter proper language name")
	@Column(name="Language")
	private String language;
	
	@Range(min=100,max=1000000)
	@Column(name="Budget")
	private Integer budget ;
	@NotNull
	@NotBlank
	@Column(name="Gender")
	private String gender;
	
	@Column(name="AgeLimit")
	private Integer agelimit;
	@NotNull
	@NotBlank
	@Column(name="Duration")
	private String duration;
    
//one to many mapping code
    @OneToMany(mappedBy = "outing", cascade = {
        CascadeType.ALL
    })
    private List < Userprofile > userprofile;
	public Outing(String duration) {
		super();
		this.duration = duration;
	}
	public List<Userprofile> getUserprofile() {
		return userprofile;
	}
	public void setUserprofile(List<Userprofile> userprofile) {
		this.userprofile = userprofile;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public Outing() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
