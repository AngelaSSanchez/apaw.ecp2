package apaw.ecp2.rest.business.views;

public class BusinessVoteView {
	
	private String themeName;
	private double value;

	public BusinessVoteView(String themeName, double value){
		this.themeName = themeName;
		this.value = value;
	}
	
	public String getThemeName(){
		return this.themeName;
	}
	
	public double getVoteValue(){
		return this.value;
	}
	
	public int getVoteValueInt(){
		return (int) this.value;
	}
	
}
