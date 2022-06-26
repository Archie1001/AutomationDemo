package pages.search.results.page;

import org.openqa.selenium.By;

public interface SearchResultsPageLocators {

    String searchResultsTitle = ": Search Result | eBay";

    By searchResultsNumber = new By.ByXPath("//h1[@class='srp-controls__count-heading']");
    By searchedItemsTitleList = new By.ByXPath("//h3[@class='s-item__title']");
}
