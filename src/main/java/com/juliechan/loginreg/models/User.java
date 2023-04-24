package com.juliechan.loginreg.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity // FOR USER REGISTRATION
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(min = 3, max = 40, message = "We can't read your mind! Please enter your name so we can get to know you! Name must be between 3-40 characters long.")
	private String name;
	
	@Email(message = "Please enter a valid email! Email is a required field.")
	private String email;
	
	@Size(min = 8, max = 128, message = "must be at least 8 characters long.")
	private String pw;
	
	@Transient
	@Size(min = 8, max = 128)
	private String confirm;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="MM-dd-yyyy")
	private Date createdAt;
	
	@DateTimeFormat(pattern="MM-dd-yyyy")
	private Date updatedAt;
	
	public User() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}

}