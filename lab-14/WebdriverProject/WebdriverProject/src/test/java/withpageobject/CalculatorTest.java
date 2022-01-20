package withpageobject;

import org.junit.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest {
	private CalculatorPage page;

	@Before
	public void createWebDriver() {
		// set path to chromedriver.exe
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Anteneh\\Desktop\\MIU\\WAA\\chromedriver.exe");
	    page = PageFactory.initElements(new ChromeDriver(), CalculatorPage.class);
	    page.open("http://www.rekenmachine-calculator.nl/");
	  }

	  @After
	  public void closeTheBrowser() {
	    page.close();
	  }

	  @Test
	  public void oneAndFour() {
	    page.clickOne();
	    page.clickAdd();
	    page.clickFour();
	    assertThat(page.getResult(),  is("1+4"));
	    page.clickEqual();
	    assertThat(page.getResult(),  is("5"));
	    page.clickClear();
	  }

	  @Test
	  public void threeAndFive() {
	    page.clickThree();
	    page.clickMultiply();
	    page.clickFive();
	    assertThat(page.getResult(),  is("3*5"));
	    page.clickEqual();
	    assertThat(page.getResult(),  is("15"));
	    page.clickClear();
	  }

	  @Test
	  public void fiveAndFour() {
	    page.clickFive();
	    page.clickSubtract();
	    page.clickFour();
	    assertThat(page.getResult(),  is("5-4"));
	    page.clickEqual();
	    assertThat(page.getResult(),  is("1"));
	    page.clickClear();
	  }

	}