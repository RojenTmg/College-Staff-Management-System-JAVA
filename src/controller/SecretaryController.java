package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.LoginModel;
import model.SecretaryModel;
import staff.ContractLecturer;
import staff.FullTimeLecturer;
import staff.PartTimeLecturer;
import view.LoginView;
import view.SecretaryView;

public class SecretaryController {
	
	SecretaryView view;
	SecretaryModel model;

	public SecretaryController(SecretaryView v, SecretaryModel m) {
		
		view = v;
		model = m;
		
		listener();
		displayData();
	}
	
	public void listener() {
		
		homeBtnAside();
		allTimeLaside();
		fullTimeLAside();
		partTimeLAside();
		contractLAside();
		addLogoutButtonListener();
		
		allTimeLHS();
		fullTimeLHS();
		partTimeLHS();
		contractLHS();
	}
	public void displayData() {
		
		displayAllTimeLecturer();
		displayAllFullTimeLecturer();
		displayAllPartTimeLecturer();
		displayAllContractLecturer();
	}
	
	public void homeBtnAside() {
		
		view.addHomeButtonListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				view.homeSectionPanelLink();
			}
		});
	}
	public void allTimeLaside() {
		
		view.addAllTimeLListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				view.allTimeLPanelLink();
			}
		});
	}
	public void fullTimeLAside() {
			
		view.addFullTimeLListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				view.fullTimeLPanelLink();
			}
		});
	}
	public void partTimeLAside() {
		
		view.addPartTimeLListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				view.partTimeLPanelLink();
			}
		});
	}
	public void contractLAside() {
		
		view.addContractLListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				view.contractLPanelLink();
			}
		});
	}
	public void addLogoutButtonListener() {
		
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

	public void allTimeLHS() {
		
		view.addAllTimeLListenerHS(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				view.allTimeLPanelLink();
			}
		});
	}
	public void fullTimeLHS() {
			
		view.addFullTimeLListenerHS(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				view.fullTimeLPanelLink();
			}
		});
	}
	public void partTimeLHS() {
		
		view.addPartTimeLListenerHS(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				view.partTimeLPanelLink();
			}
		});
	}
	public void contractLHS() {
		
		view.addContractLListenerHS(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				view.contractLPanelLink();
			}
		});
	}

	public void displayAllTimeLecturer() {
		for (FullTimeLecturer lec: model.findAllFullTimeLecturer()) {
			view.addRowJTableA(new String [] {Integer.toString(lec.getIdNo()), lec.getName(), lec.getAddress(), lec.getPhoneNo(), lec.getEmail(), lec.getDateStarted(), Integer.toString(lec.getSalary()), "-", "-", "full-time"});
		}
		for (PartTimeLecturer lec: model.findAllPartTimeLecturer()) {
			view.addRowJTableA(new String [] {Integer.toString(lec.getIdNo()), lec.getName(), lec.getAddress(), lec.getPhoneNo(), lec.getEmail(), lec.getDateStarted(), "-", Integer.toString(lec.getHourlyRate()), "-", "part-time"});
		}
		for (ContractLecturer lec: model.findAllContractLecturer()) {
			view.addRowJTableA(new String [] {Integer.toString(lec.getIdNo()), lec.getName(), lec.getAddress(), lec.getPhoneNo(), lec.getEmail(), lec.getDateStarted(), Integer.toString(lec.getSalary()), "-",lec.getDateExipiry(), "contract"});
		}
	}
	public void displayAllFullTimeLecturer() {
		for (FullTimeLecturer lec: model.findAllFullTimeLecturer()) {
			view.addRowJTableF(new String [] {Integer.toString(lec.getIdNo()), lec.getName(), lec.getAddress(), lec.getPhoneNo(), lec.getEmail(), lec.getDateStarted(), Integer.toString(lec.getSalary()), lec.getDepartment()});
		}
	}
	public void displayAllPartTimeLecturer() {
		for (PartTimeLecturer lec: model.findAllPartTimeLecturer()) {
			view.addRowJTableP(new String [] {Integer.toString(lec.getIdNo()), lec.getName(), lec.getAddress(), lec.getPhoneNo(), lec.getEmail(), lec.getDateStarted(), Integer.toString(lec.getHourlyRate()), lec.getDepartment()});
		}
	}
	public void displayAllContractLecturer() {
		for (ContractLecturer lec: model.findAllContractLecturer()) {
			view.addRowJTableC(new String [] {Integer.toString(lec.getIdNo()), lec.getName(), lec.getAddress(), lec.getPhoneNo(), lec.getEmail(), lec.getDateStarted(), Integer.toString(lec.getSalary()), lec.getDateExipiry(), lec.getDepartment()});
		}
	}
}
