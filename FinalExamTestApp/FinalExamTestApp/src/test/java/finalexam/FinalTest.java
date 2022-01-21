package finalexam;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FinalTest {
    private static CreateAccountPage page;
    private static LoginPage loginPage;
    private static WelcomePage welcomePage;


    @Before
    public void createWebDriver() {
        // set path to chromedriver.exe
        System.setProperty("webdriver.chrome.driver", "C:\\waa\\chromedriver.exe");
        page = PageFactory.initElements(new ChromeDriver(), CreateAccountPage.class);
        page.open();
    }

    @After
    public void closeTheBrowser() {
        page.close();
        if (loginPage != null) {
            loginPage.close();
        }
        if (welcomePage != null) {
            welcomePage.close();
        }
    }

    @Test
    public void createValidAccount() throws InterruptedException {
        page.enterUsernamePassword("user1", "pass1");
        loginPage = page.clickCreateAccount();
        loginPage.verifyUrl();
    }

    @Test
    public void loginWithInValidAccount() throws InterruptedException {
        page.enterUsernamePassword("user1", "pass1");
        loginPage = page.clickCreateAccount();
        loginPage.enterUsernamePassword("user2", "pass2");
        loginPage.clickSubmit();
        loginPage.verifyErrorText("Wrong username/password combination, please try again!");
    }

    @Test
    public void loginWithValidAccount() throws InterruptedException {
        page.enterUsernamePassword("user1", "pass1");
        loginPage = page.clickCreateAccount();
        loginPage.enterUsernamePassword("user1", "pass1");
        welcomePage = loginPage.clickSubmit();
        welcomePage.verifyHeaderText("Welcome user1");
    }
}