package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.AdminModel;
import model.LoginModel;
import model.SecretaryModel;
import view.AdminView;
import view.LoginView;
import view.SecretaryView;

public class LoginController {

	LoginView view;
	LoginModel model;
	
	public LoginController(LoginView v, LoginModel m) {
		
		view = v;
		model = m;
		
		loginButton();
	}
	public void loginButton() {
		
		view.addLoginButtonListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String user = model.checkUser(view.getUsername(), view.getPassword());
				if (user.equals("admin")) {					
					view.dispose();
					AdminView view = new AdminView();
					AdminModel model = new AdminModel();
					AdminController controller = new AdminController(view, model);
					view.setVisible(true);
				}
				else if (user.equals("error")) {					
					view.displayMessage("Please enter valid Username and Password!!!");
				}
				else {
					view.dispose();
					SecretaryView view = new SecretaryView();
					SecretaryModel model = new SecretaryModel();
					model.setSecretary(user);
					SecretaryController controller = new SecretaryController(view, model);
					view.setVisible(true);
				}
			}
		});
	}
}
