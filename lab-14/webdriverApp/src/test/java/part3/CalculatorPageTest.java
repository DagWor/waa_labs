package part3;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CalculatorPageTest {
    private CalculatorPage calculatorPage;

    @Before
    public void createWebDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\dagma\\Videos\\Education\\waa\\chromedriver.exe");
        calculatorPage = PageFactory.initElements(new ChromeDriver(), CalculatorPage.class);
        calculatorPage.open("http://localhost:3000");
    }

    @After
    public void closeTheBrowser() {
        calculatorPage.close();
    }

    @Test
    public void oneAndFour() {
        calculatorPage.setFirstNumberInput(1);
        calculatorPage.setSecondNumberInput(4);
        calculatorPage.clickAdd();
        assertThat(calculatorPage.getResult(),  is("5"));
    }

    @Test
    public void threeAndFive() {
        calculatorPage.setFirstNumberInput(3);
        calculatorPage.setSecondNumberInput(5);
        calculatorPage.clickMultiply();
        assertThat(calculatorPage.getResult(),  is("15"));
    }

    @Test
    public void fiveAndFour() {
        calculatorPage.setFirstNumberInput(5);
        calculatorPage.setSecondNumberInput(4);
        calculatorPage.clickSubtract();
        assertThat(calculatorPage.getResult(),  is("1"));
    }
}
