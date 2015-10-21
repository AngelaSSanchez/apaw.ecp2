package apaw.ecp2.rest.business.views;

import apaw.ecp2.web.presentation.models.Model;

public class BusinessThemeManagerView extends Model {
	
	private String themename;

	public BusinessThemeManagerView(String themename){
		this.themename = themename;
	}
	
	public String getThemeName(){
		return this.themename;
	}
}
