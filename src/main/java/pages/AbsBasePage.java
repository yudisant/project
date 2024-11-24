package pages;

import common.AbsCommon;
import org.openqa.selenium.*;

import java.util.List;

public abstract class AbsBasePage<T> extends AbsCommon {

    private final String path;
    private String baseUrl = System.getProperty("base.url", "https://otus.ru");

    By load = By.cssSelector("[class='dod_new-loader-wrapper js-dod_new-loader-wrapper']");
    By visibleLoad = By.cssSelector("[class='dod_new-loader-wrapper js-dod_new-loader-wrapper dod_new-loader-wrapper_visible']");
    By dropDown = By.cssSelector("[class='dod_new-events-dropdown__input-selected']");
    By choiceTypeEvent = By.cssSelector("[class='dod_new-events-dropdown__list-item']");

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
        var height = ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight");
        while(true) {
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
            Thread.sleep(3000);
            var newHeight = ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight");
            if(newHeight.equals(height)) {
                break;
            } else {
                height = newHeight;
            }
        }
        return (T) this;
    }

    public T choiceTypeEvent() {
        WebElement popup = getElement(dropDown);
        if(isElementReady(popup)) {
            for(var element : getElements(choiceTypeEvent)) {
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
