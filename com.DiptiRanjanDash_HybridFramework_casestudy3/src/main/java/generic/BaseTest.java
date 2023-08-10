package generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest implements Autoconstant
{
   public WebDriver driver;
   @BeforeClass
   public void opening()
   {
	   System.setProperty(chrome_key, chrome_value);
	   driver=new ChromeDriver();
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	   driver.navigate().to(Testingurl);
	   System.out.println("Test url is launched successfully");
   }
   
   @AfterClass
   public void closing()
   {
	   System.out.println("Test url is closed successfully");
	   driver.close();
   }
}
