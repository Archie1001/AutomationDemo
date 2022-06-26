package pages;

import org.openqa.selenium.WebDriver;

public abstract class Page {

    private static final String homePageURL = "http://ebay.com";

    protected WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
    }

    public void open(WebDriver driver) {
        driver.get(homePageURL);
    }
}
