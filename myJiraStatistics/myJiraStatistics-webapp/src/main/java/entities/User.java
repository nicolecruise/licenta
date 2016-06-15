package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = User.GET_ALL_USERS, query = "SELECT u from User u")
public class User{
	
	public final static String GET_ALL_USERS = "GET_ALL_USERS";
	
	private Long id;
	private String name;
	private String password;
	private String password_2;

	private String userType;

	public User() {
	}
	
	public User(Long id, String userType, String name, String password, String password_2) {
		this.id = id;
		this.userType = userType;
		this.name = name;
		this.password = password;
		this.password_2 = password_2;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getUserType() {
		return userType;
	}


	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getPassword_2() {
		return password_2;
	}

	public void setPassword_2(String password_2) {
		this.password_2 = password_2;
	}

	
	
	//@Enumerated(EnumType.STRING)
//	public String getUserType() {
//		return userType;
//	}
//
//	public void setUserType(String userType) {
//		this.userType = userType;
//	}
}
