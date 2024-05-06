package ifkbank;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class transfer {

	private JFrame frame;
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
					transfer window = new transfer();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public transfer() {
		initialize();
	}

	
	Connection con;
	
	 	
	
	private void connectToDatabase() {
        try {
            // Database connection parameters
            String url = "jdbc:oracle:thin:@localhost:1521:orcl"; // Change accordingly
            String username = "msc"; // Change accordingly
            String password = "msc"; // Change accordingly

            // Establish the connection
            con = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle any SQL exceptions
        }
    }

    // Your other methods

    // Method to fetch account details from the database
	private void findAccountDetails() {
	    String accountNumber = textField_6.getText();
	    try {
	        // Check if connection is null
	        if (con == null) {
	            connectToDatabase(); // Initialize the connection if null
	        }

	        // Proceed with preparing statement and executing query
	        String query = "SELECT BALANCE FROM account WHERE ACC_ID = ?";
	        try (PreparedStatement pstmt = con.prepareStatement(query)) {
	            pstmt.setString(1, accountNumber);
	            try (ResultSet rs = pstmt.executeQuery()) {
	                if (rs.next()) {
	                    // Assuming textField_6 is meant for displaying ACC_ID, update it accordingly
	                    textField_6.setText(accountNumber);
	                    textField_1.setText(rs.getString("BALANCE"));
	                } else {
	                    JOptionPane.showMessageDialog(frame, "Account not found");
	                }
	            }
	        }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	        JOptionPane.showMessageDialog(frame, "Error retrieving account details: " + ex.getMessage());
	    }
	}

	// Method to transfer amount from one account to another
	private void transferAmount() {
	    String fromAccount = textField_6.getText(); // Get the sender's account number
	    String toAccount = textField_3.getText(); // Get the receiver's account number
	    double amount = Double.parseDouble(textField_4.getText()); // Get the transfer amount

	    try {
	        // Check if connection is null
	        if (con == null) {
	            connectToDatabase(); // Initialize the connection if null
	        }

	        // Check if sender's account has sufficient balance
	        String queryCheckBalance = "SELECT BALANCE FROM account WHERE ACC_ID = ?";
	        try (PreparedStatement pstmt = con.prepareStatement(queryCheckBalance)) {
	            pstmt.setString(1, fromAccount);
	            try (ResultSet rs = pstmt.executeQuery()) {
	                if (rs.next()) {
	                    double balance = rs.getDouble("BALANCE");
	                    if (balance < amount) {
	                        JOptionPane.showMessageDialog(frame, "Insufficient balance");
	                        return;
	                    }
	                } else {
	                    JOptionPane.showMessageDialog(frame, "Sender's account not found");
	                    return;
	                }
	            }
	        }

	        // Deduct amount from sender's account
	        String queryDeductAmount = "UPDATE account SET BALANCE = BALANCE - ? WHERE ACC_ID = ?";
	        try (PreparedStatement pstmt = con.prepareStatement(queryDeductAmount)) {
	            pstmt.setDouble(1, amount);
	            pstmt.setString(2, fromAccount);
	            int rowsAffected = pstmt.executeUpdate();
	            if (rowsAffected == 0) {
	                JOptionPane.showMessageDialog(frame, "Failed to deduct amount from sender's account");
	                return;
	            }
	        }

	        // Add amount to receiver's account
	        String queryAddAmount = "UPDATE account SET BALANCE = BALANCE + ? WHERE ACC_ID = ?";
	        try (PreparedStatement pstmt = con.prepareStatement(queryAddAmount)) {
	            pstmt.setDouble(1, amount);
	            pstmt.setString(2, toAccount);
	            int rowsAffected = pstmt.executeUpdate();
	            if (rowsAffected == 0) {
	                JOptionPane.showMessageDialog(frame, "Failed to add amount to receiver's account");
	                // Rollback the deduction from sender's account
	                String rollbackQuery = "UPDATE account SET BALANCE = BALANCE + ? WHERE ACC_ID = ?";
	                try (PreparedStatement rollbackPstmt = con.prepareStatement(rollbackQuery)) {
	                    rollbackPstmt.setDouble(1, amount);
	                    rollbackPstmt.setString(2, fromAccount);
	                    rollbackPstmt.executeUpdate();
	                }
	                return;
	            }
	        }

	        JOptionPane.showMessageDialog(frame, "Transfer successful");
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	        JOptionPane.showMessageDialog(frame, "Error transferring amount: " + ex.getMessage());
	    }
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
		lblNewLabel.setBounds(50, 46, 160, 35);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblLastname = new JLabel("Balance");
		lblLastname.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblLastname.setBounds(72, 209, 127, 13);
		frame.getContentPane().add(lblLastname);
		
		JLabel lblCity = new JLabel("ToAccount");
		lblCity.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblCity.setBounds(72, 266, 127, 21);
		frame.getContentPane().add(lblCity);
		
		JLabel lblBranch = new JLabel("Amount");
		lblBranch.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblBranch.setBounds(72, 330, 88, 13);
		frame.getContentPane().add(lblBranch);
		
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
		
		lblCustomerNo = new JLabel("FromAccount");
		lblCustomerNo.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblCustomerNo.setBounds(72, 101, 108, 13);
		frame.getContentPane().add(lblCustomerNo);
		
		JButton btnNewButton = new JButton("TRANSFER");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				transferAmount();
			}
		});
		btnNewButton.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		btnNewButton.setBounds(568, 209, 142, 60);
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
		btnCancel.setBounds(568, 289, 131, 60);
		frame.getContentPane().add(btnCancel);
		
		JPanel panel = new JPanel();
		panel.setBounds(42, 84, 516, 455);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		textField_6 = new JTextField();
		textField_6.setBounds(188, 20, 196, 25);
		panel.add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnFind = new JButton("Find");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				findAccountDetails();
			}
		});
		btnFind.setBounds(282, 64, 84, 35);
		panel.add(btnFind);
		
		
		btnFind.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Hi\\Downloads\\bank_13141169.png"));
		lblNewLabel_1.setBounds(10, 30, 481, 394);
		panel.add(lblNewLabel_1);
		frame.setVisible(true);
	}
	

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
