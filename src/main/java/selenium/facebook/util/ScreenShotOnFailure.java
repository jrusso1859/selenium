package selenium.facebook.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShotOnFailure extends TestWatcher {
	private WebDriver driver;

    public ScreenShotOnFailure(WebDriver driver) {
        this.driver =  driver;
    }
    
    @Override
    protected void failed(Throwable e, Description description) {
    	String fileName = description.getTestClass().getSimpleName() + "-" + description.getMethodName() + ".png";
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(fileName));
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }
}
