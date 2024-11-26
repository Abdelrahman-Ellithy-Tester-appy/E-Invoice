package Pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;

public class ClientVendorPage extends BaseInvoicesPage {
    private final By saveElement= AppiumBy.accessibilityId("Save");

    private final By dropDownElement=AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.Button\").instance(1)");

    public ClientVendorPage(AndroidDriver driver){
        super(driver);
    }
    public void clickSaveBtn(){
        driverActions.clickOnElement(saveElement);
    }
    public void SelectClient(){

    }
    public void selectClient(Client client){
        driverActions.clickOnElement(dropDownElement);
        driverActions.clickOnElement(LocatorsMap.getKeyName(client));
    }
}
