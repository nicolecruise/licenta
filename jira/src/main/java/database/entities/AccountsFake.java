package database.entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.context.RequestContext;

@ManagedBean
@SessionScoped
public class AccountsFake implements Serializable {

	private static final long serialVersionUID = 1L;

	private String account;
	private List<Account> accounts;
	private List<String> filteredAccounts;
	private boolean aproved;

	private Status status;
	private Account selectedAccount;

	@PostConstruct
	public void init() {
		accounts = new ArrayList<Account>();
		accounts.add(new Account(0L, "Account 1", Status.REJECTED, "USER", 1346524199000l));
		accounts.add(new Account(1L, "Account 2", Status.REJECTED, "USER", 0));
		accounts.add(new Account(2L, "Account 3", Status.REJECTED, "USER", 0));
		accounts.add(new Account(3L, "Account 4", Status.REJECTED, "USER", 0));
		accounts.add(new Account(4L, "Account 5", Status.REJECTED, "USER", 0));
		accounts.add(new Account(5L, "Account 6", Status.REJECTED, "USER", 0));
		accounts.add(new Account(6L, "Account 7", Status.REJECTED, "USER", 0));
		accounts.add(new Account(7L, "Account 8", Status.REJECTED, "USER", 0));
		accounts.add(new Account(8L, "Account 9", Status.REJECTED, "USER", 0));
		accounts.add(new Account(9L, "Account 10", Status.REJECTED, "USER", 0));
		accounts.add(new Account(10L, "Account 11", Status.REJECTED, "USER", 0));
		accounts.add(new Account(11L, "Account 12", Status.REJECTED, "USER", 0));
		accounts.add(new Account(12L, "Account 13", Status.REJECTED, "USER", 0));
		accounts.add(new Account(13L, "Account 14", Status.REJECTED, "USER", 0));

		// this.status = Status.REJECTED;

		// Themes
		// themes = service.getThemes().subList(0, 6);
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
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

	public Account getSelectedAccount() {
		return selectedAccount;
	}

	public void setSelectedAccount(Account selectedAccount) {
		this.selectedAccount = selectedAccount;
	}

	public void search() {
		/*
		 * for(int i = 1 ; i < 11; i++){ this.accounts.add("Evil !!!"); }
		 */
	}

	public void addMessage() {
		String summary = aproved ? "Aproved" : "Unaproved";
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary));
	}

	public void showMessage() {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Are you sure you want to delete this account ?", null);

		RequestContext.getCurrentInstance().showMessageInDialog(message);
	}

	/*
	 * public void buttonAction(ActionEvent actionEvent) { addMessage(
	 * "Welcome to Primefaces!!"); } /*public void addMessage(String summary) {
	 * FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
	 * summary, null); FacesContext.getCurrentInstance().addMessage(null,
	 * message); }
	 */
	// public void toggleHandle(ToggleEvent event){
	// System.out.println("Panel #"+event.getComponent().getId()+" Is Toggled");
	// }
	//
	// public void closeHandle(CloseEvent event){
	// System.out.println("Panel #"+event.getComponent().getId()+" Is Closed");
	// }

	/*
	 * public void delete(Integer id) { accounts.remove(id); }
	 */

	public void delete() {
		accounts.remove(selectedAccount);
	}

}
