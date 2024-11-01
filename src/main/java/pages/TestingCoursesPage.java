package pages;

import data.TestingPageLocators;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class TestingCoursesPage extends AbsBasePage<TestingCoursesPage> {

    public TestingCoursesPage(WebDriver driver) {
        super(driver, "/catalog/courses?categories=testing", new WebDriverWait(driver, Duration.ofSeconds(10)));
    }

    private List<WebElement> listofCurses() {
        return getElements(TestingPageLocators.CATALOG.getLocator());
    }

    public TestingCoursesPage checkingTheNumberOfCurses() {
        Assertions.assertEquals(listofCurses().size(), 10, "Количество курсов не совпадает");

        return this;
    }

    public TestingCoursesPage openingQaLead() {
        listofCurses().getFirst().click();

        return this;
    }
}
