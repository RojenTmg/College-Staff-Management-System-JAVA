package view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class SecretaryView extends JFrame {
	
	private Container window = new Container();
	private JPanel container = new JPanel();
	private JPanel aside = new JPanel(null);
	private JPanel main = new JPanel(new CardLayout());							// homePage	
	private JPanel homeSection = new JPanel(null);					// homeSection

	private JButton homeBtn = new JButton("    Home");
	private JButton allLBtn = new JButton("    All Lecturer");
	private JButton fullTimeLBtn = new JButton("    Full-Time Lecturer");
	private JButton partTimeLBtn = new JButton("    Part-Time Lecturer");
	private JButton contractLBtn = new JButton("    Contract Lecturer");
	private JButton logoutBtn = new JButton("LOG OUT");
	
	
	
	
	

	public SecretaryView() {
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
		this.setTitle("University Human Resource System - Secretary");		//set's title of the system
		this.setSize(1200, 800);   //set's size of the system
		this.setResizable(false);	// cannot minimize or maximize the window
		this.setLocationRelativeTo(null);	//centers the window on the screen
		
		window = getContentPane();	//get the content's of Container window
		
		homeSectionPanel();
		allLecturerPanel();
		fullTimeLecturerPanel();
		partTimeLecturerPanel();
		contractTimeLecturerPanel();
		homePagePanel();
	}
	
	
	
	public void homePagePanel() {
		
		// panel for home page	
		container = new JPanel();
		container.setLayout(null);
		container.setBackground(Color.decode("#f7f7f7"));
		
		aside.setBounds(0, 0, 230, 800);
		aside.setBackground(Color.decode("#252525"));
		
		main.setBounds(250, 20, 915, 700);	
		
		menuBar();
		
		homeBtn.setBounds(20, 40, 190, 30);
//		homeBtn.setBorder(new LineBorder(black1, Color.OPAQUE));		
		homeBtn.setHorizontalAlignment(SwingConstants.LEFT);
		homeBtn.setBackground(Color.WHITE);
		
		allLBtn.setBounds(20, 90, 190, 30);
		allLBtn.setHorizontalAlignment(SwingConstants.LEFT);
		allLBtn.setBackground(Color.WHITE);
		
		fullTimeLBtn.setBounds(20, 140, 190, 30);
		fullTimeLBtn.setHorizontalAlignment(SwingConstants.LEFT);
		fullTimeLBtn.setBackground(Color.WHITE);
		
		partTimeLBtn.setBounds(20, 190, 190, 30);
		partTimeLBtn.setHorizontalAlignment(SwingConstants.LEFT);
		partTimeLBtn.setBackground(Color.WHITE);
		
		contractLBtn.setBounds(20, 240, 190, 30);
		contractLBtn.setHorizontalAlignment(SwingConstants.LEFT);
		contractLBtn.setBackground(Color.WHITE);
		
		logoutBtn.setBounds(40, 680, 150, 30);
		logoutBtn.setBackground(Color.WHITE);
//		logoutBtn.setBorder(new RoundedBorder(10));
		
		aside.add(homeBtn);
		aside.add(allLBtn);
		aside.add(fullTimeLBtn);
		aside.add(partTimeLBtn);
		aside.add(contractLBtn);
		aside.add(logoutBtn);
		
		// adding component to JPanel 'homePage'
		container.add(aside);
		container.add(main);
		// adding 'homePage' JPanel to 'window' Container
		window.add(container);
	}
	public void addHomeButtonListener(ActionListener listenForHomeButton) {   
		homeBtn.addActionListener(listenForHomeButton);  
	}	
	public void addAllTimeLListener(ActionListener listenForAllTimeLButton) {   
		allLBtn.addActionListener(listenForAllTimeLButton);  
	}
	public void addFullTimeLListener(ActionListener listenForFullTimeLButton) {   
		fullTimeLBtn.addActionListener(listenForFullTimeLButton);  
	}
	public void addPartTimeLListener(ActionListener listenForPartTimeLButton) {   
		partTimeLBtn.addActionListener(listenForPartTimeLButton);  
	}	
	public void addContractLListener(ActionListener listenForContractLButton) {   
		contractLBtn.addActionListener(listenForContractLButton);  
	}
	public void addLogoutButtonListener(ActionListener listenForLogoutButton) {   
		logoutBtn.addActionListener(listenForLogoutButton);  
	}
	public void homePagePanelLink() {
//		loginPage.setVisible(false);
		menuBar.setVisible(true);
		container.setVisible(true);		
		aside.setVisible(true);
		main.setVisible(true);
		homeSection.setVisible(true);
		
		
//		adminSection.setVisible(false);
//		departmentSection.setVisible(false);
//		departmentContainer.setVisible(false);
//		viewDepartment.setVisible(false);
//		addDepartment.setVisible(false);
//		
//		lecturerSection.setVisible(false);
//		lecturerContainer.setVisible(false);
//		viewLecturer.setVisible(false);			
//		addLecturer.setVisible(false);
	}	

	private JLabel 		 	homeHeading, underline;				// homeSection
	private JButton allLBtnHS = new JButton("     All Lecturer");
	private JButton fullTimeLBtnHS = new JButton("     Full-Time Lecturer");
	private JButton partTimeLBtnHS = new JButton("     Part-Time Lecturer");
	private JButton contractLBtnHS = new JButton("     Contract Lecturer");
	public void homeSectionPanel() {

		// panel for home page	
		homeSection.setBackground(Color.decode("#f7f7f7"));
		
		// adding component to JPanel 'main'
		main.add(homeSection);
		
		homeHeading = new JLabel("Home");
		homeHeading.setBounds(5, 0, 300, 35);
		homeHeading.setFont(new Font("Serif", Font.BOLD, 30));
		
		underline = new JLabel(underline());
		underline.setBounds(5, 25, 950, 35);
		
		allLBtnHS.setBounds(10, 80, 900, 50);
		allLBtnHS.setBackground(Color.WHITE);
		allLBtnHS.setHorizontalAlignment(SwingConstants.LEFT);
		
		fullTimeLBtnHS.setBounds(10, 140, 900, 50);
		fullTimeLBtnHS.setBackground(Color.WHITE);
		fullTimeLBtnHS.setHorizontalAlignment(SwingConstants.LEFT);
		
		partTimeLBtnHS.setBounds(10, 200, 900, 50);
		partTimeLBtnHS.setBackground(Color.WHITE);
		partTimeLBtnHS.setHorizontalAlignment(SwingConstants.LEFT);
		
		contractLBtnHS.setBounds(10, 260, 900, 50);
		contractLBtnHS.setBackground(Color.WHITE);
		contractLBtnHS.setHorizontalAlignment(SwingConstants.LEFT);
		
		homeSection.add(homeHeading);
		homeSection.add(underline);
		homeSection.add(allLBtnHS);
		homeSection.add(fullTimeLBtnHS);
		homeSection.add(partTimeLBtnHS);
		homeSection.add(contractLBtnHS);
	}
	public void addAllTimeLListenerHS(ActionListener listenForAllTimeLButton) {   
		allLBtnHS.addActionListener(listenForAllTimeLButton);  
	}
	public void addFullTimeLListenerHS(ActionListener listenForFullTimeLButton) {   
		fullTimeLBtnHS.addActionListener(listenForFullTimeLButton);  
	}
	public void addPartTimeLListenerHS(ActionListener listenForPartTimeLButton) {   
		partTimeLBtnHS.addActionListener(listenForPartTimeLButton);  
	}	
	public void addContractLListenerHS(ActionListener listenForContractLButton) {   
		contractLBtnHS.addActionListener(listenForContractLButton);  
	}	
	public void homeSectionPanelLink() {

		container.setVisible(true);	
		menuBar.setVisible(true);
//		loginPage.setVisible(false);
		aside.setVisible(true);
		main.setVisible(true);
		homeSection.setVisible(true);
		allLSection.setVisible(false);
		fullLSection.setVisible(false);
		partLSection.setVisible(false);
		contractLSection.setVisible(false);
	}

	
	
	private JLabel 	allLHeading, viewAllLHeading;			// department
	private JPanel allLSection = new JPanel(null);			// department
	private JPanel allLContainer = new JPanel(null);			// department
	public void allLecturerPanel() {
		
		// panel for department page	
		allLSection.setBackground(Color.decode("#f7f7f7"));
		
		// adding component to JPanel 'main'
		main.add(allLSection);
		
		allLHeading = new JLabel("All - Time Lecturers");
		allLHeading.setBounds(5, 0, 300, 35);
		allLHeading.setFont(new Font("Serif", Font.BOLD, 30));
		
		underline = new JLabel(underline());
		underline.setBounds(5, 30, 950, 35);
//		underline.setBounds(5, 60, 950, 35);
		
		allLContainer.setBackground(Color.WHITE);
		allLContainer.setBounds(5, 70, 950, 640);
//		allLContainer.setBounds(5, 100, 950, 610);
		
		allLSection.add(allLHeading);
		allLSection.add(underline);
		allLSection.add(allLContainer);

		viewAllLHeading = new JLabel("All-Time Lecturer");
		viewAllLHeading.setBounds(8, 0, 300, 35);
		viewAllLHeading.setFont(new Font("Serif", Font.BOLD, 20));
		
		displayAllLTable();
		
		allLContainer.add(viewAllLHeading);
	}
	private JTable tableAllL= new JTable();
	private JScrollPane scrollPane = new JScrollPane();
	private DefaultTableModel defaultTableModel = new DefaultTableModel();
	public void displayAllLTable() {
		
		scrollPane.setBounds(10, 55, 890, 560);
		scrollPane.setViewportView(tableAllL);
		allLContainer.add(scrollPane);
		
		defaultTableModel.addColumn("Id No."); 
		defaultTableModel.addColumn("Name"); 
		defaultTableModel.addColumn("Address"); 
		defaultTableModel.addColumn("Phone No."); 
		defaultTableModel.addColumn("Email");
		defaultTableModel.addColumn("Date Started");
		defaultTableModel.addColumn("Salary");
		defaultTableModel.addColumn("Hourly Rate");
		defaultTableModel.addColumn("Contract Expiry");
		defaultTableModel.addColumn("Type");

		
		tableAllL.setModel(defaultTableModel);
		tableAllL.setRowHeight(20);
		
		JTableHeader tHeader = tableAllL.getTableHeader();
		tHeader.setBackground(Color.decode("#ececec"));
	}
	public void addRowJTableA(String[] lecData) {
		defaultTableModel.addRow(lecData);		
	}
	public void allTimeLPanelLink() {

		container.setVisible(true);	
		menuBar.setVisible(true);
//		loginPage.setVisible(false);
		aside.setVisible(true);
		main.setVisible(true);
		homeSection.setVisible(false);
		allLSection.setVisible(true);
		fullLSection.setVisible(false);
		partLSection.setVisible(false);
		contractLSection.setVisible(false);
	}

	
	
	private JLabel 	fullLHeading, viewFullLHeading;			// department
	private JPanel fullLSection = new JPanel(null);			// department
	private JPanel fullLContainer = new JPanel(null);			// department
	public void fullTimeLecturerPanel() {
		
		// panel for department page	
		fullLSection.setBackground(Color.decode("#f7f7f7"));
		
		// adding component to JPanel 'main'
		main.add(fullLSection);
		
		fullLHeading = new JLabel("Full - Time Lecturers");
		fullLHeading.setBounds(5, 0, 300, 35);
		fullLHeading.setFont(new Font("Serif", Font.BOLD, 30));
		
		underline = new JLabel(underline());
		underline.setBounds(5, 30, 950, 35);
//		underline.setBounds(5, 60, 950, 35);
		
		fullLContainer.setBackground(Color.WHITE);
		fullLContainer.setBounds(5, 70, 950, 640);
//		allLContainer.setBounds(5, 100, 950, 610);
		
		fullLSection.add(fullLHeading);
		fullLSection.add(underline);
		fullLSection.add(fullLContainer);

		viewFullLHeading = new JLabel("Full-Time Lecturer");
		viewFullLHeading.setBounds(8, 0, 300, 35);
		viewFullLHeading.setFont(new Font("Serif", Font.BOLD, 20));
		
		displayFullLTable();
		
		fullLContainer.add(viewFullLHeading);
	}
	private JTable tableFullL= new JTable();
	private JScrollPane scrollPaneF = new JScrollPane();
	private DefaultTableModel defaultTableModelF = new DefaultTableModel();
	public void displayFullLTable() {
		
		scrollPaneF.setBounds(10, 55, 890, 560);
		scrollPaneF.setViewportView(tableFullL);
		fullLContainer.add(scrollPaneF);
		
		defaultTableModelF.addColumn("Id No."); 
		defaultTableModelF.addColumn("Name"); 
		defaultTableModelF.addColumn("Address"); 
		defaultTableModelF.addColumn("Phone No."); 
		defaultTableModelF.addColumn("Email");
		defaultTableModelF.addColumn("Date Started");
		defaultTableModelF.addColumn("Salary");
		
		tableFullL.setModel(defaultTableModelF);
		tableFullL.setRowHeight(20);
		
		JTableHeader tHeader = tableFullL.getTableHeader();
		tHeader.setBackground(Color.decode("#ececec"));
	}
	public void addRowJTableF(String[] lecData) {
		defaultTableModelF.addRow(lecData);		
	}
	public void fullTimeLPanelLink() {

		container.setVisible(true);	
		menuBar.setVisible(true);
//		loginPage.setVisible(false);
		aside.setVisible(true);
		main.setVisible(true);
		homeSection.setVisible(false);
		allLSection.setVisible(false);
		fullLSection.setVisible(true);
		partLSection.setVisible(false);
		contractLSection.setVisible(false);
	}
	
	
	private JLabel 	partLHeading, viewPartLHeading;			// department
	private JPanel partLSection = new JPanel(null);			// department
	private JPanel partLContainer = new JPanel(null);			// department
	public void partTimeLecturerPanel() {
		
		// panel for department page	
		partLSection.setBackground(Color.decode("#f7f7f7"));
		
		// adding component to JPanel 'main'
		main.add(partLSection);
		
		partLHeading = new JLabel("Part - Time Lecturers");
		partLHeading.setBounds(5, 0, 300, 35);
		partLHeading.setFont(new Font("Serif", Font.BOLD, 30));
		
		underline = new JLabel(underline());
		underline.setBounds(5, 30, 950, 35);
//		underline.setBounds(5, 60, 950, 35);
		
		partLContainer.setBackground(Color.WHITE);
		partLContainer.setBounds(5, 70, 950, 640);
//		partLContainer.setBounds(5, 100, 950, 610);
		
		partLSection.add(partLHeading);
		partLSection.add(underline);
		partLSection.add(partLContainer);

		viewPartLHeading = new JLabel("Part-Time Lecturer");
		viewPartLHeading.setBounds(8, 0, 300, 35);
		viewPartLHeading.setFont(new Font("Serif", Font.BOLD, 20));
		
		displayPartLTable();
		
		partLContainer.add(viewPartLHeading);
	}
	private JTable tablePartL= new JTable();
	private JScrollPane scrollPaneP = new JScrollPane();
	private DefaultTableModel defaultTableModelP = new DefaultTableModel();
	public void displayPartLTable() {
		
		scrollPaneP.setBounds(10, 55, 890, 560);
		scrollPaneP.setViewportView(tablePartL);
		partLContainer.add(scrollPaneP);
		
		defaultTableModelP.addColumn("Id No."); 
		defaultTableModelP.addColumn("Name"); 
		defaultTableModelP.addColumn("Address"); 
		defaultTableModelP.addColumn("Phone No."); 
		defaultTableModelP.addColumn("Email");
		defaultTableModelP.addColumn("Date Started");
		defaultTableModelP.addColumn("Hourly Rate");
		
		tablePartL.setModel(defaultTableModelP);
		tablePartL.setRowHeight(20);
		
		JTableHeader tHeader = tablePartL.getTableHeader();
		tHeader.setBackground(Color.decode("#ececec"));
	}
	public void addRowJTableP(String[] lecData) {
		defaultTableModelP.addRow(lecData);		
	}
	public void partTimeLPanelLink() {

		container.setVisible(true);	
		menuBar.setVisible(true);
//		loginPage.setVisible(false);
		aside.setVisible(true);
		main.setVisible(true);
		homeSection.setVisible(false);
		allLSection.setVisible(false);
		fullLSection.setVisible(false);
		partLSection.setVisible(true);
		contractLSection.setVisible(false);
	}

	
	private JLabel 	contractLHeading, viewContractLHeading;			// department
	private JPanel contractLSection = new JPanel(null);			// department
	private JPanel contractLContainer = new JPanel(null);			// department
	public void contractTimeLecturerPanel() {
		
		// panel for department page	
		contractLSection.setBackground(Color.decode("#f7f7f7"));
		
		// adding component to JPanel 'main'
		main.add(contractLSection);
		
		contractLHeading = new JLabel("Contract Lecturers");
		contractLHeading.setBounds(5, 0, 300, 35);
		contractLHeading.setFont(new Font("Serif", Font.BOLD, 30));
		
		underline = new JLabel(underline());
		underline.setBounds(5, 30, 950, 35);
//		underline.setBounds(5, 60, 950, 35);
		
		contractLContainer.setBackground(Color.WHITE);
		contractLContainer.setBounds(5, 70, 950, 640);
//		partLContainer.setBounds(5, 100, 950, 610);
		
		contractLSection.add(contractLHeading);
		contractLSection.add(underline);
		contractLSection.add(contractLContainer);

		viewContractLHeading = new JLabel("Contract Lecturer");
		viewContractLHeading.setBounds(8, 0, 300, 35);
		viewContractLHeading.setFont(new Font("Serif", Font.BOLD, 20));
		
		displayContractLTable();
		
		contractLContainer.add(viewContractLHeading);
	}
	private JTable tableContractL= new JTable();
	private JScrollPane scrollPaneC = new JScrollPane();
	private DefaultTableModel defaultTableModelC = new DefaultTableModel();
	public void displayContractLTable() {
		
		scrollPaneC.setBounds(10, 55, 890, 560);
		scrollPaneC.setViewportView(tableContractL);
		contractLContainer.add(scrollPaneC);
		
		defaultTableModelC.addColumn("Id No."); 
		defaultTableModelC.addColumn("Name"); 
		defaultTableModelC.addColumn("Address"); 
		defaultTableModelC.addColumn("Phone No."); 
		defaultTableModelC.addColumn("Email");
		defaultTableModelC.addColumn("Date Started");
		defaultTableModelC.addColumn("Salary");
		defaultTableModelC.addColumn("Contract Expiry");
		
		tableContractL.setModel(defaultTableModelC);
		tableContractL.setRowHeight(20);
		
		JTableHeader tHeader = tableContractL.getTableHeader();
		tHeader.setBackground(Color.decode("#ececec"));
	}
	public void addRowJTableC(String[] lecData) {
		defaultTableModelC.addRow(lecData);		
	}
	public void contractLPanelLink() {

		container.setVisible(true);	
		menuBar.setVisible(true);
//		loginPage.setVisible(false);
		aside.setVisible(true);
		main.setVisible(true);
		homeSection.setVisible(false);
		allLSection.setVisible(false);
		fullLSection.setVisible(false);
		partLSection.setVisible(false);
		contractLSection.setVisible(true);
	}














































	public String underline() {
		
		String hyphen = "";
		for(int i = 0; i < 130; i++) {
			hyphen += "- ";
		}
		return hyphen;
	}

	private JMenuBar     	menuBar = new JMenuBar();						// homePage
	private JMenu 	     	menu1,menu2,menu3,menu4;		// homePage
			JMenuItem    	m1,m2,m3,m4,m5,m6,m7,m8,m9,m10,m11,m12,m13,m14;					// homePage
	public void menuBar() {
		
		//creating Menu Bars 
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		menu1 = new JMenu("Scenario");
		menuBar.add(menu1);
		menu2 = new JMenu("Edit");
		menuBar.add(menu2);		
		menu3 = new JMenu("Controls");
		menuBar.add(menu3);		
		menu4 = new JMenu("Help");
		menuBar.add(menu4);
		
		// menu items of 'Scenario'
		m1 = new JMenuItem("New");
		m2 = new JMenuItem("Open");
		m3 = new JMenuItem("Save");
		m4 = new JMenuItem("Quit");
		menu1.add(m1);
		menu1.add(m2);
		menu1.add(m3);
		menu1.add(m4);
		
		// menu items of 'Edit'
		m5 = new JMenuItem("Copy");
		m6 = new JMenuItem("Paste");
		m7 = new JMenuItem("Delete");
		menu2.add(m5);
		menu2.add(m6);
		menu2.add(m7);
		
		// menu items of 'Controls'
		m8 = new JMenuItem("Act");
		m9 = new JMenuItem("Run");
		m10 = new JMenuItem("Pause");
		m11 = new JMenuItem("Reset");
		menu3.add(m8);
		menu3.add(m9);
		menu3.add(m10);
		menu3.add(m11);
		
		// menu items of 'Help'
		m12 = new JMenuItem("About");
		m13 = new JMenuItem("Topic");
		m14 = new JMenuItem("Help");
		menu4.add(m12);
		menu4.add(m13);
		menu4.add(m14);
	}	
	
}
