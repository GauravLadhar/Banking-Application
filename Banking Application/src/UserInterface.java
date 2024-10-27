import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.text.BadLocationException;
import java.awt.CardLayout;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Collections;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;

/**
 * 
 * @author Gaurav
 * Date: 2022-06-08
 * Description: GUI for the bank system
 */

public class UserInterface {

	private JFrame frmBankSystem;
	private JTextField usernameTextField;
	private JPasswordField passwordTextField;
	private JTextField userTextField;
	private JTextField passTextField;
	private JTextField nameTextField;
	private JTextField lastTextField;
	private JTextField addTextField;
	private JTextField phoneTextField;
	private JTextField savingsTextField;
	private JTextField chequingTextField;
	private JTextField investmentTextField;
	private JTextArea chequingTransactionTextArea, savingsTransactionTextArea, investmentTransactionTextArea;
	private JLabel loginErrorMessage, withdrawError, noBalanceError, savingsWithdrawError, investmentWithdrawError, lblEmployeeAccountError;
	private String firstNameInput;
	private String lastNameInput;
	private String addressInput;
	private double savingsBalanceInput;
	private double chequingBalanceInput;
	private double investmentBalanceInput;
	private String usernameInput;
	private String passwordInput;
	private String accountNumber;
	private Customer customer;
	private ChequingAccount chequing;
	private SavingsAccount savings;
	private InvestmentAccount investment;
	private CustomerRecord list;
	private CustomerList info;
	private Picture p;
	private JTextField employeeUsernameTextField;
	private JPasswordField employeePasswordTextField;


	/**
	 * Create the application.
	 */
	public UserInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame
	 */
	private void initialize() {
		frmBankSystem = new JFrame();
		frmBankSystem.setTitle("BramptonBanking.ca");
		frmBankSystem.setBounds(100, 100, 800, 600);
		frmBankSystem.setLocation(370, 100);
		frmBankSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBankSystem.getContentPane().setLayout(null);

		// main panel
		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 786, 553);
		frmBankSystem.getContentPane().add(mainPanel);
		mainPanel.setLayout(new CardLayout(0, 0));

		// login panel
		JPanel loginPanel = new JPanel();
		mainPanel.add(loginPanel, "name_2045314169401500");
		loginPanel.setLayout(null);

		// welcome label
		JLabel lblWelcome = new JLabel("Welcome to Brampton Banking!");
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblWelcome.setBounds(166, 50, 546, 95);
		loginPanel.add(lblWelcome);

		// username label
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUsername.setBounds(344, 174, 104, 30);
		loginPanel.add(lblUsername);

		// username text field
		usernameTextField = new JTextField();
		usernameTextField.setBounds(256, 214, 269, 30);
		loginPanel.add(usernameTextField);
		usernameTextField.setColumns(10);

		// password label
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPassword.setBounds(344, 278, 104, 30);
		loginPanel.add(lblPassword);

		// password text field
		passwordTextField = new JPasswordField();
		passwordTextField.setBounds(256, 313, 269, 30);
		loginPanel.add(passwordTextField);

		// create login button
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLogin.setBounds(256, 386, 104, 30);
		loginPanel.add(btnLogin);

		// create account login
		JButton btnCreateAccount = new JButton("Create");
		btnCreateAccount.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCreateAccount.setBounds(421, 386, 104, 30);
		loginPanel.add(btnCreateAccount);

		// login error message
		loginErrorMessage = new JLabel("");
		loginErrorMessage.setForeground(Color.RED);
		loginErrorMessage.setFont(new Font("Tahoma", Font.BOLD, 13));
		loginErrorMessage.setBounds(256, 341, 269, 40);
		loginPanel.add(loginErrorMessage);

		// employee login button
		JButton btnEmployeeLogin = new JButton("Employee Login");	
		btnEmployeeLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnEmployeeLogin.setBounds(256, 455, 269, 40);
		loginPanel.add(btnEmployeeLogin);

		// background image
		JLabel backgroundImage = new JLabel("New label");
		backgroundImage.setIcon(new ImageIcon("background.jpg"));
		backgroundImage.setBounds(0, 0, 786, 563);
		loginPanel.add(backgroundImage);

		// create account panel
		JPanel createAccountPanel = new JPanel();
		mainPanel.add(createAccountPanel, "name_2045594117533400");
		createAccountPanel.setLayout(null);

		// create username label
		JLabel lblUsernameCreate = new JLabel("Username");
		lblUsernameCreate.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUsernameCreate.setBounds(188, 73, 99, 45);
		createAccountPanel.add(lblUsernameCreate);

		// user text field
		userTextField = new JTextField();
		userTextField.setBounds(297, 83, 298, 30);
		createAccountPanel.add(userTextField);
		userTextField.setColumns(10);

		// create password label
		JLabel lblPasswordCreate = new JLabel("Password");
		lblPasswordCreate.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPasswordCreate.setBounds(188, 141, 99, 45);
		createAccountPanel.add(lblPasswordCreate);

		// password text field
		passTextField = new JTextField();
		passTextField.setColumns(10);
		passTextField.setBounds(297, 151, 298, 30);
		createAccountPanel.add(passTextField);

		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblFirstName.setBounds(188, 213, 99, 45);
		createAccountPanel.add(lblFirstName);

		nameTextField = new JTextField();
		nameTextField.setColumns(10);
		nameTextField.setBounds(297, 223, 298, 30);
		createAccountPanel.add(nameTextField);

		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblLastName.setBounds(188, 282, 99, 45);
		createAccountPanel.add(lblLastName);

		lastTextField = new JTextField();
		lastTextField.setColumns(10);
		lastTextField.setBounds(297, 292, 298, 30);
		createAccountPanel.add(lastTextField);

		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAddress.setBounds(198, 345, 89, 45);
		createAccountPanel.add(lblAddress);

		addTextField = new JTextField();
		addTextField.setColumns(10);
		addTextField.setBounds(297, 355, 298, 30);
		createAccountPanel.add(addTextField);

		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPhoneNumber.setBounds(167, 408, 120, 45);
		createAccountPanel.add(lblPhoneNumber);

		phoneTextField = new JTextField();
		phoneTextField.setColumns(10);
		phoneTextField.setBounds(297, 418, 298, 30);
		createAccountPanel.add(phoneTextField);

		JButton btnDone = new JButton("Done");

