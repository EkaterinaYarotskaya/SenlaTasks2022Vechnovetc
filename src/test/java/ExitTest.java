
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.time.Duration;

public class ExitTest extends FixedData {
    private LoginPage loginPage;
    private FrontPage frontPage;
    String CORRECT_LOGIN = "tomsmith";
    String CORRECT_PASSWORD = "SuperSecretPassword!";

    @Test
    public void logoutTest() {
        loginPage = new LoginPage(driver);
        frontPage = (FrontPage) loginPage.loginUserAccount(CORRECT_LOGIN, CORRECT_PASSWORD);
        loginPage = (LoginPage) frontPage.logoutUserAccount();
        loginPage.assertCheck("Login Page", By.cssSelector("#content > div > h2"));
    }
}