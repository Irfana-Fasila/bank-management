package ifkbank;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

public class account {

	private static final String USERNAME = null;
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JLabel lblCustomerNo;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					account window = new account();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void addAccount() {
	    String accountId = textField_6.getText();
	    String customerId = textField.getText();
	    String accountType = textField_3.getText();
	    String customerName = textField_1.getText();
	    double balance=0.0;

	    try {
	        balance = Double.parseDouble(textField_4.getText());
	    } catch (NumberFormatException e) {
	        // Handle the case where balance is not a valid double
	        JOptionPane.showMessageDialog(null, "Invalid balance format.", "Error", JOptionPane.ERROR_MESSAGE);
	        return;
	    }

	    try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "msc", "msc")) {
	        String sql = "INSERT INTO account (ACC_ID, CUST_ID, ACC_TYPE, BALANCE, CNAME) VALUES (?, ?, ?, ?, ?)";

	        try (PreparedStatement statement = connection.prepareStatement(sql)) {
	            statement.setString(1, accountId);
	            statement.setString(2, customerId);
	            statement.setString(3, accountType);
	            statement.setDouble(4, balance);
	            statement.setString(5, customerName);

	            int rowsInserted = statement.executeUpdate();
	            if (rowsInserted > 0) {
	                JOptionPane.showMessageDialog(null, "Account added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
	            } else {
	                JOptionPane.showMessageDialog(null, "Failed to add account.", "Error", JOptionPane.ERROR_MESSAGE);
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(null, "Failed to add account. SQLException occurred.", "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}
	
	
	public void updateAccount() {
		String accountId = textField_6.getText();
	    String customerId = textField.getText();
	    String accountType = textField_3.getText();
	    String customerName = textField_1.getText();
	    double balance=0.0;
	    try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "msc", "msc")) {
	        String sql = "UPDATE account SET CUST_ID = ?, ACC_TYPE = ?, BALANCE = ?, CNAME = ? WHERE ACC_ID = ?";

	        try (PreparedStatement statement = connection.prepareStatement(sql)) {
	            statement.setString(1, customerId);
	            statement.setString(2, accountType);
	            statement.setDouble(3, balance);
	            statement.setString(4, customerName);
	            statement.setString(5, accountId);

	            int rowsUpdated = statement.executeUpdate();
	            if (rowsUpdated > 0) {
	                JOptionPane.showMessageDialog(null, "Account updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
	            } else {
	                JOptionPane.showMessageDialog(null, "Failed to update account. Account ID not found.", "Error", JOptionPane.ERROR_MESSAGE);
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(null, "Failed to update account. SQLException occurred.", "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}

	
	


	/**
	 * Create the application.
	 */
	public account() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(186, 226, 254));
		frame.setBounds(100, 100, 800, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Account");
		lblNewLabel.setFont(new Font("SimSun", Font.BOLD, 26));
		lblNewLabel.setBounds(50, 37, 160, 35);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblFirstname = new JLabel("Customer ID");
		lblFirstname.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblFirstname.setBounds(72, 156, 108, 13);
		frame.getContentPane().add(lblFirstname);
		
		JLabel lblLastname = new JLabel("Cusomer Name");
		lblLastname.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblLastname.setBounds(72, 209, 127, 13);
		frame.getContentPane().add(lblLastname);
		
		JLabel lblCity = new JLabel("Account Type");
		lblCity.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblCity.setBounds(72, 266, 127, 21);
		frame.getContentPane().add(lblCity);
		
		JLabel lblBranch = new JLabel("Balance");
		lblBranch.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblBranch.setBounds(72, 330, 88, 13);
		frame.getContentPane().add(lblBranch);
		
		textField = new JTextField();
		textField.setBounds(240, 152, 178, 25);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(240, 205, 178, 25);
		frame.getContentPane().add(textField_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(240, 266, 178, 25);
		frame.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(240, 326, 178, 25);
		frame.getContentPane().add(textField_4);
		
		lblCustomerNo = new JLabel("Account No:");
		lblCustomerNo.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblCustomerNo.setBounds(72, 101, 108, 13);
		frame.getContentPane().add(lblCustomerNo);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(240, 97, 178, 25);
		frame.getContentPane().add(textField_6);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addAccount();
			}
		});
		btnNewButton.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		btnNewButton.setBounds(545, 171, 108, 60);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu mn=new menu();
				mn.setVisible(true);
				dispose();
			}

			private void dispose() {
				// TODO Auto-generated method stub
				
			}
			
		});
		btnCancel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		btnCancel.setBounds(545, 255, 108, 60);
		frame.getContentPane().add(btnCancel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Hi\\Downloads\\bank_13141169.png"));
		lblNewLabel_1.setBounds(131, 171, 553, 536);
		frame.getContentPane().add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(50, 75, 412, 338);
		frame.getContentPane().add(panel);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateAccount();
			}
		});
		btnEdit.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		btnEdit.setBounds(545, 88, 108, 48);
		frame.getContentPane().add(btnEdit);
		frame.setVisible(true);
		
		
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
