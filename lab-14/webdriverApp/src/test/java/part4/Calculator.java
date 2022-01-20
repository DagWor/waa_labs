package part4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Calculator {

    protected WebDriver driver;

    public Calculator(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(name = "firstNumber")
    private WebElement firstNumberInput;
    @FindBy(name = "secondNumber")
    private WebElement secondNumberInput;
    @FindBy(name = "add")
    private WebElement addButton;
    @FindBy(name = "mul")
    private WebElement multiplyButton;
    @FindBy(name = "sub")
    private WebElement subtractButton;
    @FindBy(name = "div")
    private WebElement divideButton;
    @FindBy(name = "result")
    private WebElement resultField;

    public void open(String url) {
        driver.get(url);
    }

    public void setFirstNumberInput(double number){
        firstNumberInput.sendKeys(number+"");
    }

    public void setSecondNumberInput(double number){
        secondNumberInput.sendKeys(number+"");
    }

    public void close() {
        driver.close();
    }

    public void clickAdd() {
        addButton.click();
    }

    public void clickMultiply() {
        multiplyButton.click();
    }

    public void clickSubtract() {
        subtractButton.click();
    }

    public String getResult() {
        return resultField.getText();
    }

}
