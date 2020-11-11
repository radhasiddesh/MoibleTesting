package firstProject;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;

public class project1TestNG {
	public AndroidDriver driver;
	  @Test
	  public void actionPage() throws InterruptedException {
		    // Clicking on navigating to product and other options
		    driver.findElement(By.xpath("//header[@id='navbar']//button[1]")).click();
		    Thread.sleep(2000);
		    driver.findElement(By.xpath("//a[@data-adobe-name='Header|GlobalNav|ProductsClick']")).click();
		    System.out.println("clicked on product link");
		    //Navigating to "Request a demo
		    	
			JavascriptExecutor js = (JavascriptExecutor)driver;
		    WebElement element = driver.findElement(By.xpath("//a[contains(text(),'Request a demo')]"));
		    js.executeScript("arguments[0].scrollIntoView(true);",element); 
			element.click();
			System.out.println("clicked on Request a demo button");
			Thread.sleep(5000);
			//Clicking on "Schedule a free demo"
		    driver.findElement(By.xpath("//a[contains(text(),'Schedule a free demo')]")).click();
		    System.out.println("clicked on Schedule a free demo button");
		    Thread.sleep(5000);
		    //In action page, validating each field
		    //Firstname validation
		    WebElement webelement=driver.findElement(By.xpath("//input[@id='FirstName']"));
	      	webelement.sendKeys(" ");
	      	driver.hideKeyboard();
	      	driver.findElement(By.xpath("//button[@type='submit'][contains(.,'Submit')]")).click();
	      	driver.hideKeyboard();
	      	Thread.sleep(2000);
	      	WebElement errMsg1=driver.findElement(By.xpath("//div[@role='alert'][contains(.,'This field is required.')]"));
	      	System.out.println("FirstName validation--->"+errMsg1.getText());
	      	
	      	//lastname validation
	      	driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Radha");
	      	driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys(" ");
	      	driver.hideKeyboard();
	      	Thread.sleep(2000);
	      	webelement.sendKeys(Keys.TAB);
	      	driver.hideKeyboard();
	      	Thread.sleep(2000);
	      	WebElement errMsg2=driver.findElement(By.xpath("//div[@role='alert'][contains(.,'This field is required.')]"));
	      	System.out.println("LastName validation--->"+errMsg2.getText());
	      	
	      	//email validation
	      	driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("k");
	      	driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(" ");
	      	driver.hideKeyboard();
	      	Thread.sleep(2000);
	      	webelement.sendKeys(Keys.TAB);
	      	driver.hideKeyboard();
	      	Thread.sleep(2000);
	      	WebElement errMsg3=driver.findElement(By.xpath("//div[@role='alert'][contains(.,'Must be valid email. example@yourdomain.com')]"));
	      	System.out.println("Email validation--->"+errMsg3.getAttribute("innerHTML"));
	      	//phone validation
	      	driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("radha@gmail.com");
	      	driver.findElement(By.xpath("//input[@id='Phone']")).sendKeys(" ");
	      	driver.hideKeyboard();
	      	Thread.sleep(2000);
	      	webelement.sendKeys(Keys.TAB);
	      	driver.hideKeyboard();
	      	Thread.sleep(2000);
	      	WebElement errMsg4=driver.findElement(By.xpath("//div[@role='alert'][contains(.,'Must be a phone number. 503-555-1212')]"));
	      	System.out.println("Phone validation--->"+errMsg4.getAttribute("innerHTML"));
	      	
	      	//country validation
	      	driver.findElement(By.xpath("//input[@id='Phone']")).sendKeys("456789");
	      	webelement.sendKeys(Keys.ENTER);
	      	Select drpCon= new Select(driver.findElement(By.xpath("//select[@id='Country']")));
			  	drpCon.selectByVisibleText("Select...");
			  	driver.hideKeyboard();
		      	Thread.sleep(2000);	      	
	      	webelement.sendKeys(Keys.TAB);
	      	driver.hideKeyboard();
	      	Thread.sleep(2000);        	
	      	WebElement errMsg5=driver.findElement(By.xpath("//div[contains(@id,'ValidMsgCountry')][contains(.,'This field is required.')]"));
	      	System.out.println("Country validation--->"+errMsg5.getAttribute("innerHTML"));
      	
      	//job role        	
		  	drpCon.selectByVisibleText("India");  
		  	webelement.sendKeys(Keys.ENTER);
		  	Select drpJob= new Select(driver.findElement(By. xpath("//select[@id='Job_Role__c']")));
			drpJob.selectByVisibleText("Select...");
		  	driver.hideKeyboard();
	      	Thread.sleep(2000);
	      	webelement.sendKeys(Keys.TAB);
	      	driver.hideKeyboard();
	      	Thread.sleep(2000);	      
	      	WebElement errMsg6=driver.findElement(By.xpath("//div[contains(@id,'ValidMsgJob_Role__c')][contains(.,'This field is required.')]"));
	      	System.out.println("Job role validation--->"+errMsg6.getAttribute("innerHTML"));
	      	
	      	//Company validation
	      	
			drpJob.selectByVisibleText("Ecommerce Executive");
			webelement.sendKeys(Keys.ENTER);
			driver.findElement(By.xpath("//input[@id='Company']")).sendKeys(" ");
	      	//driver.hideKeyboard();
	      	//Thread.sleep(2000);
	      	webelement.sendKeys(Keys.TAB);
	      	driver.hideKeyboard();
	      	Thread.sleep(2000);
	      	WebElement errMsg7=driver.findElement(By.xpath("//div[contains(@id,'ValidMsgCompany')][contains(.,'This field is required.')]"));
	      	System.out.println("Company validation--->"+errMsg7.getAttribute("innerHTML"));
	      	
	      	//Business type
	      	driver.findElement(By.xpath("//input[@id='Company']")).sendKeys("IBM");	
	      	webelement.sendKeys(Keys.ENTER);
	      	Select drpOR= new Select(driver.findElement(By.xpath("//select[@id='Organizational_Role__c']")));
			drpOR.selectByVisibleText("Select...");
	      	//driver.hideKeyboard();
	      	//Thread.sleep(2000);
	      	webelement.sendKeys(Keys.TAB);
	      	driver.hideKeyboard();
	      	Thread.sleep(2000);
	      	WebElement errMsg8=driver.findElement(By.xpath("//div[contains(@id,'ValidMsgOrganizational_Role__c')][contains(.,'This field is required.')]"));
	      	System.out.println("Business Type validation--->"+errMsg8.getAttribute("innerHTML"));
	      	
	      	//company sells
	      	
			drpOR.selectByVisibleText("Other");
			webelement.sendKeys(Keys.ENTER);
			Select drpDM= new Select(driver.findElement(By.xpath("//select[@id='Distribution_Method__c']")));
			drpDM.selectByVisibleText("Select..."); 
			//driver.hideKeyboard();
	      	//Thread.sleep(2000);
	      	webelement.sendKeys(Keys.TAB);
	      	driver.hideKeyboard();
	      	Thread.sleep(2000);
	      	WebElement errMsg9=driver.findElement(By.xpath("//div[contains(@id,'ValidMsgDistribution_Method__c')][contains(.,'This field is required.')]"));
	      	System.out.println("Company Sells validation--->"+errMsg9.getAttribute("innerHTML"));
		    		

	}
	  @BeforeMethod
	  public void beforeMethod() throws MalformedURLException {
			DesiredCapabilities capability= new DesiredCapabilities();
		    capability.setCapability(MobileCapabilityType.DEVICE_NAME, "Radha");
		    capability.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		    capability.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		    driver=new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),capability);
		    driver.get("https://magento.com/");
		    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		    
	}
	  @AfterMethod
	  public void afterMethod() {
		  driver.closeApp();
	  }

}
