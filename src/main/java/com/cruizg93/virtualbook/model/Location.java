package com.cruizg93.virtualbook.model;

import java.util.Set;
import java.util.Date;

import javax.persistence.CascadeType;
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
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name ="locations")
public class Location {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column( name = "id")
	private int id;
	
	@Column( name = "building_name")
	private String buildingName;
	
	@Column( name = "address")
	@NotEmpty( message = "*Please provide address")
	private String address;
	
	@Column( name = "address2")
	private String address2;
	
	@Column( name = "city")
	@NotEmpty( message = "*Please provide city name")
	private String city;
	
	@Column( name = "state")
	@NotEmpty( message = "*Please provide state")
	private String state;
	
	@Column( name = "zipcode")
	@NotEmpty( message = "*Please provide zipcode")
	private int zipcode;
	
	@Column( name = "phone_number")
	@NotEmpty( message = "*Please provide primarly phone number")
	private String phoneNumber;
	
	@Column( name = "phone_number2")
	@NotEmpty( message = "*Please provide alternate phone number")
	private String phoneNumber2;
	
	@Column( name = "is_default")
	private int isClientDefault;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL, optional = true)
	@JoinColumn( name ="client_id")
	private Client client;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL, optional = true)
	@JoinColumn( name ="created_by")
	private User createdBy;
	
	@Column( name ="created_date")
	private Date createdDate;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL, optional = true)
	@JoinColumn( name="updated_by")
	private User updatedBy;
	
	@Column( name ="updated_date")
	private Date updatedDate;
	
	@Column( name = "status")
	private int status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPhoneNumber2() {
		return phoneNumber2;
	}

	public void setPhoneNumber2(String phoneNumber2) {
		this.phoneNumber2 = phoneNumber2;
	}

	public int getIsClientDefault() {
		return isClientDefault;
	}

	public void setIsClientDefault(int isClientDefault) {
		this.isClientDefault = isClientDefault;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public User getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(User updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
	
}
