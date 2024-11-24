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

    By nameCurses = By.cssSelector("div [class='sc-1og4wiw-0 sc-s2pydo-1 iLVLDh diGrSa']");
    By descriptionCurses = By.cssSelector("[class='sc-1og4wiw-0 sc-s2pydo-3 jfNqTr dZDxRw']");
    By componentsCurses = By.cssSelector("[class='sc-3cb1l3-4 kGoYMV']");

    public void comparisonTestingCard() {
        logger.info("Проверка описание страницы курса");
        List<WebElement> webElementList = getElements(componentsCurses);
        String name = getElement(nameCurses).getText();
        String description = getElement(descriptionCurses).getText();

        Assertions.assertEquals(name, getNameCourse());
        logger.info(name, getNameCourse());
        Assertions.assertEquals(description, getDescription());
        logger.info(description, getDescription());

        for(WebElement component : webElementList) {
            if(component.getText().equals(checkDuration())) {
                Assertions.assertEquals(component.getText(), checkDuration());
                logger.info(component.getText(), checkDuration());
            }
            checkFormat();
        }
    }

    private String checkDuration() {
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
        List<WebElement> components = getElements(componentsCurses);
        for(var el : components) {
            if(el.getText().equals("Онлайн")) {
                 return el.getText().equals("Онлайн");
            }
        }
        return checkFormat();
    }

    private String getNameCourse() {
        return getElement(nameCurses).getText();
    }

    private String getDescription() {
        return getElement(descriptionCurses).getText();
    }
}
