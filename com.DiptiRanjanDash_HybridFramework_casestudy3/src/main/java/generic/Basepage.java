package generic;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Basepage extends BaseTest
{
   //select class//alert class//robot class//actions class
   public void dropdown(WebElement element,String text)
   {
	   Select s=new Select(element);
	   s.selectByVisibleText(text);
   }
   
   public void dropdown1(WebElement element,String text)
   {
	   Select s1=new Select(element);
	   s1.selectByValue(text);
   }
   public void dropdown2(WebElement element,int value)
   {
	   Select s3=new Select(element);
	   s3.selectByIndex(value);
   }
   
   public void notifications()
   {
	  Alert q=driver.switchTo().alert();
   }
   
   public void keyboardoperation() throws AWTException
   {
	   Robot r=new Robot();
	   r.keyPress(KeyEvent.VK_CONTROL);
	   r.keyPress(KeyEvent.VK_TAB);	   
	   r.keyPress(KeyEvent.VK_ENTER);
	   
	   r.keyRelease(KeyEvent.VK_CONTROL);
	   r.keyRelease(KeyEvent.VK_TAB);
	   r.keyRelease(KeyEvent.VK_ENTER);
	   
	   
   }
}
