package apaw.ecp2.web.presentation.presenters;

import java.util.ArrayList;
import java.util.List;

import apaw.ecp2.rest.business.controllers.BusinessController;
import apaw.ecp2.rest.business.views.BusinessAverageView;
import apaw.ecp2.rest.business.views.BusinessVoteView;
import apaw.ecp2.web.presentation.models.Model;

public class Voting {
	
    private String themeName;
    private int value;
    
    public String voteTheme(Model model){
    	BusinessController bussinesscontroller = new BusinessController();
    	bussinesscontroller.voteTheme(new BusinessVoteView(themeName, value));
		List<BusinessAverageView> votes = bussinesscontroller.showVoting();
		List<String> showVotes = new ArrayList<String>();
        for (BusinessAverageView vote: votes) {
        	showVotes.add("[themeName=" + vote.getThemeName() + ", average=" + vote.getVoteValue() + "]");
        }
        model.put("vote", showVotes); 
		return "VotingView"; 
	}

	public String process(Model model) {
        //model.put("vote", "VotingView:process");
        return "VotingView";
	}

	public void setThemeName(String themeName) {
		this.themeName = themeName;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

}
