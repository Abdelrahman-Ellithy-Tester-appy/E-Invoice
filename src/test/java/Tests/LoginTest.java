package Tests;

import Base.BaseTest;
import Ellithium.Utilities.assertion.AssertionExecutor;
import Ellithium.Utilities.helpers.JsonHelper;
import Pages.DashboardPage;
import Pages.DropDownOptions;
import Pages.LoginPage;
import Pages.ServerMode;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import utility.ScrollingUtils;

public class LoginTest extends BaseTest {
    @Test(description = "Test valid Login" ,priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    public void validLogin()  {
        LoginPage loginPage=new LoginPage(driver);
        var serverPage=loginPage.clickSwitchBtn();
        serverPage.selectMode(ServerMode.SERVER_MODE);
        serverPage.clickRetrieveDB();
        ScrollingUtils.scrollDown(driver);
        loginPage=serverPage.clickSaveSettingsBtn();
        loginPage.setUsername(JsonHelper.getJsonKeyValue(JsonDataFilePath,"username"));
        ScrollingUtils.scrollDown(driver);
        loginPage.setPassword(JsonHelper.getJsonKeyValue(JsonDataFilePath,"password"));
        loginPage.setBranch(DropDownOptions.Company_Building_1);
        loginPage.setStore(DropDownOptions.Company_Building_1);
        loginPage.setCacheRegister(DropDownOptions.Company_Building_1);
        DashboardPage dashboardPage=loginPage.clickLoginBtn();
        AssertionExecutor.soft softAssert = new AssertionExecutor.soft();
        String actualTitle=dashboardPage.getPageTitle();
        String expectedTitle="Dashboard";
        softAssert.assertTrue(actualTitle.contains(expectedTitle));
    }
}
