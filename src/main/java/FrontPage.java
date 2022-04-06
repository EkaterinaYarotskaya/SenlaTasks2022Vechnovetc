import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.List;

public class FrontPage implements PageObject {

    private WebDriver driver;

    @FindBy(css= "a.button.secondary")
    WebElement logoutButton;
//        =driver.findElement(By.cssSelector("a.button.secondary"));

    public FrontPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public PageObject logoutUserAccount() {

        logoutButton.click();
        return new LoginPage(driver);
    }

    public boolean isLogoutButtonPresent() {

        List<WebElement> listButton = new ArrayList<>();
        listButton.add(logoutButton);
        int size = listButton.size();
        return size > 0;
    }
}

