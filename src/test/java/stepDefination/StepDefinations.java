package stepDefination;


import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;



import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import pageObjects.HomePageObjects;
import pageObjects.LoginObjects;
import resources.Base;


@RunWith(Cucumber.class)
public class StepDefinations extends Base {

	
	WebDriver driver;
	LoginObjects li;
	
	@Given("^ititialize the browser with chrome$")
	public void ititialize_the_browser_with_chrome() throws Throwable {
		driver = intializer();
	}

	@Given("^navigate to \"([^\"]*)\" site$")
	public void navigate_to_site(String arg1) throws Throwable {
	    driver.get(arg1);
	}
	@Given("^click on sing in link in home page to land on sing in page$")
	public void click_on_sing_in_link_in_home_page_to_land_on_sing_in_page() throws Throwable {
		 HomePageObjects ob = new HomePageObjects(driver);	
		 if(ob.getpopupSize()>0)
		  {
			ob.getpopup().click();
		 }
	       li=ob.loginbtn();
	}
	 @When("^User enters (.+) and (.+) and logs in$")
	    public void user_enters_and_and_logs_in(String username, String password) throws Throwable {
		 li.emailId().sendKeys(username); 
		 li.password().sendKeys(password);
		 li.LogIn().click();
	    }
	 
	@Then("^verify that user sucessfully logged in$")
	public void verify_that_user_sucessfully_logged_in() throws Throwable {
	   driver.close();
	}}


	
	
	