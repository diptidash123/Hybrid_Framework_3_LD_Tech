package Pom;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import generic.Autoconstant;
import generic.Excellibrary;

public class PomClass extends Excellibrary implements Autoconstant 
{
	
	WebDriver driver;
    //declaration
	
	@FindBy(xpath = "(//input[@class='input_error form_input'])[1]")
	private WebElement username;
	
	@FindBy(xpath = "(//input[@class='input_error form_input'])[2]")
	private WebElement password;
	
	@FindBy(xpath = "//input[@class='submit-button btn_action']")
	private WebElement login;
	
	@FindBy(xpath = "//div[text()='Sauce Labs Bolt T-Shirt']")
	private WebElement tshirtclick;
	
	@FindBy(xpath = "//div[@class='inventory_details_price']")
	private WebElement pricetag;
	
	@FindBy(xpath = "//button[text()='Add to cart']")
	private WebElement addtocart;
	
	@FindBy(xpath = "//a[@class='shopping_cart_link']")
	private WebElement carticon;
	
	@FindBy(xpath = "//button[@id='checkout']")
	private WebElement checkout;
	
	@FindBy(xpath = "//span[text()='Checkout: Your Information']")
	private WebElement CheckoutYourInformation;
	
	@FindBy(xpath = "(//input[@class=\"input_error form_input\"])[1]")
	private WebElement checkoutfirstname;
	
	@FindBy(xpath = "(//input[@class=\"input_error form_input\"])[2]")
	private WebElement checkoutlastname;
	
	@FindBy(xpath = "(//input[@class=\"input_error form_input\"])[3]")
	private WebElement checkoutzipcode;
	
	@FindBy(xpath = "//input[@class=\"submit-button btn btn_primary cart_button btn_action\"]")
	private WebElement continuebutton;
	
	@FindBy(xpath = "//button[@class=\"btn btn_action btn_medium cart_button\"]")
	private WebElement finishbutton;
	
	@FindBy(xpath = "//button[@id=\"react-burger-menu-btn\"]")
	private WebElement burgermenu;
	
	@FindBy(xpath = "(//a[@class=\"bm-item menu-item\"])[3]")
	private WebElement logoutbuttton;
	
	//initialization
	public PomClass(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	//utilization
	public void scenariologin() throws IOException, InterruptedException
	{
		username.sendKeys(Excellibrary.Excelfetchdata(excelfilepath, excelsheetname1, 0, 1));
		Thread.sleep(3000);
		password.sendKeys(Excellibrary.Excelfetchdata(excelfilepath, excelsheetname1, 1, 1));
		Thread.sleep(3000);
		login.click();
	}
	public void urlvalidationproduct() throws InterruptedException
	{
		tshirtclick.click();
		Thread.sleep(1000);
	 String actualurl=driver.getCurrentUrl();
	 String expetcedurl="https://www.saucedemo.com/inventory-item.html?id=1";
	 if (expetcedurl.equals(actualurl))
	 {
		System.out.println("url is correct");
	 }
	 else {
		System.out.println("url is incorrect");
	      }
	}
	public void pricingprint()
	{
	 String	container=pricetag.getText();
	 System.out.println("price of the seleted product" + "" + container);
	}
	
	public void addtocartproduct() throws InterruptedException
	{
		addtocart.click();
		Thread.sleep(2000);
		System.out.println("product added successfully");
		String cart = carticon.getText();
		System.out.println(cart);
		Thread.sleep(2000);
		carticon.click();
       //String expectedstring=driver.findElement(By.xpath("//div[text()='Sauce Labs Bolt T-Shirt']")).getText();
       //String actualstring="Sauce Labs Bolt T-Shirt";
       //Assert.assertEquals(expectedstring, actualstring);
//       System.out.println("correct product is added in the cart");
       //Reporter.log(actualstring);
		
	}
	
	public void checkouttab()
	{
		checkout.click();
	}
	
	public void CheckoutYourInformation1()
	{
	  String actual=CheckoutYourInformation.getText();
	  String expected="Checkout: Your Information";
	  if (expected.equals(actual))
	  {
		  System.out.println("Checkout: Your Information is correct shown");
		
	}
	  else {
		System.out.println("Checkout: Your Information is incorrect shown");
	}
	  
	}
	
	public void checkoutprocess() throws IOException, InterruptedException
	{
		checkoutfirstname.sendKeys(Excellibrary.Excelfetchdata(excelfilepath, excelsheetname2, 0, 1));
		Thread.sleep(2000);
		checkoutlastname.sendKeys(Excellibrary.Excelfetchdata(excelfilepath, excelsheetname2, 1, 1));
		Thread.sleep(2000);
		checkoutzipcode.sendKeys(Excellibrary.Excelfetchdata(excelfilepath, excelsheetname2, 2, 1));
		Thread.sleep(2000);
		continuebutton.click();
		System.out.println("user redirected to another url");
	    String	urlstoring=driver.getCurrentUrl();
	    String  urlexpected="https://www.saucedemo.com/checkout-step-two.html";
	    if (urlexpected.equals(urlstoring))
	    {
			System.out.println("url is validated");
		}
	    else {
			System.out.println("url is not validated");
		}
	    
	    String overviewactaulstring=driver.findElement(By.xpath("//span[text()='Checkout: Overview']")).getText();
	    String overviewexpectedstring="Checkout: Overview";
	    Assert.assertEquals(overviewactaulstring,overviewexpectedstring);
	    System.out.println("user redirect to correct page- Checkout: Overview");
	    finishbutton.click();
	    String complete=driver.findElement(By.xpath("//span[.='Checkout: Complete!']")).getText();
	    String complete1="Checkout: Complete!";
	    if (complete1.equals(complete)) {
			System.out.println("correct page Checkout: Complete!");
		}
	    else {
			System.out.println("incorrect page Checkout: Complete!");
		}
	    
	   String complete2=driver.findElement(By.xpath("//h2[text()='Thank you for your order!']")).getText();
	   String complete3="Thank you for your order!";
	   if (complete2.equals(complete3))
	   {
		System.out.println("Thank you for your order! correct");
	}
	   else {
		System.out.println("Thank you for your order! is incorrect");
	}
	   
	 String  complete4=driver.findElement(By.xpath("//div[@class=\"complete-text\"]")).getText();
	 String complete5="Your order has been dispatched, and will arrive just as fast as the pony can get there!";
	 if (complete5.equals(complete4)) 
	 {
		System.out.println("successfully order");
	}
	 else {
		System.out.println("successfully not order");
	}
	 driver.findElement(By.xpath("//button[@class=\"btn btn_primary btn_small\"]")).click();
	 Thread.sleep(4000);
	}
	public void logout() throws InterruptedException, IOException
	{
		burgermenu.click();
		Thread.sleep(3000);
		logoutbuttton.click();
		TakesScreenshot ts=((TakesScreenshot) driver);
	    File sourcefile=ts.getScreenshotAs(OutputType.FILE);
	    File destinationfile=new File("./screenshots/image-1");
	    FileUtils.copyFile(sourcefile, destinationfile);
	    System.out.println("screenshot captured");
		
	}
}