		btnDone.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDone.setBounds(516, 497, 79, 30);
		createAccountPanel.add(btnDone);

		JLabel createAccountError = new JLabel("");
		createAccountError.setForeground(Color.RED);
		createAccountError.setFont(new Font("Tahoma", Font.BOLD, 13));
		createAccountError.setBounds(297, 458, 298, 30);
		createAccountPanel.add(createAccountError);

		JLabel backgroundImage2 = new JLabel("New label");
		backgroundImage2.setIcon(new ImageIcon("background.jpg"));
		backgroundImage2.setBounds(0, 0, 786, 563);
		createAccountPanel.add(backgroundImage2);

		JPanel accountInfoPanel = new JPanel();
		mainPanel.add(accountInfoPanel, "name_2049771486410700");
		accountInfoPanel.setLayout(null);

		JLabel lblFirstNameInfo = new JLabel("First Name");
		lblFirstNameInfo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFirstNameInfo.setBounds(10, 67, 105, 59);
		accountInfoPanel.add(lblFirstNameInfo);

		JTextArea firstNameTextArea = new JTextArea();
		firstNameTextArea.setEditable(false);
		firstNameTextArea.setBounds(108, 86, 215, 29);
		accountInfoPanel.add(firstNameTextArea);

		JLabel lblLastNameInfo = new JLabel("Last Name");
		lblLastNameInfo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLastNameInfo.setBounds(10, 125, 105, 59);
		accountInfoPanel.add(lblLastNameInfo);

		JTextArea lastNameTextArea = new JTextArea();
		lastNameTextArea.setEditable(false);
		lastNameTextArea.setBounds(108, 144, 215, 29);
		accountInfoPanel.add(lastNameTextArea);

		JLabel lblAccountNumberInfo = new JLabel("Account Number");
		lblAccountNumberInfo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAccountNumberInfo.setBounds(416, 67, 127, 59);
		accountInfoPanel.add(lblAccountNumberInfo);

		JTextArea accountNumberTextArea = new JTextArea();
		accountNumberTextArea.setEditable(false);
		accountNumberTextArea.setBounds(561, 86, 215, 29);
		accountInfoPanel.add(accountNumberTextArea);

		JLabel lblAddressInfo = new JLabel("Address");
		lblAddressInfo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAddressInfo.setBounds(470, 125, 74, 59);
		accountInfoPanel.add(lblAddressInfo);

		JTextArea addressTextArea = new JTextArea();
		addressTextArea.setEditable(false);
		addressTextArea.setBounds(561, 144, 215, 29);
		accountInfoPanel.add(addressTextArea);

		JLabel lblSavingsAccount = new JLabel("Savings Account Balance");
		lblSavingsAccount.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSavingsAccount.setBounds(10, 263, 215, 59);
		accountInfoPanel.add(lblSavingsAccount);

		savingsTextField = new JTextField();
		savingsTextField.setBounds(10, 312, 215, 29);
		accountInfoPanel.add(savingsTextField);
		savingsTextField.setColumns(10);

		JLabel lblChequingAccount = new JLabel("Chequing Account Balance");
		lblChequingAccount.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblChequingAccount.setBounds(290, 263, 215, 59);
		accountInfoPanel.add(lblChequingAccount);

		chequingTextField = new JTextField();
		chequingTextField.setColumns(10);
		chequingTextField.setBounds(290, 312, 215, 29);
		accountInfoPanel.add(chequingTextField);

		JLabel lblInvestmentAccount = new JLabel("Investment Account Balance");
		lblInvestmentAccount.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblInvestmentAccount.setBounds(558, 263, 218, 59);
		accountInfoPanel.add(lblInvestmentAccount);

		investmentTextField = new JTextField();
		investmentTextField.setColumns(10);
		investmentTextField.setBounds(561, 312, 215, 29);
		accountInfoPanel.add(investmentTextField);

		JLabel lblChoose = new JLabel("Select an account to transact from:");
		lblChoose.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblChoose.setBounds(10, 376, 325, 59);
		accountInfoPanel.add(lblChoose);

		JLabel lblInfoLabel = new JLabel("Account Information:");
		lblInfoLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblInfoLabel.setBounds(10, 10, 313, 59);
		accountInfoPanel.add(lblInfoLabel);

		JLabel lblAccountBalanceLabel = new JLabel("Initialize the current balance for each account:");
		lblAccountBalanceLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblAccountBalanceLabel.setBounds(10, 213, 495, 59);
		accountInfoPanel.add(lblAccountBalanceLabel);

		JButton btnSavingsAccount = new JButton("Savings Account");

		btnSavingsAccount.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSavingsAccount.setBounds(10, 445, 215, 42);
		accountInfoPanel.add(btnSavingsAccount);

		JButton btnChequingAccount = new JButton("Chequing Account");

		btnChequingAccount.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnChequingAccount.setBounds(290, 445, 215, 42);
		accountInfoPanel.add(btnChequingAccount);

		JButton btnInvestmentAccount = new JButton("Investment Account");

		btnInvestmentAccount.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnInvestmentAccount.setBounds(561, 445, 215, 42);
		accountInfoPanel.add(btnInvestmentAccount);

		noBalanceError = new JLabel("");
		noBalanceError.setForeground(Color.RED);
		noBalanceError.setFont(new Font("Tahoma", Font.BOLD, 13));
		noBalanceError.setBounds(226, 351, 452, 42);
		accountInfoPanel.add(noBalanceError);

		JButton btnExit = new JButton("Exit");

		btnExit.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnExit.setBounds(687, 27, 89, 29);
		accountInfoPanel.add(btnExit);

		JLabel backgroundImage3 = new JLabel("New label");
		backgroundImage3.setIcon(new ImageIcon("background.jpg"));
		backgroundImage3.setBounds(0, 0, 786, 563);
		accountInfoPanel.add(backgroundImage3);

		JPanel chequingAccountPanel = new JPanel();
		mainPanel.add(chequingAccountPanel, "name_2212021796574399");
		chequingAccountPanel.setLayout(null);

		JLabel chequingLabel = new JLabel("Chequing");
		chequingLabel.setBounds(316, 28, 201, 62);
		chequingLabel.setFont(new Font("Tahoma", Font.BOLD, 28));
		chequingAccountPanel.add(chequingLabel);

