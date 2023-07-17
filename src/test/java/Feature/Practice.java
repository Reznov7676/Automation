package Feature;

import org.testng.annotations.Test;
import java.io.*;
import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Practice{

	
	WebDriver driver ;
	
	
	

	
//	@AfterTest
//	public void ew() {
//		
//		driver.quit();
//	}

	@Test
	public void Browsersetup() throws IOException  {
		

		     WebDriverManager.chromedriver().setup();
		       driver = new ChromeDriver();
		       driver.manage().deleteAllCookies();
		       driver.manage().window().maximize();
		       driver.get("https://demo.seleniumeasy.com/basic-checkbox-demo.html");
		      // driver.switchTo().alert().dismiss();
		      //Boolean a = driver.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[1]/div[2]/div[1]/form/label[2]/input")).isSelected();
		      Boolean a = driver.findElement(By.xpath("//*[@id='isAgeSelected']")).isSelected();
		       if(a==true) {
		    	   System.out.println("checkbox is checked");
		       }
		       
		       else {
		    	   
		    	   System.out.println("checkbox is not checked");
		       }
		       
		       
		 
		       //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		       //WebDriverWait wait = new WebDriverWait(driver,20);
		     // WebElement a=  wait.until(ExpectedConditions.visibilityOf(By.xpath("//tagname[@attr='value']")));
		       //File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		       //Files.copy(f, new File("\\Users\\jaymaldikar\\eclipse-workspace\\PageObjectModel_currentlyworking\\src\\test\\java\\Feature\\test.png"));
	}
}



