import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class LoginPage implements PageObject {
    private WebDriver driver;
    @FindBy(id = "username")
    protected WebElement usernameField;

    @FindBy(id = "password")
    protected WebElement passwordField;

    //Тогда уже и тут прописывай вебэлемент с аннотацией FindBy
    private final By buttonField = By.tagName("button");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public PageObject loginUserAccount(String userName, String userPassword) {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        usernameField.sendKeys(userName);
        passwordField.sendKeys(userPassword);
        driver.findElement(buttonField).click();
        if (driver.getCurrentUrl().equals("http://the-internet.herokuapp.com/login")) {
            return this;
        } else {
            return new FrontPage(driver);
        }
    }

    public boolean isLoginButtonPresent() {
        int size = driver.findElements(buttonField).size();
        return size > 0;
    }

}





