import javax.swing.JOptionPane;

/**
 *
 */

/**
 * @author Harshul
 *
 */
public class CustomerList {

	/**
	 * Instance data
	 */
	private Customer list[];
	private int maxSize;
	private int newMaxSize;
	private int size;

	public CustomerList() {
		this.maxSize = 10;
		this.newMaxSize = 20;
		this.list = new CustomerRecord[maxSize];
		this.size = 0;
	}

	public boolean insert(CustomerRecord record) {
		// if size is below maxSize
		if (size < maxSize) {
			size++; // increase by 1
			list [size-1] = record;
			return true;
		}
		return false;
	}

	public boolean delete(CustomerRecord record) {
		// loop through the valid list
		for (int i = 0; i < size; i++) {
			// check if the record is found
			if (list[i].getFirstName().equalsIgnoreCase(record.getFirstName())) {
				list[i] = list[size-1]; // places the last record in the i location
				size--; // decreases usable size
				return true;
			}
		}
		// record not found
		return false;
	}


	/**
	 * Method to change the record
	 */
	public boolean change(CustomerRecord oldR, CustomerRecord newR) {
		// check if you can delete the old record
		if(delete(oldR)) {
			insert(newR);
			return true;
		}
		return false;
	}

	public String toString() {
		String theList = "";
		for (int i = 0; i < this.size; i++) {
			theList = theList + "Record " + i + ": " + this.list[i].toString() + "\n";
		}
		return theList;
	}

	/**
	 * @return the list
	 */
	public Customer[] getList() {
		return list;
	}

	/**
	 * @param list the list to set
	 */
	public void setList(Customer[] list) {
		this.list = list;
	}

	/**
	 * @return the maxSize
	 */
	public int getMaxSize() {
		return maxSize;
	}

	/**
	 * @param maxSize the maxSize to set
	 */
	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}

	/**
	 * @return the newMaxSize
	 */
	public int getNewMaxSize() {
		return newMaxSize;
	}

	/**
	 * @param newMaxSize the newMaxSize to set
	 */
	public void setNewMaxSize(int newMaxSize) {
		this.newMaxSize = newMaxSize;
	}

	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}



	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// create a List object
		CustomerList customer = new CustomerList();

		// infinite loop to test it
		while(true) {
			char command = JOptionPane.showInputDialog(null, "i - insert\n" + "d - delete\n" + "c - change\n" +
					"p - display\n" + "q - quit", "i").charAt(0);

			if (command == 'q') {
				break;
			}
			switch (command) {
			case 'i': {
				String record = JOptionPane.showInputDialog(null, "Enter <firstname, lastname, address, phonenumber, accountnumber, accounttype>",
						"Harshul,Kashyap, Brampton Canada , 4372341173 , 123456789012, c");
				// create and process a record object
				CustomerRecord sInfo = new CustomerRecord();
				sInfo.processRecord(record);
				if (customer.insert(sInfo)) {
					JOptionPane.showMessageDialog(null, "Record inserted");
				}
				else {
					JOptionPane.showMessageDialog(null, "Insert failed");
				}
				break;
			}
			case 'd': {
				String record = JOptionPane.showInputDialog(null, "<firstname, lastname, address, phonenumber, accountnumber, accounttype>",
						"Harshul,Kashyap, Brampton Canada , 4372341173 , 123456789012, c");
				// create and process a record object
				CustomerRecord sInfo = new CustomerRecord();
				sInfo.processRecord(record);
				if (customer.delete(sInfo)) {
					JOptionPane.showMessageDialog(null, "Record deleted");
				}
				else {
					JOptionPane.showMessageDialog(null, "Delete failed");
				}
				break;
			}
			case 'c': {
				String oldRecord = JOptionPane.showInputDialog(null, "<firstname, lastname, address, phonenumber, accountnumber, accounttype>",
						"Harshul,Kashyap, Brampton Canada , 4372341173 , 123456789012, c");
				// create and process a record object
				CustomerRecord oldInfo = new CustomerRecord();
				oldInfo.processRecord(oldRecord);

				String newRecord = JOptionPane.showInputDialog(null, "<firstname, lastname, address, phonenumber, accountnumber, accounttype>",
						"Harshul,Kashyap, Brampton Canada , 4372341173 , 123456789012, c");
				// create and process a record object
				CustomerRecord newInfo = new CustomerRecord();
				newInfo.processRecord(newRecord);

				if (customer.change(oldInfo, newInfo)) {
					JOptionPane.showMessageDialog(null, "Record changed");
				}
				else {
					JOptionPane.showMessageDialog(null, "Change failed");
				}
				break;
			}
			case 'p': {
				JOptionPane.showMessageDialog(null, customer.toString());
				break;
			}
			}
		}

	}

}