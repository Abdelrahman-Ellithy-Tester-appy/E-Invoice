package Base;

import Ellithium.Utilities.helpers.JsonHelper;
import Ellithium.core.base.NonBDDSetup;
import Ellithium.core.driver.DriverFactory;
import Ellithium.core.driver.DriverType;
import Pages.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import utility.ScrollingUtils;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest extends NonBDDSetup {
    protected AndroidDriver driver;
    protected String JsonDataFilePath="src/test/resources/TestData/TestData";
    @BeforeMethod
    public void setUp() throws MalformedURLException {
        UiAutomator2Options caps=new UiAutomator2Options();
        caps.setDeviceName(JsonHelper.getJsonKeyValue(JsonDataFilePath,"DeviceName"));
        caps.setAppActivity(JsonHelper.getJsonKeyValue(JsonDataFilePath,"AppActivity"));
        caps.setAppPackage(JsonHelper.getJsonKeyValue(JsonDataFilePath,"AppPackage"));
        caps.setCapability("appium:noReset", false);
        caps.setCapability("appium:fullReset", false);
        driver=DriverFactory.getNewDriver(DriverType.Android,new URL("http://127.0.0.1:4723"),caps);
    }
    protected DashboardPage loginRoutine(){
        LoginPage loginPage=new LoginPage(driver);
        var serverPage=loginPage.clickSwitchBtn();
        serverPage.selectMode(ServerMode.SERVER_MODE);
        serverPage.clickRetrieveDB();
        ScrollingUtils.scrollDown(driver);
        loginPage.selectDB(DB.NADA922);
        loginPage=serverPage.clickSaveSettingsBtn();
        loginPage.setUsername(JsonHelper.getJsonKeyValue(JsonDataFilePath,"username"));
        loginPage.setPassword(JsonHelper.getJsonKeyValue(JsonDataFilePath,"password"));
        ScrollingUtils.scrollDown(driver);
        ScrollingUtils.scrollDown(driver);
        loginPage.setBranch(DropDownOptions.Company_Building_1);
        loginPage.setStore(DropDownOptions.Company_Building_1);
        loginPage.setCacheRegister(DropDownOptions.Company_Building_1);
        return loginPage.clickLoginBtn();
    }
    @AfterMethod
    public void tareDown( ){
        DriverFactory.quitDriver();
    }
}
