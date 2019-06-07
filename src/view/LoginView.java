package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class LoginView extends JFrame {
	
	private Container window = new Container();
	
	private JLabel 		 	loginHeading, jLUsername, jLPassword, displayLoginMsg;
	private JTextField 	 	username;
	private JPasswordField 	password;
	
	private JButton loginBtn = new JButton();					// loginPage
	private JPanel loginPage = new JPanel(null); 					// loginPage
	
	
	public LoginView() {
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
		this.setTitle("University Human Resource System - Admin");		//set's title of the system
		this.setSize(1200, 800);   //set's size of the system
		this.setResizable(false);	// cannot minimize or maximize the window
		this.setLocationRelativeTo(null);	//centers the window on the screen
		
		window = getContentPane();	//get the content's of Container window
		
		loginPagePanel();	
		loginPagePanelLink();
	}
	
	public void loginPagePanel() {
		
//		menuBar.setVisible(false);
		username = new JTextField();
		password = new JPasswordField();
		
		
		// panel for login page	
		loginPage.setBackground(Color.decode("#415299"));
		
		// heading for login page
		loginHeading = new JLabel("University Human Resource System");
		loginHeading.setForeground(Color.WHITE);
		loginHeading.setBounds(220, 150, 800, 80);
		loginHeading.setFont(new Font("Serif", Font.BOLD, 50));
		
		// entering username for login page
		jLUsername = new JLabel("Username");
		jLUsername.setBounds(380, 320, 300, 35);
		jLUsername.setForeground(Color.WHITE);
		jLUsername.setFont(new Font("Serif", Font.BOLD, 20));
		username.setBorder(new LineBorder(Color.decode("#415299"), Color.OPAQUE));		
		username.setBounds(550, 320, 300, 35);
		
		// entering password for login page
		jLPassword = new JLabel("Password");
		jLPassword.setBounds(380, 380, 300, 35);
		jLPassword.setForeground(Color.WHITE);
		jLPassword.setFont(new Font("Serif", Font.BOLD, 20));
		password.setBounds(550, 380, 300, 35);
		password.setBorder(new LineBorder(Color.decode("#415299"), Color.OPAQUE));		
		password.setEchoChar('*');
		
		// login button
		loginBtn = new JButton("LOG IN");
		loginBtn.setBounds(550, 450, 300, 35);
		loginBtn.setFont(new Font("Serif", Font.BOLD, 20));
		
		// displaying message if any condition occurs
		displayLoginMsg = new JLabel();
		displayLoginMsg.setBounds(320, 550, 600, 35);
		displayLoginMsg.setFont(new Font("Serif", Font.BOLD, 28));
		displayLoginMsg.setForeground(Color.RED);
		
		// adding component to JPanel 'loginPage'
		loginPage.add(loginHeading);
		loginPage.add(jLUsername);
		loginPage.add(username);
		loginPage.add(jLPassword);
		loginPage.add(password);
		loginPage.add(loginBtn);
		loginPage.add(displayLoginMsg);
		// adding 'loginPage' JPanel to 'window' Container
		window.add(loginPage);
	}
	public String getUsername() {     
		return username.getText();  
	} 
	public char[] getPassword() {     
		return password.getPassword();  
	} 
	public void displayMessage(String loginMsg) {   
		displayLoginMsg.setText(loginMsg);  
	} 
	public void addLoginButtonListener(ActionListener listenForLoginButton) {   
		loginBtn.addActionListener(listenForLoginButton);  
	}
	public void loginPagePanelLink() {
		
		username.setText("");
		password.setText("");
		loginPage.setVisible(true);
	}
	

}
