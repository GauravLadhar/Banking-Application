/**
 * 
 */

/**
 * @author Gaurav
 * Date: 2022-05-27
 * Description: chequingAccount is an Account that deducts a fee of 0.5% of its balance, and has
 * 				has a service fee of $3.50 for each deposit made.
 */
public class ChequingAccount extends Account {

	/**
	 * Default constructor
	 */
	public ChequingAccount() {
		// initalize data
		super();
		getBalance();
		getAccountNumber();
	}
	
	/**
	 * Method to deposit into account
	 */
	public double deposit(double balanceInput, double amount) {
		// add amount to current balance
		if (amount != 0) {
			balanceInput = balanceInput + amount;
			// deduct a service fee of $3.50
			balanceInput = balanceInput - 3.50;
			return balanceInput;
		}
		else {
			return (Double) null;
		}
	}

	/**
	 * Method to withdraw from account
	 */
	public double withdraw(double balanceInput, double amount) {
		// sets a fee to 0.5% of the current balance
		double fee = balanceInput * 0.005;
		// checks to see if amount can be withdrawn
		if (balanceInput >= amount) {
			// deduct a fee before withdrawal
			balanceInput = balanceInput - fee;
			// withdraw amount from balance
			balanceInput = balanceInput - amount;
			return balanceInput;
		}
		// if withdrawal is not successful, return false
		else {
			return (Double) null;
		}
	}

	/**
	 * toString method
	 */
	public String toString() {
		return "chequingAccount [balance=" + getBalance() + ", accountNumber=" + getAccountNumber();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// self-testing main method
		ChequingAccount bank = new ChequingAccount();
		
		double balance1;
		balance1 = bank.withdraw(1000, 100);

		System.out.println("Withdraw test");
		System.out.println(balance1);
		
		double balance2;
		balance2 = bank.deposit(1000, 200);
		
		System.out.println("Deposit test");
		System.out.println(balance2);
		
		System.out.println(bank);

	}

}
