package finalProject_1A.pages;

import org.openqa.selenium.JavascriptExecutor;

import static finalProject_1A.pages.BasePage.driver;

public class Helper {

    public void timeOut(int timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,700)");
    }
}
