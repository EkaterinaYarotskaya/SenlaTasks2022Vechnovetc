import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FixedData implements PageObject {

    protected WebDriver driver;
    FileInputStream fis;
    String loginPageUrl;
    String correctLogin;
    String correctPassword;
    String incorrectLogin;
    String incorrectPassword;
    String dynamicContentUrl;
    String dynamicControlUrl;

    @BeforeAll
    public static void beforeAllTests() {
        System.setProperty("webdriver.chrome.driver",
                "chromedriver_win32\\chromedriver.exe");
    }

    @BeforeEach
    public void beforeEach() {
        driver = new ChromeDriver();

        //инициализацию переменных из проперти вынеси в бефорАлл, нам нет необходимости при каждом новом тесте лезть в проперти
        //вытащили их разок перед всеми тестами и пользуемся
        Properties property = new Properties();
        {
            try {
                fis = new FileInputStream("src/main/properties/config.properties");
                property.load(fis);

                //нет необходимости обзывать заглавными, correctLogin, correctPassword
                //в файле проперти аналогично
                loginPageUrl = property.getProperty("loginPageUrl");
                correctLogin = property.getProperty("correctLogin");
                correctPassword = property.getProperty("correctPassword");
                incorrectLogin = property.getProperty("incorrectLogin");
                incorrectPassword = property.getProperty("incorrectPassword");
                dynamicContentUrl = property.getProperty("dynamicContentUrl");
                dynamicControlUrl = property.getProperty("dynamicControlUrl");
            } catch (IOException ex) {
                ex.printStackTrace();
                System.err.println("ОШИБКА: Файл свойств отсуствует!");
            }
        }
    }

    @AfterEach
    public void afterEach() {
        driver.quit();
    }
}
