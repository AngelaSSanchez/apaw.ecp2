package apaw.ecp2.rest.business.controllers;

import java.util.ArrayList;
import java.util.List;

import apaw.ecp2.rest.business.views.BusinessThemeManagerView;
import apaw.ecp2.rest.business.views.BusinessVoteView;
import apaw.ecp2.rest.data.models.daos.DaoFactory;
import apaw.ecp2.rest.data.models.entities.Theme;
import apaw.ecp2.rest.data.models.entities.Vote;

public class BusinessController {
	
	private int idV, idT = 0;
	private Theme theme;
	
	public void voteTheme(BusinessVoteView voteview){
		idV = DaoFactory.getFactory().getVoteDao().findAll().size();
		theme = DaoFactory.getFactory().getThemeDao().findByName(voteview.getThemeName());
		DaoFactory.getFactory().getVoteDao().create(new Vote(idV, voteview.getVoteValueInt(), theme));
	}
	
	public List<BusinessVoteView> showVoting(){
		List<BusinessVoteView> listVote = new ArrayList<BusinessVoteView>();
		List<Vote> vote;		
		List<Theme> themes = DaoFactory.getFactory().getThemeDao().findAll();
		for (Theme theme : themes){			
			vote = DaoFactory.getFactory().getVoteDao().findByTheme(theme);
			listVote.add(new BusinessVoteView(theme.getName(), calculateAverage(vote))); 			
		}
		return listVote;
	}
	
	private double calculateAverage(List<Vote> vote) {
		int themenumber = 0;
		double average = 0;
		for (Vote votes: vote){
			themenumber++;
			average += votes.getVote();
		}
		return average/themenumber;
	}

	public void createTheme(BusinessThemeManagerView themeview){
		idT = DaoFactory.getFactory().getThemeDao().findAll().size();
		DaoFactory.getFactory().getThemeDao().create(new Theme(idT, themeview.getThemeName()));
	}
	
	public List<BusinessThemeManagerView> showThemeManger(){
		List<BusinessThemeManagerView> listTheme = new ArrayList<BusinessThemeManagerView>();;
		List<Theme> themes = DaoFactory.getFactory().getThemeDao().findAll();
		for (Theme theme : themes){			
			listTheme.add(new BusinessThemeManagerView(theme.getName())); 			
		}
		return listTheme;
	}
	
}
