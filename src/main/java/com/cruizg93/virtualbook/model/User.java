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

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Transient;


@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column( name = "id")
	private int id;
	
	@Column(name = "email")
	@Email( message = "*Please provide a valid Email")
	@NotEmpty( message = "Please provide an Email")
	private String email;
	
	@Column(name = "username")
	@Length( min = 5, message = "*Your username must have at least 5 characters")
	@NotEmpty( message = "*Please provide your username")
	private String username;
	
	@Column( name = "password" )
	@Length(min = 5, message = "*Your password must have at least 5 characters ")
	@NotEmpty( message = "*Please provide your password")
	@Transient
	private String password;
	
	@Column( name = "name")
	@NotEmpty( message = "*Please provide your name")
	private String name;
	
	@Column( name = "last_name")
	@NotEmpty( message = "*Please provide your last name")
	private String lastName;
	
	@Column( name = "phone_number")
	private String phoneNumber;

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
	
	@ManyToMany( cascade = CascadeType.ALL)
	@JoinTable( name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public String getFullName() {
		if(name != null && lastName != null)
			return name+" "+lastName;
		
		return "";
	}
}

