package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class EventPage extends AbsBasePage<EventPage> {
    
    public EventPage(WebDriver driver) {
        super(driver, "/events/near/");
    }

    By cardsEvent = By.cssSelector("[class='dod_new-event-content']");
    By eventType = By.cssSelector("[class='dod_new-type__text']");
    By eventDate = By.cssSelector("[class='dod_new-event__date-text']");
    By nameEvent = By.cssSelector("[class='dod_new-event__title js-dod-new-event-title']");
    Calendar calendar;

    public void checkTypeEvent() {
        logger.info("Сравнение типа мероприятия");
        List<WebElement> cards = getElements(cardsEvent);
        logger.info(cards.size());
        for(var card : cards) {
            String typeEvent = card.findElement(eventType).getText();
            logger.info("Название: {} тип: {}", getElement(nameEvent)
                                                        .getText(),typeEvent);
            Assertions.assertEquals(typeEvent, "Открытый вебинар");
        }
    }

    public void comparisonDate() throws ParseException {
        logger.info("Сравнение дат");
        List<WebElement> cards = getElements(cardsEvent);
        logger.info(cards);
        for(WebElement card : cards) {
            String dataString = card.findElement(eventDate).getText();
//            TODO исправил
            Date eventDate = formatDate(dataString);
            calendar = Calendar.getInstance();
            calendar.setTime(eventDate);
            calendar.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR));
            Date dateEvent = calendar.getTime();

            Assertions.assertTrue(dateEvent.equals(dateNow()) || dateEvent.after(dateNow()));
            logger.info("Название мероприятия: {} дата: {}", getElement(nameEvent)
                                                                    .getText(), dataString);
        }
    }

    private Date formatDate(String data) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd MMM yyyy");
        return format.parse(data + " 1970");
    }

    private Date dateNow() {
        logger.info("Получение текущей даты без времени");
        calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        return calendar.getTime();
    }
}
