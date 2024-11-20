package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TestingCoursesPage extends AbsBasePage<TestingCoursesPage> {
// TODO проверить локаторы
    By listOfCurses = By.cssSelector("[class='sc-18q05a6-1 bwGwUO'] a");
    By button = By.cssSelector("[class='sc-mrx253-0 enxKCy sc-prqxfo-0 cXVWAS']");
    By banner = By.cssSelector("[class='sticky-banner__close js-sticky-banner-close']");

    public TestingCoursesPage(WebDriver driver) {
        super(driver, "/catalog/courses?categories=testing");
    }

    private List<WebElement> listOfCurses() {
        return getElements(listOfCurses);
    }

    public TestingCoursesPage clickButton() {
        logger.info("Нажатие кнопки открыть");
        WebElement closedBanner = getElement(banner);
        closedBanner.click();
        WebElement btn = getElement(button);
        btn.click();

        return this;
    }

    public void checkingTheNumberOfCurses() {
        logger.info("Получение списка типов курса");
        logger.info("Сравнение количества карточек курсов");
        Assertions.assertEquals(listOfCurses()
                .size(), 11, "Количество курсов не совпадает");
        logger.info("Количество курсов: {}", listOfCurses().size());
    }

    public void openTestingCard() {
        logger.info("Открытие карточки курса");
        listOfCurses().getFirst().click();
    }

}
