package finalProject_1A.pages;

import org.openqa.selenium.chrome.ChromeDriver;

public class BasePage {

    public static ChromeDriver driver;

    public void openChromeUrl(String url) {
        String driverPath = "/Users/vladislavpavlovic/Library/Mobile Documents/com~apple~CloudDocs/QA/FinalTestProject/src/test/resources/chromedriver";
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
    }

    public void closeChrome(){
        driver.quit();
    }
}

