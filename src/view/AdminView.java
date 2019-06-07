package view;
import java.awt.*;
import java.awt.event.*; 
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.*;

public class AdminView extends JFrame {  
	
	private Container window = new Container();
	private JPanel container = new JPanel();					// department
	private JPanel aside = new JPanel(null);						// homePage	
	private JPanel main = new JPanel(new CardLayout());							// homePage	
	private JPanel homeSection = new JPanel(null);					// homeSection

	private JPanel adminSection = new JPanel(null);					
	private JPanel adminPanel = new JPanel(null);					// homeSection

	private JPanel departmentSection = new JPanel(null);			// department
	private JPanel departmentContainer = new JPanel(new CardLayout());			// department
	private JPanel viewDepartment = new JPanel(null);				// department
	private JPanel addDepartment = new JPanel(null);				// department
	
	private JPanel lecturerSection = new JPanel(null);			// department
	private JPanel lecturerContainer = new JPanel(new CardLayout());			// department
	private JPanel viewLecturer= new JPanel(null);				// department
	private JPanel addLecturer = new JPanel(null);				// department
	
	private JMenuBar     	menuBar = new JMenuBar();						// homePage
	private JMenu 	     	menu1,menu2,menu3,menu4;		// homePage
			JMenuItem    	m1,m2,m3,m4,m5,m6,m7,m8,m9,m10,m11,m12,m13,m14;					// homePage
	private JLabel 		 	homeHeading, underline,					// homeSection
							adminHeading,
							adminSubHeading, usernameAdmin, usernameAdminA, passwordAdmin, passwordAdminA, colon1, colon2,
							departmentHeading, viewDepartmentLink,	addDepartmentLink,					// department
							viewDeptHeading, 		// department
							addDeptHeading, deptName, depttype, deptWebAddress, deptUsername, deptPassword, 	// department
							lecturerHeading, viewLecturerLink, addLecturerLink,
							viewLecturerHeading,
							addLecturerHeading, lecId, lecName, lecAddress, lecPhNo, lecEmail, lecStarted, lecSalary, lecHRate, lecContractEx, lecDept;						// lecturer
	private JTextField 	 	deptNameTF, depttypeTF, deptWebAddressTF, deptUsernameTF,	// department
							lecIdTF, lecNameTF, lecAddressTF, lecPhNoTF, lecEmailTF, lecStartedTF, lecSalaryTF, lecHRateTF, lecContractExTF, lecDeptTF; 	
	private JPasswordField 	deptPasswordTF;					// loginPage
	
	private DefaultComboBoxModel<String> lecDCBM = new DefaultComboBoxModel<String>();
	private JComboBox<String> lecJCB;
	
	private DefaultComboBoxModel<String> aLecDCBM = new DefaultComboBoxModel<String>();
	private JComboBox<String> aLecJCB;
	
	
	private JRadioButton fullTimeL = new JRadioButton("full-time");
	private	JRadioButton partTimeL = new JRadioButton("part-time");
	private	JRadioButton contractL = new JRadioButton("contract");
	private	ButtonGroup  bg = new ButtonGroup();

	private JButton homeBtn = new JButton("    Home");
	private JButton administratorBtn = new JButton("    Administrator");
	private JButton departmentBtn = new JButton("    Department");
	private JButton lecturerBtn = new JButton("    Lecturer");
	private JButton logoutBtn = new JButton("LOG OUT");
	private JButton adminBtnHS = new JButton("     Administration");
	private JButton departmentBtnHS = new JButton("     Manage Departments");
	private JButton lecturerBtnHs = new JButton("     Manage Lecturer");
//	private JButton viewDepartmentBtn = new JButton("View Departments");
//	private JButton addDepartmentBtn = new JButton("Add Department");
	private JButton updateViewDeptBtn = new JButton("Update");
	private JButton removeViewDeptBtn = new JButton("Remove");
	private JButton updateViewLecturerBtn = new JButton("Update");
	private JButton removeViewLecturerBtn = new JButton("Remove");
	
	private JButton saveAddDeptBtn = new JButton("Save");
	private JButton updateAddDeptBtn = new JButton("Update");
	
	private JButton saveAddLecturerBtn = new JButton("Save");
	private JButton updateAddLecturerBtn = new JButton("Update");
	
	private JTable tableDepartment = new JTable();
	private JScrollPane scrollPane = new JScrollPane();
	private DefaultTableModel defaultTableModel = new DefaultTableModel();
	
	private JTable tableLecturer = new JTable();
	private JScrollPane scrollPaneL = new JScrollPane();
	private DefaultTableModel defaultTableModelL = new DefaultTableModel();
	
	private JTable tableLecturerP= new JTable();
	private JScrollPane scrollPaneLP = new JScrollPane();
	private DefaultTableModel defaultTableModelLP = new DefaultTableModel();
	
	private JTable tableLecturerC = new JTable();
	private JScrollPane scrollPaneLC = new JScrollPane();
	private DefaultTableModel defaultTableModelLC = new DefaultTableModel();
	
//	private JLabel viewDepartmentBtn = new JLabel("View Departments");
//	private JLabel addDepartmentBtn = new JLabel("Add Department");
	

