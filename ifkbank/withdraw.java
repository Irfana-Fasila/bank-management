package ifkbank;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JDesktopPane;

public class withdraw {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					withdraw window = new withdraw();
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
	public withdraw() {
		initialize();
		establishConnection();
	}

	Connection con;
	
	private void establishConnection() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "msc", "msc");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
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
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(106, 49, 1, 1);
		frame.getContentPane().add(desktopPane);
		
		JPanel panel = new JPanel();
		panel.setToolTipText("");
		panel.setBounds(38, 118, 326, 147);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter the Account No:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 27, 168, 13);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(10, 70, 289, 35);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnFind = new JButton("Find");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				findAccountDetails();
			}
		});
		btnFind.setBounds(240, 110, 59, 27);
		panel.add(btnFind);
		
		JLabel lblNewLabel_1 = new JLabel("Customer No");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(80, 373, 104, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Firstname");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(80, 413, 104, 13);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Lastname");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(80, 451, 104, 13);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_4 = new JLabel("Account No");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_4.setBounds(41, 102, 104, 13);
		frame.getContentPane().add(lblNewLabel_1_4);
		
		textField_1 = new JTextField();
		textField_1.setBounds(194, 372, 96, 19);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(194, 412, 96, 19);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(194, 450, 96, 19);
		frame.getContentPane().add(textField_3);
		
		JLabel lblNewLabel_2 = new JLabel("Balance");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(580, 94, 69, 26);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_5.setBounds(536, 145, 161, 39);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Withdraw");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_1.setBounds(580, 283, 96, 26);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_6.setBackground(new Color(101, 116, 220));
		textField_6.setForeground(new Color(255, 255, 255));
		textField_6.setColumns(10);
		textField_6.setBounds(516, 347, 192, 39);
		frame.getContentPane().add(textField_6);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 withdrawFunds();
			}
		});
		btnNewButton.setBounds(536, 420, 69, 31);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnCancel = new JButton("Cancel");
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
		btnCancel.setBounds(628, 420, 80, 31);
		frame.getContentPane().add(btnCancel);
		frame.setVisible(true);
		
	}
		private void findAccountDetails() {
		    String accountNumber = textField.getText();
		    try {
		        String query = "SELECT c.CUST_ID, c.FIRSTNAME, c.LASTNAME, a.BALANCE " +
		                       "FROM customer1 c JOIN account a ON c.CUST_ID = a.CUST_ID " +
		                       "WHERE a.ACC_ID = ?";
		        PreparedStatement pstmt = con.prepareStatement(query);
		        pstmt.setString(1, accountNumber);
		        ResultSet rs = pstmt.executeQuery();

		        if (rs.next()) {
		            textField_1.setText(rs.getString("CUST_ID"));
		            textField_2.setText(rs.getString("FIRSTNAME"));
		            textField_3.setText(rs.getString("LASTNAME"));
		            textField_5.setText(rs.getString("BALANCE"));
		        } else {
		            JOptionPane.showMessageDialog(frame, "Account not found");
		        }
		    } catch (SQLException ex) {
		        ex.printStackTrace();
		    }
		
		
	}
		private void withdrawFunds() {
		    String accountNumber = textField.getText();
		    double withdrawAmount = Double.parseDouble(textField_6.getText());
		    try {
		        String updateQuery = "UPDATE account SET BALANCE = BALANCE - ? WHERE ACC_ID = ?";
		        PreparedStatement pstmt = con.prepareStatement(updateQuery);
		        pstmt.setDouble(1, withdrawAmount);
		        pstmt.setString(2, accountNumber);
		        int rowsAffected = pstmt.executeUpdate();

		        if (rowsAffected > 0) {
		            JOptionPane.showMessageDialog(frame, "Withdrawal successful");
		            // Refresh the displayed balance
		            findAccountDetails();
		        } else {
		            JOptionPane.showMessageDialog(frame, "Failed to withdraw funds");
		        }
		    } catch (SQLException ex) {
		        ex.printStackTrace();
		    }
		}


	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
