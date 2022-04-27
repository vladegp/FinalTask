package finalProject_1A.pages;

import org.openqa.selenium.By;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FinalPage extends BasePage {

    ProductPage productPage = new ProductPage();

    private final By priceOnPage = By.xpath("//span[@class='price']");
    private final By nameOnPage = By.xpath("//*[@class='product-righter google-rich-snippet']/h1");
    private final By priceOnSummary = By.xpath("//span[@class='checkout-order-summary-total__price']");
    private final By nameOnSummary = By.xpath("//a[@class='detailed-cart-item__name-link']");

    String priceOnProductPage;
    String priceOnOrderSummary;
    String productNameOnProductPage;
    String productNameInTheEnd;

    public void checkMainPageLoaded() {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String mainPage = driver.getCurrentUrl();
        assertThat(mainPage).isEqualTo("https://www.1a.lv/");
    }

    public void getPriceAndNameOnProductPage() {
        priceOnProductPage = driver.findElement(priceOnPage).getText();
        productPage.productPrice = priceOnProductPage;
        productNameOnProductPage = driver.findElement(nameOnPage).getText();
        productPage.productName = productNameOnProductPage;

    }
    public void getPriceOnSummaryPage(){
        priceOnOrderSummary = driver.findElement(priceOnSummary).getText();
        assertThat(priceOnOrderSummary).isEqualTo(productPage.productPrice);
    }

    public void getProductNameInTheEnd(){
        productNameInTheEnd = driver.findElement(nameOnSummary).getText();
        assertThat(productNameInTheEnd).isEqualTo(productPage.productName);
    }
}
