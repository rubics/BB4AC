package app.aircrew.view.screens.deals;

import net.rim.device.api.ui.Manager;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.container.MainScreen;
import net.rim.device.api.ui.decor.BackgroundFactory;
import app.aircrew.models.Images;
import app.aircrew.view.fields.ScreenTitle;
import app.aircrew.view.managers.deals.AboutDealScreenManager;

public class VideoScreen extends MainScreen{
	private AboutDealScreenManager dealsInfo;
	String [] airlines = {"Indian", "Air Deccan", "KingFisher", "Necon"};
	public VideoScreen(AboutDealScreenManager _dealsInfo){
		super(Manager.USE_ALL_HEIGHT | Manager.NO_VERTICAL_SCROLL | Manager.NO_VERTICAL_SCROLLBAR);
		dealsInfo = _dealsInfo;
		Manager mainManager = getMainManager();
		mainManager.setBackground(BackgroundFactory.createBitmapBackground(Images.screen_background));
		setTitle(new ScreenTitle("Video"));
		add(new LabelField("Video"));
	}
	
	public boolean isDirty() {
	    return false;
	}
}
