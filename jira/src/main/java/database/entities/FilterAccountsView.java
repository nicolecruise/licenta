package database.entities;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import database.queries.AccountsQueries;


@Named
@SessionScoped

public class FilterAccountsView implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<AccountsQueries> accounts;
	private List<AccountsQueries> filteredAccounts;
	
	
	public List<AccountsQueries> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<AccountsQueries> accounts) {
		this.accounts = accounts;
	}
	public List<AccountsQueries> getFilteredAccounts() {
		return filteredAccounts;
	}
	public void setFilteredAccounts(List<AccountsQueries> filteredAccounts) {
		this.filteredAccounts = filteredAccounts;
	}

	

}
