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
import Pom.HomepageWikipedia;
import Pom.ReleaseinfopageIMDb;

public class Testonwikipedia extends Pojo {

	private WebDriver driver;
	private HomepageWikipedia homepagewiki;
	
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
		 homepagewiki=new HomepageWikipedia(driver);
	}
	
	@BeforeMethod()
	public void beforemethod() {
		System.out.println("Wikipedia Launched");
		driver.get("https://en.wikipedia.org/wiki/Pushpa:_The_Rise");
	}
	
	@Test()
	public void verfiyreleasedatecounrty() {
		System.out.println("Verifyingreleasedate&country");
		String date=homepagewiki.getreleasedate();
		System.out.println(date);
		String country=homepagewiki.getcountry();
		System.out.println(country);
		Assert.assertEquals(country, "India");
		Assert.assertEquals(date, "17 December 2021");
	}
	
	@AfterMethod()
	public void aftermethod() {
		
	}
	
	@AfterClass()
	public void afterclass() {
		homepagewiki=null;
	}
	
	@AfterTest()
	public void aftertest() {
		driver.quit();
		driver=null;
		System.gc();
	}
}
