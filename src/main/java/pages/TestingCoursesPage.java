package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TestingCoursesPage extends AbsBasePage<TestingCoursesPage> {
// TODO проверить локаторы
    By listOfCurses = By.cssSelector("[class='sc-18q05a6-1 bwGwUO'] a");
    By button = By.className("sc-mrx253-0 enxKCy sc-prqxfo-0 cXVWAS");

    public TestingCoursesPage(WebDriver driver) {
        super(driver, "/catalog/courses?categories=testing");
    }

    private List<WebElement> listOfCurses() {
        logger.info("Получение списка типов курса");
        return driver.findElements(listOfCurses);
    }

    public TestingCoursesPage clickButton() {
        logger.info("Нажатие кнопки открыть");
        WebElement btn = driver.findElement(button);
        btn.click();

        return this;
    }

    public void checkingTheNumberOfCurses() {
        logger.info("Сравнение колличества карточек курсов");
        Assertions.assertEquals(listOfCurses()
                .size(), 10, "Количество курсов не совпадает");
    }

    public TestingCoursesPage openTestingCard() {
        logger.info("Открытие карточки курса");
        for(WebElement element : listOfCurses()) {
            element.click();
            break;
        }
        return this;
    }

}
