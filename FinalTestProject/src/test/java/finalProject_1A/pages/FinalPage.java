package finalProject_1A.pages;

import finalProject_1A.models.ProductModel;
import org.openqa.selenium.By;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FinalPage extends BasePage {

    ProductModel productModel = new ProductModel();

    private final By priceOnPage = By.xpath("//span[@class='price']");
    private final By nameOnPage = By.xpath("//*[@class='product-righter google-rich-snippet']/h1");
    private final By priceOnSummary = By.xpath("//span[@class='checkout-order-summary-total__price']");
    private final By nameOnSummary = By.xpath("//a[@class='detailed-cart-item__name-link']");

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
        String priceOnProductPage = driver.findElement(priceOnPage).getText();
        productModel.setProductPrice(priceOnProductPage);
        String productNameOnProductPage = driver.findElement(nameOnPage).getText();
        productModel.setProductName(productNameOnProductPage);

    }
    public void getPriceOnSummaryPage(){
        String priceOnOrderSummary = driver.findElement(priceOnSummary).getText();
        assertThat(priceOnOrderSummary).isEqualTo(productModel.getProductPrice());
    }

    public void getProductNameInTheEnd(){
        String productNameInTheEnd = driver.findElement(nameOnSummary).getText();
        assertThat(productNameInTheEnd).isEqualTo(productModel.getProductName());
    }
}
