package common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbsCommon {

    protected WebDriver driver;
    protected static final Logger logger = LogManager.getLogger();

    public AbsCommon(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }
}
