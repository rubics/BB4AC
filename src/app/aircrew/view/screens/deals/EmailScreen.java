package app.aircrew.view.screens.deals;

import rubyx.custom_fields.ListItem;
import net.rim.device.api.ui.Manager;
import net.rim.device.api.ui.component.NullField;
import net.rim.device.api.ui.container.MainScreen;
import net.rim.device.api.ui.container.VerticalFieldManager;
import net.rim.device.api.ui.decor.BackgroundFactory;
import app.aircrew.models.Images;
import app.aircrew.view.fields.ScreenTitle;
import app.aircrew.view.fields.deals.CompositeDealLabel;
import app.aircrew.view.managers.deals.AboutDealScreenManager;

public class EmailScreen extends MainScreen{
	private AboutDealScreenManager dealsInfo;
	
	private Manager manager;
	
	public EmailScreen(AboutDealScreenManager _dealsInfo){
		super(Manager.USE_ALL_HEIGHT | Manager.NO_VERTICAL_SCROLL);
		dealsInfo = _dealsInfo;
		Manager mainManager = getMainManager();
		mainManager.setBackground(BackgroundFactory.createBitmapBackground(Images.screen_background));
		setTitle(new ScreenTitle("Email"));
		manager = new VerticalFieldManager(Manager.VERTICAL_SCROLL | Manager.VERTICAL_SCROLLBAR);
		add(manager);
		manager.add(new NullField());
		manager.add(new ListItem(dealsInfo.deal, false));
		manager.add(new CompositeDealLabel(dealsInfo.deal.image,dealsInfo.deal.description, null));
	}
	
	public boolean isDirty() {
	    return false;
	}
}
