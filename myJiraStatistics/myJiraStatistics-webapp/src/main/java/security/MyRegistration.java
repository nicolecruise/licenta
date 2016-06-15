package security;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import entities.User;
import services.UserService;

@Named
@SessionScoped
public class MyRegistration implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private UserService userService;

	private User user;

	private String username;
	private String password;
	private String password_2;

	@PostConstruct
	public void init() {
		user = new User();
	}

	public void processUser() {
		try {
			userService.saveUser(user);
			user = new User();
			displayMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Registration completed!"));
		} catch (Exception e) {
			displayMessage(new FacesMessage(FacesMessage.SEVERITY_WARN, "Registration Error", "Failed Registration"));
		}
	}

	private void displayMessage(FacesMessage message) {
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
	
	public String getPassword_2() {
		return password_2;
	}

	public void setPassword_2(String password_2) {
		this.password_2 = password_2;
	}

	public void validatePassword() {
	    FacesMessage message;

	    if (!user.getPassword().equals(user.getPassword_2()) ){
	        message = new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "Registration failed.Password didn't match.");
	    }else{
	        message = new FacesMessage(FacesMessage.SEVERITY_INFO, null, "Registration successful");
	    }

	    FacesContext.getCurrentInstance().addMessage("form:password", message);
	}
}
