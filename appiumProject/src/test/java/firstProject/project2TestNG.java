package firstProject;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;

public class project2TestNG {
	public AndroidDriver driver;
	  @Test
	  public void actionPage() throws InterruptedException, IOException {
	  File file= new File("C:\\Users\\RadhaSiddeshwaraiah\\Documents\\MTM\\data_majento.xls");
      FileInputStream fis=new FileInputStream(file);
      XSSFWorkbook wb= new XSSFWorkbook(fis);
      XSSFSheet sheet = wb.getSheetAt(0);
      int rc= sheet.getLastRowNum();
      System.out.println("total number of rows having data= "+rc);
      for(int i=1;i<=rc;i++) {
          String firstname=sheet.getRow(i).getCell(0).getStringCellValue();
          String lastname=sheet.getRow(i).getCell(1).getStringCellValue();
          String emailid=sheet.getRow(i).getCell(2).getStringCellValue();
          int phone=(int)sheet.getRow(i).getCell(3).getNumericCellValue();
          String company=sheet.getRow(i).getCell(4).getStringCellValue();
		    driver.get("https://magento.com/");
		    System.out.println("Starting the iteration-->"+i);
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    // Clicked on navigating to product and other options
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
	    	driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys(firstname);
	    	driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys(" ");
	    	driver.hideKeyboard();
	    	Thread.sleep(2000);
	    	webelement.sendKeys(Keys.TAB);
	    	driver.hideKeyboard();
	    	Thread.sleep(2000);
	    	WebElement errMsg2=driver.findElement(By.xpath("//div[@role='alert'][contains(.,'This field is required.')]"));
	    	System.out.println("LastName validation--->"+errMsg2.getText());
	    	
	    	//email validation
	    	driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys(lastname);
	    	driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(" ");
	    	driver.hideKeyboard();
	    	Thread.sleep(2000);
	    	webelement.sendKeys(Keys.TAB);
	    	driver.hideKeyboard();
	    	Thread.sleep(2000);
	    	WebElement errMsg3=driver.findElement(By.xpath("//div[@role='alert'][contains(.,'Must be valid email. example@yourdomain.com')]"));
	    	System.out.println("Email validation--->"+errMsg3.getAttribute("innerHTML"));
	    	//phone validation
	    	driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(emailid);
	    	driver.findElement(By.xpath("//input[@id='Phone']")).sendKeys(" ");
	    	driver.hideKeyboard();
	    	Thread.sleep(2000);
	    	webelement.sendKeys(Keys.TAB);
	    	driver.hideKeyboard();
	    	Thread.sleep(2000);
	    	WebElement errMsg4=driver.findElement(By.xpath("//div[@role='alert'][contains(.,'Must be a phone number. 503-555-1212')]"));
	    	System.out.println("Phone validation--->"+errMsg4.getAttribute("innerHTML"));
	    	
	    	//country validation
	    	WebElement ph=driver.findElement(By.xpath("//input[@id='Phone']"));
	    	ph.sendKeys(String.valueOf(phone));
	    	ph.sendKeys(Keys.ENTER);
	      	Select drpCon= new Select(driver.findElement(By.xpath("//select[@id='Country']")));
		  	drpCon.selectByVisibleText("Select...");
		  	//driver.hideKeyboard();
	      	Thread.sleep(5000);	      	
	      	ph.sendKeys(Keys.TAB);
	      	//driver.hideKeyboard();
	      	Thread.sleep(2000);        	
	      	WebElement errMsg5=driver.findElement(By.xpath("//div[contains(@id,'ValidMsgCountry')][contains(.,'This field is required.')]"));
	      	System.out.println("Country validation--->"+errMsg5.getAttribute("innerHTML"));
	    	
	    	//job role        	
			drpCon.selectByVisibleText("India");  
			ph.sendKeys(Keys.ENTER);
		    WebElement testDropDown = driver.findElement(By. xpath("//select[@id='Job_Role__c']"));  
		    Select drpJob = new Select(testDropDown);  
			drpJob.selectByVisibleText("Select...");
			driver.hideKeyboard();
	      	Thread.sleep(5000);
	      	testDropDown.sendKeys(Keys.TAB);
	      	driver.hideKeyboard();
	      	Thread.sleep(2000);	      
	      	WebElement errMsg6=driver.findElement(By.xpath("//div[contains(@id,'ValidMsgJob_Role__c')][contains(.,'This field is required.')]"));
	      	System.out.println("Job role validation--->"+errMsg6.getAttribute("innerHTML"));
	      	
	      	//Company validation
	      	
			drpJob.selectByVisibleText("Ecommerce Executive");
			testDropDown.sendKeys(Keys.ENTER);
			driver.findElement(By.xpath("//input[@id='Company']")).sendKeys(" ");
	      	//driver.hideKeyboard();
	      	//Thread.sleep(2000);
			testDropDown.sendKeys(Keys.TAB);
	      	driver.hideKeyboard();
	      	Thread.sleep(2000);
	      	WebElement errMsg7=driver.findElement(By.xpath("//div[contains(@id,'ValidMsgCompany')][contains(.,'This field is required.')]"));
	      	System.out.println("Company validation--->"+errMsg7.getAttribute("innerHTML"));
	      	
	      	//Business type
	      	WebElement comp=driver.findElement(By.xpath("//input[@id='Company']"));
	      	comp.sendKeys(company);	
	      	comp.sendKeys(Keys.ENTER);
	      	Select drpOR= new Select(driver.findElement(By.xpath("//select[@id='Organizational_Role__c']")));
			drpOR.selectByVisibleText("Select...");
	      	//driver.hideKeyboard();
	      	//Thread.sleep(2000);
			comp.sendKeys(Keys.TAB);
	      	driver.hideKeyboard();
	      	Thread.sleep(2000);
	      	WebElement errMsg8=driver.findElement(By.xpath("//div[contains(@id,'ValidMsgOrganizational_Role__c')][contains(.,'This field is required.')]"));
	      	System.out.println("Business Type validation--->"+errMsg8.getAttribute("innerHTML"));
	      	
	      	//company sells
	      	
			drpOR.selectByVisibleText("Other");
			comp.sendKeys(Keys.ENTER);
			WebElement testDrp = driver.findElement(By. xpath("//select[@id='Distribution_Method__c']"));  
		    Select drpDM = new Select(testDrp);
			drpDM.selectByVisibleText("Select..."); 
			//driver.hideKeyboard();
	      	//Thread.sleep(2000);
			testDrp.sendKeys(Keys.TAB);
	      	driver.hideKeyboard();
	      	Thread.sleep(2000);
	      	WebElement errMsg9=driver.findElement(By.xpath("//div[contains(@id,'ValidMsgDistribution_Method__c')][contains(.,'This field is required.')]"));
	      	System.out.println("Company Sells validation--->"+errMsg9.getAttribute("innerHTML"));
      }
	}
  
  @BeforeMethod
  public void beforeMethod() throws MalformedURLException {
	  DesiredCapabilities capability= new DesiredCapabilities();
	    capability.setCapability(MobileCapabilityType.DEVICE_NAME, "Radha");
	    capability.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	    capability.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
	    driver=new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),capability);
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    
}
  @AfterMethod
  public void afterMethod() {
		  driver.closeApp();
	}

}
