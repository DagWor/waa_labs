package part5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NopCommercePage {
    protected WebDriver driver;
    @FindBy(id = "FirstName")
    private WebElement firstNameElement;

    @FindBy(id = "gender-male")
    private WebElement maleGenderElement;

    @FindBy(id = "LastName")
    private WebElement lastNameElement;
    @FindBy(id = "Email")
    private WebElement emailElement;
    @FindBy(id = "Company")
    private WebElement companyElement;
    @FindBy(id = "Password")
    private WebElement passwordElement;
    @FindBy(id = "ConfirmPassword")
    private WebElement confirmPasswordElement;
    @FindBy(id = "register-button")
    private WebElement registerButtonElement;
    @FindBy(className = "result")
    private WebElement resultElement;

    private Select dateOfBirthDayElement;
    private Select dateOfBirthMonthElement;
    private Select dateOfBirthYearElement;

    public NopCommercePage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToRegister(){
        this.driver.navigate().to("http://demo.nopcommerce.com/register");
    }
    public void selectMaleGender(){
        this.maleGenderElement.click();
    }
    public void setFirstName(String firstName) {
        this.firstNameElement.sendKeys( firstName);
    }

    public void setLastName(String lastName) {
        this.lastNameElement.sendKeys(lastName);
    }

    public void setDateOfBirthDay(String dateOfBirthDay) {
        this.dateOfBirthDayElement = new Select(driver.findElement( By.name("DateOfBirthDay")));
        this.dateOfBirthDayElement.selectByValue(dateOfBirthDay);
    }

    public void setDateOfBirthMonth(String dateOfBirthMonth) {
        this.dateOfBirthMonthElement = new Select(driver.findElement(By.name("DateOfBirthMonth")));
        this.dateOfBirthMonthElement.selectByValue(dateOfBirthMonth);
    }

    public void setDateOfBirthYear(String dateOfBirthYear) {
        this.dateOfBirthYearElement = new Select(driver.findElement(By.name("DateOfBirthYear")));
        this.dateOfBirthYearElement.selectByValue(dateOfBirthYear);
    }

    public void setEmail(String email) {
        this.emailElement.sendKeys(email);
    }

    public void setCompany(String company) {
        this.companyElement.sendKeys(company);
    }

    public void setPassword(String password) {
        this.passwordElement.sendKeys(password);
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPasswordElement.sendKeys(confirmPassword);
    }

    public String getResult(){
        return this.resultElement.getText();
    }

    public void registerClick(){
        this.registerButtonElement.click();
    }

    public void open(String url) {
        driver.get(url);
    }

    public void close() {
        driver.close();
    }


}
