package com.cruizg93.virtualbook.model;

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

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table( name = "clients")
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column( name = "id")
	private int id;
	
	@Column( name = "company_name")
	private String companyName;
	
	@Column( name = "name")
	@NotEmpty( message = "*Please provide your name")
	private String name;
	
	@Column( name = "last_name")
	@NotEmpty( message = "*Please provide your last name")
	private String lastName;
	
	@Column(name = "email")
	@Email( message = "*Please provide a valid Email")
	@NotEmpty( message = "Please provide an Email")
	private String email;
	
	@Column( name = "phone_number")
	private String phoneNumber;
	
	@Column( name = "status")
	private int status;
	
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
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
	
	public String getFullName() {
		if(name != null && lastName != null)
			return name+" "+lastName;
		
		return "";
	}
}
