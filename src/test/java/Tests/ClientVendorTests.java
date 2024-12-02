package Tests;

import Base.BaseTest;
import Ellithium.Utilities.assertion.AssertionExecutor;
import Ellithium.Utilities.helpers.JsonHelper;
import Ellithium.core.execution.Analyzer.RetryAnalyzer;
import Pages.Client;
import Pages.TransactionPage;
import org.testng.annotations.Test;
import utility.ScrollingUtils;

public class ClientVendorTests extends BaseTest {
    @Test( dependsOnMethods ="validLogin", priority = 1,description = "Test User is able to Post client debit",retryAnalyzer = RetryAnalyzer.class)
    public void PostBalance(){
        AssertionExecutor.soft softAssert=new AssertionExecutor.soft();
        var transactionPage=new TransactionPage(driver);
        String actualTitle=transactionPage.getPageTitle();
        String expectedTitle="Transactions";
        softAssert.assertTrue(actualTitle.contains(expectedTitle));
        var purchaseInvoicePage=transactionPage.navigateToClientVendorPage();
        var invoicePage=purchaseInvoicePage.clickAddBtn();
        invoicePage.selectClient(Client.ghhhhhhkhh);
        invoicePage.setDebit();
        ScrollingUtils.scrollDown(driver);
        invoicePage.saveInvoice();
        invoicePage.postInvoice();
        softAssert.assertTrue(invoicePage.isBalancePosted(),"Balance is posted Message is not visible");
        softAssert.assertAll();
    }
}
