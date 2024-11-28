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
    private final By ReceiveBillPDFElement= AppiumBy.accessibilityId("Receive Bill A4");
    private final By selectElement= AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.Button\").instance(1)");
    private final By itemFieldTypeElement= AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(3)");
    private final By printElement=AppiumBy.accessibilityId("Print");
    private final By postElement= AppiumBy.accessibilityId("Post");
    private final By loadingElement= AppiumBy.xpath("//*[contains(@content-desc, 'Loading')]");
    private final By amountElement= AppiumBy.androidUIAutomator("new UiSelector().text(\"0\")");
    private final By debitElement= AppiumBy.androidUIAutomator("new UiSelector().text(\"0.00\").instance(0)");
    private final By clintVendorPostSuccessElement= AppiumBy.accessibilityId("This balance is posted and can`t be modified");
    public InvoicePage(AndroidDriver driver){
        this.driver=driver;
        driverAction=new DriverActions(this.driver);
        driverAction.waitForElementToDisappear(loadingElement,30,200);
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
            return driverAction.getAttributeValue(PurchasePDFElement, "content-desc", 10, 200);
        }
        catch (Exception e){
            throw new AssertionError();
        }
    }
    public String getReceiveBillPDFPageTitle(){
        try {
            return driverAction.getAttributeValue(ReceiveBillPDFElement, "content-desc", 10, 200);
        }
        catch (Exception e){
            throw new AssertionError();
        }
    }
    public boolean isPostSuccessMessageVisible(){
        try {
            driverAction.waitForElementToBeVisible(successElement);
            return driver.findElement(successElement).isDisplayed();
        }catch (Exception e){
            return false;
        }
    }
    public boolean isBalancePosted(){
        try {
            driverAction.waitForElementToBeVisible(clintVendorPostSuccessElement);
            return driver.findElement(clintVendorPostSuccessElement).isDisplayed();
        }catch (Exception e){
            return false;
        }
    }
    public void setAmount(){
        driverAction.clickOnElement(amountElement);
        driver.pressKey(new KeyEvent(AndroidKey.DIGIT_1));
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }
    public void setDebit(){
        driverAction.clickOnElement(debitElement);
        driver.pressKey(new KeyEvent(AndroidKey.DIGIT_1));
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }
}