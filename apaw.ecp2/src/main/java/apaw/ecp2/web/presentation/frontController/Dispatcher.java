package apaw.ecp2.web.presentation.frontController;

import apaw.ecp2.web.http.HttpRequest;
import apaw.ecp2.web.http.HttpResponse;

import apaw.ecp2.web.presentation.models.Model;
import apaw.ecp2.web.presentation.presenters.ThemeManager;
import apaw.ecp2.web.presentation.presenters.Voting;
import apaw.ecp2.web.presentation.views.ErrorView;
import apaw.ecp2.web.presentation.views.ThemeManagerView;
import apaw.ecp2.web.presentation.views.View;
import apaw.ecp2.web.presentation.views.VotingView;


public class Dispatcher {

	public void doPost(HttpRequest request, HttpResponse response){
        Model model = new Model();
        String controller = request.getPath();
        String action = request.getParams().get("action");
        String nextView = request.getPath() + "View";

        switch (controller) {
        case "Voting":
            Voting voting = new Voting();
            if ("voteTheme".equals(action)) {
                voting.setThemeName((request.getParams().get("themeName")));
                voting.setValue((Integer.valueOf(request.getParams().get("value"))));
                nextView = voting.voteTheme(model);
            } else {
                model.put("error", "Acción no permitida: " + action);
            }
            break;
        case "ThemeManager":
            ThemeManager thememanager = new ThemeManager();
            if ("createTheme".equals(action)) {
            	thememanager.setThemeName(request.getParams().get("themeName"));
                nextView = thememanager.createTheme(model);  
            } else {
                model.put("error", "Acción no permitida: " + action);
            }
            break;
        }
        this.show(nextView, model);
	}
	
	public void doGet(HttpRequest request, HttpResponse response){
        Model model = new Model();
        String controller = request.getPath();
        String nextView = request.getPath()+"View";

        switch (controller) {
        case "Voting":
            Voting voting = new Voting();
            nextView = voting.process(model);
            break;
        case "ThemeManager":
            ThemeManager thememanager = new ThemeManager();
            nextView = thememanager.process(model);
            break;
        }
        this.show(nextView, model);
	}

	private void show(String nextView, Model model) {
        View view;
        switch (nextView) {
        case "VotingView":
            view = new VotingView();
            break;
        case "ThemeManagerView":
            view = new ThemeManagerView();
            break;
        default:
            view = new ErrorView();
            model.put("error", "Vista no encontrada: " + nextView);
        }
        view.show(model);
	}
}