	public AdminView() {
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
		this.setTitle("University Human Resource System - Admin");		//set's title of the system
		this.setSize(1200, 800);   //set's size of the system
		this.setResizable(false);	// cannot minimize or maximize the window
		this.setLocationRelativeTo(null);	//centers the window on the screen
		
		window = getContentPane();	//get the content's of Container window
		
		homeSectionPanel();
		
		adminPanel();
		
		departmentPanel();
		viewDepartmentPanel();
		addDepartmentPanel();	
		
		lecturerPanel();
		viewLecturerPanel();
		addLecturerPanel();
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
		
		administratorBtn.setBounds(20, 90, 190, 30);
		administratorBtn.setHorizontalAlignment(SwingConstants.LEFT);
		administratorBtn.setBackground(Color.WHITE);
		
		departmentBtn.setBounds(20, 140, 190, 30);
		departmentBtn.setHorizontalAlignment(SwingConstants.LEFT);
		departmentBtn.setBackground(Color.WHITE);
		
		lecturerBtn.setBounds(20, 190, 190, 30);
		lecturerBtn.setHorizontalAlignment(SwingConstants.LEFT);
		lecturerBtn.setBackground(Color.WHITE);
		
		logoutBtn.setBounds(40, 680, 150, 30);
		logoutBtn.setBackground(Color.WHITE);
//		logoutBtn.setBorder(new RoundedBorder(10));
		
		aside.add(homeBtn);
		aside.add(administratorBtn);
		aside.add(departmentBtn);
		aside.add(lecturerBtn);
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
	public void addAdminButtonListener(ActionListener listenForAdminButton) {   
		administratorBtn.addActionListener(listenForAdminButton);  
	}
	public void addDepartmentButtonListener(ActionListener listenForDepartmentButton) {   
		departmentBtn.addActionListener(listenForDepartmentButton);  
	}	
	public void addLecturerButtonListener(ActionListener listenForLecturerButton) {   
		lecturerBtn.addActionListener(listenForLecturerButton);  
	}
	public void addLogoutButtonListener(ActionListener listenForLogoutButton) {   
		logoutBtn.addActionListener(listenForLogoutButton);  
	}
	public void homePagePanelLink() {
		menuBar.setVisible(true);
		container.setVisible(true);		
		aside.setVisible(true);
		main.setVisible(true);
		homeSection.setVisible(true);
		adminSection.setVisible(false);
		departmentSection.setVisible(false);
		departmentContainer.setVisible(false);
		viewDepartment.setVisible(false);
		addDepartment.setVisible(false);
		
		lecturerSection.setVisible(false);
		lecturerContainer.setVisible(false);
		viewLecturer.setVisible(false);			
		addLecturer.setVisible(false);
	}	
	
	
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
		
		adminBtnHS.setBounds(10, 80, 900, 50);
		adminBtnHS.setBackground(Color.WHITE);
		adminBtnHS.setHorizontalAlignment(SwingConstants.LEFT);
		
		departmentBtnHS.setBounds(10, 140, 900, 50);
		departmentBtnHS.setBackground(Color.WHITE);
		departmentBtnHS.setHorizontalAlignment(SwingConstants.LEFT);
		
		lecturerBtnHs.setBounds(10, 200, 900, 50);
		lecturerBtnHs.setBackground(Color.WHITE);
		lecturerBtnHs.setHorizontalAlignment(SwingConstants.LEFT);
		
		homeSection.add(homeHeading);
		homeSection.add(underline);
		homeSection.add(adminBtnHS);
		homeSection.add(departmentBtnHS);
		homeSection.add(lecturerBtnHs);
	}
	public void addAdminButtonListenerHS(ActionListener listenForAdminButton) {   
		adminBtnHS.addActionListener(listenForAdminButton);  
	}
	public void addDepartmentButtonListenerHS(ActionListener listenForDepartmentButton) {   
		departmentBtnHS.addActionListener(listenForDepartmentButton);  
	}
	public void addLecturerButtonListenerHS(ActionListener listenForLecturerButton) {   
		lecturerBtnHs.addActionListener(listenForLecturerButton);  
	}	
	public void homeSectionPanelLink() {

		container.setVisible(true);	
		menuBar.setVisible(true);
		aside.setVisible(true);
		main.setVisible(true);
		homeSection.setVisible(true);
		adminSection.setVisible(false);
		departmentSection.setVisible(false);
		departmentContainer.setVisible(false);
		viewDepartment.setVisible(false);
		addDepartment.setVisible(false);
		
		lecturerSection.setVisible(false);
		lecturerContainer.setVisible(false);
		viewLecturer.setVisible(false);			
		addLecturer.setVisible(false);
	}
	
	
	
	
	public void adminPanel() {
		
		// panel for lecturer page	
		adminSection.setBackground(Color.decode("#f7f7f7"));
		
		// adding component to JPanel 'main'
		main.add(adminSection);
		
		adminHeading = new JLabel("Aministrator");
		adminHeading.setBounds(5, 0, 300, 35);
		adminHeading.setFont(new Font("Serif", Font.BOLD, 30));
		
		underline = new JLabel(underline());
		underline.setBounds(5, 25, 950, 35);
		
		adminPanel.setBounds(5, 65, 950, 610);
		adminPanel.setBackground(Color.WHITE);
		
		
		adminSubHeading = new JLabel("Administrator Details");
		adminSubHeading.setBounds(13, 5, 300, 35);
		adminSubHeading.setFont(new Font("Serif", Font.BOLD, 20));
		
		
		usernameAdmin = new JLabel("Username");
		usernameAdmin.setBounds(25, 45, 100, 35);
		colon1 = new JLabel(" : ");
		colon1.setBounds(150, 40, 10, 35);
		usernameAdminA = new JLabel("admin");
		usernameAdminA.setBounds(250, 40, 300, 35);
		
		passwordAdmin = new JLabel("Password");
		passwordAdmin.setBounds(25, 75, 200, 35);
		colon2 = new JLabel(" : ");
		colon2.setBounds(150, 70, 10, 35);
		passwordAdminA = new JLabel("admin123");
		passwordAdminA.setBounds(250, 70, 300, 35);
		
		adminSection.add(adminHeading);
		adminSection.add(underline);
		adminSection.add(adminPanel);
		adminPanel.add(adminSubHeading);
		adminPanel.add(usernameAdmin);
		adminPanel.add(colon1);
		adminPanel.add(usernameAdminA);
		adminPanel.add(passwordAdmin);
		adminPanel.add(colon2);
		adminPanel.add(passwordAdminA);
		
	}
	public void adminPanelLink() {

		container.setVisible(true);	
		menuBar.setVisible(true);
		aside.setVisible(true);
		main.setVisible(true);
		homeSection.setVisible(false);
		adminSection.setVisible(true);
		departmentSection.setVisible(false);
		departmentContainer.setVisible(false);
		viewDepartment.setVisible(false);
		addDepartment.setVisible(false);
		
		lecturerSection.setVisible(false);
		lecturerContainer.setVisible(false);
		viewLecturer.setVisible(false);			
		addLecturer.setVisible(false);
	}
	
	
	
	
	
