package Pages;

import Ellithium.Utilities.interactions.DriverActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import utility.ScrollingUtils;

public class InvoicePage {
    private AndroidDriver driver;
    private DriverActions driverAction;
    private final By saveElement= AppiumBy.accessibilityId("Save");
    private final By successElement= AppiumBy.accessibilityId("Success");
    private final By warningYesElement=AppiumBy.accessibilityId("Yes");
    private final By PosPDFElement= AppiumBy.id("com.android.printspooler:id/title");
    private final By PurchasePDFElement= AppiumBy.accessibilityId("Purchase Invoice A4");
    private final By selectElement= AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.Button\").instance(1)");
    private final By itemFieldTypeElement= AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(3)");
    private final By printElement=AppiumBy.accessibilityId("Print");
    private final By postElement= AppiumBy.accessibilityId("Post");
    private final By loadingElement= AppiumBy.xpath("//*[contains(@content-desc, 'Loading')]");
    public InvoicePage(AndroidDriver driver){
        this.driver=driver;
        driverAction=new DriverActions(this.driver);
        driverAction.waitForElementToDisappear(loadingElement,20,200);
    }
    public void selectClient(Client client){
        driverAction.clickOnElement(selectElement);
        driverAction.clickOnElement(LocatorsMap.getKeyName(client));
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }
    public void addProduct(String barcode){
        ScrollingUtils.scrollDown(driver);
        driverAction.clickOnElement(itemFieldTypeElement);
        driverAction.sendData(itemFieldTypeElement,barcode);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        driverAction.waitForElementToDisappear(loadingElement,12,200);
    }
    public void postInvoice(){
        try {
            driverAction.waitForElementToDisappear(loadingElement,5,100);
        }catch (Exception e){
        }
        driverAction.sleepSeconds(2);
        driverAction.clickOnElement(postElement);
    }
    public void saveInvoice(){
        driverAction.clickOnElement(saveElement);
    }
    public void printInvoice(){
        try {
            driverAction.waitForElementToDisappear(loadingElement,5,100);
        }catch (Exception e){
        }
        driverAction.sleepSeconds(2);
        driverAction.clickOnElement(printElement);
    }
    public void clickYesToWarning(){
        driverAction.clickOnElement(warningYesElement);
        driverAction.waitForElementToDisappear(loadingElement,10,200);
    }
    public String getPosPDFPageTitle(){
        try {
            return driverAction.getAttributeValue(PosPDFElement,"content-desc",10,200);
        }catch (Exception e){
            throw new AssertionError();
        }
    }
    public String getPurchasePDFPageTitle(){
        try {
            return driverAction.getAttributeValue(PurchasePDFElement, "content-desc", 12, 200);
        }
        catch (Exception e){
            throw new AssertionError();
        }
    }
    public boolean isPostSuccessMessageVisible(){
        try {
            driverAction.waitForElementToBeVisible(successElement);
            return driver.findElement(successElement).isEnabled();
        }catch (Exception e){
            return false;
        }
    }
}