		JLabel chequingCustomerInfo = new JLabel("Customer Information");
		chequingCustomerInfo.setFont(new Font("Tahoma", Font.BOLD, 16));
		chequingCustomerInfo.setBounds(10, 111, 184, 46);
		chequingAccountPanel.add(chequingCustomerInfo);

		JTextArea chequingInfoTextArea = new JTextArea();
		chequingInfoTextArea.setEditable(false);
		chequingInfoTextArea.setBounds(10, 163, 289, 166);
		chequingAccountPanel.add(chequingInfoTextArea);

		JLabel chequingBalanceLabel = new JLabel("Balance");
		chequingBalanceLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		chequingBalanceLabel.setBounds(701, 111, 75, 46);
		chequingAccountPanel.add(chequingBalanceLabel);

		JTextArea chequingBalanceTextArea = new JTextArea();
		chequingBalanceTextArea.setEditable(false);
		chequingBalanceTextArea.setBounds(487, 163, 289, 22);
		chequingAccountPanel.add(chequingBalanceTextArea);

		JButton btnChequingDeposit = new JButton("Deposit");

		btnChequingDeposit.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnChequingDeposit.setBounds(10, 446, 124, 55);
		chequingAccountPanel.add(btnChequingDeposit);

		JButton btnChequingWithdraw = new JButton("Withdraw");

		btnChequingWithdraw.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnChequingWithdraw.setBounds(175, 446, 124, 55);
		chequingAccountPanel.add(btnChequingWithdraw);

		JButton btnChequingSave = new JButton("Save");

		btnChequingSave.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnChequingSave.setBounds(487, 446, 124, 55);
		chequingAccountPanel.add(btnChequingSave);

		JButton btnChequingBack = new JButton("Back");

		btnChequingBack.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnChequingBack.setBounds(652, 446, 124, 55);
		chequingAccountPanel.add(btnChequingBack);

		withdrawError = new JLabel("");
		withdrawError.setFont(new Font("Tahoma", Font.BOLD, 14));
		withdrawError.setForeground(new Color(255, 0, 0));
		withdrawError.setBounds(188, 331, 436, 81);
		chequingAccountPanel.add(withdrawError);

		chequingTransactionTextArea = new JTextArea();
		chequingTransactionTextArea.setBounds(487, 195, 289, 134);
		chequingAccountPanel.add(chequingTransactionTextArea);

		JLabel backgroundImage4 = new JLabel("New label");
		backgroundImage4.setIcon(new ImageIcon("background.jpg"));
		backgroundImage4.setBounds(0, 0, 786, 563);
		chequingAccountPanel.add(backgroundImage4);

		JPanel savingsAccountPanel = new JPanel();
		savingsAccountPanel.setLayout(null);
		mainPanel.add(savingsAccountPanel, "name_2217915219412000");

		JLabel savingsLabel = new JLabel("Savings");
		savingsLabel.setFont(new Font("Tahoma", Font.BOLD, 28));
		savingsLabel.setBounds(328, 29, 196, 62);
		savingsAccountPanel.add(savingsLabel);

		JLabel savingsCustomerInfo = new JLabel("Customer Information");
		savingsCustomerInfo.setFont(new Font("Tahoma", Font.BOLD, 16));
		savingsCustomerInfo.setBounds(10, 111, 184, 46);
		savingsAccountPanel.add(savingsCustomerInfo);

		JTextArea savingsInfoTextArea = new JTextArea();
		savingsInfoTextArea.setEditable(false);
		savingsInfoTextArea.setBounds(10, 163, 289, 166);
		savingsAccountPanel.add(savingsInfoTextArea);

		JLabel savingsBalanceLabel = new JLabel("Balance");
		savingsBalanceLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		savingsBalanceLabel.setBounds(701, 111, 75, 46);
		savingsAccountPanel.add(savingsBalanceLabel);

		JTextArea savingsBalanceTextArea = new JTextArea();
		savingsBalanceTextArea.setEditable(false);
		savingsBalanceTextArea.setBounds(487, 163, 289, 22);
		savingsAccountPanel.add(savingsBalanceTextArea);

		JButton btnSavingsDeposit = new JButton("Deposit");

		btnSavingsDeposit.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSavingsDeposit.setBounds(10, 446, 124, 55);
		savingsAccountPanel.add(btnSavingsDeposit);

		JButton btnSavingsWithdraw = new JButton("Withdraw");

		btnSavingsWithdraw.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSavingsWithdraw.setBounds(175, 446, 124, 55);
		savingsAccountPanel.add(btnSavingsWithdraw);

		JButton btnSavingsSave = new JButton("Save");

		btnSavingsSave.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSavingsSave.setBounds(487, 446, 124, 55);
		savingsAccountPanel.add(btnSavingsSave);

		JButton btnSavingsBack = new JButton("Back");

		btnSavingsBack.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSavingsBack.setBounds(652, 446, 124, 55);
		savingsAccountPanel.add(btnSavingsBack);

		savingsWithdrawError = new JLabel("");
		savingsWithdrawError.setForeground(Color.RED);
		savingsWithdrawError.setFont(new Font("Tahoma", Font.BOLD, 14));
		savingsWithdrawError.setBounds(186, 336, 436, 81);
		savingsAccountPanel.add(savingsWithdrawError);

		savingsTransactionTextArea = new JTextArea();
		savingsTransactionTextArea.setBounds(487, 195, 289, 134);
		savingsAccountPanel.add(savingsTransactionTextArea);

		JLabel backgroundImage5 = new JLabel("New label");
		backgroundImage5.setIcon(new ImageIcon("background.jpg"));
		backgroundImage5.setBounds(0, 0, 786, 563);
		savingsAccountPanel.add(backgroundImage5);

		JPanel investmentAccountPanel = new JPanel();
		investmentAccountPanel.setLayout(null);
		mainPanel.add(investmentAccountPanel, "name_2326634448247300");

		JLabel investmentLabel = new JLabel("Investment");
		investmentLabel.setFont(new Font("Tahoma", Font.BOLD, 28));
		investmentLabel.setBounds(311, 30, 196, 62);
		investmentAccountPanel.add(investmentLabel);

		JLabel investmentCustomerInfo = new JLabel("Customer Information");
		investmentCustomerInfo.setFont(new Font("Tahoma", Font.BOLD, 16));
		investmentCustomerInfo.setBounds(10, 111, 184, 46);
		investmentAccountPanel.add(investmentCustomerInfo);

