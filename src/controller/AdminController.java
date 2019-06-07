package controller;
import model.AdminModel;
import model.LoginModel;
import person.Department;
import staff.ContractLecturer;
import staff.FullTimeLecturer;
import staff.PartTimeLecturer;
import view.AdminView;
import view.LoginView;

import java.awt.event.*;

import javax.swing.JOptionPane;

public class AdminController {
	
	AdminView view;
	AdminModel model;
	
	public AdminController(AdminView v, AdminModel m) {
		
		view = v;
		model = m;
		
		listeners();
	}
	
	public void listeners() {

			
		homeBtnHSaside();
		asideBtnHSaside();
		departmentBtnHSaside();
		lecturerBtnHSaside();
		logoutButton();
		
		adminBtnHS();
		departmentBtnHS();
		lecturerBtnHS();
		
		addDepartmentLbl();
		updateViewDepartmentBtn();
		removeViewDepartmentBtn();
		viewDepartmentLbl();
		saveAddDepartmentBtn();
		updateAddDepartmentBtn();
		
		viewLecturerLbl();
		viewLecturerItemListener();
		addLecturerLbl();
		fullTimeLink();
		partTimeLink();
		contractTimeLink();
		
		updateViewLecturerBtn();
		removeViewLecturerBtn();
		saveAddLecturerBtn();
		updateAddLecturerBtn();
		
		displayAllDepartments();
		displayAllFullTimeLecturer();
		displayAllPartTimeLecturer();
		displayAllContractLecturer();
		displayAllDeptDropDown();
	}
	

