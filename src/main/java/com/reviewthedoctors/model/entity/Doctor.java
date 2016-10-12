package com.reviewthedoctors.model.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

@Entity
@Table(name="doctor")
public class Doctor {
	
	@Column
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long doctorId;
	
	@Column
	private String firstName;
	
	@Column
	private String middleName;
	
	@Column
	private String lastName;
	
	@Column
	private Date createdDate;
	
	@Column
	private Date updatedDate;
	
	@Column
	private int createdBy;
	
	@Column
	private int updatedBy;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private City city;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="doctor_link_hospital",
			   joinColumns=@JoinColumn(name="doctorId"),
			   inverseJoinColumns=@JoinColumn(name="hospitalId"))
	private List<Hospital> hospitalList;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="doctor_link_category",
			   joinColumns=@JoinColumn(name="doctorId"),
			   inverseJoinColumns=@JoinColumn(name="specialityId")
			)
	private List<Speciality> specialityList;
	
	@OneToMany(orphanRemoval=true, fetch=FetchType.LAZY, mappedBy="doctor")
	@LazyToOne(value = LazyToOneOption.NO_PROXY)
	private List<Review> reviewList;
	
	public long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(long doctorId) {
		this.doctorId = doctorId;
	}

	public List<Hospital> getHospitalList() {
		return hospitalList;
	}

	public void setHospitalList(List<Hospital> hospitalList) {
		this.hospitalList = hospitalList;
	}

	public List<Speciality> getSpecialityList() {
		return specialityList;
	}

	public void setSpecialityList(List<Speciality> specialityList) {
		this.specialityList = specialityList;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public int getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}

	public List<Review> getReviewList() {
		return reviewList;
	}

	public void setReviewList(List<Review> reviewList) {
		this.reviewList = reviewList;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}
}
