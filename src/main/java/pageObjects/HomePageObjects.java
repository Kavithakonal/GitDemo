package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HomePageObjects{

	WebDriver driver;
public HomePageObjects(WebDriver driver) {
	this.driver=driver;
}
By loginbtn=By.xpath("//a[@href='https://rahulshettyacademy.com/sign_in/']");
By centerText =By.xpath("//div[@class='text-center']/h2");
By navigationbar =By.cssSelector("ul[class='nav navbar-nav navbar-right']");
By LearnText=By.cssSelector("div[class*='col-sm-6 col-md-8 hidden-xs video-banner'] p");
By popup=By.xpath("//button[text()='NO THANKS']");

public LoginObjects loginbtn() {
     driver.findElement(loginbtn).click();
	LoginObjects li=new LoginObjects(driver);
	return li;
}

public WebElement getCenterText() {
	return driver.findElement(centerText);
}

public  WebElement getNavigationBar() {
	return driver.findElement(navigationbar);
}

public  WebElement getLearnText() {
	return driver.findElement(LearnText);
	
}
public  int getpopupSize() {
	return driver.findElements(popup).size();
	
}
public  WebElement getpopup() {
	return driver.findElement(popup);
	
}
}

