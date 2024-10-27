/**
 * 
 */

/**
 * @author Gaurav
 * Date: 2022-05-27
 * Description: This program keeps the customer's first and last name, address, and phone number.
 */
public class Customer {

	// initialize all instance data
	private String firstName;
	private String lastName;
	private String address;
	private String phoneNumber;

	/**
	 * Default constructor
	 */
	public Customer() {
		// initialize the data
		this.firstName = "";
		this.lastName = "";
		this.address = "";
		this.phoneNumber = "";
	}

	/**
	 * Overloaded constructor
	 */
	public Customer(String firstName, String lastName, String address, String phoneNumber) {
		// set instance data to user data being passed in 
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	/**
	 * Proccess the String
	 */
	public void processString(String record) {
		// split record into String array
		String words[] = record.split(",");
		// save the words into instance data
		this.firstName = words[0];
		this.lastName = words[1];
		this.address = words[2];
		this.phoneNumber = words[3];

	}

	/**
	 * toString method to generate and display contents
	 */
	public String toString() {
		return "Customer [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", phoneNumber="
				+ phoneNumber + "]";
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// self-testing main method
		String customerData = "Gaurav,Ladhar,Daviselm Drive,647-809-9679";

		// create object
		Customer bank = new Customer();

		// test processString
		bank.processString(customerData);

		// display customer data
		System.out.println(bank);

	}

}
