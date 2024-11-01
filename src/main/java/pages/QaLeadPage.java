package pages;

import data.QaLeadLocators;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class QaLeadPage extends AbsBasePage<TestingCoursesPage> {


    public QaLeadPage(WebDriver driver) {
        super(driver, "/lessons/qa-lead/", new WebDriverWait(driver, Duration.ofSeconds(10)));
    }


    public TestingCoursesPage checkingData() {
        Assertions.assertEquals(getNameCourses(), "QA Lead");
        Assertions.assertEquals(getStartDate(), "29 октября");
        Assertions.assertEquals(getDuration(), "6 месяцев");
        Assertions.assertEquals(getTrainingFormat(), "Онлайн");
        Assertions.assertEquals(getDaysOfTheEvent(), "Вт/Чт 19:00 Мск");

        return (TestingCoursesPage) this;
    }

    private List<WebElement> getDescription() {
        return getElements(QaLeadLocators.DESCRIPTION.getLocator());
    }

    private String getNameCourses() {
        return getElement(QaLeadLocators.NAMECOURSES.getLocator()).getText();
    }

    private String getStartDate() {
        return getDescription().get(0).getText();
    }
    private String getDuration() {
        return getDescription().get(1).getText();
    }

    private String getTrainingFormat() {
        return getDescription().get(2).getText();
    }

    private String getDaysOfTheEvent() {
        return getDescription().get(3).getText();
    }
}
