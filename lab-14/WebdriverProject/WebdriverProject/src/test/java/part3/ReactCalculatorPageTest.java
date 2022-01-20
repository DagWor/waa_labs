package part3;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ReactCalculatorPageTest {
    private ReactCalculatorPage reactCalculatorPage;

    @Before
    public void createWebDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Anteneh\\Desktop\\MIU\\WAA\\chromedriver.exe");
        reactCalculatorPage = PageFactory.initElements(new ChromeDriver(), ReactCalculatorPage.class);
        reactCalculatorPage.open("http://localhost:3000");
    }

    @After
    public void closeTheBrowser() {
        reactCalculatorPage.close();
    }

    @Test
    public void oneAndFour() {
        reactCalculatorPage.setFirstNumberInput(1);
        reactCalculatorPage.setSecondNumberInput(4);
        reactCalculatorPage.clickAdd();
        assertThat(reactCalculatorPage.getResult(),  is("5"));
    }

    @Test
    public void threeAndFive() {
        reactCalculatorPage.setFirstNumberInput(3);
        reactCalculatorPage.setSecondNumberInput(5);
        reactCalculatorPage.clickMultiply();
        assertThat(reactCalculatorPage.getResult(),  is("15"));
    }

    @Test
    public void fiveAndFour() {
        reactCalculatorPage.setFirstNumberInput(5);
        reactCalculatorPage.setSecondNumberInput(4);
        reactCalculatorPage.clickSubtract();
        assertThat(reactCalculatorPage.getResult(),  is("1"));
    }
}
