package aplus.ui.pages;

import aplus.ui.base.BasePage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DomainNameSearchPage extends BasePage {

    private final By searchResultText = By.xpath("//div[contains(@class,'js_search_result_text')]//span");
    private final By domainNameText = By.xpath("//div[contains(@class,'domain-name-search')]");
    private final By canvasLoader = By.xpath("//*[@id='canvasLoader']");


    public DomainNameSearchPage checkResultText(String titleToCheck){
//        $(canvasLoader).shouldBe(visible);
//        $(canvasLoader).should(disappear);
        $(domainNameText).shouldHave(Condition.text(titleToCheck));
        $(searchResultText).shouldHave(Condition.text("has been added to your cart"));
        return new DomainNameSearchPage();
    }
}
