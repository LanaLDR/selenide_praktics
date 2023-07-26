package github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideRepository {

    static {
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/Applications/Google Chrome.app/Contents/MacOS/Google Chrome");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        Configuration.browserCapabilities = capabilities;
    }

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://github.com/selenide/selenide";
    }

    @BeforeEach
    void beforeEach() {
        open("");
    }

    @Test
    void andreyFirstContributor() {
        $("div.Layout-sidebar").$(byText("Contributors")).closest(".BorderGrid-cell").$$("li").first().hover();
        //$$(".avatar.circle").first().hover();
        $(".Popover-message").shouldHave(text("Andrei Solntsev"));
    }

    @Test
    void softAssertionsHaveExampleWithJunit5() {
        String junit5example = """
                        @ExtendWith({SoftAssertsExtension.class})
                                             class Tests {
                                                  @Test
                                                  void test() {
                                                    Configuration.assertionMode = SOFT;
                                                    open("page.html");
                                                    
                                                    $("#first").should(visible).click();
                                                    $("#second").should(visible).click();
                                                  }
                                            }
                """;
        $("#wiki-tab").click();
        $$("#wiki-body li a").findBy(text("Soft assertion")).click();
        $$("h4").findBy(text("Using JUnit5 extend test class")).sibling(0).shouldHave(text(junit5example));
    }
}
