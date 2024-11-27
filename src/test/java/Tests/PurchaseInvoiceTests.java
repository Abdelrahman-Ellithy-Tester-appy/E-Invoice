package Tests;

import Base.BaseTest;
import Ellithium.Utilities.assertion.AssertionExecutor;
import Ellithium.Utilities.helpers.JsonHelper;
import Ellithium.core.execution.Analyzer.RetryAnalyzer;
import Pages.*;
import org.testng.annotations.Test;
import utility.ScrollingUtils;

public class PurchaseInvoiceTests extends BaseTest {
    @Test(description = "Test User is able to print purchase Invoice",dependsOnMethods = "LoginTest.validLogin",retryAnalyzer = RetryAnalyzer.class)
    public void PurchasePrintInvoice(){
        AssertionExecutor.soft softAssert=new AssertionExecutor.soft();
        var transactionPage=new TransactionPage(driver);
        String actualTitle=transactionPage.getPageTitle();
        String expectedTitle="Transactions";
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
    @Test(description = "Test User is able to Post purchase Invoice",dependsOnMethods = "LoginTest.validLogin",retryAnalyzer = RetryAnalyzer.class)
    public void PurchasePostInvoice(){
        AssertionExecutor.soft softAssert=new AssertionExecutor.soft();
        var transactionPage=new TransactionPage(driver);
        String actualTitle=transactionPage.getPageTitle();
        String expectedTitle="Transactions";
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
