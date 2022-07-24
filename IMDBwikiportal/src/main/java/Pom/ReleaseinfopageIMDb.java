package Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReleaseinfopageIMDb {

	@FindBy (xpath="(//table[@class='ipl-zebra-list ipl-zebra-list--fixed-first release-dates-table-test-only']//tr//td)[16]") 
	private WebElement country;
	

	@FindBy (xpath="(//table[@class='ipl-zebra-list ipl-zebra-list--fixed-first release-dates-table-test-only']//tr//td)[17]") 
	private WebElement releasedate;
	
	public ReleaseinfopageIMDb(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public String getcountryname() {
		String countryvalue=country.getText();
		return countryvalue;
	}
	
	public String getreleasedate() {
		String date=releasedate.getText();
		return date;
	}
}