		JTextArea investmentInfoTextArea = new JTextArea();
		investmentInfoTextArea.setEditable(false);
		investmentInfoTextArea.setBounds(10, 163, 289, 166);
		investmentAccountPanel.add(investmentInfoTextArea);

		JLabel investmentBalanceLabel = new JLabel("Balance");
		investmentBalanceLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		investmentBalanceLabel.setBounds(701, 111, 75, 46);
		investmentAccountPanel.add(investmentBalanceLabel);

		JTextArea investmentBalanceTextArea = new JTextArea();
		investmentBalanceTextArea.setEditable(false);
		investmentBalanceTextArea.setBounds(487, 163, 289, 22);
		investmentAccountPanel.add(investmentBalanceTextArea);

		JButton btnInvestmentDeposit = new JButton("Deposit");

		btnInvestmentDeposit.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnInvestmentDeposit.setBounds(10, 446, 124, 55);
		investmentAccountPanel.add(btnInvestmentDeposit);

		JButton btnInvestmentWithdraw = new JButton("Withdraw");

		btnInvestmentWithdraw.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnInvestmentWithdraw.setBounds(175, 446, 124, 55);
		investmentAccountPanel.add(btnInvestmentWithdraw);

		JButton btnInvestmentSave = new JButton("Save");

		btnInvestmentSave.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnInvestmentSave.setBounds(487, 446, 124, 55);
		investmentAccountPanel.add(btnInvestmentSave);

		JButton btnInvestmentBack = new JButton("Back");

		btnInvestmentBack.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnInvestmentBack.setBounds(652, 446, 124, 55);
		investmentAccountPanel.add(btnInvestmentBack);

		investmentWithdrawError = new JLabel("");
		investmentWithdrawError.setForeground(Color.RED);
		investmentWithdrawError.setFont(new Font("Tahoma", Font.BOLD, 14));
		investmentWithdrawError.setBounds(188, 327, 436, 81);
		investmentAccountPanel.add(investmentWithdrawError);

		investmentTransactionTextArea = new JTextArea();
		investmentTransactionTextArea.setBounds(487, 195, 289, 134);
		investmentAccountPanel.add(investmentTransactionTextArea);

		JLabel backgroundImage6 = new JLabel("New label");
		backgroundImage6.setIcon(new ImageIcon("background.jpg"));
		backgroundImage6.setBounds(0, 0, 786, 563);
		investmentAccountPanel.add(backgroundImage6);

		JPanel createEmployeeAccountPanel = new JPanel();
		mainPanel.add(createEmployeeAccountPanel, "name_2574051622586400");
		createEmployeeAccountPanel.setLayout(null);

		JLabel lblEmployeeLogin = new JLabel("Employee Login");
		lblEmployeeLogin.setBounds(269, 36, 284, 79);
		lblEmployeeLogin.setFont(new Font("Tahoma", Font.BOLD, 28));
		createEmployeeAccountPanel.add(lblEmployeeLogin);

		JLabel lblEmployeeUsername = new JLabel("Username");
		lblEmployeeUsername.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEmployeeUsername.setBounds(343, 150, 102, 33);
		createEmployeeAccountPanel.add(lblEmployeeUsername);

		employeeUsernameTextField = new JTextField();
		employeeUsernameTextField.setBounds(269, 193, 240, 33);
		createEmployeeAccountPanel.add(employeeUsernameTextField);
		employeeUsernameTextField.setColumns(10);

		JLabel lblEmployeePassword = new JLabel("Password");
		lblEmployeePassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEmployeePassword.setBounds(343, 283, 102, 33);
		createEmployeeAccountPanel.add(lblEmployeePassword);

		JButton btnLoginEmployee = new JButton("Login");

		btnLoginEmployee.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLoginEmployee.setBounds(269, 434, 102, 33);
		createEmployeeAccountPanel.add(btnLoginEmployee);

		employeePasswordTextField = new JPasswordField();
		employeePasswordTextField.setBounds(269, 325, 240, 33);
		createEmployeeAccountPanel.add(employeePasswordTextField);

		lblEmployeeAccountError = new JLabel("");
		lblEmployeeAccountError.setForeground(Color.RED);
		lblEmployeeAccountError.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEmployeeAccountError.setBounds(269, 376, 240, 48);
		createEmployeeAccountPanel.add(lblEmployeeAccountError);

		JButton btnEmployeeBack = new JButton("Back");

		btnEmployeeBack.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnEmployeeBack.setBounds(407, 434, 102, 33);
		createEmployeeAccountPanel.add(btnEmployeeBack);

		JLabel backgroundImage7 = new JLabel("New label");
		backgroundImage7.setBounds(0, 0, 786, 563);
		backgroundImage7.setIcon(new ImageIcon("EmployeeBackground.jpg"));
		createEmployeeAccountPanel.add(backgroundImage7);

		JPanel EmployeePanel = new JPanel();
		mainPanel.add(EmployeePanel, "name_2574751683318800");
		EmployeePanel.setLayout(null);

		JLabel lblAccountList = new JLabel("Account List");
		lblAccountList.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAccountList.setBounds(10, 38, 285, 42);
		EmployeePanel.add(lblAccountList);

		JTextArea accountListTextArea = new JTextArea();
		accountListTextArea.setBounds(10, 90, 766, 216);
		EmployeePanel.add(accountListTextArea);

		JButton btnAdd = new JButton("Add");

		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAdd.setBounds(10, 462, 102, 51);
		EmployeePanel.add(btnAdd);

		JTextArea infoTextArea = new JTextArea();
		infoTextArea.setBounds(10, 336, 766, 106);
		EmployeePanel.add(infoTextArea);

		JButton btnDelete = new JButton("Delete");

		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDelete.setBounds(167, 462, 102, 51);
		EmployeePanel.add(btnDelete);

		JButton btnFind = new JButton("Find");

		btnFind.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnFind.setBounds(340, 462, 102, 51);
		EmployeePanel.add(btnFind);

		JButton btnSave = new JButton("Save");

		btnSave.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSave.setBounds(520, 462, 102, 51);
		EmployeePanel.add(btnSave);

		JButton btnEmployeeExit = new JButton("Exit");

		btnEmployeeExit.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnEmployeeExit.setBounds(674, 462, 102, 51);
		EmployeePanel.add(btnEmployeeExit);

		JLabel backgroundImage8 = new JLabel("New label");
		backgroundImage8.setBounds(0, 0, 786, 563);
		backgroundImage8.setIcon(new ImageIcon("EmployeeBackground.jpg"));
		EmployeePanel.add(backgroundImage8);

