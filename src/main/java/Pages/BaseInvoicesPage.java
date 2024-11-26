package Pages;

import Ellithium.Utilities.interactions.DriverActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class BaseInvoicesPage {

    protected AndroidDriver driver;
    protected DriverActions driverActions;
    protected final By addElement= AppiumBy.accessibilityId("Add");
    protected final By backElement= AppiumBy.accessibilityId("Back");
    protected final By warningYesElement= AppiumBy.accessibilityId("Yes");
    public BaseInvoicesPage(AndroidDriver driverParam){
        this.driver=driverParam;
        driverActions=new DriverActions(driver);
    }
    public PosInvoicePage clickAddBtn(){
        driverActions.clickOnElement(addElement);
        return new PosInvoicePage(driver);
    }
    public void clickBack(){
        driverActions.clickOnElement(addElement);
    }
    public void clickYesToWarning(){
        driverActions.clickOnElement(warningYesElement);
    }
}
