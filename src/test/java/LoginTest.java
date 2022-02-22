import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.time.Duration;

public class LoginTest extends FixedData {
    String CORRECT_LOGIN = "tomsmith";
    String CORRECT_PASSWORD = "SuperSecretPassword!";
    String INCORRECT_LOGIN = "login1";
    String INCORRECT_PASSWORD = "password1";
    private LoginPage loginPage;

    @Test
    public void successfulLoginWithCorrectCredentials() {
        loginPage = new LoginPage(driver);
        loginPage.loginUserAccount(CORRECT_LOGIN, CORRECT_PASSWORD);
        loginPage.assertCheck("Welcome to the Secure Area. When you are done click logout below.",
                By.className("subheader"));
    }
    @Test
    public void unsuccessfulLoginWithIncorrectLoginAndCorrectPassword() {
        loginPage = new LoginPage(driver);
        loginPage.loginUserAccount(INCORRECT_LOGIN, CORRECT_PASSWORD);
        loginPage.assertCheck("Your username is invalid!\n" + "×", By.id("flash"));

    }
    @Test
    public void unsuccessfulLoginWithCorrectLoginAndIncorrectPassword() {
        loginPage = new LoginPage(driver);
        loginPage.loginUserAccount(CORRECT_LOGIN, INCORRECT_PASSWORD);
        loginPage.assertCheck("Your password is invalid!\n" + "×",
                By.id("flash"));
    }
    @Test
    public void unsuccessfulLoginWithIncorrectLoginAndIncorrectPassword() {
        loginPage = new LoginPage(driver);
        loginPage.loginUserAccount(INCORRECT_LOGIN, INCORRECT_PASSWORD);
        loginPage.assertCheck("Your username is invalid!\n" + "×", By.id("flash"));
    }
}
