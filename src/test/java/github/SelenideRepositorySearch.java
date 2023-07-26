package github;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class SelenideRepositorySearch {

    static {
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/Applications/Google Chrome.app/Contents/MacOS/Google Chrome");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        Configuration.browserCapabilities = capabilities;
    }
    @Test
    void shouldFindSelenideRepositoryAtTheTop() {
        open("https://github.com");
        $(".search-input").click();
        $("#query-builder-test").setValue("Selenide").pressEnter();
        $$("[data-testid=results-list] .search-title").first().click();
        $("#repository-container-header").shouldHave(text("selenide / selenide"));
    }


}
