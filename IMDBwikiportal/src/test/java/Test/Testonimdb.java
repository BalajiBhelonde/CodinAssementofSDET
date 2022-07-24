package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Base.Pojo;
import Pom.HomepageIMDB;
import Pom.ReleaseinfopageIMDb;

public class Testonimdb extends Pojo {
	
	private WebDriver driver;
	private HomepageIMDB homepageimdb;
	private ReleaseinfopageIMDb releasedate;

	@BeforeTest()
	@Parameters("browser")
	public void beforetest(String browser) {
		System.out.println("browser launched");
		if(browser.equals("Chrome"))
		{
			driver = openchromebrowser();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@BeforeClass()
	public void beforeclass() {
		 homepageimdb=new HomepageIMDB(driver);
		 releasedate=new ReleaseinfopageIMDb(driver);
	}
	
	@BeforeMethod()
	public void beforemethod() {
		System.out.println("IMDb Launched");
		driver.get("https://www.imdb.com/title/tt9389998/");
	}
	
	@Test()
	public void verfiyreleasedatecounrty() {
		System.out.println("Verifyingreleasedate&country");
		homepageimdb.clickonreleasedate();
		String country=releasedate.getcountryname();
		System.out.println(country);
		String date=releasedate.getreleasedate();
		System.out.println(date);
		Assert.assertEquals(country, "India");
		Assert.assertEquals(date, "17 December 2021");
		
	}
	
	@AfterMethod()
	public void aftermethod() {
		
	}
	
	@AfterClass()
	public void afterclass() {
		homepageimdb=null;
		releasedate=null;
	}
	
	@AfterTest()
	public void aftertest() {
		driver.quit();
		driver=null;
		System.gc();
	}
}
