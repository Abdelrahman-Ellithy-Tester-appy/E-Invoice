package Pages;

import Ellithium.Utilities.interactions.DriverActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class TransactionPage {
    private final By POSSellInvoiceElement= AppiumBy.accessibilityId("POS Sell Invoice");
    private final By ClientVendorElement= AppiumBy.accessibilityId("Client/Vendor Beginning Balance");
    private final By PaymentBillElement= AppiumBy.accessibilityId("Payment Bill");
    private final By PurchaseInvoiceElement= AppiumBy.accessibilityId("Purchase Invoice");
    private final By ReceiveBillElement= AppiumBy.accessibilityId("Receive Bill");
    private final By TitleElement= AppiumBy.androidUIAutomator("new UiSelector().description(\"Transactions\").instance(0)");
    private AndroidDriver driver;
    private DriverActions driverAction;
    public TransactionPage(AndroidDriver driver1){
        this.driver=driver1;
        driverAction=new DriverActions(driver);
    }
    public String getPageTitle(){
        return driverAction.getAttributeValue(TitleElement,"content-desc");
    }
    public ReceiveBillPage navigateToReceiveBillPage(){
        driverAction.clickOnElement(ReceiveBillElement);
        return new ReceiveBillPage(driver);
    }
    public PaymentBillPage navigateToPaymentBillPage(){
        driverAction.clickOnElement(PaymentBillElement);
        return new PaymentBillPage(driver);
    }
    public ClientVendorPage navigateToClientVendorPage(){
        driverAction.clickOnElement(ClientVendorElement);
        return new ClientVendorPage(driver);
    }
    public POSSellInvoicePage navigateToPOSSellInvoicePage(){
        driverAction.clickOnElement(POSSellInvoiceElement);
        return new POSSellInvoicePage(driver);
    }
    public PurchaseInvoicePage navigateToPurchaseInvoicePage(){
        driverAction.clickOnElement(PurchaseInvoiceElement);
        return new PurchaseInvoicePage(driver);
    }
}
