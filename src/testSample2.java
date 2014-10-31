import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class testSample2  {

	@Parameters("browser")
	@Test
	public void testLogin(String browser) throws MalformedURLException {
		System.out.println(browser);

		DesiredCapabilities capabilities = null;
		if (browser.equals("firefox")) {
			capabilities = DesiredCapabilities.firefox();
			capabilities.setBrowserName("firefox");
			capabilities.setPlatform(Platform.ANY);
		} else if (browser.equals("chrome")) {
			capabilities = DesiredCapabilities.chrome();
			capabilities.setBrowserName("chrome");
			capabilities.setPlatform(Platform.ANY);
		}
		else if (browser.equals("iexplore")) {
			capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setBrowserName("iexplore");
			capabilities.setPlatform(Platform.WINDOWS);
		}

	
		RemoteWebDriver	driver = new RemoteWebDriver(
					new URL("http://localhost:4444/wd/hub"), capabilities);

		driver.get("https://gmail.com");
		driver.findElement(By.id("Email")).sendKeys("acctestchkmail@gmail.com");
		driver.findElement(By.id("Passwd")).sendKeys("password");
		//driver.quit();
	}

}
