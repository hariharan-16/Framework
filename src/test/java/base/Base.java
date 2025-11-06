package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.Utilities;

public class Base {
	
	public WebDriver driver;
	public Properties prop;
	FileInputStream file;
	
	public Base() throws IOException {
		prop = new Properties();
		file = new FileInputStream("src/main/java/config/Config.properties");
		prop.load(file);
	}
	
	public WebDriver initializeBrowser(String browser) throws IOException {
		
		WebDriverManager.chromedriver().setup();
		if(browser.equals("chrome")) {
			driver = new ChromeDriver();
		}else if(browser.equals("edge")) {
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.PAGE_LOAD_TIMEOUT));
		
		driver.get(prop.getProperty("url"));
		
		return driver;
	}
}
