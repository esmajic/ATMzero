import java.util.ArrayList;

public class Account extends CreateAccount {

	protected static ArrayList<Account> accounts = new ArrayList<Account>();

	protected Account() {
	}

	Account(String accountName, double balance) {
		super(accountName, balance);
		accounts.add(this);
	}

	public void showAccountInfo() {
		System.out.println("Account number: " + this.getAccountNumber()
				+ "\nAccount name: " + this.getAccountName() + "\nBalance: "
				+ this.getBalance() + "$");
	}

	public static Account getAccountByAccountNumber(long accountNumber) {
		if (accounts.size() == 0) {
			System.out.println("There are no created accounts!");
		} else {
			for (Account acc : accounts) {
				if (acc.getAccountNumber() == accountNumber)
					return acc;
			}
		}
		return null;
	}

	public static int numberOfAccounts() {
		return accounts.size();
	}
}
