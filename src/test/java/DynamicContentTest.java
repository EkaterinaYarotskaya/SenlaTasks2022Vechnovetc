import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class
DynamicContentTest extends FixedData {

    //тут можно написать еще один BeforeEach и там открывать нужный урл
    //Сначала будет отрабатывать BeforeEach родительского класса FixedData, затем уже метод в тесте

    String dynamicContentUrl = property.getProperty("dynamicContentUrl");

    @BeforeEach
    public void beforeTest() {
        driver.get(dynamicContentUrl);

    }

    @Test
    public void dynamicCheck() {

        DynamicContentPage dynamicContent = new DynamicContentPage(driver);
        List<String> contentBeforeClick = dynamicContent.saveContentData();
        dynamicContent.clickOnClickHereLink();
        List<String> contentAfterClick = dynamicContent.saveContentData();
        Assertions.assertNotEquals(contentBeforeClick, contentAfterClick);
    }
}
