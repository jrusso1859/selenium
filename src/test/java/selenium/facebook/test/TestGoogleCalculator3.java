package selenium.facebook.test;

import static org.junit.Assert.assertEquals;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//@RunWith(org.junit.runners.ParentRunner.class)
public class TestGoogleCalculator3 extends TestBase {
	@Rule public TestName name = new TestName();
	
	private WebDriver driver;
	private final Logger logger = Logger.getLogger(TestGoogleCalculator3.class);
	
	private final static String[] units = { "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight",
			"Nine" };

	@Before
	public void initializeDriver() {
		this.driver = getDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	synchronized private void verifyDriver(int op1, int op2) {
		logger.info("Test method:\t" + name.getMethodName());
		logger.info(String.format("Equation: %d x %d", op1, op2));
		logger.info("Thread id:\t" + Thread.currentThread().getId());
        logger.info("WebDriver Hash:\t" + driver.hashCode());
	}
	
	
	private void doIt() {
		Random r = new Random();
		int op1 = r.nextInt(10);
		int op2 = r.nextInt(10);
		verifyDriver(op1, op2);
		try {
			Thread.sleep(r.nextInt(5000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.get("http://www.google.com");
		WebElement queryBox = new WebDriverWait(driver, 10, 500)
				.until(ExpectedConditions.presenceOfElementLocated(By.id("lst-ib")));
		;
		queryBox.sendKeys("calculate " + op1 + "*" + op2);
		driver.findElement(By.id("_fZl")).click();
		new WebDriverWait(driver, 10, 500)
				.until(ExpectedConditions.jsReturnsValue("return document.readyState=='complete';"));
		new WebDriverWait(driver, 2, 500).until(ExpectedConditions.visibilityOfElementLocated(By.id("cwos")));
		WebElement answerElement = driver.findElement(By.id("cwos"));
		assertEquals(String.valueOf(op1 * op2), answerElement.getText());
		takeScreenShot(units[op1] + "Times" + units[op2]);
	}

	@Test
	public void test1() {
		doIt();
	}

	@Test
	public void test2() {
		doIt();
	}

	@Test
	public void test3() {
		doIt();
	}

	@Test
	public void test4() {
		doIt();
	}

	@Test
	public void test5() {
		doIt();
	}

	@Test
	public void test6() {
		doIt();
	}

	@Test
	public void test7() {
		doIt();
	}

	@Test
	public void test8() {
		doIt();
	}

	@Test
	public void test9() {
		doIt();
	}

	@Test
	public void test10() {
		doIt();
	}
}
