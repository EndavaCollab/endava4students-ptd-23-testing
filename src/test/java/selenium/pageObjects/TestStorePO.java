package selenium.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.utils.SeleniumWrapper;


/*
    should stay in src/main/java
 */
public class TestStorePO {

    private WebDriver driver;
    private WebDriverWait wait;
    private SeleniumWrapper seleniumWrapper;

    By hummingBirdTshirt = By.linkText("Hummingbird Printed T-Shirt");

    public TestStorePO(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.seleniumWrapper = new SeleniumWrapper(driver);
    }

    public void selectHummingBirdTshirt() {
        seleniumWrapper.click(hummingBirdTshirt);
    }
}
