package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BaseTest {
    private WebDriver webDriver;
    private WebDriverWait waitDriver;

    public BaseTest(WebDriver webDriver, WebDriverWait waitDriver) {
        this.webDriver = webDriver;
        this.waitDriver = waitDriver;
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public WebDriverWait getWaitDriver() {
        return waitDriver;
    }

    public void waitUntilAppearByName(String name) {
        waitDriver.until(ExpectedConditions.visibilityOfElementLocated(By.name(name)));
    }

    public void waitUntilAppearByXpath(String xPath) {
        waitDriver.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)));
    }

    public void waitUntilDisappearByName(String name) {
        waitDriver.until(ExpectedConditions.invisibilityOfElementLocated(By.name(name)));
    }

    public void waitUntilDisappearByXpath(String xPath) {
        waitDriver.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xPath)));
    }

    public WebElement findElement(By by){
        return webDriver.findElement(by);
    }
}
