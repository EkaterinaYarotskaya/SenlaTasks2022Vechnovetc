import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class DynamicContentTest extends FixedData {

    //тут можно написать еще один BeforeEach и там открывать нужный урл
    //Сначала будет отрабатывать BeforeEach родительского класса FixedData, затем уже метод в тесте

    @BeforeEach
    public void beforeTest() {
        driver.get(dynamicContentUrl);
    }

    @Test
    public void dynamicCheck() {

        DynamicContentPage dynamicContent = new DynamicContentPage(driver);
        List<String> contentBeforeClick = dynamicContent.saveContentData();
        dynamicContent.click();
        List<String> contentAfterClick = dynamicContent.saveContentData();
        //метод работает и с коллекциями, сравнивая их содержимое
        Assertions.assertNotEquals(contentBeforeClick, contentAfterClick);
        //Если нужна проверка на true или false используй
        //  Assertions.assertTrue();
        //  Assertions.assertFalse();
//        Assertions.assertEquals(dynamicContent.isDynamicContentPresent(), true);
    }
}
