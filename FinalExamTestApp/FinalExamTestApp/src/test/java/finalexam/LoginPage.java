package finalexam;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class LoginPage {
    protected WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "loginUsername")
    private WebElement usernameInput;
    @FindBy(id = "loginPassword")
    private WebElement passwordInput;
    @FindBy(id = "btnSubmit")
    private WebElement submitButton;

    @FindBy(id = "btnCreateAccount")
    private WebElement createAccountButton;
    @FindBy(id = "errorText")
    private WebElement errorText;


    public void open(String url) {
        driver.get(url);
    }

    public void close() {
        driver.close();
    }

    public void enterUsernamePassword(String username, String password) {
        this.usernameInput.clear();
        this.usernameInput.sendKeys(username);
        this.passwordInput.clear();
        this.passwordInput.sendKeys(password);
    }

    public void verifyUrl() {
        assertThat(driver.getCurrentUrl().endsWith("/login"), is(true));
    }

    public WelcomePage clickSubmit() {
        submitButton.click();
        return new WelcomePage(driver);
    }

    public void verifyErrorText(String text) {
        assertThat(errorText.getText(), is(text));
    }
}
