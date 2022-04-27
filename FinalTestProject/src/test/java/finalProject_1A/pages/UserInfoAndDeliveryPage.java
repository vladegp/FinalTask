package finalProject_1A.pages;

import org.openqa.selenium.By;

public class UserInfoAndDeliveryPage extends BasePage {

    Helper helper = new Helper();

    private final By getProductAtOffice = By.xpath("//input[@value='2']");
    private final By deliveryAddress = By.xpath("//input[@value='3210']");
    private final By userName = By.id("address_first_name");
    private final By userSurname = By.id("address_last_name");
    private final By userPhoneNumber = By.id("address_phone_number");
    private final By pressSaveUserDataButton = By.xpath("//button[@type='submit']");
    private final By pressContinueButton = By.className("icon-arrow-right");
    private final By choosePaymentWay = By.id("payment_unused_22");

    public void changeTheDeliveryWay() {
        driver.findElement(getProductAtOffice).click();
        helper.timeOut(1500);
        driver.findElement(deliveryAddress).click();
    }

    public void unregisteredUserData(String customerName, String customerSurname, String customerPhoneNr) {
        helper.scrollDown();
        helper.timeOut(1500);
        driver.findElement(userName).sendKeys(customerName);
        driver.findElement(userSurname).sendKeys(customerSurname);
        driver.findElement(userPhoneNumber).sendKeys(customerPhoneNr);
        driver.findElement(pressSaveUserDataButton).click();
        helper.timeOut(1500);
        driver.findElement(pressContinueButton).click();
        driver.findElement(choosePaymentWay).click();
    }
}
