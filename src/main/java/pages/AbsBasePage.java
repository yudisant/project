package pages;

import common.AbsCommon;
import data.TestingPageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class AbsBasePage extends AbsCommon {

    private final String path;

    public AbsBasePage(WebDriver driver, String path) {
        super(driver);
        this.path = path;
    }

    private String baseUrl = System.getProperty("base.url", "https://otus.ru");

    public AbsBasePage open() {
        baseUrl = baseUrl.endsWith("/") ? baseUrl.substring(0, baseUrl.length() - 1) : baseUrl;
        driver.get(baseUrl + path);

        return this;
    }

    public List<WebElement> getElement(TestingPageLocators locators) {
        return driver.findElements(By.cssSelector(locators.getLocator()));
    }
}
