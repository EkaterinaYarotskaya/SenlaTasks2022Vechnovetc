import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DynamicControlsTest extends FixedData {
    DynamicControls dynamicControls;
    String dynamicControlUrl = property.getProperty("dynamicControlUrl");

    @BeforeEach
    public void beforeEachTest() {
        driver.get(dynamicControlUrl);
        dynamicControls = new DynamicControls(driver);
    }

    @Test
    public void clickOnCheckBox() {
        Assertions.assertTrue(dynamicControls.isCheckBoxPresent());
    }

    @Test
    public void removeAndAddButton() {

        dynamicControls.clickOnRemoveOrAddCheckBoxButton();
        Assertions.assertEquals("It's gone!", dynamicControls.getTextAfterClickOnRemoveOrAddButton());
        dynamicControls.clickOnRemoveOrAddCheckBoxButton();
        Assertions.assertEquals("It's back!", dynamicControls.getTextAfterClickOnRemoveOrAddButton());
    }

    @Test
    public void addTextToField() {

        dynamicControls.clickOnEnableOrDisableButton();
        Assertions.assertTrue(dynamicControls.addTextOnField());
        dynamicControls.clickOnEnableOrDisableButton();
        Assertions.assertTrue(dynamicControls.addTextOnField());
    }

    @Test
    public void presentsElementOnPageBeforeAndAfterClickOnButton() {

        Assertions.assertFalse(dynamicControls.presentElementAfterClickOnEnableOrDisableButton());
        dynamicControls.clickOnEnableOrDisableButton();
        Assertions.assertTrue(dynamicControls.presentElementAfterClickOnEnableOrDisableButton());


    }
}
