import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginTest extends FixedData {
    private LoginPage loginPage;
    private FrontPage frontPage;

    @Test
    public void successfulLoginWithCorrectCredentials() {
        loginPage = new LoginPage(driver);
        frontPage = (FrontPage) loginPage.loginUserAccount(CORRECT_LOGIN, CORRECT_PASSWORD);
        Assertions.assertFalse(loginPage.isLoginButtonPresent());
    }

    @Test
    public void unsuccessfulLoginWithIncorrectLoginAndCorrectPassword() {
        loginPage = new LoginPage(driver);
        loginPage.loginUserAccount(INCORRECT_LOGIN, CORRECT_PASSWORD);
        Assertions.assertTrue(loginPage.isLoginButtonPresent());
    }

    @Test
    public void unsuccessfulLoginWithCorrectLoginAndIncorrectPassword() {
        loginPage = new LoginPage(driver);
        loginPage.loginUserAccount(CORRECT_LOGIN, INCORRECT_PASSWORD);
        Assertions.assertTrue(loginPage.isLoginButtonPresent());
    }

    @Test
    public void unsuccessfulLoginWithIncorrectLoginAndIncorrectPassword() {
        loginPage = new LoginPage(driver);
        loginPage.loginUserAccount(INCORRECT_LOGIN, INCORRECT_PASSWORD);
        Assertions.assertTrue(loginPage.isLoginButtonPresent());
    }
}
