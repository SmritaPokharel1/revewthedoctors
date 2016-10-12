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
@Table(name="district")
public class District {
	
	@Column
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long districtId;
	
	@Column(unique=true)
	private String name;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="zoneId")
	private Zone zone;

	@Column
	private Date createdDate;
	
	@Column
	private Date updatedDate;
	
	@Column
	private int createdBy;
	
	@Column
	private int updatedBy;
	
	@OneToMany(orphanRemoval=true,fetch=FetchType.LAZY,mappedBy="district",cascade=CascadeType.ALL)
	private List<City> cityList;
	
	
	public long getDistrictId() {
		return districtId;
	}

	public void setDistrictId(long districtId) {
		this.districtId = districtId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Zone getZone() {
		return zone;
	}

	public void setZone(Zone zone) {
		this.zone = zone;
	}

	public List<City> getCityList() {
		return cityList;
	}

	public void setCityList(List<City> cityList) {
		this.cityList = cityList;
	}
	
	
	

}
