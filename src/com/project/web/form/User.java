package com.project.web.form;

import org.springframework.core.style.ToStringCreator;

public class User {
	private int userId;
	private String firstname;
    private String lastname;
    private String email;
    private String telephone;
    
    

	
	
	public User(int userId, String firstname, String lastname, String email,
			String telephone) {
		super();
		this.userId = userId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.telephone = telephone;
	}


	public User() {
		// TODO Auto-generated constructor stub
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
    

	public String toString() {
		return new ToStringCreator(this).append("firstname",firstname)
										.append("lasname",lastname)
										.append("email",email)
										.append("telephone",telephone).toString();
	}    
    
}
