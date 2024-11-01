package data;

public enum QaLeadLocators {
    NAMECOURSES("[class='sc-1og4wiw-0 sc-s2pydo-1 iLVLDh diGrSa']"),
    DESCRIPTION("[class='sc-1og4wiw-0 sc-3cb1l3-0 gcChXs dgWykw']");

    private final String locator;

    QaLeadLocators(String locator) {
        this.locator = locator;
    }

    public String getLocator() {
        return locator;
    }
}
