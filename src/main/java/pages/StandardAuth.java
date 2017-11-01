package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class StandardAuth {
    private By header = By.xpath("//h1");
    private WebDriver driver;

    public StandardAuth(WebDriver driver) {
        this.driver = driver;
    }

    public String getTextOfHeader() {
        return driver.findElement(header).getText();
    }
}
