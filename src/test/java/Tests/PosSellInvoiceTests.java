package Tests;

import Base.BaseTest;
import Ellithium.Utilities.assertion.AssertionExecutor;
import Ellithium.Utilities.helpers.JsonHelper;
import Ellithium.core.execution.Analyzer.RetryAnalyzer;
import Pages.*;
import org.testng.annotations.Test;
import utility.ScrollingUtils;
public class PosSellInvoiceTests extends BaseTest {
    @Test(description = "Test User is able to print Sell Invoice", dependsOnMethods ="validLogin",retryAnalyzer = RetryAnalyzer.class)
    public void POSPrintInvoice(){
        AssertionExecutor.soft softAssert=new AssertionExecutor.soft();
        var transactionPage=new TransactionPage(driver);
        String actualTitle=transactionPage.getPageTitle();
        String expectedTitle="Transactions";
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
        actualTitle=invoicePage.getPosPDFPageTitle();
        expectedTitle="Save as PDF";
        softAssert.assertTrue(actualTitle.contains(expectedTitle));
        softAssert.assertAll();
    }
    @Test(description = "Test User is able to post Sell Invoice",dependsOnMethods = "validLogin" ,retryAnalyzer = RetryAnalyzer.class)
    public void POSPostInvoice(){
        AssertionExecutor.soft softAssert=new AssertionExecutor.soft();
        var transactionPage=new TransactionPage(driver);
        String actualTitle=transactionPage.getPageTitle();
        String expectedTitle="Transactions";
        softAssert.assertTrue(actualTitle.contains(expectedTitle),"Page Title is wrong");
        var posSellInvoicePage=transactionPage.navigateToPOSSellInvoicePage();
        var invoicePage=posSellInvoicePage.clickAddBtn();
        invoicePage.selectClient(Client.ghhhhhhkhh);
        ScrollingUtils.scrollDown(driver);
        ScrollingUtils.scrollDown(driver);
        invoicePage.addProduct(JsonHelper.getJsonKeyValue(JsonDataFilePath,"barcode"));
        invoicePage.saveInvoice();
        invoicePage.clickYesToWarning();
        invoicePage.postInvoice();
        invoicePage.clickYesToWarning();
        softAssert.assertTrue(invoicePage.isPostSuccessMessageVisible(),"Success Message is not visible");
        softAssert.assertAll();
    }
}
