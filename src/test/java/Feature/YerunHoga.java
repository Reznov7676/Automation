package Feature;
import bussinesLayer.loginrelatedMethodsandXpaths;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.ArrayList;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;


import org.json.simple.parser.ParseException;
import org.junit.AfterClass;
import org.openqa.selenium.By;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

//import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class YerunHoga {
	
WebDriver driver ;


SoftAssert softAssert = new SoftAssert();





@BeforeClass
@Parameters("browser")
public void Browsersetup(String browser)  {
	

    if(browser.equals("chrome")){
     driver = new ChromeDriver();
     driver.manage().deleteAllCookies();
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
     System.out.println("hello");
}
    
    if(browser.equals("safari")){
        driver = new SafariDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        System.out.println("hello");
   }


}

//@DataProvider(name = "testData")
//public Object[][] provideTestData() {
////    return new Object[][] {
////        { "username1", "password1" ,"p1"},
////        { "username2", "password2" ,"p1"},
////        {"1" , "2","p1"},
////        // Add more test data as needed
////    };
//	
//	Object p[][]= {
//			{"s","v"},
//			{"v" , "v"}
//	};
//	
//	return p;
//}

//@Test(dataProvider = "testData")
//public void loginTest(String username, String password) {
//	
//	System.out.println(username + " "+password);
//	//System.out.println(password);
//}

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
	public void seleniumeasy() throws InterruptedException {
		
		driver.get("http://demo.seleniumeasy.com/basic-checkbox-demo.html");
		//driver.findElement(By.xpath("/html/body/div[2]/div/div/button")).click();
		
		Thread.sleep(3000);
		
	
			List <WebElement> checkboxes = driver.findElements(By.xpath("//label[@class='checkbox-inline']/input"));
			for(WebElement c : checkboxes) {

				if(c.isSelected()==false) {
					c.click();
				}
				else {
					
					System.out.println("fail");
				}
			}

	}
	
	@Test
	public void seleniumeasymultipleTabs() throws InterruptedException {
	
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
	//public void print() {
//		WebElement r=driver.findElement(By.xpath("id[@tag='ndn']"));
//	
//		WebDriverWait t = new WebDriverWait(driver , 10);
//		t.until(ExpectedConditions.visibilityOf(r));
//		
//		
//		List <WebElement> a=driver.findElements(By.xpath("id[@tag='ndn']"));
		//System.out.println("smoke");
//	}
	
	
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
	
//	@Test
//	public void swaglabs_titletest() {
		
		
		//driver.get("https://www.saucedemo.com/");
		//String Swag_title=driver.getTitle();
		//boolean a = Swag_title.equals("Swagg Labs");
		//Assert.assertEquals(Swag_title, "Swag Labs");
//		System.out.println(Swag_title);
//		
//		if(a==true) {
//			System.out.println(Swag_title.equals("Swag Labs"));
//		}
		
		
	//}
	
//	@Test
//	public void swaglabs_titletest_softssert() {
//		
//		
//		driver.get("https://www.saucedemo.com/");
		//String Swag_title_1=driver.getTitle();
		//boolean a = Swag_title.equals("Swagg Labs");
		//Assert.assertEquals(Swag_title_1, "Swag Labss");
//		System.out.println(Swag_title);
//		
//		if(a==true) {
//			System.out.println(Swag_title.equals("Swag Labs"));
//		}
		
		
	//}
	
//	@Test
//	public void jugad1() {
//		
//		String testing = "abc";
//		
//		//Assert.assertEquals(testing, "abcc");
//		softAssert.assertEquals(testing, "abcc");
//		
//		
//		
//
//	}
//	@Test
//	public void jugad2 () {
//		
//		String testing1 = "hjy";
//		
//		//Assert.assertEquals(testing, "abcc");
//		softAssert.assertEquals(testing1, "hjyy");
//		System.out.println("yed");
//	}
	
//	@AfterMethod
//	public void jugad3 () {
//		
//		softAssert.assertAll();
//	}

	@AfterMethod
	public void takescreenshot(ITestResult result) {
		
		if(ITestResult.FAILURE == result.getStatus()) {
			System.out.println("Success");
		}
	}
	
	
	
	
		public void abchello() {
		
	    //   WebDriverManager.chromedriver().setup();
	       driver = new ChromeDriver();

	       driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	       System.out.println("hello");
		System.out.println("start");
		
	}
	
	@BeforeSuite
	public void abc1() {
		System.out.println("BeforeSuite");
		
	}
	@BeforeClass
	public void abc2() {
		System.out.println("BeforeClass");
		
	}
	
	@BeforeTest
	public void abc3() {
		
		System.out.println("BeforeTest");
	}
	
	@BeforeMethod
	public void abc4() {
		System.out.println("BeforeMethod");
		
	}
	
	@AfterSuite
	public void abc5() {
		System.out.println("@AfterSuite");
		
	}
	
	@AfterClass
	public void abc6() {
		System.out.println("@AfterClass");
		
	}
	
	@AfterTest
	public void abc7() {
		
		System.out.println("@AfterTest");
	}
	
	@Test
	public void abc8() {
		
		
		String a = "jhsbdj";
		String b= a.replaceAll("[^hsb]", "");
		System.out.println(b);
	}
	
	
		
	}



	
	
	


