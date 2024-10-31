package exeptions;

public class BrowserNotFoundExceptions extends RuntimeException {

    public BrowserNotFoundExceptions(String browser) {
        super(String.format("Браузер %s не поддерживается.", browser));
    }
}
