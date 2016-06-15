package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.event.CloseEvent;
import org.primefaces.event.ToggleEvent;
 
@ManagedBean
@SessionScoped
public class AccountsFake implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String account;
    private List<String> accounts;
    private List<String> filteredAccounts;
    private boolean aproved;  
    
    private Status status; 
    
    @PostConstruct
    public void init() {
    	accounts = new ArrayList<String>();
    	accounts.add("Account 1");
    	accounts.add("Account 2");
    	accounts.add("Account 3");
    	accounts.add("Account 4");
    	accounts.add("Account 5");
    	accounts.add("Account 6");
    	accounts.add("Account 7");
    	accounts.add("Account 8");
    	accounts.add("Account 9");
    	accounts.add("Account 10");
    	accounts.add("Account 11");
    	accounts.add("Account 12");
    	accounts.add("Account 13");
    	accounts.add("Account 14");
    	this.status = Status.REJECTED;
              
        //Themes
        //themes = service.getThemes().subList(0, 6);    
    }
 
    public String getAccount() {
       return account;
    }
 
    public void setAccount(String account) {
        this.account = account;
    }
     
    public List<String> getAccounts() {
        return accounts;
    }
 
    public void setAccounts(List<String> accounts) {
        this.accounts = accounts;
    }
    
    
    
    public List<String> getFilteredAccounts() {
		return filteredAccounts;
	}

	public void setFilteredAccounts(List<String> filteredAccounts) {
		this.filteredAccounts = filteredAccounts;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public boolean isAproved() {
		return aproved;
	}

	public void setAproved(boolean aproved) {
		this.aproved = aproved;
	}

	public void search(){
        /*for(int i = 1 ; i < 11; i++){
        	this.accounts.add("Evil !!!");
        }*/
    }
    
    public void addMessage() {
        String summary = aproved ? "Aproved" : "Unaproved";
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary));
    }
    
    /*public void buttonAction(ActionEvent actionEvent) {
        addMessage("Welcome to Primefaces!!");
    }*/
     
    /*public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }*/
    
     
//    public void toggleHandle(ToggleEvent event){
//        System.out.println("Panel #"+event.getComponent().getId()+" Is Toggled");
//    }
//     
//    public void closeHandle(CloseEvent event){
//        System.out.println("Panel #"+event.getComponent().getId()+" Is Closed");
//    }
 }