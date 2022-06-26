package pages.home.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.Page;

import java.util.List;

public class HomePage extends Page implements HomePageLocators {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public WebElement acceptCookiesButton() {
        return driver.findElement(acceptCookiesButton);
    }

    public WebElement searchBar() {
        return driver.findElement(mainSearchBar);
    }

    public WebElement searchButton() {
        return driver.findElement(searchButton);
    }

    public List<WebElement> dropdownOptionsList() {
        return driver.findElements(dropDownOption);
    }
}
