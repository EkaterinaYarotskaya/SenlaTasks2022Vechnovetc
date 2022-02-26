import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class LoginPage implements PageObject {
    private WebDriver driver;
    private final By USERNAME_FIELD = By.id("username");
    private final By PASSWORD_FIELD = By.id("password");
    private final By BUTTON_FIELD = By.tagName("button");
    protected static String pageURL = "http://the-internet.herokuapp.com/login";

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }


    public PageObject loginUserAccount(String userName, String userPassword) {
        driver.get(pageURL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.findElement(USERNAME_FIELD).sendKeys(userName);
        driver.findElement(PASSWORD_FIELD).sendKeys(userPassword);
        driver.findElement(BUTTON_FIELD).click();
        if (driver.getCurrentUrl().equals("http://the-internet.herokuapp.com/login")) {
            return this;
        } else return new FrontPage(driver);
    }
}

