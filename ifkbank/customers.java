package ifkbank;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class customers {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					customers window = new customers();
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
	public customers() {
		initialize();
	}
	public void add() {
		String customerId = textField.getText(); // Assuming textField contains customer ID
	    String firstName = textField_1.getText(); // Assuming textField_1 contains first name
	    String lastName = textField_2.getText(); // Assuming textField_2 contains last name
	    String street = textField_3.getText(); // Assuming textField_3 contains street
	    String city = textField_4.getText(); // Assuming textField_4 contains city
	    String branch = textField_5.getText(); // Assuming textField_5 contains branch
	    String phone = textField_6.getText(); 
        try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","msc","msc")) {
            String sql = "INSERT INTO customer1 (CUST_ID, FIRSTNAME, LASTNAME, STREET, CITY, BRANCH, PHONE) " +
                         "VALUES (?, ?, ?, ?, ?, ?, ?)";

            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, customerId);
                statement.setString(2, firstName);
                statement.setString(3, lastName);
                statement.setString(4, street);
                statement.setString(5, city);
                statement.setString(6, branch);
                statement.setString(7, phone);

                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    JOptionPane.showMessageDialog(null, "Customer added successfully.");
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to add customer.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage());
        }
    }

	public void update(String customerId, String firstName, String lastName, String street, String city, String branch, String phone) {
	    try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","msc","msc")) {
	        String sql = "UPDATE customer1 SET FIRSTNAME = ?, LASTNAME = ?, STREET = ?, CITY = ?, BRANCH = ?, PHONE = ? WHERE CUST_ID = ?";
	        
	        try (PreparedStatement statement = connection.prepareStatement(sql)) {
	            statement.setString(1, firstName);
	            statement.setString(2, lastName);
	            statement.setString(3, street);
	            statement.setString(4, city);
	            statement.setString(5, branch);
	            statement.setString(6, phone);
	            statement.setString(7, customerId);

	            int rowsUpdated = statement.executeUpdate();
	            if (rowsUpdated > 0) {
	                JOptionPane.showMessageDialog(null, "Customer updated successfully.");
	            } else {
	                JOptionPane.showMessageDialog(null, "Failed to update customer. Customer ID not found.");
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage());
	    }
	}


	
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(SystemColor.activeCaption);
		frame.setBounds(100, 100, 800, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(186, 226, 254));
		panel.setBounds(0, -10, 1058, 761);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(65, 90, 584, 554);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblFirstname = new JLabel("FirstName");
		lblFirstname.setBounds(86, 150, 80, 22);
		lblFirstname.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		panel_1.add(lblFirstname);
		
		JLabel lblCustomerNo = new JLabel("Customer No:");
		lblCustomerNo.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblCustomerNo.setBounds(86, 105, 108, 13);
		panel_1.add(lblCustomerNo);
		
		JLabel lblLastname = new JLabel("LastName");
		lblLastname.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblLastname.setBounds(90, 208, 88, 13);
		panel_1.add(lblLastname);
		
		JLabel lblStreet = new JLabel("Street");
		lblStreet.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblStreet.setBounds(90, 252, 88, 13);
		panel_1.add(lblStreet);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblCity.setBounds(90, 282, 88, 22);
		panel_1.add(lblCity);
		
		JLabel lblBranch = new JLabel("Branch");
		lblBranch.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblBranch.setBounds(90, 327, 88, 13);
		panel_1.add(lblBranch);
		
		JLabel lblPhone = new JLabel("phone");
		lblPhone.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblPhone.setBounds(86, 365, 88, 22);
		panel_1.add(lblPhone);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(204, 101, 178, 25);
		panel_1.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(204, 151, 178, 25);
		panel_1.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(204, 196, 178, 25);
		panel_1.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(204, 240, 178, 25);
		panel_1.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(204, 283, 178, 25);
		panel_1.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(204, 323, 178, 25);
		panel_1.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(204, 366, 178, 25);
		panel_1.add(textField_6);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(52, 188, 488, 366);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Hi\\Downloads\\bank_13141169.png"));
		
		JLabel lblNewLabel = new JLabel("Customer");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(65, 44, 241, 58);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(659, 167, 108, 39);
		panel.add(btnNewButton);
		
		JButton btnCancel = new JButton("EDIT");
		btnCancel.setBounds(659, 294, 108, 39);
		panel.add(btnCancel);
		
		JButton btnCancel_1 = new JButton("CANCEL");
		btnCancel_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu mn=new menu();
				mn.setVisible(true);
				dispose();
			}
		});
		btnCancel_1.setBounds(659, 234, 108, 39);
		panel.add(btnCancel_1);
		
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String customerId = textField.getText();
	            String firstName = textField_1.getText();
	            String lastName = textField_2.getText();
	            String street = textField_3.getText();
	            String city = textField_4.getText();
	            String branch = textField_5.getText();
	            String phone = textField_6.getText();

	            // Call the update method with the obtained values
	            update(customerId, firstName, lastName, street, city, branch, phone);
	        
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				add();
			}
		});
		frame.setVisible(true);
	}

	protected void dispose() {
		// TODO Auto-generated method stub
		
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
