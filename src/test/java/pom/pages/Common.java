package pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pom.utils.Driver;
import java.time.Duration;

public class Common {
    public static void setUpChrome(boolean isHeadless) {
        Driver.setUpChromeDriver(isHeadless);
    }

    public static void setUpChrome(boolean isHeadless, int waitDurationSeconds) {
        Driver.setUpChromeDriver(isHeadless);
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(waitDurationSeconds));
    }

    public static void openUrl(String url) {
        Driver.getDriver().get(url);
    }

    public static void closeWindow() {
        Driver.closeDriver();
    }

    public static void quitDriver() {
        Driver.quitDriver();
    }

    public static String getText(By locator) {
        return getElement(locator).getText();
    }

    public static String getAttribute(By locator, String attribute) {
        return getElement(locator).getAttribute(attribute);
    }

    public static void clickOnElement(By locator) {
        getElement(locator).click();
    }

    public static void hoverOnElement(By locator) {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(getElement(locator)).perform();
    }

    public static boolean waitForElementToBeVisible(By locator, int seconds) {
        boolean isVisible;
        int duration = 0;
        do {
            try {
                Thread.sleep(500);
                getElement(locator).isDisplayed();
                isVisible = true;
            } catch (NoSuchElementException e) {
                isVisible = false;
            } catch (InterruptedException e) {
                e.printStackTrace();
                return false;
            }
            duration++;
        } while (!isVisible || duration / 2 >= seconds);
        return isVisible;
    }

    private static WebElement getElement(By locator) {
        return Driver.getDriver().findElement(locator);
    }
}
