package pages;

import data.TestingPageLocators;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TestingCoursesPage extends AbsBasePage {

    public TestingCoursesPage(WebDriver driver) {
        super(driver, "/catalog/courses?categories=testing");
    }

    private List<WebElement> listofCurses() {
        return getElement(TestingPageLocators.CATALOG);
    }

    public TestingCoursesPage checkingTheNumberOfCurses() {
        Assertions.assertEquals(listofCurses().size(), 10, "Количество курсов не совпадает");

        return this;
    }

}