	public void asideBtnHSaside() {
		
		view.addAdminButtonListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				view.adminPanelLink();
			}
		});
	}
	public void homeBtnHSaside() {
		
		view.addHomeButtonListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				view.homePagePanelLink();
			}
		});
	}
	public void departmentBtnHSaside() {
			
		view.addDepartmentButtonListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				view.departmentPanelLink();
			}
		});
	}
	public void lecturerBtnHSaside() {
		
		view.addLecturerButtonListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				view.lecturerPanelLink();
				displayAllDeptDropDown();
			}
		});
	}
	
	public void logoutButton() {
		
		view.addLogoutButtonListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				view.dispose();
				LoginView view = new LoginView();
				LoginModel model = new LoginModel();
				LoginController controller = new LoginController(view, model);
				
				view.setVisible(true);
			}
		});
	}
	public void adminBtnHS() {
		
		view.addAdminButtonListenerHS(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				view.adminPanelLink();
			}
		});
	}	
	public void departmentBtnHS() {
		
		view.addDepartmentButtonListenerHS(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				view.departmentPanelLink();
			}
		});
	}
	public void lecturerBtnHS() {
		
		view.addLecturerButtonListenerHS(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				view.lecturerPanelLink();
				displayAllDeptDropDown();
			}
		});
	}
	
	public void viewDepartmentLbl() {
	
		view.addViewDepartmentMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				view.departmentPanelLink();
			}
		});
	}
	public void updateViewDepartmentBtn() {
		
		view.updateViewDeptButtonListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					view.setDepartmentName(view.getValueAtJTable(view.getSelectedRowJTable(), 0));
					view.setDepartmentType(view.getValueAtJTable(view.getSelectedRowJTable(), 1));
					view.setDepartmentWebAddress(view.getValueAtJTable(view.getSelectedRowJTable(), 2));
					view.setDepartmentUsername(view.getValueAtJTable(view.getSelectedRowJTable(), 3));
					view.setDepartmentPassword(view.getValueAtJTable(view.getSelectedRowJTable(), 4));
					
					view.addDepartmentPanelLink();
				}
				catch (ArrayIndexOutOfBoundsException e) {
					JOptionPane.showMessageDialog(null, "Please select a data to be updated!!!");
				}
			}
		});
	}
	public void removeViewDepartmentBtn() {
		view.removeViewDeptButtonListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					model.removeDepartment(view.getValueAtJTable(view.getSelectedRowJTable(), 0));
					view.removeRowJTable(view.getSelectedRowJTable());
				}
				catch (ArrayIndexOutOfBoundsException e) {
					JOptionPane.showMessageDialog(null, "Please select a data to be removed!!!");
				}
			}
		});
	}
	public void addDepartmentLbl() {
		view.addAddDepartmentMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				view.emptyDepartment();	
				view.addDepartmentPanelLink();
			}
		});
	}
	public void saveAddDepartmentBtn() {		
		view.addSaveDeptButtonListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					model.addDepartment(view.getDepartmentName(), view.getDepartmentType(), view.getDepartmentWebAddress(), view.getDepartmentUsername(), view.getDepartmentPassword());
					view.addRowJTable(new String [] {view.getDepartmentName(), view.getDepartmentType(), view.getDepartmentWebAddress(), view.getDepartmentUsername(), view.getDepartmentPassword()});
					view.emptyDepartment();					
					view.viewDepartmentPanelLink();
			}
		});
	}
	public void updateAddDepartmentBtn() {
		
		view.addUpdateDeptButtonListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				model.updateDepartment(view.getValueAtJTable(view.getSelectedRowJTable(), 0), view.getDepartmentName(), view.getDepartmentType(), view.getDepartmentWebAddress(), view.getDepartmentUsername(), view.getDepartmentPassword());
				view.setValueAtJTable(view.getDepartmentName(), view.getSelectedRowJTable(), 0);
				view.setValueAtJTable(view.getDepartmentType(), view.getSelectedRowJTable(), 1);
				view.setValueAtJTable(view.getDepartmentWebAddress(), view.getSelectedRowJTable(), 2);
				view.setValueAtJTable(view.getDepartmentUsername(), view.getSelectedRowJTable(), 3);
				view.setValueAtJTable(view.getDepartmentPassword(), view.getSelectedRowJTable(), 4);
				view.emptyDepartment();
				view.viewDepartmentPanelLink();
			}
		});
	}
	
	public void viewLecturerLbl() {
		
		view.addViewLecturerMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				view.lecturerPanelLink();
			}
		});
	}
	public void viewLecturerItemListener() {
		view.viewLecPanelItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				view.viewLecPanelLink();
			}
		});
	}
	public void addLecturerLbl() {
		
		view.addAddLecturerMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				view.addLecturerPanelLink();
				view.emptyLecturer();	
				view.fullTimeLink();
			}
		});
	}
	
	public void fullTimeLink() {
			
		view.fullTimeLItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				view.fullTimeLink();
			}
		});
	}
	public void partTimeLink() {
		
		view.partTimeLItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				view.partTimeLink();
			}
		});
	}
	public void contractTimeLink() {
		
		view.contractTimeLItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				view.contractTimeLink();
			}
		});
	}

	public void saveAddLecturerBtn() {
		
		view.addSaveLecturerButtonListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (view.getSelectedIndexRBL() == 0) {
					try {
						model.addFullTimeLecturer(view.getLecId(), view.getlecName(), view.getlecAddress(), view.getlecPhNo(), view.getlecEmail(), view.getlecStarted(), view.getlecSalary(), view.getlecDept());
						view.addRowJTableL(new String [] {view.getLecId(), view.getlecName(), view.getlecAddress(), view.getlecPhNo(), view.getlecEmail(), view.getlecStarted(), view.getlecSalary(), view.getlecDept()});
						view.emptyLecturer();					
						view.setSelectedIndexL(0);
						view.viewLecturerPanelLink();
					}
					catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(null, "You entered invalid data!!!\nPlease enter number in the field, 'Identification Number' or 'Salary'.");
					}
				}
				else if (view.getSelectedIndexRBL() == 1) {
					try {
						model.addPartTimeLecturer(view.getLecId(), view.getlecName(), view.getlecAddress(), view.getlecPhNo(), view.getlecEmail(), view.getlecStarted(), view.getlecHRate(), view.getlecDept());
						view.addRowJTableLP(new String [] {view.getLecId(), view.getlecName(), view.getlecAddress(), view.getlecPhNo(), view.getlecEmail(), view.getlecStarted(), view.getlecHRate(), view.getlecDept()});
						view.emptyLecturer();					
						view.setSelectedIndexL(1);
						view.viewLecturerPanelLink();
					}
					catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(null, "You entered invalid data!!!\nPlease enter number in the field, 'Identification Number' or 'Hourly Rate'.");
					}
				}
				else if (view.getSelectedIndexRBL() == 2) {
					try {
						model.addContractLecturer(view.getLecId(), view.getlecName(), view.getlecAddress(), view.getlecPhNo(), view.getlecEmail(), view.getlecStarted(), view.getlecSalary(), view.getlecContractEx(), view.getlecDept());
						view.addRowJTableLC(new String [] {view.getLecId(), view.getlecName(), view.getlecAddress(), view.getlecPhNo(), view.getlecEmail(), view.getlecStarted(), view.getlecSalary(), view.getlecContractEx(), view.getlecDept()});
						view.emptyLecturer();					
						view.setSelectedIndexL(2);
						view.viewLecturerPanelLink();
					}
					catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(null, "You entered invalid data!!!\nPlease enter number in the field, 'Identification Number' or 'Salary'.");
					}
				}
			}
		});
	}
	public void updateViewLecturerBtn() {
		
		view.updateViewLecturerButtonListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (view.getSelectedIndexL() == 0) {
					try {
						view.setLecId(view.getValueAtJTableL(view.getSelectedRowJTableL(), 0));
						view.setlecName(view.getValueAtJTableL(view.getSelectedRowJTableL(), 1));
						view.setlecAddress(view.getValueAtJTableL(view.getSelectedRowJTableL(), 2));
						view.setlecPhNo(view.getValueAtJTableL(view.getSelectedRowJTableL(), 3));
						view.setlecEmail(view.getValueAtJTableL(view.getSelectedRowJTableL(), 4));
						view.setlecStarted(view.getValueAtJTableL(view.getSelectedRowJTableL(), 5));
						view.setlecSalary(view.getValueAtJTableL(view.getSelectedRowJTableL(), 6));
						view.setlecDept(view.getValueAtJTableL(view.getSelectedRowJTableL(), 7));
						
						view.setSelectedIndexRBL(0);
						view.fullTimeLink();
						view.addLecturerPanelLink();
					}
					catch (ArrayIndexOutOfBoundsException e) {
						JOptionPane.showMessageDialog(null, "Please select a data to be updated!!!");
					}
				}
				else if (view.getSelectedIndexL() == 1) {
					try {
						view.setLecId(view.getValueAtJTableLP(view.getSelectedRowJTableLP(), 0));
						view.setlecName(view.getValueAtJTableLP(view.getSelectedRowJTableLP(), 1));
						view.setlecAddress(view.getValueAtJTableLP(view.getSelectedRowJTableLP(), 2));
						view.setlecPhNo(view.getValueAtJTableLP(view.getSelectedRowJTableLP(), 3));
						view.setlecEmail(view.getValueAtJTableLP(view.getSelectedRowJTableLP(), 4));
						view.setlecStarted(view.getValueAtJTableLP(view.getSelectedRowJTableLP(), 5));
						view.setlecHRate(view.getValueAtJTableLP(view.getSelectedRowJTableLP(), 6));
						view.setlecDept(view.getValueAtJTableLP(view.getSelectedRowJTableLP(), 7));
						
						view.setSelectedIndexRBL(1);
						view.addLecturerPanelLink();
					}
					catch (ArrayIndexOutOfBoundsException e) {
						JOptionPane.showMessageDialog(null, "Please select a data to be updated!!!");
					}
				}
				else if (view.getSelectedIndexL() == 2) {
					try {
						view.setLecId(view.getValueAtJTableLC(view.getSelectedRowJTableLC(), 0));
						view.setlecName(view.getValueAtJTableLC(view.getSelectedRowJTableLC(), 1));
						view.setlecAddress(view.getValueAtJTableLC(view.getSelectedRowJTableLC(), 2));
						view.setlecPhNo(view.getValueAtJTableLC(view.getSelectedRowJTableLC(), 3));
						view.setlecEmail(view.getValueAtJTableLC(view.getSelectedRowJTableLC(), 4));
						view.setlecStarted(view.getValueAtJTableLC(view.getSelectedRowJTableLC(), 5));
						view.setlecSalary(view.getValueAtJTableLC(view.getSelectedRowJTableLC(), 6));
						view.setlecContractEx(view.getValueAtJTableLC(view.getSelectedRowJTableLC(), 7));
						view.setlecDept(view.getValueAtJTableLC(view.getSelectedRowJTableLC(), 8));
						
						view.setSelectedIndexRBL(2);
						view.addLecturerPanelLink();
					}
					catch (ArrayIndexOutOfBoundsException e) {
						JOptionPane.showMessageDialog(null, "Please select a data to be updated!!!");
					}
				}
			}
		});
	}
	public void removeViewLecturerBtn() {
		view.removeViewLecturerButtonListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (view.getSelectedIndexL() == 0) 
					try {
						model.removeFullTimeLecturer(view.getValueAtJTableL(view.getSelectedRowJTableL(), 0));
						view.removeRowJTableL(view.getSelectedRowJTableL());
					}
					catch (ArrayIndexOutOfBoundsException e) {
						JOptionPane.showMessageDialog(null, "Please select a data to be removed!!!");
					}
				else if (view.getSelectedIndexL() == 1) 
					try {
						model.removePartTimeLecturer(view.getValueAtJTableLP(view.getSelectedRowJTableLP(), 0));
						view.removeRowJTableLP(view.getSelectedRowJTableLP());
					}
					catch (ArrayIndexOutOfBoundsException e) {
						JOptionPane.showMessageDialog(null, "Please select a data to be removed!!!");
					}
				else if (view.getSelectedIndexL() == 2) 
					try {
						model.removeContractLecturer(view.getValueAtJTableLC(view.getSelectedRowJTableLC(), 0));
						view.removeRowJTableLC(view.getSelectedRowJTableLC());
					}
					catch (ArrayIndexOutOfBoundsException e) {
						JOptionPane.showMessageDialog(null, "Please select a data to be removed!!!");
					}
			}
		});
	}
	public void updateAddLecturerBtn() {
		
		view.addUpdateLecturerButtonListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (view.getSelectedIndexRBL() == 0) {
					try {
						model.updateFullTimeLecturer(view.getValueAtJTableL(view.getSelectedRowJTableL(), 0), view.getLecId(), view.getlecName(), view.getlecAddress(), view.getlecPhNo(), view.getlecEmail(), view.getlecStarted(), view.getlecSalary(), view.getlecDept());
						view.setValueAtJTableL(view.getLecId(), view.getSelectedRowJTableL(), 0);
						view.setValueAtJTableL(view.getlecName(), view.getSelectedRowJTableL(), 1);
						view.setValueAtJTableL(view.getlecAddress(), view.getSelectedRowJTableL(), 2);
						view.setValueAtJTableL(view.getlecPhNo(), view.getSelectedRowJTableL(), 3);
						view.setValueAtJTableL(view.getlecEmail(), view.getSelectedRowJTableL(), 4);
						view.setValueAtJTableL(view.getlecStarted(), view.getSelectedRowJTableL(), 5);
						view.setValueAtJTableL(view.getlecSalary(), view.getSelectedRowJTableL(), 6);
						view.setValueAtJTableL(view.getlecDept(), view.getSelectedRowJTableL(), 7);
						view.emptyLecturer();
						view.setSelectedIndexL(0);
						view.viewLecturerPanelLink();
					} catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(null, "You entered invalid data!!!\nPlease enter number in the field, 'Identification Number' or 'Salary'.");
					}
				}
				else if (view.getSelectedIndexRBL() == 1) {
					try {
						model.updatePartTimeLecturer(view.getValueAtJTableLP(view.getSelectedRowJTableLP(), 0), view.getLecId(), view.getlecName(), view.getlecAddress(), view.getlecPhNo(), view.getlecEmail(), view.getlecStarted(), view.getlecHRate(), view.getlecDept());
						view.setValueAtJTableLP(view.getLecId(), view.getSelectedRowJTableLP(), 0);
						view.setValueAtJTableLP(view.getlecName(), view.getSelectedRowJTableLP(), 1);
						view.setValueAtJTableLP(view.getlecAddress(), view.getSelectedRowJTableLP(), 2);
						view.setValueAtJTableLP(view.getlecPhNo(), view.getSelectedRowJTableLP(), 3);
						view.setValueAtJTableLP(view.getlecEmail(), view.getSelectedRowJTableLP(), 4);
						view.setValueAtJTableLP(view.getlecStarted(), view.getSelectedRowJTableLP(), 5);
						view.setValueAtJTableLP(view.getlecHRate(), view.getSelectedRowJTableLP(), 6);
						view.setValueAtJTableLP(view.getlecDept(), view.getSelectedRowJTableLP(), 7);
						view.emptyLecturer();
						view.setSelectedIndexL(1);
						view.viewLecturerPanelLink();
					} catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(null, "You entered invalid data!!!\nPlease enter number in the field, 'Identification Number' or 'Hour Rate'.");
					}
				}
				else if (view.getSelectedIndexRBL() == 2) {
					try {
						model.updateContractLecturer(view.getValueAtJTableLC(view.getSelectedRowJTableLC(), 0), view.getLecId(), view.getlecName(), view.getlecAddress(), view.getlecPhNo(), view.getlecEmail(), view.getlecStarted(), view.getlecSalary(), view.getlecContractEx(), view.getlecDept());
						view.setValueAtJTableLC(view.getLecId(), view.getSelectedRowJTableLC(), 0);
						view.setValueAtJTableLC(view.getlecName(), view.getSelectedRowJTableLC(), 1);
						view.setValueAtJTableLC(view.getlecAddress(), view.getSelectedRowJTableLC(), 2);
						view.setValueAtJTableLC(view.getlecPhNo(), view.getSelectedRowJTableLC(), 3);
						view.setValueAtJTableLC(view.getlecEmail(), view.getSelectedRowJTableLC(), 4);
						view.setValueAtJTableLC(view.getlecStarted(), view.getSelectedRowJTableLC(), 5);
						view.setValueAtJTableLC(view.getlecSalary(), view.getSelectedRowJTableLC(), 6);
						view.setValueAtJTableLC(view.getlecContractEx(), view.getSelectedRowJTableLC(), 7);
						view.setValueAtJTableLC(view.getlecDept(), view.getSelectedRowJTableLC(), 8);
						view.emptyLecturer();
						view.setSelectedIndexL(2);
						view.viewLecturerPanelLink();
					} catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(null, "You entered invalid data!!!\nPlease enter number in the field, 'Identification Number' or 'Salary'.");
					}
				}
			}
		});
	}
	public void displayAllDeptDropDown() {
		view.removeElementLecDCBM();
		model.findAllDepartment();
		for (String dept: model.findAllDepartmentDropDown()) {		
			view.addElementLecDCBM(dept);
		}
	}
	
	public void displayAllDepartments() {
		for (Department dept : model.findAllDepartment()) {
			view.addRowJTable(new String [] {dept.getDeptName(), dept.getDepttype(), dept.getDeptWebAddress(), dept.getDeptUsername(), dept.getDeptPassword()});
		}
	}
	
	public void displayAllFullTimeLecturer() {
		for (FullTimeLecturer lec: model.findAllFullTimeLecturer()) {
			view.addRowJTableL(new String [] {Integer.toString(lec.getIdNo()), lec.getName(), lec.getAddress(), lec.getPhoneNo(), lec.getEmail(), lec.getDateStarted(), Integer.toString(lec.getSalary()), lec.getDepartment()});
		}
	}
	public void displayAllPartTimeLecturer() {
		for (PartTimeLecturer lec: model.findAllPartTimeLecturer()) {
			view.addRowJTableLP(new String [] {Integer.toString(lec.getIdNo()), lec.getName(), lec.getAddress(), lec.getPhoneNo(), lec.getEmail(), lec.getDateStarted(), Integer.toString(lec.getHourlyRate()), lec.getDepartment()});
		}
	}
	public void displayAllContractLecturer() {
		for (ContractLecturer lec: model.findAllContractLecturer()) {
			view.addRowJTableLC(new String [] {Integer.toString(lec.getIdNo()), lec.getName(), lec.getAddress(), lec.getPhoneNo(), lec.getEmail(), lec.getDateStarted(), Integer.toString(lec.getSalary()), lec.getDateExipiry(), lec.getDepartment()});
		}
	}
}
