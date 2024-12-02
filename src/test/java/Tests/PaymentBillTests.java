package Tests;

import Base.BaseTest;
import Ellithium.Utilities.assertion.AssertionExecutor;
import Ellithium.core.execution.Analyzer.RetryAnalyzer;
import Pages.Client;
import Pages.TransactionPage;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import utility.ScrollingUtils;
public class PaymentBillTests extends BaseTest {
    @Test(dependsOnMethods = "validLogin",priority = 1,description = "Test User is able to Print client Balance",retryAnalyzer = RetryAnalyzer.class)
    @Severity(SeverityLevel.CRITICAL)
    public void PrintBalance(){
        AssertionExecutor.soft softAssert=new AssertionExecutor.soft();
        var transactionPage=new TransactionPage(driver);
        String actualTitle=transactionPage.getPageTitle();
        String expectedTitle="Transactions";
        softAssert.assertTrue(actualTitle.contains(expectedTitle));
        ScrollingUtils.scrollDown(driver);
        var purchaseInvoicePage=transactionPage.navigateToPaymentBillPage();
        var invoicePage=purchaseInvoicePage.clickAddBtn();
        invoicePage.selectClient(Client.ghhhhhhkhh);
        invoicePage.setAmount();
        ScrollingUtils.scrollDown(driver);
        ScrollingUtils.scrollDown(driver);
        ScrollingUtils.scrollDown(driver);
        invoicePage.saveInvoice();
        invoicePage.printInvoice();
        actualTitle=invoicePage.getPaymentBillPDFPageTitle();
        expectedTitle="Payment Bill A4";
        softAssert.assertTrue(actualTitle.contains(expectedTitle),"Page Title is wrong");
        softAssert.assertAll();
    }
    @Test(priority = 2,description = "Test User is able to post client Balance",retryAnalyzer = RetryAnalyzer.class)
    @Severity(SeverityLevel.CRITICAL)
    public void PostBalance(){
        AssertionExecutor.soft softAssert=new AssertionExecutor.soft();
        var transactionPage=new TransactionPage(driver);
        String actualTitle=transactionPage.getPageTitle();
        String expectedTitle="Transactions";
        softAssert.assertTrue(actualTitle.contains(expectedTitle));
        ScrollingUtils.scrollDown(driver);
        var purchaseInvoicePage=transactionPage.navigateToPaymentBillPage();
        var invoicePage=purchaseInvoicePage.clickAddBtn();
        invoicePage.selectClient(Client.ghhhhhhkhh);
        invoicePage.setAmount();
        ScrollingUtils.scrollDown(driver);
        ScrollingUtils.scrollDown(driver);
        ScrollingUtils.scrollDown(driver);
        invoicePage.saveInvoice();
        invoicePage.postInvoice();
        softAssert.assertTrue(invoicePage.isPostSuccessMessageVisible(),"Balance is posted Message is not visible");
        softAssert.assertAll();
    }
}
