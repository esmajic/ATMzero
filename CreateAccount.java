import java.util.ArrayList;

public class CreateAccount {

	private long accountNumber;
	private String accountName;
	private double balance;
	private ArrayList<Long> accountNumbersList = new ArrayList<Long>();

	protected CreateAccount() {
	}

	CreateAccount(String accountName, double balance) {
		this.accountName = accountName;
		this.balance = balance;
		this.createUniqueAccountNumber();
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		if (balance < 0)
			this.balance = 0;
		else
			this.balance = balance;
	}

	public long getAccountNumber() {
		return this.accountNumber;
	}

	private void createUniqueAccountNumber() {
		long accNumber = (long) (Math.random() * 8999999999L) + 1000000000L;

		while (!isUniqueAccountNumber(accNumber)) {
			accNumber = (long) (Math.random() * 8999999999L) + 1000000000L;
		}
		this.accountNumber = accNumber;
	}

	private boolean isUniqueAccountNumber(long accountNumber) {
		for (int i = 0; i < accountNumbersList.size(); i++) {
			if (accountNumbersList.get(i) == accountNumber)
				return false;
		}
		return true;
	}
}
