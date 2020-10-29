package End2EndFrameWork;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.HomePageObjects;
import resources.Base;


public class ValidateNavigationBar extends Base
{
	HomePageObjects ob;
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void prequest() throws IOException {
		driver = intializer();
		driver.get(prop.getProperty("url"));
	}
	@Test
	public void launchbrowserfrombase() {
		 ob = new HomePageObjects(driver);
		//to verify centered text feature course
		Assert.assertEquals(ob.getCenterText().getText(),"FEATURED COURSES");
		log.info("Text on home page is verified");
		//to verify navigation bar is present or not
		ob.getNavigationBar().isDisplayed();
		log.info("Navigation bar  is verified");
		Assert.assertTrue(ob.getNavigationBar().isDisplayed());
		log.info("Navigation bar is verified by assersion");

}
	@Test
	public void verfyingTexts() {
		//to verify learn text on landing page
		Assert.assertEquals(ob.getLearnText().getText(),"Learn Hot tools like Selenium, Appium, JMeter, SoapUI,Database Testing and more..");
		log.info("Learn Text on home page is verified");
		}
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
}


