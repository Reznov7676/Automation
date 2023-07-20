package Feature;
import bussinesLayer.loginrelatedMethodsandXpaths;
import org.testng.annotations.Test;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.ArrayList;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;


import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;



import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;



import io.github.bonigarcia.wdm.WebDriverManager;

public class YerunHoga {
	
WebDriver driver ;


@BeforeClass
public void Browsersetup()  {
	

	       WebDriverManager.chromedriver().setup();
	       driver = new ChromeDriver();
	       driver.manage().deleteAllCookies();
	       driver.manage().window().maximize();
	       driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	       System.out.println("hello");
  
}

@AfterTest
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

	}
	
	@Test
	public void flipkarttestcase() throws InterruptedException {
		
		driver.get("https://demo.seleniumeasy.com/basic-checkbox-demo.html");
		//driver.findElement(By.xpath("/html/body/div[2]/div/div/button")).click();
		
		Thread.sleep(3000);
		
		WebElement elementName = driver.findElement(By.xpath("/html/body/div[1]/div[2]/nav/div/div[1]/div/a"));
		 elementName.sendKeys(Keys.COMMAND,Keys.ENTER);
		 
		 WebElement elementName1=driver.findElement(By.xpath("//a[text()='Selenium Tutorials']"));
		 elementName1.sendKeys(Keys.COMMAND,Keys.ENTER);
		 

		 
		 Set <String> w =driver.getWindowHandles();
		 
		 List <String> wq= new ArrayList<String>(w);

		 for(String y: wq) {
			 String title=driver.switchTo().window(y).getTitle();
			 //System.out.println(title);
			 if(title.contains("500 Internal Server Error")) {
				 
				 driver.switchTo().window(y);
				String r= driver.getTitle();
				 System.out.println(r);
			 }
		 }

	}
	
	@Test
	public void print() {
//		WebElement r=driver.findElement(By.xpath("id[@tag='ndn']"));
//	
//		WebDriverWait t = new WebDriverWait(driver , 10);
//		t.until(ExpectedConditions.visibilityOf(r));
//		
//		
//		List <WebElement> a=driver.findElements(By.xpath("id[@tag='ndn']"));
		System.out.println("smoke");
	}
	
	@Test
	public void verifyTitle() {
		String ExpectedTitle="Google";
		
		driver.get("https://www.google.com");
		
		String ActualTitle=driver.getTitle();
		
		if(ExpectedTitle.equals(ActualTitle)) {
			
			System.out.println("Title is matching");
		}
		
	}
	
	@Test
	public void dragAnddrop() {
		
		driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame lazyloaded']")));
		WebElement src=driver.findElement(By.xpath("//img[@alt='The peaks of High Tatras']"));
		WebElement dst=driver.findElement(By.xpath("//*[@id='trash']"));
		Actions a = new Actions(driver);
		a.dragAndDrop(src, dst).build().perform();
		
		
		
		
	}


	
	
	

}
