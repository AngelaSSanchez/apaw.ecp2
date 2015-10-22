package apaw.ecp2.web.presentation.views;

import apaw.ecp2.web.presentation.models.Model;

public class VotingView implements View{

	@Override
	public void show(Model model) {
		System.out.println("Theme Manager Page \n   Temas: " + model.get("vote"));
	}

}
