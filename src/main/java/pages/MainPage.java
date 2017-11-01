package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MainPage {
    private By buttonStandardAuth = By.xpath("//a[@href='/protected-standard/\']");
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnButtonStandardAuth() {
        driver.findElement(buttonStandardAuth).click();
    }
}
