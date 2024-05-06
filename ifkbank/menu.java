package ifkbank;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class menu {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menu window = new menu();
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
	public menu() {
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
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(101, 116, 220));
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("file");
		mnNewMenu.setForeground(new Color(64, 0, 64));
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("customer");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				customers cus=new customers();
				cus.setVisible(true);
				dispose();
				
			}

			private void dispose() {
				// TODO Auto-generated method stub
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Account");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				account ac=new account();
				ac.setVisible(true);
				dispose();
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_1 = new JMenu("Transaction");
		mnNewMenu_1.setBackground(new Color(128, 128, 128));
		mnNewMenu_1.setForeground(new Color(64, 0, 64));
		mnNewMenu_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Deposit");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deposit dp=new deposit();
				dp.setVisible(true);
				dispose();
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Withdraw");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				withdraw wt= new withdraw();
				wt.setVisible(true);
				dispose();
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_1_1 = new JMenu("Transfer");
		mnNewMenu_1_1.setBackground(new Color(240, 240, 240));
		mnNewMenu_1_1.setForeground(new Color(64, 0, 64));
		mnNewMenu_1_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(mnNewMenu_1_1);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Account to Account");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				transfer tf=new transfer();
				tf.setVisible(true);
				dispose();
			}
		});
		mnNewMenu_1_1.add(mntmNewMenuItem_4);
		
		JMenu mnNewMenu_1_2 = new JMenu("Report");
		mnNewMenu_1_2.setForeground(new Color(64, 0, 64));
		mnNewMenu_1_2.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(mnNewMenu_1_2);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Customer Report");
		mnNewMenu_1_2.add(mntmNewMenuItem_5);
		
		JMenu mnNewMenu_1_3 = new JMenu("Balance");
		mnNewMenu_1_3.setForeground(new Color(64, 0, 64));
		mnNewMenu_1_3.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(mnNewMenu_1_3);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Balance Check");
		mnNewMenu_1_3.add(mntmNewMenuItem_6);
		
		JMenu mnNewMenu_1_4 = new JMenu("Account");
		mnNewMenu_1_4.setForeground(new Color(64, 0, 64));
		mnNewMenu_1_4.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(mnNewMenu_1_4);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("User Account");
		mnNewMenu_1_4.add(mntmNewMenuItem_7);
		
		JButton btnNewButton = new JButton("Logout");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBackground(new Color(186, 224, 255));
		menuBar.add(btnNewButton);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(139, 167, 480, 414);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Hi\\Downloads\\BANK.jpg"));
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("WELCOME TO IFK BANK");
		lblNewLabel_1.setBounds(32, 80, 781, 100);
		lblNewLabel_1.setForeground(new Color(85, 100, 202));
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 62));
		frame.getContentPane().add(lblNewLabel_1);
		frame.setVisible(true);
	}

	protected void dispose() {
		// TODO Auto-generated method stub
		
	}

	public static void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
