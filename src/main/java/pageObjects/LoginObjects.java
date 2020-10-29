package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginObjects {
	
	WebDriver driver;
public LoginObjects(WebDriver driver) {
	this.driver=driver;
	
}

By emailId =By.cssSelector("#user_email");
By password =By.cssSelector("#user_password");
By LogIn=By.xpath("//input[@value='Log In']");
By forgotpassword=By.xpath("//a[contains(text(),'Forgot Password?')]");




public WebElement emailId() {
	return driver.findElement(emailId);	
}

public WebElement password() {
	return driver.findElement(password);	
}

public  WebElement LogIn() {
	return driver.findElement(LogIn);	
}
public ForgotPasswordPageObjects getForgotPasswordPageObject() {
	driver.findElement(forgotpassword).click();
	ForgotPasswordPageObjects fp=new ForgotPasswordPageObjects(driver);
	return fp;
}


}