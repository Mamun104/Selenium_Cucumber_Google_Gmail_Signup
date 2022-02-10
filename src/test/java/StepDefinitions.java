import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.Signup;

import java.time.Duration;

public class StepDefinitions {

    WebDriver driver;

    @Given("User visits to the signup page")
    public void user_visits_to_the_signup_page() {
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--headless");
        driver = new ChromeDriver(ops);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://accounts.google.com/signup/v2/webcreateaccount?hl=en&flowName=GlifWebSignIn&flowEntry=SignUp");
    }

    @When("User inputs invalid {string}")
    public void user_inputs_invalid_password(String spass) throws InterruptedException {
        Signup signup = new Signup(driver);
        signup.doSignUp(spass);
    }

    @Then("User cannot signup")
    public void user_cannot_signup() throws InterruptedException {
        Signup signup = new Signup(driver);
        String text = signup.firstErrorMessage();
        Assert.assertEquals(text,"Use 8 characters or more for your password");
        driver.close();
    }

    @When("User gives invalid {string}")
    public void user_gives_invalid(String wpass) throws InterruptedException {
        Signup signup = new Signup(driver);
        signup.doSignUp(wpass);
    }

    @Then("User cannot signup again")
    public void user_cannot_signup_again() throws InterruptedException {
        Signup signup = new Signup(driver);
        String text = signup.secondErrorMessage();
        Assert.assertEquals(text,"Please choose a stronger password. Try a mix of letters, numbers, and symbols.");
        driver.close();
    }
}
