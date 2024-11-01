package data;

public enum TestingPageLocators {
    CATALOG("div [class='sc-o4bnil-0 riKpM'] a"),
    QA_LEAD("[class='sc-zzdkm7-0 erWoun]");

    private final String locator;


    TestingPageLocators(String locator) {
        this.locator = locator;
    }

    public String getLocator() {
        return locator;
    }
}
