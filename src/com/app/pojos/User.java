package com.app.pojos;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;
@Entity
@Table(name = "user")
public class User 
{
	@JsonProperty
	private Integer userId;
	private	String name;
	private String email;
	private String password;
	private String address;
	private String mobileNo;
	private Role role;
	
	public User() 
	{
		
	}
		
	public User(Integer userId, String name, String email, String password, String address, String mobileNo,
			Organisation organisation, Role role) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.address = address;
		this.mobileNo = mobileNo;
		this.role = role;
	}




	@Id      //primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)//auto_increment
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	@Column(length = 50)
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(length = 50, unique = true)
	public String getEmail() {
		return email;
	}
	
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(length = 30, unique = true,nullable = false)
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(length = 100)
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getMobileNo() {
		return mobileNo;
	}
	
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "role", length = 20)
	public Role getRole() {
		return role;
	}
	
	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", address=" + address + ", mobileNo=" + mobileNo + ", role="
				+ role + "]";
	}

	

}