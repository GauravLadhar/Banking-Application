/**
 *
 */

/**
 * @author Harshul
 *
 */
public class CustomerRecord extends Customer{

	/**
	 * Instance data
	 */
	private String firstName;
	private String lastName;
	private String address;
	private String phoneNumber;
	private String accountNumber;
	private char accountType;

	public CustomerRecord() {
		this.firstName = "";
		this.lastName = "";
		this.address = "";
		this.phoneNumber = "";
		this.accountNumber = "";
		this.accountType = 'c';
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
	 * @return the accountType
	 */

	public char getAccountType() {
		return accountType;
	}

	/**
	 * @param accountType the accountType to set
	 */
	public void setAccountType(char accountType) {
		this.accountType = accountType;
	}

	@Override
	public String toString() {
		switch(accountType) {

		case 'c': {
			String c = String.valueOf("Chequing account");
			return "CustomerRecord [Firstname= " + firstName + " ,Lastname= " + lastName +" ,Address= " + address
					+ "PhoneNumber= " + phoneNumber + ",Accountnumber=" + accountNumber + " ,Accounttype= " + c + "]";
		}
		case 's': {
			String s = String.valueOf("Savings account");

			return "CustomerRecord [Firstname= " + firstName + " ,Lastname= " + lastName +" ,Address= " + address
					+ "PhoneNumber= " + phoneNumber + ",Accountnumber=" + accountNumber +  " ,Accounttype " + s + "]";

		}
		case 'i': {
			String i = String.valueOf("Investment account");
			return "CustomerRecord [Firstname= " + firstName + " ,Lastname= " + lastName +" ,Address= " + address
					+ "PhoneNumber= " + phoneNumber + " "
					+ ",Accountnumber=" + accountNumber + " ,Accounttype " + i + "]";
		}
		}
		if ((accountType != 'c') && (accountType != 'i') && (accountType != 's' )) {
			System.out.println("Error, please type a valid character");
		}


		return "CustomerRecord [Firstname= " + firstName + " ,Lastname= " + lastName +" ,Address= " + address
				+ "PhoneNumber= " + phoneNumber + " ,Accountnumber=" + accountNumber + " ,Accounttype " + "]";
	}


	public void processRecord(String record) {
		// split record into String array
		String words[] = record.split(",");
		// save the words into the instance variables
		this.firstName= words[0];
		this.lastName = words[1];
		this.address = words[2];
		this.phoneNumber = words[3];
		this.accountNumber = words[4];
		this.accountType = words[5].charAt(0);



	}

	public static void main(String[] args) {
		// self-testing
		String record = "Harshul,Kashyap, Brampton Canada , 4372341173 , 123456789012, c";

		// create object
		CustomerRecord sInfo = new CustomerRecord(); // tests the constructor

		// test the processRecord
		sInfo.processRecord(record);


		System.out.println(sInfo);

		String record2 = "Gaurav,Ladhar, Daviselm Drive , 6478099679 , 456789012345, s";

		// create object
		CustomerRecord sInfo2 = new CustomerRecord(); // tests the constructor

		// test the processRecord
		sInfo2.processRecord(record2);


		System.out.println(sInfo2);

		String record3 = "Joey, Oshawa , Toronto Canada  , 6472341173 , 678901234567, i";

		// create object
		CustomerRecord sInfo3 = new CustomerRecord(); // tests the constructor

		// test the processRecord
		sInfo3.processRecord(record3);


		System.out.println(sInfo3);






	}

}
