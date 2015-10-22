package apaw.ecp2.web.presentation.presenters;

import java.util.ArrayList;
import java.util.List;

import apaw.ecp2.rest.business.controllers.BusinessController;
import apaw.ecp2.rest.business.views.BusinessThemeManagerView;
import apaw.ecp2.web.presentation.models.Model;

public class ThemeManager {
	
	private String themeName;

	public String process(Model model) {
        model.put("thememanager", "");
        return "ThemeManagerView";
	}
	
	public String createTheme(Model model){
		new BusinessController().createTheme(new BusinessThemeManagerView(this.themeName));
		List<BusinessThemeManagerView> themeManager = new BusinessController().showThemeManger();
		List<String> showThemes = new ArrayList<String>();
        for (BusinessThemeManagerView themes : themeManager){
			showThemes.add(themes.getThemeName());
        }
        model.put("thememanager", showThemes);
		return "ThemeManagerView";
	}

	public void setThemeName(String themename) {
		this.themeName = themename;
	}
}
