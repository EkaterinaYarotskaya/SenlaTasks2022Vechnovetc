import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DynamicControlsTest extends FixedData {

    @BeforeEach
    public void beforeTest() {
        driver.get(dynamicControlUrl);
    }

    @Test
    public void clickOnCheckBox() {
        DynamicControls dynamicControls = new DynamicControls(driver);
        Assertions.assertTrue(dynamicControls.isCheckBox());
    }

    @Test
    public void removeAndAddButton() {
        DynamicControls dynamicControls = new DynamicControls(driver);
        dynamicControls.clickOnRemoveOrAddButton();
        Assertions.assertEquals("It's gone!", dynamicControls.getText());
        dynamicControls.clickOnRemoveOrAddButton();
        Assertions.assertEquals("It's back!", dynamicControls.getText());
    }

    @Test
    public void addTextToField() {
        DynamicControls dynamicControls = new DynamicControls(driver);
        dynamicControls.clickOnEnableOrDisableButton();
        Assertions.assertTrue(dynamicControls.addTextOnField());
        dynamicControls.clickOnEnableOrDisableButton();
        Assertions.assertFalse(dynamicControls.addTextOnField());

    }

    @Test
    public void presentsElementOnPageBeforeAndAfterClickOnButton() {
        DynamicControls dynamicControls = new DynamicControls(driver);
        Assertions.assertFalse(dynamicControls.presentElementOnWeb());
        dynamicControls.clickOnEnableOrDisableButton();
        Assertions.assertTrue(dynamicControls.presentElementOnWeb());


    }
}
