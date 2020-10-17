package org.revfran.selenium3;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

/**
 * Hello world!
 */
public class FirefoxHelloWorld {
    public static void main(String[] args) {
        // Setup driver
        System.setProperty("webdriver.gecko.driver", "selenium-drivers/src/resources/geckodriver-v0.27.0.exe");

        WebDriver driver = new FirefoxDriver();

        WebDriverWait wait = new WebDriverWait(driver, 10L);
        try {
            driver.get("https://duckduckgo.com/");
            driver.findElement(By.name("q")).sendKeys("cheese" + Keys.ENTER);
            WebElement result = wait.until(presenceOfElementLocated(By.xpath("(//*[@class='result__a'])[1]")));
            System.out.println(result.getAttribute("textContent"));
        } finally {
            driver.quit();
        }
    }
}
