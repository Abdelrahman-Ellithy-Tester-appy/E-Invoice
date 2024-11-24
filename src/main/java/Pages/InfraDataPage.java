package Pages;

import Ellithium.Utilities.interactions.DriverActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class InfraDataPage {
    private AndroidDriver driver;
    private DriverActions driverAction;
    public InfraDataPage(AndroidDriver driver1){
        this.driver=driver1;
        driverAction=new DriverActions(driver);
    }
}
