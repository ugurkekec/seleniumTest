import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestAll {
    public static final String BASE_URL = "https://connect-th.beinsports.com/en";

    public static void main(String[] args) {

        WebDriver webDriver = WebDriverFactory.getWebDriver(Driver.Chrome);
        webDriver.get(BASE_URL);

        WebDriverWait webDriverWait = WebDriverFactory.getWaitDriver(webDriver, 30);

        SubscriptionTest subscriptionTest = new SubscriptionTest(webDriver, webDriverWait);
        subscriptionTest.testOneMonthSubscription();
        subscriptionTest.testCreateAccount();
        subscriptionTest.testInfoDialog();
        subscriptionTest.testCheckBoxAndExitDialog();
        subscriptionTest.testPaymentPage();
    }
}
