package github;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.withTagAndText;
import static com.codeborne.selenide.Selenide.*;

public class MainPageTest {

    static {
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/Applications/Google Chrome.app/Contents/MacOS/Google Chrome");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        Configuration.browserCapabilities = capabilities;
    }

    @Test
    void enterprisePageOpen() {
        open("https://github.com/");
        $(".header-menu-wrapper").$(withTagAndText("button", "Solutions")).hover();
        $("#solutions-for-heading").sibling(0).$(withTagAndText("a", "Enterprise")).click();
        $(withTagAndText("h1", "Build like the best")).shouldBe(visible);
        sleep(5000);
    }
}