	public void lecturerPanel() {
		
		// panel for lecturer page	
		lecturerSection.setBackground(Color.decode("#f7f7f7"));
		
		// adding component to JPanel 'main'
		main.add(lecturerSection);
		
		lecturerHeading = new JLabel("Lecturers");
		lecturerHeading.setBounds(5, 0, 300, 35);
		lecturerHeading.setFont(new Font("Serif", Font.BOLD, 30));
		
		viewLecturerLink = new JLabel("View Lectueres");
		viewLecturerLink.setBounds(5, 50, 150, 20);
		addLecturerLink = new JLabel("Add Lecturers");
		addLecturerLink.setBounds(160, 50, 150, 20);
		
		underline = new JLabel(underline());
		underline.setBounds(5, 60, 950, 35);
		
//		lecturerContainer.setBackground(Color.decode("#f00"));
		lecturerContainer.setBounds(5, 100, 950, 610);
		
//		addDepartmentPanel();
//		viewDepartmentPanel();
		
		lecturerSection.add(lecturerHeading);
		lecturerSection.add(viewLecturerLink);
		lecturerSection.add(addLecturerLink);
		lecturerSection.add(underline);
		lecturerSection.add(lecturerContainer);
	}
	public void addViewLecturerMouseListener(MouseAdapter listenForViewLecturerButton) {   
		viewLecturerLink.addMouseListener(listenForViewLecturerButton);  
	}
	public void addAddLecturerMouseListener(MouseAdapter listenForAddLecturerButton) {   
		addLecturerLink.addMouseListener(listenForAddLecturerButton);  
	}	
	public void lecturerPanelLink() {
		container.setVisible(true);		
		aside.setVisible(true);
		main.setVisible(true);
		homeSection.setVisible(false);
		adminSection.setVisible(false);
		departmentSection.setVisible(false);
		departmentContainer.setVisible(false);
		viewDepartment.setVisible(false);			
		addDepartment.setVisible(false);
		
		lecturerSection.setVisible(true);
		lecturerContainer.setVisible(true);
		viewLecturer.setVisible(true);			
		addLecturer.setVisible(false);
	}
	
	public void viewLecturerPanel() {

//		viewDepartment.setBackground(Color.decode("#f7f7f7"));
		viewLecturer.setBackground(Color.WHITE);
		
		viewLecturerHeading = new JLabel("View Lecturers");
		viewLecturerHeading.setBounds(8, 0, 300, 35);
		viewLecturerHeading.setFont(new Font("Serif", Font.BOLD, 20));
		
		lecDCBM.addElement("Full-Time Lecturer");
		lecDCBM.addElement("Part-Time Lecturer");
		lecDCBM.addElement("Contract Lecturer");
		lecJCB = new JComboBox<String>(lecDCBM);
		lecJCB.setBounds(390, 10, 200, 25);
		lecJCB.setSelectedIndex(0);
		viewLecturer.add(lecJCB);
		
		displayLecturerTableF();
		displayLecturerTableP();
		displayLecturerTableC();
		
		updateViewLecturerBtn.setBounds(610, 10, 140, 25);
		updateViewLecturerBtn.setBackground(Color.decode("#4982c2"));
		updateViewLecturerBtn.setForeground(Color.WHITE);
		updateViewLecturerBtn.setBorder(new LineBorder(Color.decode("#4982c2"), Color.OPAQUE));		
		viewLecturer.add(updateViewLecturerBtn);
		
		removeViewLecturerBtn.setBounds(758, 10, 140, 25);
		removeViewLecturerBtn.setBackground(Color.decode("#c73f3f"));
		removeViewLecturerBtn.setForeground(Color.WHITE);
		removeViewLecturerBtn.setBorder(new LineBorder(Color.decode("#c73f3f"), Color.OPAQUE));		
		viewLecturer.add(removeViewLecturerBtn);
		
		lecturerContainer.add(viewLecturer);
		viewLecturer.add(viewLecturerHeading);
	}
	public int getSelectedIndexL() {
		return lecJCB.getSelectedIndex();
	}
	public void setSelectedIndexL(int x) {
		lecJCB.setSelectedIndex(x);
	}
	public void viewLecPanelItemListener(ItemListener listenForViewLecturerButton) {
		lecJCB.addItemListener(listenForViewLecturerButton);
	}
	public void viewLecPanelLink() {
		if (lecJCB.getSelectedIndex() == 0) {
			scrollPaneL.setVisible(true);
			scrollPaneLP.setVisible(false);
			scrollPaneLC.setVisible(false);
		}
		else if (lecJCB.getSelectedIndex() == 1) {
			scrollPaneL.setVisible(false);
			scrollPaneLP.setVisible(true);
			scrollPaneLC.setVisible(false);
		}
		else if (lecJCB.getSelectedIndex() == 2) {
			scrollPaneL.setVisible(false);
			scrollPaneLP.setVisible(false);
			scrollPaneLC.setVisible(true);
		}
	}
	public void updateViewLecturerButtonListener(ActionListener listenForUpdateLecturerButton) {   
		updateViewLecturerBtn.addActionListener(listenForUpdateLecturerButton);  
	}
	public void removeViewLecturerButtonListener(ActionListener listenForRemoveLecturerButton) {   
		removeViewLecturerBtn.addActionListener(listenForRemoveLecturerButton);  
	}
	public void displayLecturerColumnActionPerformed() {
		
	}
	public void viewLecturerPanelLink() {
		
		container.setVisible(true);		
		aside.setVisible(true);
		main.setVisible(true);
		homeSection.setVisible(false);
		adminSection.setVisible(false);
		departmentSection.setVisible(false);
		departmentContainer.setVisible(false);
		viewDepartment.setVisible(false);
		addDepartment.setVisible(false);
		
		lecturerSection.setVisible(true);
		lecturerContainer.setVisible(true);
		viewLecturer.setVisible(true);			
		addLecturer.setVisible(false);
	}
	
