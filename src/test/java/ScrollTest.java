import helpers.Helper;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.MainPage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class ScrollTest {
    private WebDriver driver;
    private JavascriptExecutor jsExecutor;

    @BeforeTest
    @Parameters({"url", "timeout", "driverPath"})
    public void setUp(String url, int timeout, String driverPath) {
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
        jsExecutor = (JavascriptExecutor) driver;
        driver.get(url);
        driver.manage().window().maximize();
    }

    @Parameters({"str"})
    @Test
    private void scrollCheckTest(String str) throws IOException, InterruptedException {
        MainPage mainPage = new MainPage(driver);

        mainPage.showWidthOfInput(jsExecutor, driver);
        boolean scrollCheck = !Helper.isScrolled(jsExecutor);
        mainPage.inputSomething(str);
        mainPage.blurInput(jsExecutor, driver);
        mainPage.clickOnButtonSearch();
        mainPage.waitForSearching();

        Assert.assertTrue(scrollCheck && Helper.isScrolled(jsExecutor));
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}