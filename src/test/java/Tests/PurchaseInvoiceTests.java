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

public class PurchaseInvoiceTests extends BaseTest {
    @Test(priority = 1,description = "Test User is able to print purchase Invoice",dependsOnMethods = "validLogin",retryAnalyzer = RetryAnalyzer.class)
    @Severity(SeverityLevel.CRITICAL)
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
        softAssert.assertTrue(actualTitle.contains(expectedTitle),"Page Title is wrong");
        softAssert.assertAll();
    }
    @Test(priority = 2,description = "Test User is able to Post purchase Invoice",dependsOnMethods = "validLogin",retryAnalyzer = RetryAnalyzer.class)
    @Severity(SeverityLevel.CRITICAL)
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
        softAssert.assertTrue(invoicePage.isPostSuccessMessageVisible(),"Success Message is not visible");
        softAssert.assertAll();
    }
}
