package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;


public class Helper {
    public static Long getWidth(JavascriptExecutor jsExecutor, WebDriver driver, By by) {
        WebElement element = driver.findElement(by);
        return (Long) jsExecutor.executeScript("return arguments[0].offsetWidth;", element);
    }

    public static boolean isScrolled(JavascriptExecutor jsExecutor) {
        return (boolean) jsExecutor.executeScript("return document.body.scrollHeight > document.documentElement.clientHeight");
    }

    public static void blurElement(JavascriptExecutor jsExecutor, WebDriver driver, By by) {
        WebElement element = driver.findElement(by);
        jsExecutor.executeScript("arguments[0].blur();", element);
    }
}
