package Base;

import Ellithium.Utilities.helpers.JsonHelper;
import Ellithium.core.base.NonBDDSetup;
import Ellithium.core.driver.DriverFactory;
import Ellithium.core.driver.DriverType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest extends NonBDDSetup {
    protected AndroidDriver driver;
    protected String JsonDataFilePath="src/test/resources/TestData/TestData";

    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options caps=new UiAutomator2Options();
        caps.setDeviceName(JsonHelper.getJsonKeyValue(JsonDataFilePath,"DeviceName"));
        caps.setAppActivity(JsonHelper.getJsonKeyValue(JsonDataFilePath,"AppActivity"));
        caps.setAppPackage(JsonHelper.getJsonKeyValue(JsonDataFilePath,"AppPackage"));
        caps.setCapability("appium:noReset", true);
        caps.setCapability("appium:fullReset", false);
        driver=DriverFactory.getNewDriver(DriverType.Android,new URL("http://127.0.0.1:4723"),caps);
    }
    @AfterClass
    public void tareDown( ){
        DriverFactory.quitDriver();
    }
}
