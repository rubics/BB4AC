package app.aircrew.view.managers.deals;

import net.rim.device.api.system.Bitmap;
import net.rim.device.api.system.Display;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.Manager;
import net.rim.device.api.ui.container.HorizontalFieldManager;
import net.rim.device.api.ui.container.MainScreen;
import rubyx.custom_fields.CustomButton;
import rubyx.tabbedUI.TabbedScreenManager;
import app.aircrew.models.Images;
import app.aircrew.view.screens.chat.ChatRoomScreen;
import app.aircrew.view.screens.chat.FilterScreen;
import app.aircrew.view.screens.chat.HistoryScreen;
import app.aircrew.view.screens.chat.NearMeScreen;
import app.aircrew.view.screens.deals.SearchResultScreen;

public class DealsScreenManager {
	private Bitmap[] images = Images.deals_tabbed_button;
	
	private TabbedScreenManager tabbedScreenManager;	
	private MainScreen[] tabbedScreens = new MainScreen[4];
	private Field[] tabbedButtons = new Field[4];
	private Manager tabbedButtonManager;
	
	public DealsScreenManager(){
		
		tabbedScreens[0]= new SearchResultScreen();
		tabbedScreens[1] = new FilterScreen();

		
		tabbedButtonManager = new HorizontalFieldManager();
		
		for(int i=0; i<2; i++){
			tabbedButtons[i] = new CustomButton(images[i], Display.getWidth()/2, 50);
			tabbedButtonManager.add(tabbedButtons[i]);
		}
		
		tabbedScreenManager = new TabbedScreenManager(tabbedScreens, tabbedButtonManager);
	}
	public void pushScreen(){
		if(tabbedScreenManager != null)
			tabbedScreenManager.pushScreen();
	}
}