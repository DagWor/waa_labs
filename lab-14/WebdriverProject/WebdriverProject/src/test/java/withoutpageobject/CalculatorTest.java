package withoutpageobject;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class CalculatorTest {
	private WebDriver driver;

	@Before
	public void createWebDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Anteneh\\Desktop\\MIU\\WAA\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@After
	public void closeWebDriver() {
		driver.close();
	}

	@Test
	public void oneAndFour() {
		driver.navigate().to("http://www.rekenmachine-calculator.nl/");

		WebElement button = driver.findElement(By.name("one"));
		button.click();
		button = driver.findElement(By.name("add"));
		button.click();
		button = driver.findElement(By.name("four"));
		button.click();
		assertThat(driver.findElement(By.name("txt")).getAttribute("value"), is("1+4"));
		button = driver.findElement(By.name("equal"));
		button.click();
		assertThat(driver.findElement(By.name("txt")).getAttribute("value"), is("5"));
	}

	@Test
	public void threeAndFive(){
		driver.navigate().to("http://www.rekenmachine-calculator.nl/");

		WebElement button = driver.findElement(By.name("three"));
		button.click();

		button = driver.findElement(By.name("mul"));
		button.click();

		button = driver.findElement(By.name("five"));
		button.click();
		assertEquals(driver.findElement(By.name("txt")).getAttribute("value"),"3*5");

		button= driver.findElement(By.name("equal"));
		button.click();;
		assertEquals(driver.findElement(By.name("txt")).getAttribute("value"),"15");

	}
}
