package apaw.ecp2.web.presentation.views;

import apaw.ecp2.web.presentation.models.Model;

public class ThemeManagerView implements View{

	@Override
	public void show(Model model) {
		System.out.println("Theme Manager Page \n   Temas: " + model.get("thememanager"));
	}

}
