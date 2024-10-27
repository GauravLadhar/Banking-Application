/**
 * 
 */

/**
 * @author Joseph
 *
 */
public class InvestmentAccount extends Account{

	/**
	 * 
	 */
	public InvestmentAccount() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	public double deposit(double balanceInput, double amount) {
		if (amount < 2500) {
			System.out.println("Min deposit required");
			System.exit(0);
		}
		else {
			double fee = amount * 0.00035;
			// deduct fee
			balanceInput = balanceInput - fee;
			// find final balance
			balanceInput = balanceInput + amount;
			return balanceInput;
		}
		return (Double) null;
	}
	
	public double withdraw(double balanceInput, double amount) {
		if (balanceInput >= amount) {
			balanceInput = balanceInput - amount;
			return balanceInput;
		}
		// if withdrawal is not successful, return false
		else {
			return (Double) null;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InvestmentAccount test = new InvestmentAccount();
		double balance;
		balance = test.deposit(1000, 9000);
		System.out.println(balance);

	}

}
