package apaw.ecp2.rest.business.views;

public class BusinessAverageView {

	private double value;
	private String themeName;

	public BusinessAverageView(String themeName, double value){
		this.themeName = themeName;
		this.value = value;
	}
	
	public double getVoteValue(){
		return this.value;
	}
	
	public String getThemeName(){
		return this.themeName;
	}
}
