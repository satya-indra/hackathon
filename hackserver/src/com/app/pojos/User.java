package com.app.pojos;

import javax.persistence.*;


@Entity
@Table(name = "user")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
	private Integer id;
	private String name;
	private String email;
	private String phone;
	private String passwd;
	private Role role;
	
	public User() {
	System.out.println("inside user ctor");	
	}
	
	public User( String name, String email, String phone, String passwd, Role role) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.passwd = passwd;
		this.role = role;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(length = 50)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(length = 50)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(length = 10)
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Column(length = 50)
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(length = 15)
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
	@Override
	public String toString() {
		return getClass().getName() + " [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", passwd=" + passwd + "]";
	}
}
