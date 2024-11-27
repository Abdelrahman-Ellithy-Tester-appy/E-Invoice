package Tests;

import Base.BaseTest;
import Ellithium.Utilities.assertion.AssertionExecutor;
import Ellithium.Utilities.helpers.JsonHelper;
import Ellithium.core.execution.Analyzer.RetryAnalyzer;
import Pages.*;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import utility.ScrollingUtils;

public class LoginTest extends BaseTest {
    @Test(description = "Test valid Login")
    @Severity(SeverityLevel.CRITICAL)
    public void validLogin()  {
        LoginPage loginPage=new LoginPage(driver);
        var serverPage=loginPage.clickSwitchBtn();
        serverPage.selectMode(ServerMode.SERVER_MODE);
        serverPage.clickRetrieveDB();
        ScrollingUtils.scrollDown(driver);
//        loginPage.selectDB(DB.NADA922);
        loginPage=serverPage.clickSaveSettingsBtn();
        loginPage.setUsername(JsonHelper.getJsonKeyValue(JsonDataFilePath,"username"));
        loginPage.setPassword(JsonHelper.getJsonKeyValue(JsonDataFilePath,"password"));
        ScrollingUtils.scrollDown(driver);
        ScrollingUtils.scrollDown(driver);
        loginPage.setBranch(DropDownOptions.Company_Building_1);
        loginPage.setStore(DropDownOptions.Company_Building_1);
        loginPage.setCacheRegister(DropDownOptions.Company_Building_1);
        DashboardPage dashboardPage=loginPage.clickLoginBtn();
        String actualTitle=dashboardPage.getPageTitle();
        String expectedTitle="Dashboard";
        dashboardPage.navigateToTransactionPage();
        AssertionExecutor.hard.assertTrue(actualTitle.contains(expectedTitle));
    }
}
