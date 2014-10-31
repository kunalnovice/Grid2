import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;


public class testSample extends testCore{

	@Test
	public void testLogin() throws MalformedURLException{
		
		
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			capabilities.setBrowserName("firefox");
			capabilities.setPlatform(Platform.ANY);
		
		
		if(driver==null)
		//require for WebDriver
		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
		//RemoteWebDriver driver = new FirefoxDriver();
		driver.get("https://gmail.com");
		driver.findElement(By.id("Email")).sendKeys("acctestchkmail@gmail.com");
		driver.findElement(By.id("Passwd")).sendKeys("password");
		driver.quit();
	}

}