	public void addLecturerPanel() {
		
//		addDepartment.setSize(450, 290);
		addLecturer.setBackground(Color.WHITE);
		
		addLecturerHeading = new JLabel("Add Lecturers");
		addLecturerHeading.setBounds(10, 0, 200, 35);
		addLecturerHeading.setFont(new Font("Serif", Font.BOLD, 20));
		
		fullTimeL.setBounds(510, 0, 80, 30);
		fullTimeL.setBackground(Color.WHITE);
		partTimeL.setBounds(675, 0, 80, 30);
		partTimeL.setBackground(Color.WHITE);
		contractL.setBounds(820, 0, 80, 30);
		contractL.setBackground(Color.WHITE);
		bg.add(fullTimeL);
		bg.add(partTimeL);
		bg.add(contractL);
		fullTimeL.setSelected(true);
//		fullTimeLink();
		
		lecId = new JLabel("Identification Number");
		lecId.setBounds(15, 35, 300, 30);
		lecIdTF = new JTextField();
		lecIdTF.setBounds(15, 65, 400, 30);
		
		lecName = new JLabel("Name");
		lecName.setBounds(15, 95, 300, 30);
		lecNameTF = new JTextField();
		lecNameTF.setBounds(15, 125, 400, 30);
		
		lecAddress = new JLabel("Address");
		lecAddress.setBounds(15, 155, 300, 30);
		lecAddressTF = new JTextField();
		lecAddressTF.setBounds(15, 185, 400, 30);

		lecPhNo = new JLabel("Phone Number");
		lecPhNo.setBounds(15, 215, 300, 30);
		lecPhNoTF = new JTextField();
		lecPhNoTF.setBounds(15, 245, 400, 30);
		
		lecEmail = new JLabel("Email Address");
		lecEmail.setBounds(15, 275, 300, 30);
		lecEmailTF = new JTextField();
		lecEmailTF.setBounds(15, 305, 400, 30);
		
		lecStarted = new JLabel("Date Started");
		lecStarted.setBounds(15, 335, 300, 30);
		lecStartedTF = new JTextField();
		lecStartedTF.setBounds(15, 365, 400, 30);
		
		lecDept = new JLabel("Department");
		lecDept.setBounds(15, 455, 400, 30);
		
//		aLecDCBM.addElement("Full-Time Lecturer");
//		aLecDCBM.addElement("Part-Time Lecturer");
//		aLecDCBM.addElement("Contract Lecturer");
//		
		aLecJCB = new JComboBox<String>(aLecDCBM);
		aLecJCB.setBounds(15, 485, 400, 30);
//		aLecJCB.setSelectedIndex(0);
		
		/////
		lecSalary = new JLabel("Salary");
		lecSalary.setBounds(15, 395, 300, 30);
		lecSalaryTF = new JTextField();
		lecSalaryTF.setBounds(15, 425, 400, 30);
		/////
		lecHRate = new JLabel("Hourly Rate");
		lecHRate.setBounds(15, 395, 300, 30);
		lecHRateTF = new JTextField();
		lecHRateTF.setBounds(15, 425, 400, 30);
		/////
		lecContractEx = new JLabel("Contract Expiry");
		lecContractEx.setBounds(15, 515, 400, 30);
		lecContractExTF = new JTextField();
		lecContractExTF.setBounds(15, 545, 400, 30);
		////
		
		saveAddLecturerBtn.setBounds(500, 560, 195, 30);
//		saveAddDeptBtn.setFont(new Font("Serif", Font.BOLD, 20));
		saveAddLecturerBtn.setBackground(Color.decode("#309d0f"));
		saveAddLecturerBtn.setForeground(Color.WHITE);
		saveAddLecturerBtn.setBorder(new LineBorder(Color.decode("#309d0f"), Color.OPAQUE));		
		
		updateAddLecturerBtn.setBounds(700, 560, 200, 30);
//		saveAddDeptBtn.setFont(new Font("Serif", Font.BOLD, 20));
		updateAddLecturerBtn.setBackground(Color.decode("#4982c2"));
		updateAddLecturerBtn.setForeground(Color.WHITE);
		updateAddLecturerBtn.setBorder(new LineBorder(Color.decode("#4982c2"), Color.OPAQUE));		
		
		lecturerContainer.add(addLecturer);
		addLecturer.add(addLecturerHeading);
		addLecturer.add(fullTimeL);
		addLecturer.add(partTimeL);
		addLecturer.add(contractL);
		addLecturer.add(lecId);
		addLecturer.add(lecIdTF);
		addLecturer.add(lecName);
		addLecturer.add(lecNameTF);
		addLecturer.add(lecAddress);
		addLecturer.add(lecAddressTF);
		addLecturer.add(lecPhNo);
		addLecturer.add(lecPhNoTF);
		addLecturer.add(lecEmail);
		addLecturer.add(lecEmailTF);
		addLecturer.add(lecStarted);
		addLecturer.add(lecStartedTF);
		addLecturer.add(lecSalary);
		addLecturer.add(lecSalaryTF);
		addLecturer.add(lecHRate);
		addLecturer.add(lecHRateTF);
		addLecturer.add(lecDept);
		addLecturer.add(aLecJCB);
		addLecturer.add(lecContractEx);
		addLecturer.add(lecContractExTF);
		addLecturer.add(saveAddLecturerBtn);
		addLecturer.add(updateAddLecturerBtn);
	}
	public void fullTimeLItemListener(ItemListener listenForFullTimeLItem) {   
		fullTimeL.addItemListener(listenForFullTimeLItem);  
	}
	public void partTimeLItemListener(ItemListener listenForPartTimeLItem) {   
		partTimeL.addItemListener(listenForPartTimeLItem);  
	}
	public void contractTimeLItemListener(ItemListener listenForContractTimeLItem) {   
		contractL.addItemListener(listenForContractTimeLItem);  
	}
	public void addElementLecDCBM(String dept) {
		aLecDCBM.addElement(dept);
	}
	public void removeElementLecDCBM() {
		aLecDCBM.removeAllElements();
	}
	
