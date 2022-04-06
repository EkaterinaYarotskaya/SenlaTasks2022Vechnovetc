import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoginTest extends FixedData {


    private LoginPage loginPage;
    private FrontPage frontPage;
    public final String correctLogin = property.getProperty("correctLogin");
    private final String correctPassword =property.getProperty("correctPassword");
    private final String  incorrectLogin =property.getProperty("incorrectLogin");
    private final String incorrectPassword =property.getProperty("incorrectPassword");

    @BeforeEach
    public void beforeEach() {
        driver.get(property.getProperty("loginPageUrl"));
        loginPage = new LoginPage(driver);

    }

    @Test
    public void successfulLoginWithCorrectCredentials() {

        frontPage = (FrontPage) loginPage.loginUserAccount(correctLogin, correctPassword);
        Assertions.assertTrue(frontPage.isLogoutButtonPresent());
    }

    @Test
    public void unsuccessfulLoginWithIncorrectLoginAndCorrectPassword() {

        loginPage.loginUserAccount(incorrectLogin, correctPassword);
        Assertions.assertTrue(loginPage.isLoginButtonPresent());
    }

    @Test
    public void unsuccessfulLoginWithCorrectLoginAndIncorrectPassword() {

        loginPage.loginUserAccount(correctLogin, incorrectPassword);
        Assertions.assertTrue(loginPage.isLoginButtonPresent());
    }

    @Test
    public void unsuccessfulLoginWithIncorrectLoginAndIncorrectPassword() {

        loginPage.loginUserAccount(incorrectLogin, incorrectPassword);
        Assertions.assertTrue(loginPage.isLoginButtonPresent());
    }

    @Test
    public void logoutTest(){
       frontPage=(FrontPage) loginPage.loginUserAccount(correctLogin, correctPassword);
        loginPage=(LoginPage)frontPage.logoutUserAccount();
        Assertions.assertTrue(loginPage.isLoginButtonPresent());

    }
}
