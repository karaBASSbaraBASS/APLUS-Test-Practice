package base;

import aplus.ui.Variables;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverProvider;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import javax.annotation.Nonnull;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.*;

public class BaseTest {


    private static class ChromeWebDriverProvider implements WebDriverProvider {

        @Nonnull
        @Override
        public WebDriver createDriver(@Nonnull DesiredCapabilities desiredCapabilities) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.merge(desiredCapabilities);
            return new ChromeDriver(options);
        }
    }

    @BeforeAll
    public static void setUpStage() {
        webdriver().driver().clearCookies();
        Configuration.startMaximized = true;
        browser = ChromeWebDriverProvider.class.getName();
        open(Variables.urlStage);
        pollingInterval = 30;
        timeout = 60000;
    }

//    @AfterAll
//    public static void close() {
//        closeWebDriver();
//    }
}
