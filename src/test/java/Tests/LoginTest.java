package Tests;

import Base.BaseTest;
import Ellithium.Utilities.helpers.JsonHelper;
import Pages.DropDownOptions;
import Pages.LoginPage;
import Pages.ServerMode;
import org.testng.annotations.Test;
import utility.ScrollingUtils;

public class LoginTest extends BaseTest {
    @Test(description = "Test valid Login")
    public void validLogin()  {
        LoginPage loginPage=new LoginPage(driver);
        var serverPage=loginPage.clickSwitchBtn();
        serverPage.selectMode(ServerMode.SERVER_MODE);
        serverPage.clickRetrieveDB();
        ScrollingUtils.scrollDown(driver);
        loginPage=serverPage.clickSaveSettingsBtn();
        ScrollingUtils.scrollDown(driver);
        ScrollingUtils.scrollDown(driver);
        loginPage.setUsername(JsonHelper.getJsonKeyValue(JsonDataFilePath,"username"));
        loginPage.setPassword(JsonHelper.getJsonKeyValue(JsonDataFilePath,"password"));
        loginPage.setBranch(DropDownOptions.shereen_branch_bill);
        loginPage.setStore(DropDownOptions.shereen_branch_bill);
        loginPage.setCacheRegister(DropDownOptions.shereen_branch_bill);
        loginPage.clickLoginBtn();
    }
}
