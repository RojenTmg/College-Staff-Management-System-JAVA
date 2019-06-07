import controller.LoginController;
import model.LoginModel;
import view.LoginView;

public class SystemsMVC {
	
	public static void main(String[] args) {
		
		LoginView view = new LoginView();
		LoginModel model = new LoginModel();
		LoginController controller = new LoginController(view, model);
		
		view.setVisible(true); 
	}
}
