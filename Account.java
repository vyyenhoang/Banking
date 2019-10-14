package Assignment1_200408803;

import java.util.regex.Pattern;

public class Account {

	private int accountNumber = 10000;
	private String accountName = "DefaultAccount";
	private double accountBalance = 0;

	public Account() {
	}

	public Account(String accountName, int accountNumber, double accountBalance) {
		if (accountNumber > 10000 && accountNumber <= 999999999) {
			this.accountNumber = accountNumber;
		} else {
			this.accountNumber = 10000;
		}

		if (isValidName(accountName)) {
			this.accountName = accountName;
		} else {
			this.accountName = "DefaultAccount";
		}

		if (isValidBalance(accountBalance)) {
			this.accountBalance = accountBalance;
		} else {
			this.accountBalance = 0;
		}

	}

	public String getAccountName() {
		return accountName;
	}

	public boolean setAccountName(String accountName) {
		if (isValidName(accountName)) {
			this.accountName = accountName;
			return true;
		}
		return false;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public boolean setAccountNumber(int accountNumber) {
		if (accountNumber > 10000 && accountNumber <= 999999999) {
			this.accountNumber = accountNumber;
			return true;
		}
		return false;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public boolean setAccountBalance(double value) {
		if (isValidBalance(value)) {
			this.accountBalance = value;
			return true;
		}
		return false;
	}

	@Override
	public boolean equals(Object obj) {

		try{
			Account compare = (Account)obj;
			return this.toString().equals(compare.toString());
		}

		catch (Exception e){

			return false;
		}


	}

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", accountName=" + accountName + ", accountBalance="
				+ accountBalance + "]";
	}

	private boolean isValidName(String accountName) {
		if(accountName.length() < 4) {
			return false;
		}
		
		final Pattern regex = Pattern.compile( "^(?!.*([ ']).*\1)[a-zA-Z- ']+$");

		return regex.matcher(accountName).matches();
	}

	private boolean isValidBalance(double value) {
		String text = Double.toString(Math.abs(value));
		int integerPlaces = text.indexOf('.');
		int decimalPlaces = text.length() - integerPlaces - 1;
		if(decimalPlaces <= 2) {
			return true;
		}

		return false;
	}

}