import java.util.Scanner;

public class MainATM {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		double amount, balance = -1;
		String accountName;
		int choice = -1;
		long accountNumberSource, accountNumberDestination, accountNumber;

		while (choice != 0) {
			System.out.println("Welcome to Deez Atm. Please choose your option:" + "\n1. Create account"
					+ "\n2. Transfer money to another account" + "\n3. Show account info" + "\n0. Exit");
			choice = input.nextInt();

			if (choice == 1) {

				input.nextLine();

				System.out.print("Enter account name: ");
				accountName = input.nextLine();
				System.out.print("Enter your balance: ");
				balance = input.nextDouble();

				while (balance < 0) {
					System.out.print("The balance must be positive!\nEnter your balance: ");
					balance = input.nextDouble();
				}

				Account account = new Account(accountName, balance);
				System.out.println(
						"The account with the account number " + account.getAccountNumber() + " has been created!");
			} else if (choice == 2) {
				if (Account.numberOfAccounts() == 0 || Account.numberOfAccounts() == 1) {
					System.out.println("There are no active accounts or there is only one account!");
				} else {
					System.out.print("Enter the account number for the source account: ");
					accountNumberSource = input.nextLong();
					if (Account.getAccountByAccountNumber(accountNumberSource) == null)
						System.out.println("That account doesn't exist!");
					else {
						System.out.print("Enter the account number for the destination account: ");
						accountNumberDestination = input.nextLong();
						if (Account.getAccountByAccountNumber(accountNumberDestination) == null)
							System.out.println("That account doesn't exist!");
						else {
							System.out.print("Enter the amount: ");
							amount = input.nextDouble();

							Transaction.transferMoney(Account.getAccountByAccountNumber(accountNumberSource),
									Account.getAccountByAccountNumber(accountNumberDestination), amount);
							System.out.println();
						}
					}
				}
			} else if (choice == 3) {
				if (Account.numberOfAccounts() == 0)
					System.out.println("There are no active accounts!");
				else {
					System.out.print("Enter account number: ");
					accountNumber = input.nextLong();

					if (Account.getAccountByAccountNumber(accountNumber) != null)
						Account.getAccountByAccountNumber(accountNumber).showAccountInfo();
					else
						System.out.println("That account doesn't exist!");
				}
			}
		}
		input.close();
		System.out.println("Thank you for using Deez Atm!");

	}

}
