package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class MyListsPageObject extends MainPageObject {

    public MyListsPageObject(AppiumDriver driver)
    {
        super(driver);
    }

    public static final String
        FOLDER_BUTTON = "//*[contains(@text, 'Article')]",
        ELEMENT_FOR_DELETE = "//*[contains(@resource-id, 'org.wikipedia:id/page_list_item_title')]",
        DELETED_ELEMENT = "//*[contains(@resource-id, 'org.wikipedia:id/page_list_item_title')]";

    public void openFolderByName(String name_of_folder)
    {
        this.waitForElementAndClick(
                By.xpath(FOLDER_BUTTON),
                "Cannot find Article button",
                10
        );
    }

    public void deleteElementBySwipe()
    {
        this.swipeElementToLeft(
                By.xpath(ELEMENT_FOR_DELETE),
                "Cannot swipe this element"
        );
    }

    public void checkThatElementIsDeleted()
    {
        this.waitForElementNotPresent(
                By.xpath(DELETED_ELEMENT),
                "Cannot find existing article",
                5
        );
    }
}
