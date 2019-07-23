package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class NavigationUI extends MainPageObject {

    public NavigationUI(AppiumDriver driver)
    {
        super(driver);
    }

    public static final String
        NO_THANKS_BUTTON = "//*[contains(@text, 'NO THANKS')]",
        MY_LISTS_BUTTON = "//*[contains(@content-desc, 'My lists')]";

    public void clickMyLists()
    {
        this.waitForElementAndClick(
                By.xpath(NO_THANKS_BUTTON),
                "Cannot find NO THANKS button",
                10
        );

        this.waitForElementAndClick(
                By.xpath(MY_LISTS_BUTTON),
                "Cannot find My List button",
                5
        );
    }
}
