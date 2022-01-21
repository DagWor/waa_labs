package finalexam;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateAccountPage {
    protected WebDriver driver;

    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(id = "username")
    private WebElement usernameInput;
    @FindBy(id = "password")
    private WebElement passwordInput;
    @FindBy(id = "btnSubmit")

    private WebElement submitButton;

    public void open() {
        driver.get("http://localhost:3000/");
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

    public LoginPage clickCreateAccount() {
        submitButton.click();
        return new LoginPage(driver);
    }
}
