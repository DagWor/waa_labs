package part4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void createWebDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\dagma\\Videos\\Education\\waa\\chromedriver.exe");
        calculator = PageFactory.initElements(new ChromeDriver(), Calculator.class);
        calculator.open("http://localhost:3000/part-4");
    }

    @After
    public void closeTheBrowser() {
        calculator.close();
    }

    @Test
    public void oneAndFour() {
        calculator.setFirstNumberInput(1);
        calculator.setSecondNumberInput(4);
        calculator.clickAdd();
        assertThat(calculator.getResult(),  is("5"));
    }

    @Test
    public void threeAndFive() {
        calculator.setFirstNumberInput(3);
        calculator.setSecondNumberInput(5);
        calculator.clickMultiply();
        assertThat(calculator.getResult(),  is("15"));
    }

    @Test
    public void fiveAndFour() {
        calculator.setFirstNumberInput(5);
        calculator.setSecondNumberInput(4);
        calculator.clickSubtract();
        assertThat(calculator.getResult(),  is("1"));
    }
}
