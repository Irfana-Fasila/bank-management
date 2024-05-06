package ifkbank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class signup {

    private JFrame frame;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;

   
    

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                signup window = new signup();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * @wbp.parser.entryPoint
     */
    public signup() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(180, 226, 254));
        frame.setBounds(100, 100, 800, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JButton btnNewButton = new JButton("SIGNUP");
        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String fullname = textField_4.getText();
                String address = textField_3.getText();
                String email = textField.getText();
                String phone = textField_2.getText();
                String username = textField_1.getText();
                String password = textField_5.getText();

                try {
                    // Load the Oracle JDBC driver
                    Class.forName("oracle.jdbc.OracleDriver");
                    
                    // Connect to the database
                    try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/ORCL", "msc", "msc")) {
                        String sql = "INSERT INTO signupp (FULLNAME, ADDRESS, EMAIL, PHONE, USERNAME, PASSWORD) VALUES (?, ?, ?, ?, ?, ?)";
                        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                            pstmt.setString(1, fullname);
                            pstmt.setString(2, address);
                            pstmt.setString(3, email);
                            pstmt.setString(4, phone);
                            pstmt.setString(5, username);
                            pstmt.setString(6, password);
                            pstmt.executeUpdate();
                            JOptionPane.showMessageDialog(frame, "Signup Successful!");
                        }
                    }
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(frame, "Error: Oracle JDBC driver not found!");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(frame, "Error: Signup failed!");
                }
            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnNewButton.setForeground(Color.BLACK);
        btnNewButton.setBackground(new Color(255, 255, 255));
        btnNewButton.setBounds(522, 441, 89, 35);
        frame.getContentPane().add(btnNewButton);

        
 

		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setBounds(522, 441, 89, 35);
		frame.getContentPane().add(btnNewButton);
		textField = new JTextField();
		textField.setBackground(new Color(255, 255, 255));
		textField.setBounds(577, 273, 117, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		textField_1 = new JTextField();
		textField_1.setBackground(new Color(255, 255, 255));
		textField_1.setColumns(10);
		textField_1.setBounds(577, 325, 117, 20);
		frame.getContentPane().add(textField_1);
		JLabel lblNewLabel_2 = new JLabel("Already a member,Login here");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				login lo=new login();
				lo.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setBounds(458, 486, 178, 14);
		frame.getContentPane().add(lblNewLabel_2);
		JLabel lblNewLabel_3 = new JLabel("WELCOME TO IFK BANK");
		lblNewLabel_3.setFont(new Font("Yu Gothic Medium", Font.BOLD, 16));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_3.setBackground(new Color(0, 0, 0));
		lblNewLabel_3.setBounds(382, 43, 260, 31);
		frame.getContentPane().add(lblNewLabel_3);
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBackground(new Color(176, 224, 230));
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\Hi\\Downloads\\BANK (1).jpg"));
		lblNewLabel_4.setBounds(-35, 106, 485, 370);
		frame.getContentPane().add(lblNewLabel_4);
		JLabel lblNewLabel_5 = new JLabel("Exit");
		lblNewLabel_5.setFont(new Font("Dialog", Font.BOLD, 15));
		
		lblNewLabel_5.setBounds(557, 527, 51, 23);
		
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBackground(new Color(255, 255, 255));
		textField_2.setBounds(577, 219, 117, 20);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBackground(new Color(255, 255, 255));
		textField_3.setBounds(577, 163, 117, 20);
		frame.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBackground(new Color(255, 255, 255));
		textField_4.setBounds(577, 106, 117, 20);
		frame.getContentPane().add(textField_4);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPhone.setForeground(Color.BLACK);
		lblPhone.setBackground(Color.BLACK);
		lblPhone.setBounds(461, 220, 61, 14);
		frame.getContentPane().add(lblPhone);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAddress.setForeground(Color.BLACK);
		lblAddress.setBackground(Color.BLACK);
		lblAddress.setBounds(461, 164, 61, 14);
		frame.getContentPane().add(lblAddress);
		
		JLabel lblFullname = new JLabel("FullName");
		lblFullname.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFullname.setForeground(Color.BLACK);
		lblFullname.setBackground(Color.BLACK);
		lblFullname.setBounds(461, 108, 61, 14);
		frame.getContentPane().add(lblFullname);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBackground(new Color(255, 255, 255));
		textField_5.setBounds(577, 378, 117, 20);
		frame.getContentPane().add(textField_5);
		
		JLabel lblEmail = new JLabel("email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEmail.setForeground(Color.BLACK);
		lblEmail.setBackground(Color.BLACK);
		lblEmail.setBounds(461, 274, 51, 14);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(Color.BLACK);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUsername.setBackground(Color.BLACK);
		lblUsername.setBounds(461, 328, 72, 14);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPassword.setBackground(Color.BLACK);
		lblPassword.setBounds(461, 381, 72, 14);
		frame.getContentPane().add(lblPassword);
		frame.setVisible(true);
		
	}

	protected void dispose() {
		// TODO Auto-generated method stub
		
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}