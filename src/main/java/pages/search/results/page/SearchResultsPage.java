package pages.search.results.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.Page;

import java.util.List;

public class SearchResultsPage extends Page implements SearchResultsPageLocators {

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public WebElement searchResultsNumber() {
        return driver.findElement(searchResultsNumber);
    }

    public List<WebElement> searchedItemsTitleList() {
        return driver.findElements(searchedItemsTitleList);
    }
}
