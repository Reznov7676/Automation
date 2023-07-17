package bussinesLayer;



import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class loginrelatedMethodsandXpaths {
	
	WebDriver driver ;
	JSONParser readFiles;
	JSONObject re;
	String Url;
	String User_name;
	String Password ;
	String Submit_btn;
	String AddtoCart_btn;
	String usr;
	String pwd ;
	
	
	public loginrelatedMethodsandXpaths(WebDriver driver) {
		this.driver = driver ;
	}

	public void readLocators() throws FileNotFoundException, IOException, ParseException  {
		
		 readFiles = new JSONParser();
		 re = (JSONObject) readFiles.parse(new FileReader("/Users/jaymaldikar/eclipse-workspace/PageObjectModel_currentlyworking/json/locators.json"));
		 Url =(String) re.get("Portal_url");
		 User_name =(String) re.get("username");
		 Password =(String) re.get("password");
		 Submit_btn =(String) re.get("Login_btn");
		 AddtoCart_btn = (String) re.get("ClickonAddtoCart_btn");
		

		
	}
	
	public void readData() throws FileNotFoundException, IOException, ParseException  {
		
		 readFiles = new JSONParser();
		 re = (JSONObject) readFiles.parse(new FileReader("/Users/jaymaldikar/eclipse-workspace/PageObjectModel_currentlyworking/json/Testdata.jason"));
		 usr =(String) re.get("Data_username");
		 pwd =(String) re.get("Data_password");
		
	}
	
	
	public void Login() throws InterruptedException {
			
		driver.get(Url);
		driver.findElement(By.xpath(User_name)).sendKeys(usr);
		driver.findElement(By.xpath(Password)).sendKeys(pwd);
		driver.findElement(By.xpath(Submit_btn)).click();
	    Thread.sleep(3000);
	}

	
	public void quit() throws InterruptedException {
		Thread.sleep(7000);
		driver.quit();
	}
	
	

	public void clickOnaddTocart() {
		String b [] = {"Sauce Labs Backpack","Sauce Labs Bike Light","Sauce Labs Fleece Jacket"};
		//String b  = "Sauce Labs Bike Light";
		//String a =driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div")).getText();
		List<WebElement> gt =driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
		for(int i=0;i<=gt.size()-1;i++) {
			
			
			String p = gt.get(i).getText();
			//System.out.println(p);
			
			List names = Arrays.asList(b);

			
		if (names.contains(p)) {
		
			    driver.findElements(By.cssSelector(".btn")).get(i).click();
				
       }
			
			
			
    }
		   
	   

   }
	
}
