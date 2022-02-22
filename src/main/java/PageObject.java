import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public interface PageObject {

    default void assertCheck(String expected, By selector) {
        String actual = FixedData.driver.findElement(selector).getText();
        Assertions.assertEquals(expected, actual);
    }
}
