package app.aircrew.controller.user;

import helpers.org.json.me.JSONException;
import helpers.org.json.me.JSONObject;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.UiApplication;
import app.aircrew.models.SigninRequest;
import app.aircrew.models.User;
import app.aircrew.view.screens.DashboardScreen;
import app.aircrew.view.screens.SigninScreen;

public class UserController {
	
	private User user;
	private SigninScreen signinScreen;
	
	public SigninRequest signinRequest = new SigninRequest() {
		
		public void httpsuccess(byte[] array, String str){
			String json_response = new String(array);
			System.out.println(">> Json response: " + json_response);
			System.out.println();

			try {
				JSONObject json = new JSONObject(json_response);
				
				if(json.has("response") & !json.isNull("response")) {
					
					JSONObject response = json.getJSONObject("response");
					String message = response.getString("message");
					
					System.out.println("Message: " + message);			
					System.out.println();
					
					UiApplication.getUiApplication().popScreen(signinScreen);
					UiApplication.getUiApplication().pushScreen(DashboardScreen.createDashboardScreenInstance());

				} else {}
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		public void httpfailure(String errmsg) {}
	};
	
	//------------------------------------------------------------------------------//
	
	public UserController(){}
	
	public void pushSignInScreen(){
		signinScreen = new SigninScreen();
	}
}
