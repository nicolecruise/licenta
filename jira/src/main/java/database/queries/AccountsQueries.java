package database.queries;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import database.entities.Account;
import database.entities.Status;

@Named
@SessionScoped
public class AccountsQueries implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Account> accounts;

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
	}

	public Account find(long id) {
		for (Account account : accounts) {
			if (account.getId().equals(id)) {
				return account;
			}
		}
		return null;
	}

	public void approve(long id) {
		for (Account account : accounts) {
			if (account.getId().equals(id)) {
				account.setStatus(Status.APPROVED);
			}
		}
	}

	public void reject(long id) {
		for (Account account : accounts) {
			if (account.getId().equals(id)) {
				account.setStatus(Status.REJECTED);
			}
		}
	}
	
	public void remove(long id) {
		for (Account account : accounts) {
			if (account.getId().equals(id)) {
				accounts.remove(account);
				return;
			}
		}
	}

	public Account find(String name) {
		for (Account account : accounts) {
			if (account.getName().equals(name)) {
				return account;
			}
		}
		return null;
	}

	public void save(Account account) {
		accounts.add(account);
	}
	
	public List<Account> getAccounts() {
		return accounts;
	}
}
