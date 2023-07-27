package com.herokuapp;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTest {

    static {
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/Applications/Google Chrome.app/Contents/MacOS/Google Chrome");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        Configuration.browserCapabilities = capabilities;
    }

    @Test
    void canMoveBlockAtoBlockB() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        Actions actions = new Actions(WebDriverRunner.getWebDriver());
        SelenideElement blockA = $("#column-a");
        SelenideElement blockB = $("#column-b");
        $(blockA).dragAndDropTo(blockB);
        //actions.dragAndDrop(blockA, blockB).build().perform(); //не работает, перетаскивает блок в центр экрана
    }
}
