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
    String pageURL;
    String CORRECT_LOGIN;
    String CORRECT_PASSWORD;
    String INCORRECT_LOGIN;
    String INCORRECT_PASSWORD;
    String pageURL_DYNAMIC;
    String pageURL_DYNAMIC_CONTROL;

    @BeforeAll
    public static void beforeAllTests() {
        System.setProperty("webdriver.chrome.driver",
                "chromedriver_win32\\chromedriver.exe");
    }

    @BeforeEach
    public void beforeEach() {
        driver = new ChromeDriver();

        Properties property = new Properties();
        {
            try {
                fis = new FileInputStream("src/main/properties/config.properties");
                property.load(fis);

                pageURL = property.getProperty("pageURL");
                CORRECT_LOGIN = property.getProperty("CORRECT_LOGIN");
                CORRECT_PASSWORD = property.getProperty("CORRECT_PASSWORD");
                INCORRECT_LOGIN = property.getProperty("INCORRECT_LOGIN");
                INCORRECT_PASSWORD = property.getProperty("INCORRECT_PASSWORD");
                pageURL_DYNAMIC = property.getProperty("pageURL_DYNAMIC");
                pageURL_DYNAMIC_CONTROL= property.getProperty("pageURL_DYNAMIC_CONTROL");
                driver.get(pageURL_DYNAMIC_CONTROL);
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
