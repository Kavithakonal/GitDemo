package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class ForgotPasswordPageObjects {
	WebDriver driver;
	
	public ForgotPasswordPageObjects(WebDriver driver) {
		this.driver=driver;
	}
	By forgotpassword=By.xpath("//a[contains(text(),'Forgot Password?')]");
	By emailAdress=By.cssSelector("#user_email");
	By sendMeBtn=By.xpath("//input[@value='Send Me Instruction']");

	
	public WebElement getEmailAddress() {
		return  driver.findElement(emailAdress);
		
	}
	public WebElement sendMeButton() {
		return driver.findElement(sendMeBtn);
	}
	
}
