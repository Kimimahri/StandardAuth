package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import helpers.Helper;

public class MainPage {
    private By inputSearch = By.id("lst-ib");
    private By buttonSearch = By.xpath("//input[@name='btnK']");
    private By ResultStats = By.id("resultStats");
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void inputSomething(String something) {
        driver.findElement(inputSearch).sendKeys(something);
    }

    public void showWidthOfInput(JavascriptExecutor jsExecutor, WebDriver driver) {
        System.out.println("Width: " + Helper.getWidth(jsExecutor, driver, inputSearch));
    }

    public void blurInput(JavascriptExecutor jsExecutor, WebDriver driver) {
        Helper.blurElement(jsExecutor, driver, inputSearch);
    }

    public void clickOnButtonSearch() {
        driver.findElement(buttonSearch).click();
    }

    public void waitForSearching() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(ResultStats));
    }
}
