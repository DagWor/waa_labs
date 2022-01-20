package part5;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class NopCommerceTest {
    private NopCommercePage nopCommercePage;

    @Before
    public void createWebDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Anteneh\\Desktop\\MIU\\WAA\\chromedriver.exe");
        nopCommercePage = PageFactory.initElements(new ChromeDriver(), NopCommercePage.class);
        nopCommercePage.open("https://demo.nopcommerce.com/");
    }

    @After
    public void closeTheBrowser() {
        nopCommercePage.close();
    }


    @Test
    public void register(){
        this.nopCommercePage.navigateToRegister();
        this.nopCommercePage.selectMaleGender();
        this.nopCommercePage.setFirstName("Test 1");
        this.nopCommercePage.setLastName("Test 2");
        this.nopCommercePage.setDateOfBirthDay("2");
        this.nopCommercePage.setDateOfBirthMonth("6");
        this.nopCommercePage.setDateOfBirthYear("1999");
        this.nopCommercePage.setEmail(createUniqueEmail());
        this.nopCommercePage.setCompany("MIU");
        this.nopCommercePage.setPassword("PasswordISRandom");
        this.nopCommercePage.setConfirmPassword("PasswordISRandom");
        this.nopCommercePage.registerClick();
        assertThat(this.nopCommercePage.getResult(),  is("Your registration completed"));
    }

    private String createUniqueEmail() {
        String email="@gmail.com";
        String name="frank"+ createRandomNumber();
        return name+email;
    }

    private int createRandomNumber() {
        return (int) (Math.random() * 5000 + 1);
    }
}
