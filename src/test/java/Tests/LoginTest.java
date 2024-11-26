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
        DashboardPage dashboardPage=loginRoutine();
        AssertionExecutor.soft softAssert = new AssertionExecutor.soft();
        String actualTitle=dashboardPage.getPageTitle();
        String expectedTitle="Dashboard";
        softAssert.assertTrue(actualTitle.contains(expectedTitle));
    }
}
