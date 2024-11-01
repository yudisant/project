package pages;

import common.AbsCommon;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class AbsBasePage<T> extends AbsCommon {

    private final String path;

    public AbsBasePage(WebDriver driver,String path, WebDriverWait webDriverWait ) {
        super(driver, webDriverWait);
        this.path = path;
    }

    private String baseUrl = System.getProperty("base.url", "https://otus.ru");

    public T open() {
        baseUrl = baseUrl.endsWith("/") ? baseUrl.substring(0, baseUrl.length() - 1) : baseUrl;
        driver.get(baseUrl + path);

        return (T) this;
    }

    protected List<WebElement> getElements(String locators) {
        return driver.findElements(By.cssSelector(locators));
    }

    protected WebElement getElement(String locator) {
        return driver.findElement(By.cssSelector(locator));
    }
}
