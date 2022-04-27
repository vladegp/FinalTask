package finalProject_1A.pages;

import finalProject_1A.models.UserModel;
import org.openqa.selenium.By;

public class HomePage extends BasePage {

    Helper helper = new Helper();
    UserModel userInfo = new UserModel();

    private final By removeCookiesNotification = By.xpath("//a[@href='javascript:void(0)']");
    private final By enterSearchQuery = By.id("q");
    private final By pressSearchProduct = By.className("main-search-submit");
    private final By selectProduct = By.xpath("//a[@data-gtm-link='461039']");
    private final By addToCardButton = By.id("add_to_cart_btn");
    private final By closePopUpWindow = By.xpath("//button[@class='fancybox-button fancybox-close-small']");
    private final By goToCard = By.xpath("//i[@class='cart-block__icon icon-svg']");
    private final By continueOrder = By.xpath("//input[@class='main-button cart-main-button']");
    private final By enterUnregisteredUserEmail = By.id("user_email");
    private final By pressContinueButton = By.xpath("//input[@value='Turpināt']");

    public void removeCookies() {
        driver.findElement(removeCookiesNotification).click();
    }

    public void searchProduct(String productSearchQuery) {
        driver.findElement(enterSearchQuery).sendKeys(productSearchQuery);
        driver.findElement(pressSearchProduct).click();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void selectPreferredProduct() {
        helper.scrollDown();
        helper.timeOut(1500);
        driver.findElement(selectProduct).click();
    }

    public void addToCart() {
        driver.findElement(addToCardButton).click();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void closePopUp() {
        driver.findElement(closePopUpWindow).click();
    }

    public void switchToParent() {
        driver.switchTo().parentFrame();
    }

    public void goToCart() {
        driver.findElement(goToCard).click();
    }

    public void completeOrder(String userEmail) {
        driver.findElement(continueOrder).click();
        driver.findElements(enterUnregisteredUserEmail).get(1).sendKeys(userEmail);
        driver.findElement(pressContinueButton).click();
    }
}

