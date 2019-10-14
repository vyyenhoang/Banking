package Assignment1_200408803;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Bank {

	private String bankName = "DefaultBank";
	private String branchLocation = "DEFAULT_LOCATION";
	private List<Account> accounts = new ArrayList<Account>();

	public static enum BranchLocations {
		DEFAULT_LOCATION, NEW_YORK, WASHINGTON, CHICAGO, CALIFORNIA, ARIZONA
	};

	public Bank() {
	}

	public Bank(String bankName, String branchLocation) {
		if (isValidName(bankName)) {
			this.bankName = bankName;
		}else {
			this.bankName = "DefaultBank";
		}
		if (doesEnumContains(branchLocation)) {
			this.branchLocation = branchLocation;
		}else {
			this.branchLocation = "DEFAULT_LOCATION";
		}
	}

	public Bank(String bankName, BranchLocations branchLocation) {
		if (isValidName(bankName)) {
			this.bankName = bankName;
		}else {
			this.bankName = "DefaultBank";
		}
		if (doesEnumContains(branchLocation.toString())) {
			this.branchLocation = branchLocation.toString();
		}else {
			this.branchLocation = "DEFAULT_LOCATION";
		}
	}

	public String getBankName() {
		return bankName;
	}

	public boolean setBankName(String bankName) {
		if (isValidName(bankName)) {
			this.bankName = bankName;
			return true;
		}
		return false;
	}

	public boolean setBranchLocation(String branchLocation) {
		if (doesEnumContains(branchLocation)) {
			this.branchLocation = branchLocation;
			return true;
		}
		return false;
	}

	public String getBranchLocation() {
		return branchLocation;
	}

	public boolean setBranchLocation(BranchLocations branchLocation) {
		if (doesEnumContains(branchLocation.toString())) {
			this.branchLocation = branchLocation.toString();
			return true;
		}
		return false;
	}

	public Account getAccountByNumber(int accountNumber) {

		for (Account account : accounts) {
			if (account.getAccountNumber() == accountNumber) {
				return account;
			}
		}

		return new Account();
	}

	public boolean addAccount(Account account) {
		for (Account a : accounts) {
			if (a.getAccountNumber() == account.getAccountNumber()) {
				return false;
			}
		}

		accounts.add(account);

		return true;
	}

	public boolean addAccount(String accountName, int accountNumber, double accountBalance) {
		for (Account a : accounts) {
			if (a.getAccountNumber() == accountNumber) {
				return false;
			}
		}
		Account account = new Account(accountName, accountNumber, accountBalance);
		accounts.add(account);

		return true;
	}

	public Account viewAccount(int accountNumber) {
		return getAccountByNumber(accountNumber);
	}

	public Account viewAccount(byte index) {

		if (accounts.size() <= index) {
			return new Account();
		}

		return accounts.get(index);
	}

	public boolean modifyAccount(int accountNumber, String accountName) {
		Account a = viewAccount(accountNumber);
		return a.setAccountName(accountName);
	}

	public boolean modifyAccount(int accountNumber, double accountBalance) {
		Account a = viewAccount(accountNumber);
		return a.setAccountBalance(accountBalance);
	}

	public boolean modifyAccount(int accountNumber, String accountName, double accountBalance) {
		Account a = viewAccount(accountNumber);
		if(a.setAccountName(accountName) && a.setAccountBalance(accountBalance)) {
			return true;
		}
		return false;
	}

	public boolean modifyAccount(byte index, String accountName) {
		Account a = viewAccount(index);
		return a.setAccountName(accountName);
	}

	public boolean modifyAccount(byte index, double accountBalance) {
		Account a = viewAccount(index);
		return a.setAccountBalance(accountBalance);
	}

	public boolean modifyAccount(byte index, String accountName, double accountBalance) {
		Account a = viewAccount(index);
		if(a.setAccountName(accountName) && a.setAccountBalance(accountBalance)) {
			return true;
		}
		return false;
	}

	public boolean deleteAccount(int accountNumber) {
		Account a = viewAccount(accountNumber);
		if(a.getAccountNumber()==accountNumber) {
			accounts.remove(a);
			return true;
		}
		return false;
	}

	public boolean deleteAccount(byte index) {
		Account a = viewAccount(index);
		if(a.getAccountNumber() > 10000) {
			accounts.remove(a);
			return true;
		}
		return false;
	}

	private boolean isValidName(String bankName) {
		if (bankName.length() < 8) {
			return false;
		}

		final Pattern regex = Pattern.compile("^(?!(?:[^\\d\\n]*\\d){4})(?!.*([ ']).*\\1)[a-zA-Z\\d& ']+$");

		return regex.matcher(bankName).matches();
	}

	private boolean doesEnumContains(String str) {

		for (BranchLocations b : BranchLocations.values()) {
			if (b.name().equals(str)) {
				return true;
			}
		}

		return false;
	}

}