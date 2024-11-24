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
    protected AppiumDriverLocalService serviceBuilder;
    protected String JsonDataFilePath="src/test/resources/TestData/TestData";

    @BeforeClass
    public void setUp() throws MalformedURLException {
        String appiumMainJsPath=System.getProperty("user.home").concat("\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js");
        serviceBuilder = new AppiumServiceBuilder().
                withAppiumJS(new File(appiumMainJsPath)).withIPAddress("0.0.0.0").usingPort(4723).build();
        //serviceBuilder.start();
        UiAutomator2Options options=new UiAutomator2Options();
        options.setDeviceName(JsonHelper.getJsonKeyValue(JsonDataFilePath,"DeviceName"));
        options.setAppActivity(JsonHelper.getJsonKeyValue(JsonDataFilePath,"AppActivity"));
        options.setAppPackage(JsonHelper.getJsonKeyValue(JsonDataFilePath,"AppPackage"));
        options.setCapability("appium:noReset", true);
        options.setCapability("appium:fullReset", false);
        driver=DriverFactory.getNewDriver(DriverType.Android,new URL("http://127.0.0.1:4723"),options);
    }
    @AfterClass
    public void tareDown( ){
//        String fileName="Test-Output/VideoRecords/TestRecord"+TestDataGenerator.getTimeStamp()+".mp4";
        DriverFactory.quitDriver();
        serviceBuilder.stop();
        serviceBuilder.close();
    }
}
