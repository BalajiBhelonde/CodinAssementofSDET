package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Pojo {

	public static WebDriver openchromebrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\balaji\\chromedriver_win32 (3)\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		return driver;
	}
	
}
