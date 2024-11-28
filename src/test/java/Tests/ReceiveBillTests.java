package Tests;

import Base.BaseTest;
import Ellithium.Utilities.assertion.AssertionExecutor;
import Ellithium.core.execution.Analyzer.RetryAnalyzer;
import Pages.Client;
import Pages.TransactionPage;
import org.testng.annotations.Test;
import utility.ScrollingUtils;

public class ReceiveBillTests extends BaseTest {
    @Test(priority = 1,description = "Test User is able to print Receive Bill",dependsOnMethods = "validLogin" ,retryAnalyzer = RetryAnalyzer.class)
    public void PrintReceiveBill(){
        AssertionExecutor.soft softAssert=new AssertionExecutor.soft();
        var transactionPage=new TransactionPage(driver);
        String actualTitle=transactionPage.getPageTitle();
        String expectedTitle="Transactions";
        softAssert.assertTrue(actualTitle.contains(expectedTitle));
        var receiveBillPage=transactionPage.navigateToReceiveBillPage();
        var invoicePage=receiveBillPage.clickAddBtn();
        invoicePage.selectClient(Client.ghhhhhhkhh);
        invoicePage.setAmount();
        ScrollingUtils.scrollDown(driver);
        ScrollingUtils.scrollDown(driver);
        ScrollingUtils.scrollDown(driver);
        invoicePage.saveInvoice();
        invoicePage.printInvoice();
        expectedTitle="Receive Bill A4";
        actualTitle=invoicePage.getReceiveBillPDFPageTitle();
        softAssert.assertTrue(actualTitle.contains(expectedTitle),"Page Title is wrong");
        softAssert.assertAll();
    }
    @Test(priority = 2,description = "Test User is able to post Receive Bill",dependsOnMethods = "validLogin" ,retryAnalyzer = RetryAnalyzer.class)
    public void PostReceiveBill(){
        AssertionExecutor.soft softAssert=new AssertionExecutor.soft();
        var transactionPage=new TransactionPage(driver);
        String actualTitle=transactionPage.getPageTitle();
        String expectedTitle="Transactions";
        softAssert.assertTrue(actualTitle.contains(expectedTitle));
        var receiveBillPage=transactionPage.navigateToReceiveBillPage();
        var invoicePage=receiveBillPage.clickAddBtn();
        invoicePage.selectClient(Client.ghhhhhhkhh);
        invoicePage.setAmount();
        ScrollingUtils.scrollDown(driver);
        ScrollingUtils.scrollDown(driver);
        ScrollingUtils.scrollDown(driver);
        invoicePage.saveInvoice();
        invoicePage.postInvoice();
        softAssert.assertTrue(invoicePage.isPostSuccessMessageVisible(),"Success Message is not visible");
        softAssert.assertAll();
    }
}