	public void fullTimeLink() {
		lecSalary.setVisible(true);
		lecSalaryTF.setVisible(true);
		lecHRate.setVisible(false);
		lecHRateTF.setVisible(false);
		lecContractEx.setVisible(false);
		lecContractExTF.setVisible(false);
	}
	public void partTimeLink() {   
		lecSalary.setVisible(false);
		lecSalaryTF.setVisible(false);
		lecHRate.setVisible(true);
		lecHRateTF.setVisible(true);
		lecContractEx.setVisible(false);
		lecContractExTF.setVisible(false);
	}
	public void contractTimeLink() {   
		lecSalary.setVisible(true);
		lecSalaryTF.setVisible(true);
		lecHRate.setVisible(false);
		lecHRateTF.setVisible(false);
		lecContractEx.setVisible(true);
		lecContractExTF.setVisible(true);
	}	
	public int getSelectedIndexRBL() {
		if (fullTimeL.isSelected())
			return 0;
		else if (partTimeL.isSelected())
			return 1;
		else if (contractL.isSelected())
			return 2;
		return 0;
	}
	public void setSelectedIndexRBL(int x) {
		if (x == 0)
			fullTimeL.setSelected(true);
		else if (x == 1)
			partTimeL.setSelected(true);
		else if (x == 2)
			contractL.setSelected(true);
	}
	public String getLecId() {
		return lecIdTF.getText();
	}
	public String getlecName() {
		return lecNameTF.getText();
	}
	public String getlecAddress() {
		return lecAddressTF.getText();
	}
	public String getlecPhNo() {
		return lecPhNoTF.getText();
	}
	public String getlecEmail() {
		return lecEmailTF.getText();
	}
	public String getlecStarted() {
		return lecStartedTF.getText();
	}
	public String getlecSalary() {
		return lecSalaryTF.getText();
	}
	public String getlecHRate() {
		return lecHRateTF.getText();
	}
	public String getlecContractEx() {
		return lecContractExTF.getText();
	}
	public String getlecDept() {
		return (String) aLecDCBM.getSelectedItem();
	}
	public void setLecId(String id) {
		lecIdTF.setText(id);
	}
	public void setlecName(String name) {
		lecNameTF.setText(name);
	}
	public void setlecAddress(String address) {
		lecAddressTF.setText(address);
	}
	public void setlecPhNo(String phone) {
		lecPhNoTF.setText(phone);
	}
	public void setlecEmail(String email) {
		lecEmailTF.setText(email);
	}
	public void setlecStarted(String started) {
		lecStartedTF.setText(started);
	}
	public void setlecSalary(String salary) {
		lecSalaryTF.setText(salary);
	}
	public void setlecHRate(String rate) {
		lecHRateTF.setText(rate);
	}
	public void setlecContractEx(String contract) {
		lecContractExTF.setText(contract);
	}
	public void setlecDept(String dept) {
		aLecJCB.setToolTipText(dept);
	}
	public void emptyLecturer() {
		setLecId("");
		setlecName("");
		setlecAddress("");
		setlecPhNo("");
		setlecEmail("");
		setlecStarted("");
		setlecSalary("");
		setlecHRate("");
		setlecContractEx("");
		setlecDept("");
	}
	public void addSaveLecturerButtonListener(ActionListener listenForSaveLecturerButton) {   
		saveAddLecturerBtn.addActionListener(listenForSaveLecturerButton);  
	}
	public void addUpdateLecturerButtonListener(ActionListener listenForUpdateLecturerButton) {   
		updateAddLecturerBtn.addActionListener(listenForUpdateLecturerButton);  
	}
	public void addLecturerPanelLink() {
		
		container.setVisible(true);		
		aside.setVisible(true);
		main.setVisible(true);
		homeSection.setVisible(false);
		adminSection.setVisible(false);
		departmentSection.setVisible(false);
		departmentContainer.setVisible(false);
		viewDepartment.setVisible(false);
		addDepartment.setVisible(false);
		
		lecturerSection.setVisible(true);
		lecturerContainer.setVisible(true);
		viewLecturer.setVisible(false);			
		addLecturer.setVisible(true);
	}
	
	
	
		
	public void departmentPanel() {
		
		// panel for department page	
		departmentSection.setBackground(Color.decode("#f7f7f7"));
		
		// adding component to JPanel 'main'
		main.add(departmentSection);
		
		departmentHeading = new JLabel("Departments");
		departmentHeading.setBounds(5, 0, 300, 35);
		departmentHeading.setFont(new Font("Serif", Font.BOLD, 30));
		
		viewDepartmentLink = new JLabel("View Department");
		viewDepartmentLink.setBounds(5, 50, 150, 20);
		addDepartmentLink = new JLabel("Add Department");
		addDepartmentLink.setBounds(160, 50, 150, 20);
		
		underline = new JLabel(underline());
		underline.setBounds(5, 60, 950, 35);
		
//		departmentContainer.setBackground(Color.decode("#f00"));
		departmentContainer.setBounds(5, 100, 950, 610);
		
//		addDepartmentPanel();
//		viewDepartmentPanel();
		
		departmentSection.add(departmentHeading);
		departmentSection.add(viewDepartmentLink);
		departmentSection.add(addDepartmentLink);
		departmentSection.add(underline);
		departmentSection.add(departmentContainer);
	}
	public void addViewDepartmentMouseListener(MouseAdapter listenForViewDepartmentButton) {   
		viewDepartmentLink.addMouseListener(listenForViewDepartmentButton);  
	}
	public void addAddDepartmentMouseListener(MouseAdapter listenForAddDepartmentButton) {   
		addDepartmentLink.addMouseListener(listenForAddDepartmentButton);  
	}	
	public void departmentPanelLink() {
		container.setVisible(true);		
		aside.setVisible(true);
		main.setVisible(true);
		homeSection.setVisible(false);
		adminSection.setVisible(false);
		departmentSection.setVisible(true);
		departmentContainer.setVisible(true);
		viewDepartment.setVisible(true);			
		addDepartment.setVisible(false);
		
		lecturerSection.setVisible(false);
		lecturerContainer.setVisible(false);
		viewLecturer.setVisible(false);			
		addLecturer.setVisible(false);
	}
	
