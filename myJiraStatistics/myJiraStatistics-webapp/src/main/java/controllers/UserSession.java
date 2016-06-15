package controllers;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import entities.User;
import services.UserService;

@Named
@SessionScoped
public class UserSession implements Serializable {

	private static final long serialVersionUID = 1L;

	private User user;
	private String homeUrl;
	
	private Boolean isAdmin;
	
	@EJB
	private UserService userService;

	@PostConstruct
	public void init() {
		//login();
		
		user = new User();
		isAdmin = true;
	}

	public void login(ActionEvent event) throws IOException {
		/*user = new User(1L, UserType.USER, "Tom", "s3cr3t");
		 FacesContext.getCurrentInstance().addMessage(null,
	                new FacesMessage("Welcome " + user.getName()));*/
		
		List<User> users = userService.loadUsers();
		System.out.println("Porcarie!!!!!");
		
		for (User u : users){
			System.out.println(u.getName());
		}		
		
		user.setId(null);
		
		
		for (User u : users){
			if (u.getName().equals(user.getName())){
				if (u.getPassword().equals(user.getPassword())){
					System.out.println("Good!");
					System.out.println(user.getUserType());
					
//					if(user.getUserType().name().equals("ADMIN")){
//						isAdmin = true;						
//					}else{
//						isAdmin = false;
//					}
				}else {
					System.out.println("Parola gresita!");					
				}
			}else{
				System.out.println("Userul nu exista!");
			}
			
		}
		
		
	}

	public String logout() {
		//FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "help";
	}

	//TODO
	/*public boolean isUser() {
		return user.getUserType() == UserType.USER;
	}

	public boolean isAdmin() {
		return user.getUserType() == UserType.ADMIN;
	}

	public User getUser() {
		return user;
	}*/
	
	
	//registration part
	public String registration() {
		System.out.println("aiciiiiiiiii");
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message = null;
        boolean loggedIn = false;
         
        if(user.getName() != null && user.getPassword() != null) {
            loggedIn = true;
            userService.saveUser(user);
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Authentication completed!");            
            
        } else {
            loggedIn = false;
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Invalid credentials");
        }
         
        FacesContext.getCurrentInstance().addMessage(null, message);
        context.addCallbackParam("loggedIn", loggedIn);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Authentication completed!"));
        
        //System.out.println("Hello"+ user.getName());
        return "login";
    }

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}  
	
	
}
