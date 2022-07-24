package Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomepageIMDB {

	@FindBy (xpath="(//ul[@class='ipc-metadata-list ipc-metadata-list--dividers-all ipc-metadata-list--base']//li//div//a)[1]") 
	private WebElement releasedate;
	
	public HomepageIMDB(WebDriver driver){
		
		PageFactory.initElements(driver, this);
	}
	
	public void clickonreleasedate() {
		releasedate.click();
	}
}
