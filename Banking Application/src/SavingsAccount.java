/**
 * 
 */


/**
 * @author Harshul
 * Date: May.2022
 */
public class SavingsAccount extends Account {
	
	/**
	 * Default constructor
	 */
	public SavingsAccount() {
		// initalize data
		super();
		getBalance();
		getAccountNumber();

	}
	
	/**
	 * Method to withdraw from account
	 */
	public double withdrawal(double balanceInput, double amount) {
		// checks to see if amount can be withdrawn
		if (balanceInput >= amount && balanceInput > 10000) {
			balanceInput = balanceInput - amount;
			return balanceInput;
		}
		//  there is a balance lower than $10000.00.
		if (balanceInput < 10000) {
			balanceInput = balanceInput - amount;
			balanceInput = balanceInput- 6.25;
			return balanceInput;
		}
		return (Double) null;
	}
	
	/**
	 * Method to deposit into account
	 */
	public double deposit(double balanceInput, double amount) {
		// add amount to current balance
		if (amount != 0) {
			balanceInput = balanceInput + amount;
			return balanceInput;
		}
		else {
			return (Double) null;
		}
	}

	/**
	 * toString method
	 */
	public String toString() {
		return "Account [balance=" + getBalance() + ", accountNumber=" + getAccountNumber() + ", bank="
				+ getBank() + "]";
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Self-Testing
		SavingsAccount bank = new SavingsAccount();
		double newBalance;
		newBalance = bank.withdrawal(9000, 200);
		System.out.println(newBalance);

	}

}
