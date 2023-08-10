package Test;

import java.io.IOException;

import org.testng.annotations.Test;

import Pom.PomClass;
import generic.BaseTest;

public class Testclass extends BaseTest{
  @Test
  public void executing() throws IOException, InterruptedException 
  {
	  PomClass p=new PomClass(driver);
	  p.scenariologin();
	  p.urlvalidationproduct();
	  p.pricingprint();
	  p.addtocartproduct();
	  p.checkouttab();
	  p.CheckoutYourInformation1();
	  p.checkoutprocess();
	  p.logout();
  }
}
