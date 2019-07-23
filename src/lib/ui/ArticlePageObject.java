package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ArticlePageObject extends MainPageObject {

    private static final String
        JAVA_ARTICLE_TITLE = "//*[contains(@content-desc, 'Java (programming language)')]",
        JAVA_ELEMENT_FOR_SWIPE = "//*[@content-desc='Principles']",
        ADD_ARTICLE_TO_READING_LIST = "//*[contains(@content-desc, 'Add this article to a reading list')]",
        GOT_IT_BUTTON = "//*[contains(@text, 'GOT IT')]",
        CREATE_NEW_BUTTON = "//*[contains(@text, 'Create new')]",
        NAME_OF_THIS_LIST = "//*[contains(@text, 'Name of this list')]",
        OK_BUTTON = "//*[contains(@text, 'OK')]",
        NAVIGATE_UP_BUTTON = "//*[contains(@content-desc, 'Navigate up')]";


    public ArticlePageObject(AppiumDriver driver)
    {
        super(driver);
    }

    public WebElement waitForTitleElement()
    {
        return this.waitForElementPresent(By.xpath(JAVA_ARTICLE_TITLE), "Cannot find title article on page", 20);
    }

    public void swipeToElement()
    {
        this.swipeUpToFindElement(
                By.xpath(JAVA_ELEMENT_FOR_SWIPE),
                "Cannot find the element in article",
                20
        );
    }

    public void addArticleToMyList(String name_of_folder)
    {
        this.waitForElementAndClick(
                By.xpath(ADD_ARTICLE_TO_READING_LIST),
                "Cannot find button for adding article to reading list",
                20
        );

        this.waitForElementAndClick(
                By.xpath(GOT_IT_BUTTON),
                "Cannot find GOT IT button",
                5
        );

        this.waitForElementAndClick(
                By.xpath(CREATE_NEW_BUTTON),
                "Cannot find Create new button",
                5
        );

        this.waitForElementAndSendKeys(
                By.xpath(NAME_OF_THIS_LIST),
                name_of_folder,
                "Cannot find Name of this list button",
                5
        );

        this.waitForElementAndClick(
                By.xpath(OK_BUTTON),
                "Cannot find OK button",
                1
        );
    }

    public void closeArticle()
    {
        this.waitForElementAndClick(
                By.xpath(NAVIGATE_UP_BUTTON),
                "Cannot find Navigate up button",
                5
        );
    }

}
