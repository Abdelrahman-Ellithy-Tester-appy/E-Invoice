package Pages;

import Ellithium.Utilities.interactions.DriverActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;

public class InvoicePage {
    private AndroidDriver driver;
    private DriverActions driverAction;
    private final By saveElement= AppiumBy.accessibilityId("Save");
    private final By warningYesElement=AppiumBy.accessibilityId("Yes");

    private final By PDFElement= AppiumBy.id("com.android.printspooler:id/title");
    private final By selectElement= AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.Button\").instance(1)");
    private final By itemFieldClickElement= AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(4)");
    private final By itemFieldTypeElement= AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(3)");
    private final By printElement=AppiumBy.accessibilityId("Print");
    private final By postElement= AppiumBy.accessibilityId("Post");
    private final By loadingElement= AppiumBy.xpath("//*[contains(@content-desc, 'Loading')]");
    public InvoicePage(AndroidDriver driver){
        this.driver=driver;
        driverAction=new DriverActions(this.driver);
        driverAction.waitForElementToDisappear(loadingElement,10,200);
    }
    public void selectClient(Client client){
        driverAction.clickOnElement(selectElement);
        driverAction.clickOnElement(LocatorsMap.getKeyName(client));
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }
    public void addProduct(String barcode){
        driverAction.clickOnElement(itemFieldClickElement);
        driverAction.sendData(itemFieldTypeElement,barcode);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        driverAction.waitForElementToDisappear(loadingElement,10,200);
    }
    public void postInvoice(){
        driverAction.clickOnElement(postElement);
    }
    public void saveInvoice(){
        driverAction.clickOnElement(saveElement);
    }
    public void printInvoice(){
        driverAction.clickOnElement(printElement);
    }
    public void clickYesToWarning(){
        driverAction.clickOnElement(warningYesElement);
        driverAction.waitForElementToDisappear(loadingElement,10,200);
    }
    public String getPDFPageTitle(){
        return driverAction.getAttributeValue(PDFElement,"text",10,200);
    }
}