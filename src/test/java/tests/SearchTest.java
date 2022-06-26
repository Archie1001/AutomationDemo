package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.home.page.HomePage;
import pages.search.results.page.SearchResultsPage;

import java.time.Duration;
import java.util.ArrayList;


public class SearchTest {

    private static WebDriver driver;
    private static WebDriverWait wait;
    private HomePage homePage;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        homePage.open(driver);
        driver.manage().window().maximize();
    }

    // TODO: try other ways of waiting for dropdownOptionsList in testForSearchOptionsList
    //  Setup logging for all test cases

    @Test
    public void testForSearchOptionsList() {
        String searchInput = "iphone 13";

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.getTitle(), homePage.homePageTitle);

        homePage.searchBar().sendKeys(searchInput);
        wait.until(ExpectedConditions.visibilityOfAllElements(homePage.dropdownOptionsList()));
        System.out.println("Total autosuggestion options number is: " + homePage.dropdownOptionsList().size());

        for (WebElement option : homePage.dropdownOptionsList()) {
            System.out.println(option.getText());
            softAssert.assertTrue(option.getText().toLowerCase().contains(searchInput));
        }

        softAssert.assertAll();
    }

    @Test
    public void testForProductsName() {
        String searchInput = "iphone 13";

        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);

        homePage.searchBar().sendKeys(searchInput);
        wait.until(ExpectedConditions.visibilityOfAllElements(homePage.dropdownOptionsList()));
        homePage.searchButton().click();
        wait.until(ExpectedConditions.visibilityOf(searchResultsPage.searchResultsNumber()));

        System.out.println("Total search results: " + searchResultsPage.searchResultsNumber().getText());

        ArrayList<WebElement> searchResultsItems = new ArrayList<>(searchResultsPage.searchedItemsTitleList());

            for (int i = 1; i < searchResultsItems.size(); i++) {
                Assert.assertTrue(searchResultsItems.get(i).getText().toLowerCase().contains(searchInput), "Following search result does not contain searched input: " + searchResultsItems.get(i).getText());
            }
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