	public void viewDepartmentPanel() {

//		viewDepartment.setBackground(Color.decode("#f7f7f7"));
		viewDepartment.setBackground(Color.WHITE);
		
		viewDeptHeading = new JLabel("View Departments");
		viewDeptHeading.setBounds(8, 0, 300, 35);
		viewDeptHeading.setFont(new Font("Serif", Font.BOLD, 20));
		
		updateViewDeptBtn.setBounds(610, 10, 140, 25);
		updateViewDeptBtn.setBackground(Color.decode("#4982c2"));
		updateViewDeptBtn.setForeground(Color.WHITE);
		updateViewDeptBtn.setBorder(new LineBorder(Color.decode("#4982c2"), Color.OPAQUE));		
		viewDepartment.add(updateViewDeptBtn);
		
		removeViewDeptBtn.setBounds(758, 10, 140, 25);
		removeViewDeptBtn.setBackground(Color.decode("#c73f3f"));
		removeViewDeptBtn.setForeground(Color.WHITE);
		removeViewDeptBtn.setBorder(new LineBorder(Color.decode("#c73f3f"), Color.OPAQUE));		
		viewDepartment.add(removeViewDeptBtn);
		
		displayDepartmentTable();
		
		departmentContainer.add(viewDepartment);
		viewDepartment.add(viewDeptHeading);
	}
	public void updateViewDeptButtonListener(ActionListener listenForUpdateDeptButton) {   
		updateViewDeptBtn.addActionListener(listenForUpdateDeptButton);  
	}
	public void removeViewDeptButtonListener(ActionListener listenForRemoveDeptButton) {   
		removeViewDeptBtn.addActionListener(listenForRemoveDeptButton);  
	}
	public void viewDepartmentPanelLink() {
		
		container.setVisible(true);		
		aside.setVisible(true);
		main.setVisible(true);
		homeSection.setVisible(false);
		adminSection.setVisible(false);
		departmentSection.setVisible(true);
		departmentContainer.setVisible(true);
		viewDepartment.setVisible(true);
		addDepartment.setVisible(false);
		
		lecturerSection.setVisible(false);
		lecturerContainer.setVisible(false);
		viewLecturer.setVisible(false);			
		addLecturer.setVisible(false);
	}

