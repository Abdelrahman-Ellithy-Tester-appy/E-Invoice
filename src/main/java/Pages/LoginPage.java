package Pages;

import Ellithium.Utilities.interactions.DriverActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;

import java.util.Map;

public class LoginPage {
    private final AndroidDriver driver;
    private final DriverActions driverActions;
    private final By switchBtn= AppiumBy.className("android.widget.Switch");
    private final By usernameElement=AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(0)");
    private final By passwordElement=AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(1)");
    private final By branchElement=AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(2)");
    private final By storeElement=AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(3)");
    private final By cacheRegisterElement=AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(4)");
    private final By loginBtn= AppiumBy.accessibilityId("LOGIN");
    private final By dbDropDown= AppiumBy.accessibilityId("20240921test");
    public LoginPage(AndroidDriver driver){
        this.driver=driver;
        this.driverActions=new DriverActions(driver);
    }
    public void setUsername(String username){
        driverActions.clickOnElement(usernameElement);
        driverActions.sendData(usernameElement,username);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }
    public void setPassword(String password){
        driverActions.clickOnElement(passwordElement);
        driverActions.sendData(passwordElement,password);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    public void setBranch(DropDownOptions option ) {
        driverActions.clickOnElement(branchElement);
        driverActions.clickOnElement(LocatorsMap.getKeyName(option));
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));

    }
    public void setStore( DropDownOptions option) {
        driverActions.clickOnElement(storeElement);
        driverActions.clickOnElement(LocatorsMap.getKeyName(option));
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        //driverActions.clickOnElement(AppiumBy.xpath("//android.widget.Button[contains(@content-desc,"+store+")]"));
    }
    public void setCacheRegister(DropDownOptions option ) {
        driverActions.clickOnElement(cacheRegisterElement);
        driverActions.clickOnElement(LocatorsMap.getKeyName(option));
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        //driverActions.clickOnElement(AppiumBy.xpath("//android.widget.Button[contains(@content-desc,"+cacheRegister+")]"));
        //driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }
    public void selectDB(DB db) {
        driverActions.clickOnElement(dbDropDown);
        driverActions.clickOnElement(LocatorsMap.getKeyName(db));
    }
    public ServerPage clickSwitchBtn(){
        driverActions.clickOnElement(switchBtn);
        return new ServerPage(driver);
    }
    public DashboardPage clickLoginBtn(){
        driverActions.clickOnElement(loginBtn);
        return new DashboardPage(driver);
    }
}
