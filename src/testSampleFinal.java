import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class testSampleFinal  {

	
	@Test(dataProvider="getData")
	public void testLogin(String username, String passwd, String browser) throws MalformedURLException {
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

		driver.get("https://qa.scribestar.internal");
		driver.findElement(By.id("emailAddressInput")).sendKeys(username);
		driver.findElement(By.id("passwordInput")).sendKeys(passwd);
		driver.findElement(By.id("loginButton")).click();
		//driver.quit();
	}
	
    @DataProvider(parallel=true)
	public Object[][] getData(){
		Object data[][] = new Object[3][3];
		
		data [0][0] ="kunal.mehta@scribestar.com";
		data [0][1] ="Scr1best@r!";
		data [0][2] ="firefox";
		
		data [1][0] ="nick.meldrum@scribestar.com";
		data [1][1] ="Scr1best@r!";
		data [1][2] ="chrome";
		
		data [2][0] ="christian.booth@scribestar.com";
		data [2][1] ="Scr1best@r!";
		data [2][2] ="iexplore";
		return data;
	}
}