	public void addDepartmentPanel() {
		
//		addDepartment.setSize(450, 290);
		addDepartment.setBackground(Color.WHITE);
		
		addDeptHeading = new JLabel("Add Department");
		addDeptHeading.setBounds(10, 0, 300, 35);
		addDeptHeading.setFont(new Font("Serif", Font.BOLD, 20));
		
		deptName = new JLabel("Department Name");
		deptName.setBounds(15, 35, 300, 30);
		deptNameTF = new JTextField();
		deptNameTF.setBounds(15, 65, 400, 30);
		
		depttype = new JLabel("Department Type");
		depttype.setBounds(15, 95, 300, 30);
		depttypeTF = new JTextField();
		depttypeTF.setBounds(15, 130, 400, 30);
		
		deptWebAddress = new JLabel("Web Address");
		deptWebAddress.setBounds(15, 160, 300, 30);
		deptWebAddressTF = new JTextField();
		deptWebAddressTF.setBounds(15, 190, 400, 30);
		
		deptUsername = new JLabel("Username");
		deptUsername.setBounds(15, 220, 300, 30);
		deptUsernameTF = new JTextField();
		deptUsernameTF.setBounds(15, 250, 400, 30);
		
		deptPassword = new JLabel("Password");
		deptPassword.setBounds(15, 280, 300, 30);
		deptPasswordTF = new JPasswordField();
		deptPasswordTF.setBounds(15, 310, 400, 30);
		deptPasswordTF.setEchoChar('*');
		
		saveAddDeptBtn.setBounds(15, 370, 195, 30);
//		saveAddDeptBtn.setFont(new Font("Serif", Font.BOLD, 20));
		saveAddDeptBtn.setBackground(Color.decode("#309d0f"));
		saveAddDeptBtn.setForeground(Color.WHITE);
		saveAddDeptBtn.setBorder(new LineBorder(Color.decode("#309d0f"), Color.OPAQUE));		
		
		updateAddDeptBtn.setBounds(215, 370, 200, 30);
//		saveAddDeptBtn.setFont(new Font("Serif", Font.BOLD, 20));
		updateAddDeptBtn.setBackground(Color.decode("#4982c2"));
		updateAddDeptBtn.setForeground(Color.WHITE);
		updateAddDeptBtn.setBorder(new LineBorder(Color.decode("#4982c2"), Color.OPAQUE));		
		
		departmentContainer.add(addDepartment);
		addDepartment.add(addDeptHeading);
		addDepartment.add(deptName);
		addDepartment.add(deptNameTF);
		addDepartment.add(depttype);
		addDepartment.add(depttypeTF);
		addDepartment.add(deptWebAddress);
		addDepartment.add(deptWebAddressTF);
		addDepartment.add(deptUsername);
		addDepartment.add(deptUsernameTF);
		addDepartment.add(deptPassword);
		addDepartment.add(deptPasswordTF);
		addDepartment.add(saveAddDeptBtn);
		addDepartment.add(updateAddDeptBtn);
	}
	public String getDepartmentName() {
		return deptNameTF.getText();
	}
	public String getDepartmentType() {
		return depttypeTF.getText();
	}
	public String getDepartmentWebAddress() {
		return deptWebAddressTF.getText();
	}
	public String getDepartmentUsername() {
		return deptUsernameTF.getText();
	}
	public String getDepartmentPassword() {
		return String.valueOf(deptPasswordTF.getPassword());
	}
	public void setDepartmentName(String name) {
		deptNameTF.setText(name);
	}
	public void setDepartmentType(String type) {
		depttypeTF.setText(type);
	}
	public void setDepartmentWebAddress(String webAddress) {
		deptWebAddressTF.setText(webAddress);
	}
	public void setDepartmentUsername(String username) {
		deptUsernameTF.setText(username);
	}
	public void setDepartmentPassword(String password) {
		deptPasswordTF.setText(password);
	}
	public void emptyDepartment() {

		setDepartmentName("");
		setDepartmentType("");
		setDepartmentWebAddress("");
		setDepartmentUsername("");
		setDepartmentPassword("");
		
	}
	public void addSaveDeptButtonListener(ActionListener listenForSaveDeptButton) {   
		saveAddDeptBtn.addActionListener(listenForSaveDeptButton);  
	}
	public void addUpdateDeptButtonListener(ActionListener listenForUpdateDeptButton) {   
		updateAddDeptBtn.addActionListener(listenForUpdateDeptButton);  
	}
	public void addDepartmentPanelLink() {
		
		container.setVisible(true);		
		aside.setVisible(true);
		main.setVisible(true);
		homeSection.setVisible(false);
		adminSection.setVisible(false);
		departmentSection.setVisible(true);
		departmentContainer.setVisible(true);
		viewDepartment.setVisible(false);
		addDepartment.setVisible(true);
		
		lecturerSection.setVisible(false);
		lecturerContainer.setVisible(false);
		viewLecturer.setVisible(false);			
		addLecturer.setVisible(false);
	}
	
	
	
	
	
	
	
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
	public String underline() {
		
		String hyphen = "";
		for(int i = 0; i < 130; i++) {
			hyphen += "- ";
		}
		return hyphen;
	}

	
	public void displayDepartmentTable() {
		
//		scrollPane.setBounds(5, 55, 900, 540);
		scrollPane.setBounds(10, 55, 890, 530);
		scrollPane.setViewportView(tableDepartment);
		viewDepartment.add(scrollPane);
		
		defaultTableModel.addColumn("Name");
		defaultTableModel.addColumn("Type");
		defaultTableModel.addColumn("Web Address");
		defaultTableModel.addColumn("Username");
		defaultTableModel.addColumn("Password");
		

//		TableColumnModel tcm = tableDepartment.getColumnModel();
////		tcm.removeColumn( tcm.getColumn(...) );
//		tcm.getColumn(1).setWidth(0);
		
		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(defaultTableModel);
		tableDepartment.setRowSorter(sorter);
	   
		tableDepartment.setModel(defaultTableModel);
		tableDepartment.setRowHeight(20);
		tableDepartment.getColumnModel().getColumn(4).setMaxWidth(0);
		
		JTableHeader tHeader = tableDepartment.getTableHeader();
		tHeader.setBackground(Color.decode("#ececec"));
//		defaultTableModel = (DefaultTableModel)tableDepartment.getModel();
	}
	public int getSelectedRowJTable() {   
		 return tableDepartment.getSelectedRow();
	}
	public void removeRowJTable(int x) {   
		defaultTableModel.removeRow(x);
	}
	public String getValueAtJTable(int x, int y) {

		return (String) tableDepartment.getValueAt(x, y);
	}
	public void setValueAtJTable(String data, int x, int y) {
		
		defaultTableModel.setValueAt(data, x, y);
	}
	public void addRowJTable(String [] deptData) {
		defaultTableModel.addRow(deptData);		
	}

	
	public void displayLecturerTableF() {
		
//		scrollPane.setBounds(5, 55, 900, 540);
		scrollPaneL.setBounds(10, 55, 890, 530);
		scrollPaneL.setViewportView(tableLecturer);
		viewLecturer.add(scrollPaneL);
		
		defaultTableModelL.addColumn("Id No."); 
		defaultTableModelL.addColumn("Name"); 
		defaultTableModelL.addColumn("Address"); 
		defaultTableModelL.addColumn("Phone No."); 
		defaultTableModelL.addColumn("Email");
		defaultTableModelL.addColumn("Date Started");
		defaultTableModelL.addColumn("Salary");
		defaultTableModelL.addColumn("Department");

		tableLecturer.setModel(defaultTableModelL);
		tableLecturer.setRowHeight(20);
		
		JTableHeader tHeaderL = tableLecturer.getTableHeader();
		tHeaderL.setBackground(Color.decode("#ececec"));
//		defaultTableModel = (DefaultTableModel)tableDepartment.getModel();
	}
	public int getSelectedRowJTableL() {   
		 return tableLecturer.getSelectedRow();
	}
	public void removeRowJTableL(int x) {   
		defaultTableModelL.removeRow(x);
	}
	public String getValueAtJTableL(int x, int y) {

		return (String) tableLecturer.getValueAt(x, y);
	}
	public void setValueAtJTableL(String data, int x, int y) {
		
		defaultTableModelL.setValueAt(data, x, y);
	}
	public void addRowJTableL(String[] lecData) {
		defaultTableModelL.addRow(lecData);		
	}

