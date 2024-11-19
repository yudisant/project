import factory.WebDriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.EventPage;

import java.text.ParseException;

public class EventPageTest {
    WebDriver driver;

    @BeforeEach
    public void setDriver() {
        driver = new WebDriverFactory().created();
        driver.manage().window().maximize();
    }

    @AfterEach
    public void close() {
        if(driver != null) {
            driver.quit();
        }
    }

    @Test
    public void checkDateEvent() throws ParseException, InterruptedException {
        new EventPage(driver)
                .open()
                .scrollPage()
                .comparisonDate();
    }

    @Test
    public void checkTypeEvent() throws InterruptedException {
        new EventPage(driver)
                .open()
                .choiceTypeEvent()
                .scrollPage()
                .checkTypeEvent();
    }
}
