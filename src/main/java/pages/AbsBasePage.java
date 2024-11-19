package pages;

import common.AbsCommon;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public abstract class AbsBasePage<T> extends AbsCommon {

    private final String path;
    private String baseUrl = System.getProperty("base.url", "https://otus.ru");

    public AbsBasePage(WebDriver driver,String path) {
        super(driver);
        this.path = path;
    }

    public T open() {
        baseUrl = baseUrl.endsWith("/") ? baseUrl.substring(0, baseUrl.length() - 1) : baseUrl;
        driver.get(baseUrl + path);

        return (T) this;
    }

    public T scrollPage() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(3));
        var height = ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight");
        while(true) {
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
            var newHeight = ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight");
            wait.wait();
            if (newHeight.equals(height)) {
                break;
            } else {
                height = newHeight;
            }
        }
        return (T) this;
    }

    public T choiceTypeEvent() {
        WebElement popup = driver.findElement(By.className("dod_new-events-dropdown__input-selected"));
        if(isElementReady(popup)) {
            for(var element : driver.findElements(By.className("dod_new-events-dropdown__list-item"))) {
                if(element.getText().equals("Открытый вебинар")) {
                    element.click();
                    break;
                } else {
                    popup.click();
                }
            }
        }
        return (T) this;
    }

    protected List<WebElement> getElements(By locators) {
        return driver.findElements(locators);
    }

    protected WebElement getElement(By locator) {
        return driver.findElement(locator);
    }

    protected boolean isElementReady(WebElement locator) {
        try {
            return locator.isDisplayed() && locator.isEnabled();
        } catch (NoSuchElementException ignored) {
            return false;
        }
    }
}
