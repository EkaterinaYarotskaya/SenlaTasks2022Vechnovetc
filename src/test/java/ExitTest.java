import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExitTest extends FixedData {

    private LoginPage loginPage;
    private FrontPage frontPage;

    @Test
    public void logoutTest() {
        loginPage = new LoginPage(driver);
        frontPage = (FrontPage) loginPage.loginUserAccount(CORRECT_LOGIN, CORRECT_PASSWORD);
        loginPage = (LoginPage) frontPage.logoutUserAccount();
        Assertions.assertFalse(frontPage.isLogoutButtonPresent());
    }
}