import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class LoginTest extends FixedData {
    //Логин, пароль, URL вынеси в property
    String CORRECT_LOGIN = "tomsmith";
    String CORRECT_PASSWORD = "SuperSecretPassword!";
    String INCORRECT_LOGIN = "login1";
    String INCORRECT_PASSWORD = "password1";
    private LoginPage loginPage;

    @Test
    public void successfulLoginWithCorrectCredentials() {
        loginPage = new LoginPage(driver);
        loginPage.loginUserAccount(CORRECT_LOGIN, CORRECT_PASSWORD);
        // непонятно для чего в пэйджобджекте метод, который выполняет проверку. Если делаешь свои кастомные проверки,
        // то выноси их в отдельный класс. В этой методе вообще нету никакого смысла. Это аналогично:
        //        Assertions.assertEquals("Welcome to the Secure Area. When you are done click logout below.",
        //                driver.findElement(By.className("subheader")).getText()));
        // избегай использование локаторов в тексте. Если тебе уже нужен какйото элемент или текст из этого элемента,
        // то прописывай метод в пэйдже, который будет тебе возвращать необходимые данные.
        // assertCheck убрать нафиг
        // В отдельный метод выносить есть смысл, если планируешь сделать несколько проверок и действий, как я писал:
        //
        //    private void assertUrlAndAlertMessage(String pageUrl, String alertMessage){
        //        getExpectedParametersOnTxt(pageUrl, alertMessage);
        //        takeScreenShot();
        //        assertions.assertThat(driver.getCurrentUrl()).as("check url").isEqualTo(pageUrl);
        //        assertions.assertThat(loginPage.getAlertMessage()).as("check message").isEqualTo(alertMessage);
        //        assertions.assertAll();
        //    }
        // Сначала проверили соответствие URL, затем проверили текст сообщения. Использовалась библиотека assertj, но можно сделать и вручную.
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
