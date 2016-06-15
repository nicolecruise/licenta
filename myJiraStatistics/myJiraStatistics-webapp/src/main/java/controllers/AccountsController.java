package controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import entities.Account;
import entities.Status;
import entities.UserType;

@Named
@SessionScoped
public class AccountsController implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Account> accounts;

	private List<Account> filteredAccounts;

	@PostConstruct
	public void init() {
		System.out.println("AccountsController init");
		accounts = new ArrayList<Account>();
		accounts.add(new Account("account1", Status.APPROVED, UserType.ADMIN));
		accounts.add(new Account("bla", Status.REJECTED, UserType.USER));

		filteredAccounts = new ArrayList<Account>();
		filteredAccounts.add(new Account("account1", Status.APPROVED, UserType.ADMIN));
		filteredAccounts.add(new Account("bla", Status.REJECTED, UserType.USER));
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public List<Account> getFilteredAccounts() {
		return filteredAccounts;
	}

	public void setFilteredAccounts(List<Account> filteredAccounts) {
		this.filteredAccounts = filteredAccounts;
	}
}
