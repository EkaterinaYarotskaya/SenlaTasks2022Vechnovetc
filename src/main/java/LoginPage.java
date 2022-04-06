import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class LoginPage implements PageObject {

    private WebDriver driver;
    @FindBy(id = "username")
    protected WebElement usernameField;

    @FindBy(id = "password")
    protected WebElement passwordField;

    @FindBy(tagName = "button")
    protected WebElement buttonField;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public PageObject loginUserAccount(String userName, String userPassword) {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        usernameField.sendKeys(userName);
        passwordField.sendKeys(userPassword);
        buttonField.click();
        if (driver.getCurrentUrl().equals("http://the-internet.herokuapp.com/login")) {
            return this;
        } else {
            return new FrontPage (driver);
        }
    }

    public boolean isLoginButtonPresent() {
        List<WebElement> listButton = new ArrayList<>();
        listButton.add(buttonField);
        int size = listButton.size();
        return size > 0;
    }

}





