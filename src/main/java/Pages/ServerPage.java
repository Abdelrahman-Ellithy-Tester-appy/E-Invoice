package Pages;

import Ellithium.Utilities.interactions.DriverActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
public class ServerPage {
    private AndroidDriver driver;
    private DriverActions driverActions;
    public ServerPage(AndroidDriver driver){
        this.driver=driver;
        this.driverActions=new DriverActions(driver);
    }
    private final By modeDropDown= AppiumBy.xpath("//android.widget.Button[@content-desc=\"Local - داخلي\" or @content-desc=\"Server - خارجي\" ]");
    private final By saveSettingsBtn=AppiumBy.accessibilityId("SAVE SETTINGS");
    private final By retrieveDB=AppiumBy.accessibilityId("Retrieve Database");
    public void selectMode(ServerMode mode){
        driverActions.clickOnElement(modeDropDown);
        driverActions.clickOnElement(LocatorsMap.getKeyName(mode));
    }
    public void clickRetrieveDB(){
        driverActions.clickOnElement(retrieveDB);
    }
    public LoginPage clickSaveSettingsBtn(){
        driverActions.clickOnElement(saveSettingsBtn);
        return new LoginPage(driver);
    }
}
