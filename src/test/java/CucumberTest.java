import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

@Test
@CucumberOptions(
        plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
        features = "src/test/resources/features",
        glue = {"step_defs"}
)
public class CucumberTest extends AbstractTestNGCucumberTests {

    @BeforeSuite
    public void beforeSuite() {
        setDriverConfig();
        SelenideLogger.addListener(
                "AllureSelenide",
                new AllureSelenide()
                        .screenshots(true)
                        .savePageSource(false)
        );
    }

    @BeforeMethod
    public void beforeScenario() {
        Selenide.open();
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }

    @AfterMethod
    public void afterScenario() {
        Selenide.closeWindow();
    }

    private void setDriverConfig() {
        Map<String, Object> selenoidOptions = new HashMap<>();
        selenoidOptions.put("sessionTimeout", "5m");
        selenoidOptions.put("enableVNC", true);
        selenoidOptions.put("enableLog", true);
        selenoidOptions.put("enableVideo", false);
        selenoidOptions.put("acceptInsecureCerts", true);

        Configuration.browserCapabilities.setCapability("selenoid:options", selenoidOptions);
        Configuration.remote = "http://192.168.0.63:4444/wd/hub/";
    }
}
