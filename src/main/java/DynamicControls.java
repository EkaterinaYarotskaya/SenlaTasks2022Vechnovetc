import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class DynamicControls implements PageObject {

    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"checkbox\"]")
    WebElement checkBox;

    @FindBy(css = "#checkbox-example > button")
    WebElement removeOrAddButton;

    @FindBy(css = "input[type='checkbox']")
    WebElement successfulButtonClickMessage;

    @FindBy(css = "input[type=text]")
    WebElement textInputField;

    @FindBy(css = "#input-example>button")
    WebElement enableOrDisableButton;

    @FindBy(css = "#input-example>#message")
    List<WebElement> buttonEnableOrDisableClickMassage;

    public DynamicControls(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isCheckBoxPresent() {
        List<WebElement> checkBoxes = new ArrayList<>();
        checkBoxes.add(checkBox);
        int size = checkBoxes.size();
        return size > 0;
    }

    public String getTextAfterClickOnRemoveOrAddButton() {
        return successfulButtonClickMessage.getText();
    }

    public void clickOnRemoveOrAddCheckBoxButton() {

        if (isCheckBoxPresent()) {
            removeOrAddButton.click();
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.stalenessOf(checkBox));
        } else {
            removeOrAddButton.click();
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.presenceOfElementLocated(
                            By.xpath ("//*[@id=\"checkbox\"]")));
        }
    }

//    public DynamicControls clickToRemoveOrAddCheckboxButton() {
//        if(isCheckboxPresent()) {
//            removeOrAddCheckboxButton.click();
//            new WebDriverWait(driver, 10)
//                    .until(ExpectedConditions.stalenessOf(driver.findElement(checkBox)));
//        } else {
//            removeOrAddCheckboxButton.click();
//            new WebDriverWait(driver, 10)
//                    .until(ExpectedConditions.presenceOfElementLocated(checkBox));
//        }
//        return this;
//    }
//


//    public String getTextEnableOrDisable() {
//        WebElement element = (new WebDriverWait(driver, Duration.ofSeconds(10))
//                .until(ExpectedConditions.presenceOfElementLocated(GET_MESSAGE)));
//        String text = element.getText();
//        return text;


    public boolean addTextOnField() {

        if (textInputField.isEnabled()) {
            textInputField.sendKeys("123");
            return true;
        } else {
            clickOnEnableOrDisableButton();
            textInputField.sendKeys("123");
            return true;
        }
    }

    public void clickOnEnableOrDisableButton() {

        enableOrDisableButton.click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(textInputField));
    }

    public boolean presentElementAfterClickOnEnableOrDisableButton() {

        int size = buttonEnableOrDisableClickMassage.size();
        return size > 0;
    }
}