	public void displayLecturerTableP() {
		
	//	scrollPane.setBounds(5, 55, 900, 540);
		scrollPaneLP.setBounds(10, 55, 890, 530);
		scrollPaneLP.setViewportView(tableLecturerP);
		viewLecturer.add(scrollPaneLP);
		
		defaultTableModelLP.addColumn("Id No."); 
		defaultTableModelLP.addColumn("Name"); 
		defaultTableModelLP.addColumn("Address"); 
		defaultTableModelLP.addColumn("Phone No."); 
		defaultTableModelLP.addColumn("Email");
		defaultTableModelLP.addColumn("Date Started");
		defaultTableModelLP.addColumn("Hourly Rate");
		defaultTableModelLP.addColumn("Department");

		tableLecturerP.setModel(defaultTableModelLP);
		tableLecturerP.setRowHeight(20);
		
		JTableHeader tHeaderLP = tableLecturer.getTableHeader();
		tHeaderLP.setBackground(Color.decode("#ececec"));
	//	defaultTableModel = (DefaultTableModel)tableDepartment.getModel();
	}
	public int getSelectedRowJTableLP() {   
		 return tableLecturerP.getSelectedRow();
	}
	public void removeRowJTableLP(int x) {   
		defaultTableModelLP.removeRow(x);
	}
	public String getValueAtJTableLP(int x, int y) {
	
		return (String) tableLecturerP.getValueAt(x, y);
	}
	public void setValueAtJTableLP(String data, int x, int y) {
		
		defaultTableModelLP.setValueAt(data, x, y);
	}
	public void addRowJTableLP(String [] deptData) {
		defaultTableModelLP.addRow(deptData);		
	}
		
	public void displayLecturerTableC() {
		
		//	scrollPane.setBounds(5, 55, 900, 540);
			scrollPaneLC.setBounds(10, 55, 890, 530);
			scrollPaneLC.setViewportView(tableLecturerC);
			viewLecturer.add(scrollPaneLC);
			
			defaultTableModelLC.addColumn("Id No."); 
			defaultTableModelLC.addColumn("Name"); 
			defaultTableModelLC.addColumn("Address"); 
			defaultTableModelLC.addColumn("Phone No."); 
			defaultTableModelLC.addColumn("Email");
			defaultTableModelLC.addColumn("Date Started");
			defaultTableModelLC.addColumn("Salary");
			defaultTableModelLC.addColumn("Contact Expiry");
			defaultTableModelLC.addColumn("Department");

			tableLecturerC.setModel(defaultTableModelLC);
			tableLecturerC.setRowHeight(20);
			
			JTableHeader tHeaderLC = tableLecturer.getTableHeader();
			tHeaderLC.setBackground(Color.decode("#ececec"));
		//	defaultTableModel = (DefaultTableModel)tableDepartment.getModel();
		}
	public int getSelectedRowJTableLC() {   
		 return tableLecturerC.getSelectedRow();
	}
	public void removeRowJTableLC(int x) {   
		defaultTableModelLC.removeRow(x);
	}
	public String getValueAtJTableLC(int x, int y) {
	
		return (String) tableLecturerC.getValueAt(x, y);
	}
	public void setValueAtJTableLC(String data, int x, int y) {
		
		defaultTableModelLC.setValueAt(data, x, y);
	}
	public void addRowJTableLC(String [] deptData) {
			defaultTableModelLC.addRow(deptData);		
		}
} 
