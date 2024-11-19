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

    By nameCurses = By.className("sc-1og4wiw-0 sc-s2pydo-1 iLVLDh diGrSa");
    By descriptionCurses = By.className("sc-1og4wiw-0 sc-s2pydo-3 jfNqTr dZDxRw");
    By componentsCurses = By.cssSelector("[class='sc-3cb1l3-4 kGoYMV']");

    public void openCardPage() {
        logger.info("Проверка описание страницы курса");
//        List<WebElement> testingCard = driver.findElements(By.cssSelector("[class='sc-18q05a6-1 bwGwUO'] a"));
        List<WebElement> webElementList = driver.findElements(componentsCurses);
        String name = driver.findElement(nameCurses).getText();
        String description = driver.findElement(descriptionCurses).getText();

//        for(WebElement element : testingCard) {
//            element.click();
        Assertions.assertEquals(name, getNameCourse());
        Assertions.assertEquals(description, getDescription());

        for (WebElement component : webElementList) {
            Assertions.assertEquals(component.getText(), checkDuration());
            checkFormat();
        }
        driver.navigate().back();
//    }
    }

    private String checkDuration() {
        logger.info("Получение продолжительности курса");
        Pattern pattern = Pattern.compile("месяц");
        List<WebElement> components = driver.findElements(componentsCurses);
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
        List<WebElement> components = driver.findElements(componentsCurses);
        for (var el : components) {
            if(el.isEnabled()) {
                 return el.getText().equals("Онлайн");
            }
        }
        return checkFormat();
    }

    private String getNameCourse() {
        logger.info("Получение названия курса");
        return driver.findElement(nameCurses).getText();
    }

    private String getDescription() {
        logger.info("Получение описания курса");
        return driver.findElement(descriptionCurses).getText();
    }
}
