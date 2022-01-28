package aplus.ui.pages;

import aplus.ui.base.BasePage;
import org.openqa.selenium.By;
import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DailyDealsLearnPage extends BasePage {
    private final By dailyDealsBlock = By.xpath("//div[contains(@class,'dealsCountdownTimer')]");

    public DailyDealsLearnPage CheckDailyDealsBlockVisible() {
        verifyElementExistsAndVisible(dailyDealsBlock);
        return new DailyDealsLearnPage();
    }
    //Todo
    //Ask why it didnt work?
    public DailyDealsLearnPage checkCurentURL(){
        String expectedUrl = "https://preview-aplus-website.c45stagehostopia.com/deals";
        String currentUrl = WebDriverRunner.url(); //returns  https://preview-aplus-website.c45stagehostopia.com

        assertEquals(expectedUrl, currentUrl);
        return new DailyDealsLearnPage();
    }
}
