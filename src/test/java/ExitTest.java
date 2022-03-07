import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

//можно было все тесты сделать в одном классе, не вижу необходимости этот тест выделять в отдельный
public class ExitTest extends FixedData {

    //такого рода данные типо логин, пароль, URL обычно пишут в файл с расширением .property, читай ссылку ниже
    // https://devcolibri.com/%D0%BF%D1%80%D0%BE%D1%81%D1%82%D0%BE%D0%B9-%D0%BF%D1%80%D0%B8%D0%BC%D0%B5%D1%80-%D1%80%D0%B0%D0%B1%D0%BE%D1%82%D1%8B-%D1%81-property-%D1%84%D0%B0%D0%B9%D0%BB%D0%B0%D0%BC%D0%B8-%D0%B2-java/
    String CORRECT_LOGIN = "tomsmith";
    String CORRECT_PASSWORD = "SuperSecretPassword!";

    @Test
    public void logoutTest() {
        driver.findElement(By.id("username")).sendKeys(CORRECT_LOGIN);
        driver.findElement(By.id("password")).sendKeys(CORRECT_PASSWORD);
        driver.findElement(By.tagName("button")).click();
        driver.findElement(By.cssSelector("a.button.secondary")).click();
        String actual = driver.findElement(By.cssSelector("#content > div > h2")).getText();
        System.out.println(actual);
        String expected = "Login Page";
        Assertions.assertEquals(expected, actual);
    }
}