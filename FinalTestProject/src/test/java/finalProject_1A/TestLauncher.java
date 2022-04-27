package finalProject_1A;

import finalProject_1A.pages.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestLauncher {

    BasePage basePage = new BasePage();
    HomePage homePage = new HomePage();
    FinalPage finalPage = new FinalPage();
    UserInfoAndDeliveryPage userAndDelivery = new UserInfoAndDeliveryPage();
    Helper helper = new Helper();

    @Before
    public void startChrome(){
        basePage.openChromeUrl("https://www.1a.lv/");
    }

    @After
    public void closeChrome(){
        basePage.closeChrome();
    }

    @Test
    public void searchProduct() {
        finalPage.checkMainPageLoaded();
        homePage.removeCookies();
        homePage.searchProduct("MacBook Pro");
        homePage.selectPreferredProduct();
        finalPage.getPriceAndNameOnProductPage();
        homePage.addToCart();
        homePage.switchToParent();
        homePage.closePopUp();
        homePage.goToCart();
        finalPage.getProductNameInTheEnd();
        homePage.completeOrder("uncer@gfail.com");
        userAndDelivery.changeTheDeliveryWay();
        userAndDelivery.unregisteredUserData("Uncer", "Ivanov", "26432935");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
