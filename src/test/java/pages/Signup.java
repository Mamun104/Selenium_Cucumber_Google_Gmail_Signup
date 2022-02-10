package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Signup {

    public Signup(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "firstName")
    WebElement firstName;
    @FindBy(id = "lastName")
    WebElement lastName;
    @FindBy(id = "username")
    WebElement userName;
    @FindBy(name = "Passwd")
    WebElement pass;
    @FindBy(name = "ConfirmPasswd")
    WebElement confirmPass;
    @FindBy(xpath = "//span[contains(text(),'Next')]")
    WebElement btnNext;
    @FindBy(xpath = "//span[contains(text(),'Use 8 characters or more for your password')]")
    WebElement firstError;
    @FindBy(xpath = "//span[contains(text(),'Please choose a stronger password. Try a mix of le')]")
    WebElement secondError;

    public void doSignUp(String password) throws InterruptedException {
        firstName.sendKeys("Jon");
        lastName.sendKeys("Doe");
        userName.sendKeys("djon84729");
        pass.sendKeys(password);
        confirmPass.sendKeys(password);
        Thread.sleep(1500);
        btnNext.click();
    }

    public String firstErrorMessage() throws InterruptedException {
        Thread.sleep(1500);
        return firstError.getText();
    }
    public String secondErrorMessage() throws InterruptedException {
        Thread.sleep(1500);
        return secondError.getText();
    }

}
