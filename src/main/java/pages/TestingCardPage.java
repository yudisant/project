package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestingCardPage extends TestingCoursesPage{

    public TestingCardPage(WebDriver driver) {
        super(driver);
    }

    By nameCurses = By.cssSelector("[class='sc-1og4wiw-0 sc-s2pydo-1 iLVLDh diGrSa']");
    By descriptionCurses = By.cssSelector("[class='sc-1og4wiw-0 sc-s2pydo-3 jfNqTr dZDxRw']");
    By componentsCurses = By.cssSelector("[class='sc-3cb1l3-4 kGoYMV']");

    public void comparisonTestingCard() throws InterruptedException {
        logger.info("Проверка описание страницы курса");
        List<WebElement> webElementList = getElements(componentsCurses);
        String name = getElement(nameCurses).getText();
        String description = getElement(descriptionCurses).getText();

        Assertions.assertEquals(name, getNameCourse());
        Assertions.assertEquals(description, getDescription());

        for (WebElement component : webElementList) {
            Assertions.assertEquals(component.getText(), checkDuration());
            checkFormat();
        }
        driver.navigate().back();
    }

    private String checkDuration() {
        logger.info("Получение продолжительности курса");
        Pattern pattern = Pattern.compile(".месяц.");
        List<WebElement> components = getElements(componentsCurses);
        for(var el : components) {
            if(el.isEnabled()) {
                Matcher matcher = pattern.matcher(el.getText());
                if(matcher.find()) {
                    return el.getText();
                }
            }
        }
        return checkDuration();
    }

    private boolean checkFormat() {
        logger.info("Сравнение формата курсов");
        List<WebElement> components = getElements(componentsCurses);
        for (var el : components) {
            if(el.isEnabled()) {
                 return el.getText().equals("Онлайн");
            }
        }
        return checkFormat();
    }

    private String getNameCourse() throws InterruptedException {
        logger.info("Получение названия курса");
        Thread.sleep(5000);
        return getElement(nameCurses).getText();
    }

    private String getDescription() throws InterruptedException {
        logger.info("Получение описания курса");
        Thread.sleep(5000);
        return getElement(descriptionCurses).getText();
    }
}
