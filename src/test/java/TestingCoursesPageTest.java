import factory.WebDriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.QaLeadPage;
import pages.TestingCoursesPage;

public class TestingCoursesPageTest {

    private WebDriver driver;

    @BeforeEach
    public void init() {
        driver = new WebDriverFactory().created();
    }

    @AfterEach
    public void close() {
        if(driver != null) {
            driver.quit();
        }
    }

    @Test
    public void checkTestingPage() throws InterruptedException {
        new TestingCoursesPage(driver)
                .open()
                .checkingTheNumberOfCurses()
                .openingQaLead();
        new QaLeadPage(driver).checkingData();
        Thread.sleep(10000);

    }
}
