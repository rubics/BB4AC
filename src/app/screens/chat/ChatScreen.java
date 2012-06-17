package app.screens.chat;

import net.rim.device.api.ui.Color;
import net.rim.device.api.ui.Graphics;
import net.rim.device.api.ui.Manager;
import net.rim.device.api.ui.container.MainScreen;
import net.rim.device.api.ui.container.VerticalFieldManager;
import net.rim.device.api.ui.decor.BackgroundFactory;
import rubyx.custom_fields.ScreenBannar;
import rubyx.tabbedUI.TabbedButton;
import app.fields.chat.ChatMessageField;
import app.models.Images;

public class ChatScreen  extends MainScreen{
	
	private TabbedButton backButton;
	private TabbedButton homeButton;
	
	VerticalFieldManager vrm;
	
	public ChatScreen(){
		super(Manager.USE_ALL_HEIGHT | Manager.NO_VERTICAL_SCROLL | Manager.NO_VERTICAL_SCROLLBAR);
		Manager mainManager = getMainManager();
		mainManager.setBackground(BackgroundFactory.createBitmapBackground(Images.screen_background));
		
		backButton = new TabbedButton("Back", 6, 100, 36);
		backButton.setRVAlue(10);
		homeButton = new TabbedButton("Home", 6, 100, 36);
		homeButton.setRVAlue(10);
		
		setTitle(new ScreenBannar("Chat", 40, backButton, homeButton));
		
		vrm = new VerticalFieldManager(Manager.VERTICAL_SCROLL | Manager.VERTICAL_SCROLLBAR);
		vrm.add(new ChatMessageField(Images.avatar_a[0], "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut suscipit pulvinar justo vel ullamcorper.",true));
		vrm.add(new ChatMessageField(Images.avatar_a[1], Images.profile_pics[2],false));
		vrm.add(new ChatMessageField(Images.avatar_a[1], "Aenean nulla mi, scelerisque et rutrum vel, molestie eu elit. Nulla a ipsum ligula",false));
		vrm.add(new ChatMessageField(Images.avatar_a[0], Images.profile_pics[3],true));
		add(vrm);
	}
	
	public boolean isDirty() {
	    return false;
	}
}
