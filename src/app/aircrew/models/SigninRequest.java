package app.aircrew.models;

import helpers.org.json.me.JSONException;
import helpers.org.json.me.JSONObject;
import rubyx.httpconnection.HttpRequestDispatcher;
import rubyx.httpconnection.HttpRequestListener;

public abstract class SigninRequest implements HttpRequestListener{
	
	private static final String action = "index.php/iphone_4aircrew/login_phone";
	private static final String method = "POST";
	private HttpRequestListener requestListener = this;
	private static SigninRequest controller;
	private HttpRequestDispatcher dispatcher;
	
	public SigninRequest(){}
	
	public void sign_in(String userEmail, String password){
		dispatcher = new HttpRequestDispatcher(AirCrew.url + action, method, requestListener, "user_email="+userEmail+"&user_pass="+password);
		dispatcher.start();
	}

	public abstract void httpfailure(String errmsg);

	public abstract void httpsuccess(byte[] array, String str);
}
