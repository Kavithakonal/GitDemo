package End2EndFrameWork;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.ForgotPasswordPageObjects;
import pageObjects.HomePageObjects;
import pageObjects.LoginObjects;
import resources.Base;

public class VerifiyingForgotPassword extends Base {
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void prequest() throws IOException {
		driver = intializer();
		driver.get(prop.getProperty("url"));
	}
	@Test
	public void doForgotPassword() {
		HomePageObjects ho=new HomePageObjects(driver);
		LoginObjects li=ho.loginbtn();
		log.info("clicked on login button on homepage sucessfully");
		ForgotPasswordPageObjects fp=li.getForgotPasswordPageObject();
		log.info("click on forgot password pagge sucessfully on login page");
		fp.getEmailAddress().sendKeys("kavitha.konal@gmail.com");
		log.info("entered valid email address sucessfully");
		fp.sendMeButton().click();
		log.info("clicked on send me  button sucessfully");
	}
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}

}
