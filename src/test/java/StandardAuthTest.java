import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.MainPage;
import java.util.concurrent.TimeUnit;
import net.lightbody.bmp.proxy.ProxyServer;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.StandardAuth;


public class StandardAuthTest {
    private WebDriver driver;
    private ProxyServer server;

    @BeforeTest
    @Parameters({"url", "timeout", "driverPath", "domain", "username", "password"})
    public void setUp(String url, int timeout, String driverPath, String domain, String username, String password) {
        server = new ProxyServer(4444);
        server.start();
        server.autoBasicAuthorization(domain, username, password);
        Proxy proxy = server.seleniumProxy();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.PROXY, proxy);
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver(capabilities);
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
        driver.get(url);
        driver.manage().window().maximize();
    }

    @Test
    private void standardAuthTest() {
        MainPage mainPage = new MainPage(driver);
        StandardAuth standardAuth = new StandardAuth(driver);

        mainPage.clickOnButtonStandardAuth();
        Assert.assertEquals("Auth Success", standardAuth.getTextOfHeader());
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
        server.stop();
    }

}