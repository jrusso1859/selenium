package selenium.facebook.test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import selenium.facebook.util.DriverFactory;
import selenium.facebook.util.ScreenShotOnFailure;

public class TestBase {

	private static WebDriver driver;
	private static DriverFactory driverFactory = DriverFactory.getInstance();
	@Rule
    public ScreenShotOnFailure screenShootFailure = new ScreenShotOnFailure(driver);
	
	@BeforeClass
	public static void driverSetup() {
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		//capabilities.setCapability("firefox_binary", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
		capabilities.setVersion("52.0");
		System.setProperty("webdriver.gecko.driver", "C:\\webdrivers\\marionette\\geckodriver.exe");
		driver = driverFactory.getDriver();
		//driver = new FirefoxDriver(capabilities);
	}

	public WebDriver getDriver() {
		return driver;
	}

	@AfterClass
	public static void driverShutdown() {
		driverFactory.removeDriver();
	}

	synchronized protected void takeScreenShot(String fileName) {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(fileName + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
