package app;

import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.UiApplication;
import app.aircrew.controller.user.UserController;
import app.aircrew.view.screens.SigninScreen;
import app.aircrew.view.screens.SplashScreen;

public class AirCrewApp extends UiApplication {
	
	public static AirCrewApp app;
	public static UserController userController;
	
	public static AirCrewApp createAirCrewInstance(){
		if(app == null)
			return new AirCrewApp();
		else
			return app;
	}

	protected AirCrewApp(){
		userController = new UserController();
		userController.pushSignInScreen();
		SplashScreen splash = new SplashScreen((float) 0.5);
		pushScreen(splash);
	}
	
	public static void main(String [] args){
		AirCrewApp app = AirCrewApp.createAirCrewInstance();
		app.enterEventDispatcher();
	}
	
	public static final FieldChangeListener backButtonListener = new FieldChangeListener() {
		
		public void fieldChanged(Field field, int context) {
			UiApplication.getUiApplication().popScreen(field.getScreen());
		}
	};
}
