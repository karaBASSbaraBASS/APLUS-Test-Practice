package aplus.ui.widgets;

import aplus.ui.base.BasePage;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;

import java.util.ArrayList;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CarouselTests extends BasePage{

    public CarouselTests carouselShouldChangeSlideIfDotIsClicked(String selector, By clickableElement, By carouselActiveLocator, Boolean nextSlideClickIsNeeded) {

        //This will get the number of items in the carousel
        ArrayList items = (ArrayList) WebDriverRunner.getWebDriver().findElements(By.xpath(selector));
        ArrayList list1 = new ArrayList();
        String name;

        for (int i = 0; i < items.size(); i++) {
            int index = i + 1;

            //This will get the classname of each item in carousel
            name = WebDriverRunner.getWebDriver().findElement(By.xpath(selector + "[" + index + "]")).getAttribute("class");
            list1.add(name);
        }

        if (nextSlideClickIsNeeded){
            //Next we click on the arrow of the carousel
            WebDriverRunner.getWebDriver().findElement(clickableElement).click();
        } else {
            //Next wait until carousel change status
            $(carouselActiveLocator).shouldNotHave(cssClass("active"));
        }

        //Then we new items are loaded in the carousel following the click,
        //we get the names again

        ArrayList nextItems = (ArrayList) WebDriverRunner.getWebDriver().findElements(By.xpath(selector));
        ArrayList list2 = new ArrayList();

        String newName;

        for (int i = 0; i < nextItems.size(); i++) {
            int index = i + 1;

            //This will get the classname of each item in carousel
            newName = WebDriverRunner.getWebDriver().findElement(By.xpath(selector + "[" + index + "]")).getAttribute("class");
            list2.add(newName);
        }

        //Then we compare the two arrayLists are not the same
        Boolean commonList = list1.retainAll(list2);

        assertTrue(commonList == false);

        return new CarouselTests();
    }

}
