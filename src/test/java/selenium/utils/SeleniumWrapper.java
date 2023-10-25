package selenium.utils;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
    should stay in src/main/java
 */
public class SeleniumWrapper {
    public WebDriver driver;
    private WebDriverWait wait;

    public SeleniumWrapper(WebDriver driver){
        this.driver = driver;

        wait = new WebDriverWait(this.driver, 3000);

    }

    public void sendKeys(By by, String value){
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            driver.findElement(by).clear();
            driver.findElement(by).sendKeys(value);
        }catch(Exception e){
            e.printStackTrace();
            Assertions.fail("Could not set the value for the element located by: " + by);
        }
    }

    public void click(By by){
        try{
            wait.until(ExpectedConditions.elementToBeClickable(by));
            driver.findElement(by).click();
        }catch(Exception e){
            e.printStackTrace();
            Assertions.fail("Could not click the element located by: " + by);
        }
    }

}
