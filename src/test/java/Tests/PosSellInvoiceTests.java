package Tests;

import Base.BaseTest;
import Ellithium.Utilities.assertion.AssertionExecutor;
import Ellithium.Utilities.helpers.JsonHelper;
import Pages.*;
import org.testng.annotations.Test;
import utility.ScrollingUtils;

public class PosSellInvoiceTests extends BaseTest {
    @Test(description = "Test User is able to post Sell Invoice")
    public void PrintInvoice(){
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
        var transactionPage=dashboardPage.navigateToTransactionPage();
        actualTitle=transactionPage.getPageTitle();
        expectedTitle="Transactions";
        softAssert.assertTrue(actualTitle.contains(expectedTitle));
        var posSellInvoicePage=transactionPage.navigateToPOSSellInvoicePage();
        var invoicePage=posSellInvoicePage.clickAddBtn();
        invoicePage.selectClient(Client.ghhhhhhkhh);
        ScrollingUtils.scrollDown(driver);
        ScrollingUtils.scrollDown(driver);
        invoicePage.addProduct(JsonHelper.getJsonKeyValue(JsonDataFilePath,"barcode"));
        invoicePage.saveInvoice();
        invoicePage.clickYesToWarning();
        invoicePage.printInvoice();
        invoicePage.printInvoice();
        actualTitle=invoicePage.getPDFPageTitle();
        expectedTitle="Save as PDF";
        softAssert.assertTrue(actualTitle.contains(expectedTitle));
        softAssert.assertAll();
    }
}
