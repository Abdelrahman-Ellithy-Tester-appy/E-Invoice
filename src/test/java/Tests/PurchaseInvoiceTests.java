package Tests;

import Base.BaseTest;
import Ellithium.Utilities.assertion.AssertionExecutor;
import Ellithium.Utilities.helpers.JsonHelper;
import Pages.*;
import org.testng.annotations.Test;
import utility.ScrollingUtils;

public class PurchaseInvoiceTests extends BaseTest {
    @Test(description = "Test User is able to print purchase Invoice")
    public void PurchasePrintInvoice(){
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
        var purchaseInvoicePage=transactionPage.navigateToPurchaseInvoicePage();
        var invoicePage=purchaseInvoicePage.clickAddBtn();
        invoicePage.selectClient(Client.ghhhhhhkhh);
        ScrollingUtils.scrollDown(driver);
        ScrollingUtils.scrollDown(driver);
        invoicePage.addProduct(JsonHelper.getJsonKeyValue(JsonDataFilePath,"barcode"));
        invoicePage.saveInvoice();
        invoicePage.printInvoice();
        invoicePage.printInvoice();
        actualTitle=invoicePage.getPurchasePDFPageTitle();
        expectedTitle="Purchase Invoice A4";
        softAssert.assertTrue(actualTitle.contains(expectedTitle));
        softAssert.assertAll();
    }
    @Test(description = "Test User is able to Post purchase Invoice")
    public void PurchasePostInvoice(){
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
        var purchaseInvoicePage=transactionPage.navigateToPurchaseInvoicePage();
        var invoicePage=purchaseInvoicePage.clickAddBtn();
        invoicePage.selectClient(Client.ghhhhhhkhh);
        ScrollingUtils.scrollDown(driver);
        ScrollingUtils.scrollDown(driver);
        invoicePage.addProduct(JsonHelper.getJsonKeyValue(JsonDataFilePath,"barcode"));
        invoicePage.saveInvoice();
        invoicePage.postInvoice();
        invoicePage.clickYesToWarning();
        softAssert.assertTrue(invoicePage.isPostSuccessMessageVisible());
        softAssert.assertAll();
    }
}
