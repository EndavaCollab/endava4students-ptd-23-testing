package selenium.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import selenium.base.BasePage;


public class ShopTest extends BasePage {

    @Test
    public void addItemToCart() throws InterruptedException {

        // navigate to URL
        driver.get(properties.getProperty("url"));

        // to perform Scroll on application using Selenium
        homePage.scrollPage(500);

        // access test store
        homePage.openTestStoreApp();

        // select product
        testStorePO.selectHummingBirdTshirt();

        // select size
        singleProductPO.selectSize("M");

        // add one more product
        singleProductPO.increaseQuantityByOne();

        // click add to cart
        driver.findElement(By.cssSelector(".add-to-cart")).click();
        Thread.sleep(4000);

        // click proceed to checkout
        driver.findElement(By.cssSelector(".cart-content-btn .btn-primary")).click();
        Thread.sleep(4000);

        // get total value
        WebElement totalValue = driver.findElement(By.cssSelector(".cart-summary-line.cart-total > .value"));

        try {
            // compare values
            Assertions.assertEquals(totalValue.getText(), "$45.24");
            report.createTest("Add product").pass("Product added successfully!");
        } catch (AssertionError e) {
            report.createTest("Add product").fail("Could NOT buy product!");
            Assertions.fail("Could not buy product!");
        }
    }

}
