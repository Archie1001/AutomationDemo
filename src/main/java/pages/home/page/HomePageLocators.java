package pages.home.page;

import org.openqa.selenium.By;

public interface HomePageLocators {

    String homePageTitle = "Electronics, Cars, Fashion, Collectibles & More | eBay";

    By acceptCookiesButton = new By.ById("gdpr-banner-accept");
    By mainSearchBar = new By.ByXPath("//input[@type='text']");
    By searchButton = new By.ByXPath("//input[@type='submit']");
    By dropDownOption = new By.ByXPath("//ul[@id='ui-id-1']/li[contains(@class,'visible')]");
}
