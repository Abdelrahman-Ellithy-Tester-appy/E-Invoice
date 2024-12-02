package Pages;

import Ellithium.Utilities.interactions.DriverActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class BaseInvoicesPage {

    protected AndroidDriver driver;
    protected DriverActions driverActions;
    protected final By addElement= AppiumBy.accessibilityId("Add");
    protected final By warningYesElement= AppiumBy.accessibilityId("Yes");
    protected final By loadingElement= AppiumBy.xpath("//*[contains(@content-desc, 'Loading')]");
    public BaseInvoicesPage(AndroidDriver driverParam){
        this.driver=driverParam;
        driverActions=new DriverActions(driver);
    }
    public InvoicePage clickAddBtn(){
        driverActions.clickOnElement(addElement);
        return new InvoicePage(driver);
    }
    public void clickBack(){
        driverActions.clickOnElement(addElement);
    }
    public void clickYesToWarning(){
        driverActions.clickOnElement(warningYesElement);
    }
}
