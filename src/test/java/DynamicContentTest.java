import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DynamicContentTest extends FixedData {

    @Test
    public void dynamicCheck() {

        DynamicContentPage dynamicContent = new DynamicContentPage(driver);
        dynamicContent.safeDateBeforeContentChanges();
        dynamicContent.click();
        dynamicContent.safeDateAfterContentChanges();
        Assertions.assertEquals(dynamicContent.isDynamicContentPresent(), true);

    }

}
