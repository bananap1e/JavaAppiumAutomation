package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class SearchPageObject extends MainPageObject {

    private static final String
        SKIP_ELEMENT = "//*[contains(@text, 'SKIP')]",
        SEARCH_INIT_ELEMENT = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.TextView",
        SEARCH_INPUT = "//*[contains(@text, 'Search Wikipedia')]",
        SEARCH_RESULT_BY_SUBSTRING_TPL = "//*[contains(@text, '{SUBSTRING}')]",
        SEARCH_CANCEL_BUTTON = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.ImageButton",
        SEARCH_RESULT_LOCATOR = "//*[@resource-id='org.wikipedia:id/search_results_list']/*[@class='android.view.ViewGroup']",
        EMPTY_RESULT_LABEL = "//*[contains(@text, 'No results found')]";


    public SearchPageObject(AppiumDriver driver)
    {
        super(driver);
    }

    private static String getResultSearchElement(String substring)
    {
        return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{SUBSTRING}", substring);
    }

    public void skipElement()
    {
        this.waitForElementAndClick(By.xpath(SKIP_ELEMENT), "Cannot find and click SKIP button", 5);
    }

    public void initSearchInput()
    {
        this.waitForElementAndClick(By.xpath(SEARCH_INIT_ELEMENT), "Cannot find and click search init element", 13);
    }

    public void typeSearchLine (String search_line)
    {
        this.waitForElementAndSendKeys(By.xpath(SEARCH_INPUT), search_line, "Cannot find and type into search input", 5);
    }

    public void waitForSearchResult(String substring)
    {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementPresent(By.xpath(search_result_xpath), "Cannot find search result", 5);
    }

    public void waitForCancelButtonToAppear()
    {
        this.waitForElementPresent(By.xpath(SEARCH_CANCEL_BUTTON), "Cannot find search cancel buttton", 3);
    }

    public void waitForCancelButtonToDisappear()
    {
        this.waitForElementNotPresent(By.xpath(SEARCH_CANCEL_BUTTON), "Serach cancel button is still present", 3);
    }

    public void clickCancelSearch()
    {
        this.waitForElementAndClick(By.xpath(SEARCH_CANCEL_BUTTON), "Cannot find and click search cancel button", 3);
    }

    public void clickByArticleWithSubstring(String substring)
    {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementAndClick(By.xpath(search_result_xpath), "Cannot find and click search result", 5);
    }

    public int getAmountOfFoundArticles()
    {
        this.waitForElementPresent(
                By.xpath(SEARCH_RESULT_LOCATOR),
                "Cannot find anything by the request",
                15
        );

        return this.getAmountOfElements(By.xpath(SEARCH_RESULT_LOCATOR));
    }

    public void waitForEmptyResultLabel()
    {
        this.waitForElementPresent(
                By.xpath(EMPTY_RESULT_LABEL),
                "Cannot find empty result label by the request",
                15
        );
    }

    public void checkThatThereIsNoResultSearch()
    {
        this.assertElementNotPresent(
                By.xpath(SEARCH_RESULT_LOCATOR),
                "We have found some result by request"
        );
    }

    public void checkThatElementNotExist(String substring)
    {
        this.waitForElementNotPresent(
                By.xpath(getResultSearchElement(substring)),
                "Cannot find OOP lang after returning from background",
                5
        );
    }
}
