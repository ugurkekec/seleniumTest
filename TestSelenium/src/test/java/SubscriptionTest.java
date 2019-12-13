import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SubscriptionTest extends BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(SubscriptionTest.class);

    public SubscriptionTest(WebDriver webDriver, WebDriverWait webDriverWait) {
        super(webDriver, webDriverWait);
    }

    /**
     * Tests subscription plan
     */
    public void testOneMonthSubscription() {
        waitUntilDisappearByXpath("//*[@id=\"loading\"]");
        waitUntilAppearByName("Subscribe");
        findElement(By.name("Subscribe")).click();

        String loadingIconXpath = "//*[@id=\"loading\"]";
        waitUntilDisappearByXpath(loadingIconXpath);
        waitUntilAppearByXpath("//span[text()='ONE MONTH']");

        By oneMonth = By.xpath("//span[text()='ONE MONTH']");
        findElement(oneMonth).click();

        String oneMonthTrialXpath = "/html/body/div[6]/div[3]/div/div[2]/div[2]/div[2]/a";
        waitUntilAppearByXpath(oneMonthTrialXpath);

        By oneMonthTrial = By.xpath(oneMonthTrialXpath);
        findElement(oneMonthTrial).click();
    }

    public void testCreateAccount() {
        waitUntilDisappearByXpath("//*[@id=\"loading\"]");

        String firstNameXpath = "//*[@id=\"form-register\"]/div/div[2]/div[3]/input";
        waitUntilAppearByXpath(firstNameXpath);
        findElement(By.xpath(firstNameXpath)).sendKeys("test");

        String lastNameXpath = "//*[@id=\"form-register\"]/div/div[2]/div[4]/input";
        waitUntilAppearByXpath(lastNameXpath);
        findElement(By.xpath(lastNameXpath)).sendKeys("testSurname");

        String emailXpath = "//*[@id=\"form-register\"]/div/div[2]/div[5]/input";
        waitUntilAppearByXpath(emailXpath);
        findElement(By.xpath(emailXpath)).sendKeys("test99@gmail.com");

        String passwordXpath = "//*[@id=\"password\"]";
        waitUntilAppearByXpath(passwordXpath);
        findElement(By.xpath(passwordXpath)).sendKeys("Abc123456");

        String createAccountButtonXpath = "//*[@id=\"form-register\"]/div/div[2]/div[11]/input";
        waitUntilAppearByXpath(createAccountButtonXpath);
        By createAccountButton = By.xpath(createAccountButtonXpath);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        findElement(createAccountButton).click();
    }

    public void testInfoDialog() {
        String infoExitButtonXpath = "//*[@id=\"close\"]";
        waitUntilAppearByXpath(infoExitButtonXpath);
        findElement(By.xpath(infoExitButtonXpath)).click();
    }

    public void testCheckBoxAndExitDialog() {
        waitUntilDisappearByXpath("//*[@id=\"loading\"]");
        String checkBoxXpath = "//*[@id=\"form-basket\"]/div[1]/div[4]/div[1]/label";
        waitUntilAppearByXpath(checkBoxXpath);
        findElement(By.xpath(checkBoxXpath)).click();

        String checkBoxPath = "//*[@id=\"checkTerms\"]";

        if (findElement(By.xpath(checkBoxPath)).isSelected()) {
            String payNowXpath = "//*[@id=\"form-basket\"]/div[1]/div[6]/input[2]";
            findElement(By.xpath(payNowXpath)).click();
        } else {
            logger.error("Check-Box is not checked");
        }
    }

    public void testPaymentPage() {
        String cardHoldersNameXpath = "//*[@id=\"Ecom_Payment_Card_Name\"]";
        waitUntilAppearByXpath(cardHoldersNameXpath);
        findElement(By.xpath(cardHoldersNameXpath)).sendKeys("testUser");

        String cardNumberXpath = "//*[@id=\"Ecom_Payment_Card_Number\"]";
        waitUntilAppearByXpath(cardNumberXpath);
        findElement(By.xpath(cardNumberXpath)).sendKeys("5555555555554444");

        String expireDateMonthXpath = "//*[@id=\"Ecom_Payment_Card_ExpDate_Month\"]";
        waitUntilAppearByXpath(expireDateMonthXpath);
        findElement(By.xpath(expireDateMonthXpath)).sendKeys("06");

        String expireDateYearXpath = "//*[@id=\"Ecom_Payment_Card_ExpDate_Year\"]";
        waitUntilAppearByXpath(expireDateYearXpath);
        findElement(By.xpath(expireDateYearXpath)).sendKeys("2022");

        String cardVerificationCodeXpath = "//*[@id=\"Ecom_Payment_Card_Verification\"]";
        waitUntilAppearByXpath(cardVerificationCodeXpath);
        findElement(By.xpath(cardVerificationCodeXpath)).sendKeys("800");

        String confirmPaymentXpath = "//*[@id=\"submit3\"]";
        waitUntilAppearByXpath(confirmPaymentXpath);
        findElement(By.xpath(confirmPaymentXpath)).click();

        paymentResult();
    }

    public void paymentResult() {
        String paymentSuccessXpath = "//*[@id=\"content\"]/div/table[2]/tbody/tr/td";
        waitUntilAppearByXpath(paymentSuccessXpath);

        String paymentFailedXpath = "//*[@id=\"content\"]/div/table[2]/tbody/tr/td/h3";
        waitUntilAppearByXpath(paymentFailedXpath);

        if (findElement(By.xpath(paymentSuccessXpath)).getText().contains("This order has already been processed")) {
            logger.info("Payment process is success");
        } else {
            logger.info("Payment process has been denied");
        }
    }
}
