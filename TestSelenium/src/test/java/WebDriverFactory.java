import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverFactory {

    public static WebDriver getWebDriver(Driver driver) {
        WebDriver webDriver;
        switch (driver) {
            case Chrome:
                webDriver = new ChromeDriver();
                break;
            case Firefox:
                webDriver = new FirefoxDriver();
                break;
            case Opera:
                webDriver = new OperaDriver();
                break;
            default:
                webDriver = new ChromeDriver();
        }
        return webDriver;
    }

    public static WebDriverWait getWaitDriver(WebDriver webDriver, int timeOut) {
        return new WebDriverWait(webDriver, timeOut);
    }
}
