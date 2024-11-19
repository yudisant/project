package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class EventPage extends AbsBasePage<EventPage> {
    
    public EventPage(WebDriver driver) {
        super(driver, "/events/near/");
    }

    By cardsEvent = By.className("dod_new-event-content");

    public void checkTypeEvent() {
        logger.info("Сравнение типа мероприятия");
        List<WebElement> cards = driver.findElements(cardsEvent);
        for(var element : cards) {
            String typeEvent = element.findElement(By.className("dod_new-type__text")).getText();
            Assertions.assertEquals(typeEvent, "Открытый вебинар");
        }
    }

    public void comparisonDate() throws ParseException {
        logger.info("Сравнение дат");
        List<WebElement> cards = driver.findElements(cardsEvent);
        for(WebElement card : cards) {
            String dataString = card.findElement(By.className("dod_new-event__date-text")).getText();
//            TODO исправить
            String dataEvent = dataString + " 2024";
            Date eventDate = formatDate(dataEvent);

            Assertions.assertTrue(eventDate.equals(dateNow()) || eventDate.after(dateNow()));
        }
    }

    private Date formatDate(String data) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd MMM yyyy");
        return format.parse(data);
    }

    private Date dateNow() {
        logger.info("Получение текущей даты без времени");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        return calendar.getTime();
    }
}
