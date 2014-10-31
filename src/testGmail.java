import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class testGmail extends testCore{

	@Test(dataProvider="getData")
	public void doLogin(String username, String password, String browser) throws MalformedURLException{
		
		System.out.println(browser);
		DesiredCapabilities capabilities = null;
		if(browser.equals("firefox")){
			
			capabilities = DesiredCapabilities.firefox();
			capabilities.setBrowserName("firefox");
			capabilities.setPlatform(Platform.ANY);
			
		}else if(browser.equals("ie")){
			
			capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setBrowserName("iexplore");
			capabilities.setPlatform(Platform.WINDOWS);
			
		}else if(browser.equals("chrome")){
			
			capabilities = DesiredCapabilities.chrome();
			capabilities.setBrowserName("chrome");
		
			capabilities.setPlatform(Platform.ANY);
		}
		 
		capabilities.setCapability("_important", "2");
		
		if(driver==null)
		//require for WebDriver
		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
		//RemoteWebDriver driver = new FirefoxDriver();
		driver.get("https://accounts.google.com/ServiceLogin?service=mail&continue=https://mail.google.com/mail/&hl=en");
		driver.findElement(By.id("Email")).sendKeys(username);
		driver.findElement(By.id("Passwd")).sendKeys(password);
		
	}
	
	@DataProvider(parallel=true)
	public Object[][] getData(){
		
		Object[][] data = new Object[2][3];
		data[0][0] = "selenium";
		data[0][1] = "sfsdfs";
		data[0][2] = "firefox";
		
		
		data[1][0] = "WebDriver";
		data[1][1] = "sfsdfs";
		data[1][2] = "firefox";
		/*		
		data[1][0] = "webdriver";
		data[1][1] = "sdfsdfs";
		data[1][2] = "ie";*/
		
		return data;
		
		
		
	}

}
