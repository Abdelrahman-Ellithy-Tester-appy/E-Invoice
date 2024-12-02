package Pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;

public class ClientVendorPage extends BaseInvoicesPage {
    public ClientVendorPage(AndroidDriver driver){
        super(driver);
        driverActions.waitForElementToDisappear(loadingElement,10,200);
    }
}
