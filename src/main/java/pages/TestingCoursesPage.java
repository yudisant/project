package pages;

import org.openqa.selenium.WebDriver;

public class TestingCoursesPage extends AbsBasePage {

    public TestingCoursesPage(WebDriver driver) {
        super(driver, "/catalog/courses?categories=testing");
    }


}
