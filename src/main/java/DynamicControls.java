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
    List<WebElement>  checkBox;

    @FindBy(css = "#checkbox-example > button")
    WebElement removeOrAddButton;

    @FindBy(css = "#checkbox-example>p")
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

        int size = checkBox.size();
        return size > 0;
    }

    public String getTextAfterClickOnRemoveOrAddButton() {

        return successfulButtonClickMessage.getText();
    }

    public void clickOnRemoveOrAddCheckBoxButton() {
        boolean isCheckBoxPresent = isCheckBoxPresent();
        if (isCheckBoxPresent) {
            removeOrAddButton.click();
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.stalenessOf(
                            driver.findElement(By.xpath("//*[@id=\"checkbox\"]"))));
        } else {
            removeOrAddButton.click();
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.presenceOfElementLocated(
                            By.xpath("//*[@id=\"checkbox\"]")));
        }
    }

    public boolean addTextOnField() {

        if (textInputField.isEnabled()) {
            textInputField.sendKeys("123");
            return true;
        } else {
            return false;
        }
    }

    public String textSuccessfullyEntered(){
        String textInField = textInputField.getAttribute("value");
        return textInField;
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
