package selenium.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.utils.SeleniumWrapper;


/*
    should stay in src/main/java
 */
public class SingleProductPO {

    private WebDriver driver;
    private WebDriverWait wait;
    private SeleniumWrapper seleniumWrapper;

    By sizeDropdown = By.id("group_1");
    By quantityControlUp = By.cssSelector(".touchspin-up");

    public SingleProductPO(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.seleniumWrapper = new SeleniumWrapper(driver);
    }

    public void selectSize(String size) {
        Select option = new Select(driver.findElement(sizeDropdown));
        option.selectByVisibleText(size);
    }

    public void increaseQuantityByOne() {
        seleniumWrapper.click(quantityControlUp);
    }
}
