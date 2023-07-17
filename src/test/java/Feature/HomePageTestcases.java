package Feature;
import org.testng.annotations.Test;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import bussinesLayer.HomePagerelatedMethodsandXpaths;
import bussinesLayer.loginrelatedMethodsandXpaths;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HomePageTestcases {
	
	
		
	WebDriver driver ;

	@BeforeTest
	public void Browsersetup()  {
		

		     WebDriverManager.chromedriver().setup();
		       driver = new ChromeDriver();
		       driver.manage().deleteAllCookies();
		       driver.manage().window().maximize();

	}
		
	@Test(groups= {"smoke"})
		public void HomepageTest() throws InterruptedException, FileNotFoundException, IOException, ParseException {
			
			loginrelatedMethodsandXpaths a = new loginrelatedMethodsandXpaths(driver);
			HomePagerelatedMethodsandXpaths b = new HomePagerelatedMethodsandXpaths(driver);
			a.readLocators();
			a.readData();
			a.Login();
			b.clickOnaddTocart();
			a.quit();	
		}

	}



