package entities;

import java.io.Serializable;
import java.sql.Date;

public class Account implements Serializable {
	
	private String name;
	private Status status;
	
	private UserType role;
	
	//private Date registrationTime;

	public Account(){}
	
	public Account(String name, Status status, UserType role/*, Date registrationTime*/) {
		super();
		this.name = name;
		this.status = status;
		this.role = role;
		//this.registrationTime = registrationTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public UserType getRole() {
		return role;
	}

	public void setRole(UserType role) {
		this.role = role;
	}

	/*public Date getRegistrationTime() {
		return registrationTime;
	}

	public void setRegistrationTime(Date registrationTime) {
		this.registrationTime = registrationTime;
	}*/
	
	
	
	
	
	
	
	
}