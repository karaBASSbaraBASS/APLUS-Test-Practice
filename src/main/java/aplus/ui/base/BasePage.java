package aplus.ui.base;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;
import org.openqa.selenium.By;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static java.time.Duration.ofMinutes;
import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class BasePage {

    /**
     * Verifies that the element exists and visible on the page.
     *
     * @param locator - page element locator.
     */
    protected SelenideElement verifyElementExistsAndVisible(By locator) {
        return $(locator).should(exist).shouldBe(visible);
    }

    /**
     * Verifies that the element exists and visible on the page.
     *
     * @param element - page element.
     */
    protected SelenideElement verifyElementExistsAndVisible(SelenideElement element) {
        return element.should(exist).shouldBe(visible);
    }

    /**
     * Verifies that the element is not visible on the page.
     *
     * @param locator - page element locator.
     */
    protected SelenideElement verifyElementIsNotVisible(By locator) {
        return $(locator).shouldNotBe(visible, ofMinutes(5));
    }

    /**
     * Verifies that the element is not visible on the page.
     *
     * @param element - page element.
     */
    protected SelenideElement verifyElementIsNotVisible(SelenideElement element) {
        return element.shouldNotBe(visible, ofMinutes(5));
    }

    /**
     * Verifies that the elements count on the page is greater than zero.
     *
     * @param locator - page elements locator.
     */
    protected ElementsCollection verifyElementsCount(By locator) {
        return $$(locator).shouldHave(sizeGreaterThan(0));
    }

    /**
     * Verifies that the elements count on the page is greater than zero.
     *
     * @param elements - collection of the page elements.
     */
    protected ElementsCollection verifyElementsCount(ElementsCollection elements) {
        return elements.shouldHave(sizeGreaterThan(0));
    }

    /**
     * Verifies that the nested element exists and visible on the page.
     *
     * @param parentLocator - parent page element locator.
     * @param nestedLocator - nested page element locator.
     */
    protected SelenideElement verifyNestedElementExistsAndVisible(By parentLocator, By nestedLocator) {
        return $(parentLocator).find(nestedLocator).should(exist).shouldBe(visible);
    }

    /**
     * Verifies that the nested element exists and visible on the page.
     *
     * @param parentElement - parent page element.
     * @param nestedLocator - nested page element locator.
     */
    protected SelenideElement verifyNestedElementExistsAndVisible(SelenideElement parentElement, By nestedLocator) {
        return parentElement.find(nestedLocator).should(exist).shouldBe(visible);
    }

    /**
     * Verifies that the nested element is not visible on the page.
     *
     * @param parentLocator - parent page element locator.
     * @param nestedLocator - nested page element locator.
     */
    protected SelenideElement verifyNestedElementIsNotVisible(By parentLocator, By nestedLocator) {
        return $(parentLocator).find(nestedLocator).shouldNotBe(visible, ofMinutes(5));
    }

    /**
     * Verifies that the nested element is not visible on the page.
     *
     * @param parentElement - parent page element.
     * @param nestedLocator - nested page element locator.
     */
    protected SelenideElement verifyNestedElementIsNotVisible(SelenideElement parentElement, By nestedLocator) {
        return parentElement.find(nestedLocator).shouldNotBe(visible, ofMinutes(5));
    }

    /**
     * Verifies that the nested elements count on the page is greater than zero.
     *
     * @param parentLocator - parent page element locator.
     * @param nestedLocator - nested page elements locator.
     */
    protected ElementsCollection verifyNestedElementsCount(By parentLocator, By nestedLocator) {
        return $(parentLocator).findAll(nestedLocator).shouldHave(sizeGreaterThan(0));
    }

    /**
     * Verifies that the nested elements count on the page is greater than zero.
     *
     * @param parentElement - parent page element.
     * @param nestedLocator - nested page elements locator.
     */
    protected ElementsCollection verifyNestedElementsCount(SelenideElement parentElement, By nestedLocator) {
        return parentElement.findAll(nestedLocator).shouldHave(sizeGreaterThan(0));
    }

    /**
     * Verifies if modal window is displayed and waits until its disappearance.
     *
     * @param modalWindowLocator - modal window locator.
     */
    public void verifyModalWindow(By modalWindowLocator) {
        try {
            verifyElementExistsAndVisible(modalWindowLocator);
            verifyElementIsNotVisible(modalWindowLocator);
        } catch (ElementNotFound e) {
            sleep(60000);   //Workaround for cases when modal window disappears too fast
        }
    }

    /**
     * Verifies if modal window is displayed and waits until its disappearance.
     *
     * @param modalWindow - modal window.
     */
    public void verifyModalWindow(SelenideElement modalWindow) {
        try {
            verifyElementExistsAndVisible(modalWindow);
            verifyElementIsNotVisible(modalWindow);
        } catch (ElementNotFound e) {
            sleep(60000);   //Workaround for cases when modal window disappears too fast
        }
    }

    /**
     * Drag and drop the page element.
     *
     * @param fromLocator - page element previous container locator.
     * @param toLocator   - page element next container locator.
     */
    protected void dragAndDropElement(By fromLocator, By toLocator) {
        actions().clickAndHold($(fromLocator)).moveToElement($(toLocator)).release().perform();
    }

    /**
     * Drag and drop the page element.
     *
     * @param from - page element previous container.
     * @param to   - page element next container.
     */
    protected void dragAndDropElement(SelenideElement from, SelenideElement to) {
        actions().clickAndHold(from).moveToElement(to).release().perform();
    }

    /**
     * Drag and drop the page element.
     *
     * @param fromLocator - page element previous container locator.
     * @param xOffset     - offset distance by X axis.
     * @param yOffset     - offset distance by Y axis.
     */
    protected void dragAndDropElement(By fromLocator, int xOffset, int yOffset) {
        actions().clickAndHold($(fromLocator)).moveByOffset(xOffset, yOffset).release().perform();
    }

    /**
     * Drag and drop the page element.
     *
     * @param from    - page element previous container.
     * @param xOffset - offset distance by X axis.
     * @param yOffset - offset distance by Y axis.
     */
    protected void dragAndDropElement(SelenideElement from, int xOffset, int yOffset) {
        actions().clickAndHold(from).moveByOffset(xOffset, yOffset).release().perform();
    }

    /**
     * Verifies dropdown menu options.
     *
     * @param dropdownMenuLocator        - dropdown menu locator.
     * @param dropdownMenuOptionsLocator - dropdown menu options locator.
     * @param expectedOptionValues       - dropdown menu options expected values.
     */
    protected void verifyDropdownMenuOptions(By dropdownMenuLocator, By dropdownMenuOptionsLocator, List<String> expectedOptionValues) {
        $(dropdownMenuLocator).click();
        verifyElementsCount($$(dropdownMenuOptionsLocator)).shouldHave(exactTexts(expectedOptionValues));
        $(dropdownMenuLocator).click();
    }

    /**
     * Verifies dropdown menu options.
     *
     * @param dropdownMenu         - dropdown menu.
     * @param dropdownMenuOptions  - dropdown menu options.
     * @param expectedOptionValues - dropdown menu options expected values.
     */
    protected void verifyDropdownMenuOptions(SelenideElement dropdownMenu, ElementsCollection dropdownMenuOptions, List<String> expectedOptionValues) {
        dropdownMenu.click();
        verifyElementsCount(dropdownMenuOptions).shouldHave(exactTexts(expectedOptionValues));
        dropdownMenu.click();
    }

    /**
     * Selects an option from the dropdown menu.
     *
     * @param dropdownMenuLocator       - dropdown menu locator.
     * @param dropdownMenuOptionLocator - dropdown menu option for selection locator.
     * @param expectedOptionValue       - dropdown menu selected option expected value.
     */
    protected void selectDropdownMenuOption(By dropdownMenuLocator, By dropdownMenuOptionLocator, String expectedOptionValue) {
        actions().click($(dropdownMenuLocator)).pause(ofSeconds(1)).perform();
        $(dropdownMenuOptionLocator).click();
        $(dropdownMenuLocator).shouldHave(text(expectedOptionValue));
    }

    /**
     * Selects an option from the dropdown menu.
     *
     * @param dropdownMenu        - dropdown menu.
     * @param dropdownMenuOption  - dropdown menu option for selection.
     * @param expectedOptionValue - dropdown menu selected option expected value.
     */
    protected void selectDropdownMenuOption(SelenideElement dropdownMenu, SelenideElement dropdownMenuOption, String expectedOptionValue) {
        actions().click(dropdownMenu).pause(ofSeconds(1)).perform();
        dropdownMenuOption.click();
        dropdownMenu.shouldHave(text(expectedOptionValue));
    }

    /**
     * Reads the table column and stores its data into the list.
     *
     * @param tableRowsLocator - table rows locator.
     * @param tableColumnIndex - table column index.
     */
    protected List<String> getTableColumnData(By tableRowsLocator, int tableColumnIndex) {
        List<String> tableColumnData = new ArrayList<>();
        for (SelenideElement tableRow : $$(tableRowsLocator)) {
            ElementsCollection tableCells = tableRow.findAll(By.cssSelector("td"));
            tableColumnData.add(tableCells.get(tableColumnIndex).getText());
        }
        return tableColumnData;
    }

    /**
     * Reads the table column and stores its data into the list.
     *
     * @param tableRows        - table rows collection.
     * @param tableColumnIndex - table column index.
     */
    protected List<String> getTableColumnData(ElementsCollection tableRows, int tableColumnIndex) {
        List<String> tableColumnData = new ArrayList<>();
        for (SelenideElement tableRow : tableRows) {
            ElementsCollection tableCells = tableRow.findAll(By.cssSelector("td"));
            tableColumnData.add(tableCells.get(tableColumnIndex).getText());
        }
        return tableColumnData;
    }

    /**
     * Sorts table by each column.
     *
     * @param tableHeaders - table headers collection.
     * @param tableRows    - table rows collection.
     */
    protected void verifyTableSortingByColumns(ElementsCollection tableHeaders, ElementsCollection tableRows) {
        for (int i = 0; i < tableHeaders.size(); i++) {
            //Get table column data before sorting
            List<String> columnDataBeforeSorting = getTableColumnData(tableRows, i);

            //Executes sorting only for the columns with the distinctive records
            if (columnDataBeforeSorting.stream().distinct().count() > 1) {
                //Sort table by ascending
                tableHeaders.get(i).click();
                List<String> columnDataAfterSortingByAscending = getTableColumnData(tableRows, i);

                //Sort table by descending
                tableHeaders.get(i).click();
                List<String> columnDataAfterSortingByDescending = getTableColumnData(tableRows, i);
                assertNotEquals(columnDataAfterSortingByAscending, columnDataAfterSortingByDescending);

                //Reset to default sorting settings
                tableHeaders.get(i).click();
                List<String> columnDataAfterResettingSortingSettings = getTableColumnData(tableRows, i);
                assertEquals(columnDataBeforeSorting, columnDataAfterResettingSortingSettings);
            }
        }
    }

    /**
     * Sorts table by each column.
     *
     * @param tableHeadersLocator - table headers locator.
     * @param tableRowsLocator    - table rows locator.
     */
    protected void verifyTableSortingByColumns(By tableHeadersLocator, By tableRowsLocator) {
        ElementsCollection tableHeaders = $$(tableHeadersLocator);
        ElementsCollection tableRows = $$(tableRowsLocator);

        for (int i = 0; i < tableHeaders.size(); i++) {
            //Get table column data before sorting
            List<String> columnDataBeforeSorting = getTableColumnData(tableRows, i);

            //Executes sorting only for the columns with the distinctive records
            if (columnDataBeforeSorting.stream().distinct().count() > 1) {
                //Sort table by ascending
                tableHeaders.get(i).click();
                List<String> columnDataAfterSortingByAscending = getTableColumnData(tableRows, i);

                //Sort table by descending
                tableHeaders.get(i).click();
                List<String> columnDataAfterSortingByDescending = getTableColumnData(tableRows, i);
                assertNotEquals(columnDataAfterSortingByAscending, columnDataAfterSortingByDescending);

                //Reset to default sorting settings
                tableHeaders.get(i).click();
                List<String> columnDataAfterResettingSortingSettings = getTableColumnData(tableRows, i);
                assertEquals(columnDataBeforeSorting, columnDataAfterResettingSortingSettings);
            }
        }
    }

    /**
     * Verifies navigation arrows functionality.
     *
     * @param navigationArrowsLocator - navigation arrows locator.
     */
    protected void navigationArrowsVerification(By navigationArrowsLocator) {
        ElementsCollection navigationArrowsCollection = $$(navigationArrowsLocator);

        //Default navigation arrows states verification
        navigationArrowsCollection.get(0).shouldHave(
                attribute("title", "Go to the first page"),
                attribute("class", "k-link k-pager-nav k-pager-first k-state-disabled")
        );
        navigationArrowsCollection.get(1).shouldHave(
                attribute("title", "Go to the previous page"),
                attribute("class", "k-link k-pager-nav k-state-disabled")
        );
        navigationArrowsCollection.get(2).shouldHave(
                attribute("title", "Go to the next page"),
                attribute("class", "k-link k-pager-nav")
        );
        navigationArrowsCollection.get(3).shouldHave(
                attribute("title", "Go to the last page"),
                attribute("class", "k-link k-pager-nav k-pager-last")
        );

        //Click on "Go to the next page" arrow
        navigationArrowsCollection.get(2).click();
        navigationArrowsCollection.get(0).shouldHave(
                attribute("class", "k-link k-pager-nav k-pager-first")
        );
        navigationArrowsCollection.get(1).shouldHave(
                attribute("class", "k-link k-pager-nav")
        );

        //Click on "Go to the previous page" arrow
        navigationArrowsCollection.get(1).click();
        navigationArrowsCollection.get(0).shouldHave(
                attribute("class", "k-link k-pager-nav k-pager-first k-state-disabled")
        );
        navigationArrowsCollection.get(1).shouldHave(
                attribute("class", "k-link k-pager-nav k-state-disabled")
        );

        //Click on "Go to the last page" arrow
        navigationArrowsCollection.get(3).click();
        navigationArrowsCollection.get(2).shouldHave(
                attribute("class", "k-link k-pager-nav k-state-disabled")
        );
        navigationArrowsCollection.get(3).shouldHave(
                attribute("class", "k-link k-pager-nav k-pager-last k-state-disabled")
        );

        //Click on "Go to the first page" arrow
        navigationArrowsCollection.get(0).click();
        navigationArrowsCollection.get(2).shouldHave(
                attribute("class", "k-link k-pager-nav")
        );
        navigationArrowsCollection.get(3).shouldHave(
                attribute("class", "k-link k-pager-nav k-pager-last")
        );
    }

    /**
     * Verifies navigation arrows functionality.
     *
     * @param navigationArrowsCollection - navigation arrows collection.
     */
    protected void navigationArrowsVerification(ElementsCollection navigationArrowsCollection) {
        //Default navigation arrows states verification
        navigationArrowsCollection.get(0).shouldHave(
                attribute("title", "Go to the first page"),
                attribute("class", "k-link k-pager-nav k-pager-first k-state-disabled")
        );
        navigationArrowsCollection.get(1).shouldHave(
                attribute("title", "Go to the previous page"),
                attribute("class", "k-link k-pager-nav k-state-disabled")
        );
        navigationArrowsCollection.get(2).shouldHave(
                attribute("title", "Go to the next page"),
                attribute("class", "k-link k-pager-nav")
        );
        navigationArrowsCollection.get(3).shouldHave(
                attribute("title", "Go to the last page"),
                attribute("class", "k-link k-pager-nav k-pager-last")
        );

        //Click on "Go to the next page" arrow
        navigationArrowsCollection.get(2).click();
        navigationArrowsCollection.get(0).shouldHave(
                attribute("class", "k-link k-pager-nav k-pager-first")
        );
        navigationArrowsCollection.get(1).shouldHave(
                attribute("class", "k-link k-pager-nav")
        );

        //Click on "Go to the previous page" arrow
        navigationArrowsCollection.get(1).click();
        navigationArrowsCollection.get(0).shouldHave(
                attribute("class", "k-link k-pager-nav k-pager-first k-state-disabled")
        );
        navigationArrowsCollection.get(1).shouldHave(
                attribute("class", "k-link k-pager-nav k-state-disabled")
        );

        //Click on "Go to the last page" arrow
        navigationArrowsCollection.get(3).click();
        navigationArrowsCollection.get(2).shouldHave(
                attribute("class", "k-link k-pager-nav k-state-disabled")
        );
        navigationArrowsCollection.get(3).shouldHave(
                attribute("class", "k-link k-pager-nav k-pager-last k-state-disabled")
        );

        //Click on "Go to the first page" arrow
        navigationArrowsCollection.get(0).click();
        navigationArrowsCollection.get(2).shouldHave(
                attribute("class", "k-link k-pager-nav")
        );
        navigationArrowsCollection.get(3).shouldHave(
                attribute("class", "k-link k-pager-nav k-pager-last")
        );
    }

    /**
     * Scrolls to the top of the page.
     */
    protected void scrollToTheTopOfThePage() {
        executeJavaScript("window.scrollTo(0,0);");
    }

    /**
     * Scrolls to the bottom of the page.
     */
    protected void scrollToTheBottomOfThePage() {
        executeJavaScript("window.scrollBy(0,document.body.scrollHeight || document.documentElement.scrollHeight);");
    }

    /**
     * Closes selected browser tab.
     *
     * @param tabIndex - browser tab index.
     */
    protected void closeBrowserTab(int tabIndex) {
        switchTo().window(tabIndex);
        closeWindow();
    }

    /**
     * Verifies opened browser tab link and closes tab after it.
     *
     * @param expectedPageUrl - expected page URL.
     */
    protected void verifyOpenedBrowserTabLinkAndCloseTabAfter(String expectedPageUrl) {
        Set<String> windowHandles = getWebDriver().getWindowHandles();
        switchTo().window(windowHandles.size() - 1);
        assertTrue(getWebDriver().getCurrentUrl().contains(expectedPageUrl));
        closeWindow();
        switchTo().window(windowHandles.size() - 2);
    }

    /**
     * Verifies file presence in the specified directory.
     *
     * @param directoryPath - directory path in the system.
     * @param fileName      - expected file name.
     */
    protected void verifyFilePresenceInDirectory(String directoryPath, String fileName) {
        File directory = new File(directoryPath);
        String[] files = directory.list();
        assumeTrue(files != null);
        assertTrue(Arrays.asList(files).contains(fileName));
    }

    /**
     * Verifies directory existence by the specified system path.
     *
     * @param directoryPath - directory path in the system.
     */
    protected void verifyDirectoryExistence(String directoryPath) {
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            try {
                Files.createDirectory(Paths.get(directoryPath));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
