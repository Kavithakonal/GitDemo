package End2EndFrameWork;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePageObjects;
import pageObjects.LoginObjects;
import resources.Base;



public class LaunchingBrowser extends Base {
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(Base.class.getName());

	@BeforeTest
	public void prequest() throws IOException {
		driver = intializer();
		log.info("Driver is intialized");
		
	}
	
	@Test(dataProvider = "getInput")
	public void launchbrowserfrombase(String username1, String password1) throws IOException {
		driver.get(prop.getProperty("url"));
		log.info("browser is opended");
		HomePageObjects ob = new HomePageObjects(driver);
		
		LoginObjects li=ob.loginbtn();
		log.info("click on the login button");
		// invalid username and valid password
		li.emailId().sendKeys(username1);
		li.password().sendKeys(password1);
		li.LogIn().click();
		log.info("completed all terms");
	}
		@AfterTest
		public void closeBrowser() {
			driver.close();
		}
		
		

	@DataProvider
	public Object[][] getInput() {
		Object[][] ob = new Object[3][2];
		//valid username and valid password
		ob[0][0] = "kavitha";
		ob[0][1] = "kavitha@123";
//invalid username and valid password
		ob[1][0] = "savitha";
		ob[1][1] = "Savitha@123";
//ivalid password and invalid usernames
		ob[2][0] = "Sunitha";
		ob[2][1] = "Sunitha@123";

		return ob;

	}
	}
	



