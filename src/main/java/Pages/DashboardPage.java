package Pages;

import Ellithium.Utilities.interactions.DriverActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
public class DashboardPage {
    private final By TitleElement= AppiumBy.androidUIAutomator("new UiSelector().description(\"Dashboard\").instance(0)");
    private final By transactionElement= AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.View\").instance(12)");
    private final By infraDataElement= AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.View\").instance(14)");

    private AndroidDriver driver;
    private DriverActions driverAction;
    public DashboardPage(AndroidDriver driver1){
        this.driver=driver1;
        driverAction=new DriverActions(driver);
    }
    public String getPageTitle(){
        return driverAction.getAttributeValue(TitleElement,"content-desc");
    }
    public TransactionPage navigateToTransactionPage(){
        driverAction.clickOnElement(transactionElement);
        return new TransactionPage(driver);
    }
    public InfraDataPage navigateToInfraDataPage(){
        driverAction.clickOnElement(infraDataElement);
        return new InfraDataPage(driver);
    }
}
