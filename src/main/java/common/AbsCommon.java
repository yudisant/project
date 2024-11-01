package common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class AbsCommon {

    protected WebDriver driver;
    protected WebDriverWait webDriverWait;
    protected static final Logger logger = LogManager.getLogger();

    public AbsCommon(WebDriver driver, WebDriverWait webDriverWait) {
        this.driver = driver;
        this.webDriverWait = webDriverWait;

        PageFactory.initElements(driver, this);
    }
}
