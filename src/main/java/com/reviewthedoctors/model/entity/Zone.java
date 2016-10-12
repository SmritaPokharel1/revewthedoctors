package com.reviewthedoctors.model.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="zone")
public class Zone {

	@Column
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long zoneId;
	
	@Column(unique=true)
	private String name;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="countryId")
	private Country country;

	@Column
	private Date createdDate;
	
	@Column
	private Date updatedDate;
	
	@Column
	private int createdBy;
	
	@Column
	private int updatedBy;
	
	@OneToMany(orphanRemoval=true,fetch=FetchType.LAZY,mappedBy="zone",cascade=CascadeType.ALL)
	private List<District> districtList;
	
	public long getZoneId() {
		return zoneId;
	}

	public void setZoneId(long zoneId) {
		this.zoneId = zoneId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
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

	public List<District> getDistrictList() {
		return districtList;
	}

	public void setDistrictList(List<District> districtList) {
		this.districtList = districtList;
	}
	
}
