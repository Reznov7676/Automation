package Feature;

import org.testng.annotations.Test;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import bussinesLayer.loginrelatedMethodsandXpaths;
import io.github.bonigarcia.wdm.WebDriverManager;

public class YerunHoga {
	
WebDriver driver ;






@BeforeTest(groups= {"smoke"})
public void Browsersetup()  {
	

	     WebDriverManager.chromedriver().setup();
	       driver = new ChromeDriver();
	       driver.manage().deleteAllCookies();
	       driver.manage().window().maximize();
	       //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	       System.out.println("beforetestmethod");
	       JavascriptExecutor js = (JavascriptExecutor) driver;
	       
	       WebElement ty = driver.findElement(By.xpath("test"));
	       
	       Actions A = new Actions (driver);
	       
A.click(ty).build().perform();   

	    

}

@AfterClass
public void quitbrowser() {
	
	driver.quit();
}
	
	@Test
	public void LoginTestCase() throws InterruptedException, FileNotFoundException, IOException, ParseException {
		
		loginrelatedMethodsandXpaths a = new loginrelatedMethodsandXpaths(driver);
		a.readLocators();
		a.readData();
		a.Login();
		a.clickOnaddTocart();
		//a.quit();	
	}
	
	@Test(groups= {"smoke"})
	public void flipkarttestcase() throws InterruptedException {
		
		driver.get("https://www.google.co.in/");
		//driver.findElement(By.xpath("/html/body/div[2]/div/div/button")).click();
		
		Thread.sleep(3000);
		
		WebElement elementName = driver.findElement(By.xpath("//*[@id=\"gb\"]/div/div[1]/div/div[1]/a"));
		 elementName.sendKeys(Keys.COMMAND,Keys.ENTER);
		 
		 WebElement elementName1=driver.findElement(By.xpath("//*[@id=\"gb\"]/div/div[1]/div/div[2]/a"));
		 elementName1.sendKeys(Keys.COMMAND,Keys.ENTER);
		 

		 
		 Set <String> w =driver.getWindowHandles();
		 
		 List <String> wq= new ArrayList<String>(w);

		 for(String y: wq) {
			 String title=driver.switchTo().window(y).getTitle();
			 //System.out.println(title);
			 if(title.contains("Google Images")) {
				 
				 driver.switchTo().window(y);
				String r= driver.getTitle();
				 System.out.println(r);
			 }
		 }

	}
	
	@Test(groups= {"smoke"})
	public void print() {
		//WebElement r=driver.findElement(By.xpath("//id[@tag='ndn']"));
	
//		WebDriverWait t = new WebDriverWait(driver , 10);
//		t.until(ExpectedConditions.visibilityOf(r));
//		
//		
//		List <WebElement> a=driver.findElements(By.xpath("//id[@tag='ndn']"));
		System.out.println("smoke");
	}
	
	
	@AfterGroups(groups= {"smoke"})
	public void rt() {
		
		
		
		
	}


	
	
	

}
