package com.mmsports.bean;

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
@Table (name ="sports")

public class Sports {
	public Sports(Long id, String groupname, Integer membersrequired, Date date, Time time, String place,
			String location, String language) {
		super();
		this.id = id;
		this.groupname = groupname;
		this.membersrequired = membersrequired;
		this.date = date;
		this.time = time;
		this.place = place;
		this.location = location;
		this.language = language;
	
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	
	@Id
	@Column(name="Id")
	@GeneratedValue (strategy =GenerationType.AUTO)
	private Long id;
	@NotNull
	@NotBlank
	@Size(min = 3,max =15,message =" enter proper sports name")
	@Column(name="SportName")
	private String sportname;
	public Sports(String sportname) {
		super();
		this.sportname = sportname;
	}

	public String getSportname() {
		return sportname;
	}
	public void setSportname(String sportname) {
		this.sportname = sportname;
	}
	
	@NotNull
	@NotBlank
	@Size(min = 4, max = 15, message = "Group name need to have min 4 and max 15 characters")
	@Column(name="GroupName")
	private String groupname;
	@NotNull
	@Range(min=3,max=40)
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
	//one to many mapping code
    @OneToMany(mappedBy = "sports", cascade = {
        CascadeType.ALL
    })
    private List < Userprofile > userprofile;
	
	public List<Userprofile> getUserprofile() {
		return userprofile;
	}
	public void setUserprofile(List<Userprofile> userprofile) {
		this.userprofile = userprofile;
	}
	public Sports() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
