package Pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class ClientVendorPage extends BaseInvoicesPage {
    private final By saveElement= AppiumBy.accessibilityId("Save");
    public ClientVendorPage(AndroidDriver driver){
        super(driver);
    }
    public void clickSaveBtn(){
        driverActions.clickOnElement(saveElement);
    }
}
