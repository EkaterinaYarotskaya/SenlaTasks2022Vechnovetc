import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoginTest extends FixedData {
    private LoginPage loginPage;
    private FrontPage frontPage;


    @BeforeEach
    public void beforeTest() {
        driver.get(loginPageUrl);
    }

    //у тебя тут все проверки одинаковые, или кнопка есть, или ее нет)) можно же проверить, что при некорректном логине
    // сверху появилось уведомление еще например, урл не поменялся)
    @Test
    public void successfulLoginWithCorrectCredentials() {
        loginPage = new LoginPage(driver);
        frontPage = (FrontPage) loginPage.loginUserAccount(correctLogin, correctPassword);
        Assertions.assertFalse(loginPage.isLoginButtonPresent());
    }

    @Test
    public void unsuccessfulLoginWithIncorrectLoginAndCorrectPassword() {
        loginPage = new LoginPage(driver);
        loginPage.loginUserAccount(incorrectLogin, correctPassword);
        Assertions.assertTrue(loginPage.isLoginButtonPresent());
    }

    @Test
    public void unsuccessfulLoginWithCorrectLoginAndIncorrectPassword() {
        loginPage = new LoginPage(driver);
        loginPage.loginUserAccount(correctLogin, incorrectPassword);
        Assertions.assertTrue(loginPage.isLoginButtonPresent());
    }

    @Test
    public void unsuccessfulLoginWithIncorrectLoginAndIncorrectPassword() {
        loginPage = new LoginPage(driver);
        loginPage.loginUserAccount(incorrectLogin, incorrectPassword);
        Assertions.assertTrue(loginPage.isLoginButtonPresent());
    }

    //Этот тест можно положить в LoginTest (я и положил)
    @Test
    public void logoutTest() {
        loginPage = new LoginPage(driver);
        frontPage = (FrontPage) loginPage.loginUserAccount(correctLogin, correctPassword);
        loginPage = (LoginPage) frontPage.logoutUserAccount();
        Assertions.assertFalse(frontPage.isLogoutButtonPresent());
    }
}
