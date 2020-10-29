package resources;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;



public class Base {
	public WebDriver driver;
	public Properties prop;

	@Test
	public WebDriver intializer() throws IOException {
	     prop=new Properties();
	    String path = System.getProperty("user.dir")+"/src/main/java/resources/resourses.properties";
		System.out.println(path);
	    //FileInputStream fis =new FileInputStream("D:\\JavaProgramsWorkspaceEclips\\completeFrameWork\\src\\main\\java\\resources\\resourses.properties");
	    FileInputStream fis =new FileInputStream(path);
		prop.load(fis);
		String browserName=prop.getProperty("browser");
		//to  run on  different browser
		//String browserName=System.getProperty("browser");
		//mvn test -Dbrowser=chrome
		if(browserName.contains("chrome")) {
			
			//System.setProperty("webdriver.chrome.driver", "D:\\SeleniumRelated\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver.exe");
		 ChromeOptions options=new ChromeOptions();
		 if(browserName.contains("headless")) {
			options.addArguments("headless");
			}
			driver=new ChromeDriver(options);
		}
	 else if(browserName.equalsIgnoreCase("FireFox")) {
		 System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\geckodriver.exe");
			 driver=new FirefoxDriver();	
		}
	 else if(browserName.equalsIgnoreCase("Edge")) {
		 System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\msedgedriver.exe");
			 driver=new EdgeDriver();	
		}
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		return driver;
	}

	public String getScreenShot(String testCaseName,WebDriver driver) throws IOException {
		
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String destinationFile=System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		org.apache.commons.io.FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
	}
}
