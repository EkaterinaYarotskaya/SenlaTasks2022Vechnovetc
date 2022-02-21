import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class FixedData {
   protected static    String pageURL = "http://the-internet.herokuapp.com/login";
    protected static  WebDriver driver;
    @BeforeAll
    public static   void beforeAllTests() {

        System.setProperty("webdriver.chrome.driver",
                "chromedriver_win32\\chromedriver.exe");         }
    @BeforeEach
    public   void beforeEach() {
        driver=new ChromeDriver();
        driver.get(pageURL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));}
    @AfterEach
    public   void afterEach() {
        driver.quit();
    }
}
