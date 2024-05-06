package ifkbank;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JPasswordField;

public class login {

	JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
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
	public login() {
		initialize();
	}
	public boolean validateLogin() {
	    String username = textField.getText();
	    String password = textField_1.getText();

	    if (username.isEmpty()) {
	        JOptionPane.showMessageDialog(frame, "Please enter username");
	        return false;
	    }

	    if (password.isEmpty()) {
	        JOptionPane.showMessageDialog(frame, "Please enter password");
	        return false;
	    }

	    try {
	        Class.forName("oracle.jdbc.driver.OracleDriver");
	        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "msc", "msc");
	        String query = "SELECT * FROM signupp WHERE USERNAME = ? AND PASSWORD = ?";
	        PreparedStatement pstmt = con.prepareStatement(query);
	        pstmt.setString(1, username);
	        pstmt.setString(2, password);
	        ResultSet rs = pstmt.executeQuery();

	        if (rs.next()) {
	            JOptionPane.showMessageDialog(frame, "Login Successful");
	            con.close();
	            return true;
	        } else {
	            JOptionPane.showMessageDialog(frame, "Invalid Username or Password");
	            con.close();
	            return false;
	        }
	    } catch (ClassNotFoundException ex) {
	        ex.printStackTrace();
	        // Handle ClassNotFoundException
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	        // Handle SQLException
	    }
	    
	    return false;
	}

	
	public boolean validateLogin1() {
        String username = textField.getText();
        String password = textField_1.getText();

        if (username.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Please enter username");
            return false;
        }

        if (password.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Please enter password");
            return false;
        }

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "msc", "msc");
         
            con.close();
            
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            // Handle ClassNotFoundException
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Handle SQLException
        }
        
        return true;
    }
	
	private void openMenuPage() {
		menu mn=new menu();
		mn.setVisible(true);
		dispose();
	}
	 
	
	private void dispose() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(180, 226, 254));
		frame.getContentPane().setForeground(Color.WHITE);
		frame.setBounds(100, 100, 800, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JLabel L1 = new JLabel("Username");
		L1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		L1.setBackground(Color.BLACK);
		L1.setForeground(Color.BLACK);
		L1.setBounds(492, 241, 89, 14);
		frame.getContentPane().add(L1);
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setBounds(492, 292, 89, 14);
		frame.getContentPane().add(lblNewLabel_1);
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				validateLogin();
				openMenuPage(); 
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(new Color(240, 248, 255));
		btnNewButton.setBounds(549, 386, 89, 23);
		frame.getContentPane().add(btnNewButton);
		textField = new JTextField();
		textField.setBackground(new Color(255, 255, 255));
		textField.setBounds(604, 241, 132, 23);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		JLabel lblNewLabel = new JLabel("Forgot Password?");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(658, 317, 118, 23);
		frame.getContentPane().add(lblNewLabel);
		JLabel lblNewLabel_2 = new JLabel("Not a member,Signup Now");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				signup sp=new signup();
				sp.setVisible(true);
				dispose();
			}

			private void dispose() {
				// TODO Auto-generated method stub
				
			}
		});
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setBounds(459, 419, 166, 14);
		frame.getContentPane().add(lblNewLabel_2);
		JLabel lblNewLabel_3 = new JLabel("WELCOME TO IFK BANK");
		lblNewLabel_3.setFont(new Font("Yu Gothic Medium", Font.BOLD, 18));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_3.setBackground(new Color(0, 0, 0));
		lblNewLabel_3.setBounds(492, 160, 241, 31);
		frame.getContentPane().add(lblNewLabel_3);
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBackground(new Color(176, 224, 230));
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\Hi\\Downloads\\BANK (1).jpg"));
		lblNewLabel_4.setBounds(-31, 95, 461, 338);
		frame.getContentPane().add(lblNewLabel_4);
		JLabel lblNewLabel_5 = new JLabel("Exit");
		lblNewLabel_5.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNewLabel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblNewLabel_5.setBounds(566, 541, 46, 68);
		frame.getContentPane().add(lblNewLabel_5);
		
		textField_1 = new JTextField();
		textField_1.setBounds(603, 288, 132, 23);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		frame.setVisible(true);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}