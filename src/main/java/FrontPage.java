import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FrontPage implements PageObject {

    private final By logoutButton = By.cssSelector("a.button.secondary");
    private WebDriver driver;

    public FrontPage(WebDriver driver) {
        this.driver = driver;
    }

    public PageObject logoutUserAccount() {

        driver.findElement(logoutButton).click();
        if (driver.getCurrentUrl().equals("http://the-internet.herokuapp.com/secure"))
            return this;
        else return new LoginPage(driver);
    }
    public boolean isLogoutButtonPresent() {
        int size = driver.findElements(logoutButton).size();
        return size > 0;
    }
}

