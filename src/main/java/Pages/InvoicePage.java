package Pages;

import Ellithium.Utilities.interactions.DriverActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class InvoicePage {
    private AndroidDriver driver;
    private DriverActions driverAction;
    private final By saveElement= AppiumBy.accessibilityId("Save");
    private final By warningYesElement= AppiumBy.accessibilityId("Yes");
    private final By selectElement= AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.Button\").instance(1)");
    private final By itemFieldElement= AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(3)");
    private final By searchElement= AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.Button\").instance(5)");
    private final By printElement=AppiumBy.accessibilityId("Print");
    private final By postElement= AppiumBy.accessibilityId("Post");

    public InvoicePage(AndroidDriver driver){
        this.driver=driver;
        driverAction=new DriverActions(this.driver);
    }
    public void selectClient(Client client){
        driverAction.clickOnElement(selectElement);
        driverAction.sendData(selectElement,client.toString());
        driverAction.clickOnElement(LocatorsMap.getKeyName(client));
    }
    public void addProduct(String barcode){
        driverAction.clickOnElement(itemFieldElement);
        driverAction.sendData(itemFieldElement,barcode);
        driverAction.clickOnElement(searchElement);
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
    }
}