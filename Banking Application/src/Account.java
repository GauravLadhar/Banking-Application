import javax.swing.JOptionPane;

/**
 * 
 */

/**
 * @author Gaurav
 * Date: 2022-06-30
 * 
 *
 */
public class Account {
	
	// initalize instance data
	private double balance;
	private String accountNumber;
	private Customer bank;

	/**
	 * Default constructor
	 */
	public Account() {
		// initalize the balance and accountNumber
		this.balance = 0;
		this.accountNumber = "";
		
		// generate a random 12-digit account number;
		for (int i = 0; i < 12; i++) {
			int digits = (int)(Math.random() * 9);
			this.accountNumber = this.accountNumber + Integer.toString(digits);
		}
		
		// initalize a bank object
		this.bank = bank;
	}
	
	/**
	 * Overloaded constructor
	 */
	public Account(Customer theOwner) {
		// initalize the balance
		this.balance = balance;
		
		// initalize the accountNumber
		this.accountNumber = accountNumber;
		
		// initialize theOwner
		Customer bank = theOwner;
	}
	
	/**
	 * Method to deposit into account
	 */
	public boolean deposit(double amount) {
		// add amount to current balance
		if (amount != 0) {
			balance = balance + amount;
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Method to withdraw from account
	 */
	public boolean withdraw(double amount) {
		// checks to see if amount can be withdrawn
		if (balance >= amount) {
			balance = balance - amount;
			return true;
		}
		// if withdrawal is not successful, return false
		else {
			return false;
		}
	}

	/**
	 * toString method
	 */
	public String toString() {
		return "Account [balance=" + balance + ", accountNumber=" + accountNumber + ", bank="
				+ bank + "]";
	}

	/**
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * @return the accountNumber
	 */
	public String getAccountNumber() {
		return accountNumber;
	}

	/**
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	/**
	 * @return the bank
	 */
	public Customer getBank() {
		return bank;
	}

	/**
	 * @param bank the bank to set
	 */
	public void setBank(Customer bank) {
		this.bank = bank;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// self-testing main method
		Account bank = new Account();
		double newBalance = bank.balance = 5000;
		bank.getAccountNumber();
		
		bank.deposit(5000);
		bank.withdraw(1000);
		
		System.out.println(bank.getAccountNumber());
		System.out.println(bank.getBalance());

	}

}