		// import DecimalFormat to two decimals
		DecimalFormat twoDigit = new DecimalFormat("#0.00");

		// createAccount panel
		btnCreateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// set createAccount panel visible
				loginPanel.setVisible(false);
				createAccountPanel.setVisible(true);
				accountInfoPanel.setVisible(false);
				savingsAccountPanel.setVisible(false);
				chequingAccountPanel.setVisible(false);
				investmentAccountPanel.setVisible(false);
				EmployeePanel.setVisible(false);
				createEmployeeAccountPanel.setVisible(false);
			}
		});

		// login panel
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// get info from TextFields
				String username = userTextField.getText();
				String password = passTextField.getText();
				String firstName = nameTextField.getText();
				String lastName = lastTextField.getText();
				String address = addTextField.getText();
				String phoneNumber = phoneTextField.getText();

				loginErrorMessage.setText("");

				// checks to see if any blanks are left when creating account
				if (username.isEmpty() || password.isEmpty() || firstName.isEmpty() || 
						lastName.isEmpty() || address.isEmpty() || phoneNumber.isEmpty()) {
					createAccountError.setText("Error, please complete the registration");
				}
				// display when successful
				else {
					usernameTextField.setText("");
					passwordTextField.setText("");

					loginPanel.setVisible(true);
					createAccountPanel.setVisible(false);
					accountInfoPanel.setVisible(false);
					savingsAccountPanel.setVisible(false);
					chequingAccountPanel.setVisible(false);
					investmentAccountPanel.setVisible(false);
					EmployeePanel.setVisible(false);
					createEmployeeAccountPanel.setVisible(false);
				}
			}
		});

		// accountInfo panel
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// get username and password from textField
				String username = userTextField.getText();
				String password = passTextField.getText();

				// run only when username and password are correct
				if (usernameTextField.getText().equals(username) && passwordTextField.getText().equals(password)) {

					accountInfoPanel.setVisible(true);
					loginPanel.setVisible(false);
					createAccountPanel.setVisible(false);
					savingsAccountPanel.setVisible(false);
					chequingAccountPanel.setVisible(false);
					investmentAccountPanel.setVisible(false);

					// get and set account info text
					firstNameInput = nameTextField.getText();
					firstNameTextArea.setText(firstNameInput);

					lastNameInput = lastTextField.getText();
					lastNameTextArea.setText(lastNameInput);

					addressInput = addTextField.getText();
					addressTextArea.setText(addressInput);

					// generate account number
					accountNumber = "";
					// generate a random 12-digit account number;
					for (int i = 0; i < 12; i++) {
						int digits = (int)(Math.random() * 9);
						accountNumber = accountNumber + Integer.toString(digits);
					}

					// set accountNumber
					accountNumberTextArea.setText(accountNumber);

				}
				// if user tries to login without entering a username or password
				if (username.isEmpty() || password.isEmpty()) {

					accountInfoPanel.setVisible(false);
					loginPanel.setVisible(true);
					createAccountPanel.setVisible(false);
					savingsAccountPanel.setVisible(false);
					chequingAccountPanel.setVisible(false);
					investmentAccountPanel.setVisible(false);
					EmployeePanel.setVisible(false);
					createEmployeeAccountPanel.setVisible(false);

					loginErrorMessage.setText("Error, please create an account first");
				}
				// if incorrect password is entered
				if (username.isEmpty() != true && password.isEmpty() != true && usernameTextField.getText().equals(username) != true || passwordTextField.getText().equals(password) != true) {
					// display an error message to panel
					loginErrorMessage.setText("Error, username or password is incorrect");
				}
			}

		});

		// exit button takes user back to main menu
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// set login panel visible
				accountInfoPanel.setVisible(false);
				loginPanel.setVisible(true);
				createAccountPanel.setVisible(false);
				savingsAccountPanel.setVisible(false);
				chequingAccountPanel.setVisible(false);
				investmentAccountPanel.setVisible(false);
				EmployeePanel.setVisible(false);
				createEmployeeAccountPanel.setVisible(false);
				
				loginErrorMessage.setText("");
				usernameTextField.setText("");
				passwordTextField.setText("");
			}
		});

		// <<<<<<<<<<information for chequing account components>>>>>>>>>>

		// chequingAccount panel
		btnChequingAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String output;
				String valueInput = chequingTextField.getText();

				// if user tries to login to chequing account without entering balance 
				if (valueInput.isEmpty() || !(valueInput.matches("^[0-9]+$"))) {
					noBalanceError.setText("Error, please insert a balance for chequing account");
				}
				else {
					accountInfoPanel.setVisible(false);
					loginPanel.setVisible(false);
					createAccountPanel.setVisible(false);
					savingsAccountPanel.setVisible(false);
					chequingAccountPanel.setVisible(true);
					investmentAccountPanel.setVisible(false);
					EmployeePanel.setVisible(false);
					createEmployeeAccountPanel.setVisible(false);

					// get text from initial balances
					chequingBalanceInput = Double.parseDouble(chequingTextField.getText());

					output = chequingBalanceTextArea.getText() + chequingBalanceInput;
					chequingBalanceTextArea.setText(output);

					// get and set account info text
					chequingInfoTextArea.setText("First Name: " + nameTextField.getText() + "\n" + "Last Name: " + lastTextField.getText() + 
							"\n" + "Account Number: " + accountNumberTextArea.getText() + "\n" + "Address: " + addTextField.getText() + 
							"\n" + "Phone Number: " + phoneTextField.getText());
				}

			}
		});

		// deposit button for chequing account
		btnChequingDeposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				withdrawError.setText("");

				// initialize fee and var for new balance
				double newBalance;
				double fee = 3.50;

				// create new chequingAccount object
				chequing = new ChequingAccount();

				// get user-inputed chequing account balance
				chequingBalanceInput = Double.parseDouble(chequingBalanceTextArea.getText());

				// prompt user to input a deposit amount
				double deposit = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter amount to deposit"));

				// call chequingAccount and deposit amount
				newBalance = chequing.deposit(chequingBalanceInput, deposit);

				// display
				chequingBalanceTextArea.setText(twoDigit.format(newBalance));

				// show last transaction
				chequingTransactionTextArea.setText("Transaction" + "\n" + "==========" + "\n" + "Balance: " + "$" + chequingBalanceInput +  "\n" + "Deposit: " + "$" + deposit 
						+ "\n" + "Service fee: " + "$" + twoDigit.format(fee) + "\n" + "==========" + "\n" + "New balance: " + "$" + twoDigit.format(newBalance));

			}
		});

		// withdraw button for chequing account
		btnChequingWithdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				withdrawError.setText("");

				// initalize new balance var
				double newBalance;

				// create new chequingAccount object
				chequing = new ChequingAccount();

				// get chequing balance input 
				chequingBalanceInput = Double.parseDouble(chequingBalanceTextArea.getText());

				// prompt user to enter a withdraw amount
				double withdraw = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter amount to withdraw"));

				// set fee
				double fee = chequingBalanceInput * 0.005;

				// if there is enough balance for a withdrawl
				if (chequingBalanceInput >= withdraw) {
					// call chequingAccount and withdraw amount
					newBalance = chequing.withdraw(chequingBalanceInput, withdraw);

					// display
					chequingBalanceTextArea.setText(twoDigit.format(newBalance));

					// show last transaction
					chequingTransactionTextArea.setText("Transaction" + "\n" + "==========" + "\n" + "Balance: " + "$" + chequingBalanceInput +  "\n" + "Withdraw: " + "$" + withdraw 
							+ "\n" + "Service fee: " + "$" + twoDigit.format(fee) + "\n" + "==========" + "\n" + "New balance: " + "$" + twoDigit.format(newBalance));
				}
				// display error if not enough balance 
				else {
					withdrawError.setText("Error, insufficient funds to complete the transaction");
				}

			}
		});

		// save button
		btnChequingSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// file save message
				JOptionPane.showMessageDialog(null, "Customer File Saved");

				// get first 3 numbers of String
				String accountFileName = accountNumberTextArea.getText();
				String newAccountNumber = accountFileName.substring(0, 3);

				// create file based on last name, first name, and first 3 digits of account number
				try {
					FileWriter fileW = new FileWriter(lastTextField.getText() + "-" + nameTextField.getText() + "-" + newAccountNumber);
					PrintWriter output = new PrintWriter(fileW);
					output.print("=================================" + "\n" + "First Name: " + nameTextField.getText() + "\n" + "Last Name: " + lastTextField.getText() + 
							"\n" + "Account Number: " + accountNumberTextArea.getText() + "\n" + "Address: " + addTextField.getText() + 
							"\n" + "Phone Number: " + phoneTextField.getText() + "\n" + "=================================" + "\n"
							+ "Chequing account balance: " + "$" + chequingBalanceTextArea.getText());
					fileW.close();
					// catch errors
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "File Save Unsuccessful");
				}
			}
		});

		// exit button
		btnChequingBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// go back to accountInfo screen
				noBalanceError.setText("");

				// set account info panel visible
				accountInfoPanel.setVisible(true);
				loginPanel.setVisible(false);
				createAccountPanel.setVisible(false);
				savingsAccountPanel.setVisible(false);
				chequingAccountPanel.setVisible(false);
				investmentAccountPanel.setVisible(false);
				EmployeePanel.setVisible(false);
				createEmployeeAccountPanel.setVisible(false);

				// update balances on account info
				chequingTextField.setText(chequingBalanceTextArea.getText());
				savingsTextField.setText(savingsBalanceTextArea.getText());
				investmentTextField.setText(investmentBalanceTextArea.getText());

				chequingBalanceTextArea.setText("");
			}
		});


		// <<<<<<<<<<information for savings account components>>>>>>>>>>

		// savingsAccount panel
		btnSavingsAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String output;
				String valueInput = savingsTextField.getText();

				// if user tries to login to chequing account without entering balance
				if (valueInput.isEmpty() || !(valueInput.matches("^[0-9]+$"))) {
					noBalanceError.setText("Error, please insert a balance for savings account");
				}
				else {
					accountInfoPanel.setVisible(false);
					loginPanel.setVisible(false);
					createAccountPanel.setVisible(false);
					savingsAccountPanel.setVisible(true);
					chequingAccountPanel.setVisible(false);
					investmentAccountPanel.setVisible(false);
					EmployeePanel.setVisible(false);
					createEmployeeAccountPanel.setVisible(false);

					// get text from initial balances
					savingsBalanceInput = Double.parseDouble(savingsTextField.getText());

					// set display
					output = savingsBalanceTextArea.getText() + savingsBalanceInput;
					savingsBalanceTextArea.setText(output);

					// get and set account info text
					savingsInfoTextArea.setText("First Name: " + nameTextField.getText() + "\n" + "Last Name: " + lastTextField.getText() + 
							"\n" + "Account Number: " + accountNumberTextArea.getText() + "\n" + "Address: " + addTextField.getText() + 
							"\n" + "Phone Number: " + phoneTextField.getText());
				}

			}

		});

		// savings deposit
		btnSavingsDeposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				withdrawError.setText("");

				// initialize var for new balance
				double newBalance;

				// create new chequingAccount object
				savings = new SavingsAccount();

				// get the user-inputed balance
				savingsBalanceInput = Double.parseDouble(savingsBalanceTextArea.getText());

				// prompt user for deposit
				double deposit = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter amount to deposit"));

				// call chequingAccount and deposit amount
				newBalance = savings.deposit(savingsBalanceInput, deposit);

				// display
				savingsBalanceTextArea.setText(twoDigit.format(newBalance));

				// show last transaction
				savingsTransactionTextArea.setText("Transaction" + "\n" + "==========" + "\n" + "Balance: " + "$" + savingsBalanceInput +  "\n" + "Deposit: " + "$" + deposit 
						+ "\n" + "==========" + "\n" + "New balance: " + "$" + twoDigit.format(newBalance));
			}
		});

		// savings withdraw
		btnSavingsWithdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				savingsWithdrawError.setText("");

				// initilize var for new balance
				double newBalance;

				// create new chequingAccount object
				savings = new SavingsAccount();

				// get user-inputed balance
				savingsBalanceInput = Double.parseDouble(savingsBalanceTextArea.getText());

				// prompt user for withdraw amount
				double withdraw = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter amount to withdraw"));

				// if there is enough balance for withdraw
				if (savingsBalanceInput >= withdraw) {
					// call chequingAccount and withdraw amount
					newBalance = savings.withdrawal(savingsBalanceInput, withdraw);

					// display
					savingsBalanceTextArea.setText(twoDigit.format(newBalance));

					// show last transaction
					savingsTransactionTextArea.setText("Transaction" + "\n" + "==========" + "\n" + "Balance: " + "$" + savingsBalanceInput +  "\n" + "Withdraw: " + "$" + withdraw 
							+ "\n" + "==========" + "\n" + "New balance: " + "$" + twoDigit.format(newBalance));
				}
				// if not enough balance, display error
				else {
					savingsWithdrawError.setText("Error, insufficient funds to complete the transaction");
				}
			}
		});

		// save button for savings account
		btnSavingsSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Customer File Saved");

				// use substring to get first 3 numbers of String
				String accountFileName = accountNumberTextArea.getText();
				String newAccountNumber = accountFileName.substring(0, 3);

				// create file with last name, first name, and first 3 digits of account number
				try {
					FileWriter fileW = new FileWriter(lastTextField.getText() + "-" + nameTextField.getText() + "-" + newAccountNumber);
					PrintWriter output = new PrintWriter(fileW);
					output.print("=================================" + "\n" + "First Name: " + nameTextField.getText() + "\n" + "Last Name: " + lastTextField.getText() + 
							"\n" + "Account Number: " + accountNumberTextArea.getText() + "\n" + "Address: " + addTextField.getText() + 
							"\n" + "Phone Number: " + phoneTextField.getText() + "\n" + "=================================" + "\n"
							+ "Savings account balance: " + "$"
							+ savingsBalanceTextArea.getText());
					fileW.close();
					// catch errors
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "File Save Unsuccessful");
				}
			}
		});

		// savings back button
		btnSavingsBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// go back to accountInfo screen
				noBalanceError.setText("");

				// set account info panel visible
				accountInfoPanel.setVisible(true);
				loginPanel.setVisible(false);
				createAccountPanel.setVisible(false);
				savingsAccountPanel.setVisible(false);
				chequingAccountPanel.setVisible(false);
				investmentAccountPanel.setVisible(false);
				EmployeePanel.setVisible(false);
				createEmployeeAccountPanel.setVisible(false);

				// update balances on account info
				chequingTextField.setText(chequingBalanceTextArea.getText());
				savingsTextField.setText(savingsBalanceTextArea.getText());
				investmentTextField.setText(investmentBalanceTextArea.getText());

				savingsBalanceTextArea.setText("");
			}
		});

		// <<<<<<<<<<information for investment account components>>>>>>>>>>

		// investmentAccount panel
		btnInvestmentAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String output;
				String valueInput = investmentTextField.getText();

				// if user tries to login to chequing account without entering balance
				if (valueInput.isEmpty() || !(valueInput.matches("^[0-9]+$"))) {
					noBalanceError.setText("Error, please insert a balance for investment account");
				}
				else {
					accountInfoPanel.setVisible(false);
					loginPanel.setVisible(false);
					createAccountPanel.setVisible(false);
					savingsAccountPanel.setVisible(false);
					chequingAccountPanel.setVisible(false);
					investmentAccountPanel.setVisible(true);
					EmployeePanel.setVisible(false);
					createEmployeeAccountPanel.setVisible(false);

					// get text from initial balances
					investmentBalanceInput = Double.parseDouble(investmentTextField.getText());

					// set output for display
					output = investmentBalanceTextArea.getText() + investmentBalanceInput;
					investmentBalanceTextArea.setText(output);

					// get and set account info text
					investmentInfoTextArea.setText("First Name: " + nameTextField.getText() + "\n" + "Last Name: " + lastTextField.getText() + 
							"\n" + "Account Number: " + accountNumberTextArea.getText() + "\n" + "Address: " + addTextField.getText() + 
							"\n" + "Phone Number: " + phoneTextField.getText());
				}

			}
		});

		// investment account deposit
		btnInvestmentDeposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				withdrawError.setText("");
				investmentWithdrawError.setText("");

				// initlize new balance
				double newBalance;

				// create new chequingAccount object
				investment = new InvestmentAccount();

				// get investment balance input
				investmentBalanceInput = Double.parseDouble(investmentBalanceTextArea.getText());

				// prompt user for amount to deposit
				double deposit = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter amount to deposit"));

				// set fee 
				double fee = deposit * 0.00035;

				// if user does not input a deposit over 2500
				if (deposit < 2500) {
					investmentWithdrawError.setText("Error, please input an amount greater than $2500");
				}
				else {
					// call chequingAccount and deposit amount
					newBalance = investment.deposit(investmentBalanceInput, deposit);

					// display
					investmentBalanceTextArea.setText(twoDigit.format(newBalance));

					// show last transaction
					investmentTransactionTextArea.setText("Transaction" + "\n" + "==========" + "\n" + "Balance: " + "$" + investmentBalanceInput +  "\n" + "Deposit: " + "$" + deposit 
							+ "\n" + "Service fee: " + "$" + twoDigit.format(fee) + "\n" + "==========" + "\n" + "New balance: " + "$" + twoDigit.format(newBalance));
				}
			}
		});

		// investment account withdraw
		btnInvestmentWithdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				investmentWithdrawError.setText("");

				// set var for new balance
				double newBalance;

				// create new chequingAccount object
				investment = new InvestmentAccount();

				// get input amount from investment balance input
				investmentBalanceInput = Double.parseDouble(investmentBalanceTextArea.getText());

				// prompt user with withdraw amount
				double withdraw = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter amount to withdraw"));

				if (investmentBalanceInput >= withdraw) {
					// call chequingAccount and withdraw amount
					newBalance = investment.withdraw(investmentBalanceInput, withdraw);

					// display
					investmentBalanceTextArea.setText(twoDigit.format(newBalance));

					// show last transaction
					investmentTransactionTextArea.setText("Transaction" + "\n" + "==========" + "\n" + "Balance: " + "$" + investmentBalanceInput +  "\n" + "Withdraw: " + "$" + withdraw 
							+ "\n" + "==========" + "\n" + "New balance: " + "$" + twoDigit.format(newBalance));

				}
				// if not enough funds to withdraw, display error
				else {
					investmentWithdrawError.setText("Error, insufficient funds to complete the transaction");
				}
			}
		});

		// investment account save
		btnInvestmentSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// display file save message
				JOptionPane.showMessageDialog(null, "Customer File Saved");

				// use substring to get first 3 numbers of String
				String accountFileName = accountNumberTextArea.getText();
				String newAccountNumber = accountFileName.substring(0, 3);

				// create file based on last name, first name, and first 3 digits of account number
				try {
					FileWriter fileW = new FileWriter(lastTextField.getText() + "-" + nameTextField.getText() + "-" + newAccountNumber);
					PrintWriter output = new PrintWriter(fileW);
					output.print("=================================" + "\n" + "First Name: " + nameTextField.getText() + "\n" + "Last Name: " + lastTextField.getText() + 
							"\n" + "Account Number: " + accountNumberTextArea.getText() + "\n" + "Address: " + addTextField.getText() + 
							"\n" + "Phone Number: " + phoneTextField.getText() + "\n" + "=================================" + "\n"
							+ "Investment Account Balance: " + "$" + investmentBalanceTextArea.getText());
					fileW.close();
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "File Save Unsuccessful");
				}
			}
		});

		// investment account back
		btnInvestmentBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// go back to accountInfo screen
				noBalanceError.setText("");

				// set account info panel true
				accountInfoPanel.setVisible(true);
				loginPanel.setVisible(false);
				createAccountPanel.setVisible(false);
				savingsAccountPanel.setVisible(false);
				chequingAccountPanel.setVisible(false);
				investmentAccountPanel.setVisible(false);
				EmployeePanel.setVisible(false);
				createEmployeeAccountPanel.setVisible(false);

				// update balances on account info
				chequingTextField.setText(chequingBalanceTextArea.getText());
				savingsTextField.setText(savingsBalanceTextArea.getText());
				investmentTextField.setText(investmentBalanceTextArea.getText());

				investmentBalanceTextArea.setText("");

			}
		});

		// <<<<<<<<<<information for employee login components>>>>>>>>>>

		// if employee login pressed
		btnEmployeeLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// set create panel true
				accountInfoPanel.setVisible(false);
				loginPanel.setVisible(false);
				createAccountPanel.setVisible(false);
				savingsAccountPanel.setVisible(false);
				chequingAccountPanel.setVisible(false);
				investmentAccountPanel.setVisible(false);
				EmployeePanel.setVisible(false);
				createEmployeeAccountPanel.setVisible(true);
			}
		});

		btnLoginEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// get username and password from textField
				String username = employeeUsernameTextField.getText();
				String password = employeePasswordTextField.getText();

				// if the set password is incorrect
				if (employeePasswordTextField.getText().equals("bank123") != true) {
					lblEmployeeAccountError.setText("Error, password is incorrect");
				}

				// display
				else {
					accountInfoPanel.setVisible(false);
					loginPanel.setVisible(false);
					createAccountPanel.setVisible(false);
					savingsAccountPanel.setVisible(false);
					chequingAccountPanel.setVisible(false);
					investmentAccountPanel.setVisible(false);
					createEmployeeAccountPanel.setVisible(false);
					EmployeePanel.setVisible(true);

					// give user info
					infoTextArea.setText("-----Information-----" + "\n" + "Add: inserts a new customer file" + "\n" + "Delete: deletes a specified file from the list"
							+ "\n" + "Find: displays the specified customer to be found" + "\n" + "Save: saves all customer files into a text file" + "\n" + "Exit: logs out employee to the main menu");
				}
			}
		});

		// back button
		btnEmployeeBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// display login panel
				accountInfoPanel.setVisible(false);
				loginPanel.setVisible(true);
				createAccountPanel.setVisible(false);
				savingsAccountPanel.setVisible(false);
				chequingAccountPanel.setVisible(false);
				investmentAccountPanel.setVisible(false);
				createEmployeeAccountPanel.setVisible(false);
				EmployeePanel.setVisible(false);
			}
		});

		// add button
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// create new CustomerRecord object
				list = new CustomerRecord();

				// prompt user to enter info
				String record = JOptionPane.showInputDialog(null, "Enter <firstname, lastname, address, phone number, account number, account type>",
						"Harshul, Kashyap, Brampton Canada , 4372341173 , 123456789012, c");

				// proccess the record
				list.processRecord(record);

				// display to textArea
				accountListTextArea.append(record + "\n");

			}
		});

		// delete button
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				list = new CustomerRecord();
				info = new CustomerList();

				String record = JOptionPane.showInputDialog(null, "Enter <firstname, lastname, address, phone number, account number, account type>",
						"Harshul, Kashyap, Brampton Canada , 4372341173 , 123456789012, c");

				list.processRecord(record);
				info.delete(list);

				// get last line and delete
				int end = 0;
				try {
					end = accountListTextArea.getLineEndOffset(0);
				} catch (BadLocationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				// replace given range
				accountListTextArea.replaceRange("", 0, end);

			}
		});

		// find button
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				list = new CustomerRecord();
				info = new CustomerList();

				String record = JOptionPane.showInputDialog(null, "Enter <firstname, lastname, address, phone number, account number, account type>",
						"Harshul, Kashyap, Brampton Canada , 4372341173 , 123456789012, c");

				// get the current list
				String getList = accountListTextArea.getText();

				// set a start location
				int start = accountListTextArea.getText().indexOf(getList);
				if (start >= 0 && getList.length() > 0) {
					// replace current range
					accountListTextArea.replaceRange(record, start, start
							+ getList.length());
					// set new line
					accountListTextArea.append("\n");
				}
			}
		});

		// save to text file
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// display file save message
				JOptionPane.showMessageDialog(null, "Customer information Saved");

				// create file based on last name and first 3 digits of account number
				try {
					FileWriter fileW = new FileWriter("Employee" + "-" + employeeUsernameTextField.getText());
					PrintWriter output = new PrintWriter(fileW);
					output.print(accountListTextArea.getText());
					fileW.close();
					// catch errors
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "File Save Unsuccessful");
				}
			}
		});

		// exit button
		btnEmployeeExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginErrorMessage.setText("");
				
				// take user back to login panel
				accountInfoPanel.setVisible(false);
				loginPanel.setVisible(true);
				createAccountPanel.setVisible(false);
				savingsAccountPanel.setVisible(false);
				chequingAccountPanel.setVisible(false);
				investmentAccountPanel.setVisible(false);
				createEmployeeAccountPanel.setVisible(false);
				EmployeePanel.setVisible(false);
			}
		});
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// run app
					UserInterface window = new UserInterface();
					window.frmBankSystem.setVisible(true);
					// error catch
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
