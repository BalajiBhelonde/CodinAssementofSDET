package Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomepageWikipedia {

	
	@FindBy (xpath="(//td[@class='infobox-data'])[10]") 
	private WebElement releasedate;
	
	@FindBy (xpath="(//td[@class='infobox-data'])[12]") 
	private WebElement country;
	
	public HomepageWikipedia(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public String getreleasedate() {
		String date=releasedate.getText();
		return date;		
	}
	
	public String getcountry() {
		String countryname=country.getText();
		return countryname;	
	}
}
