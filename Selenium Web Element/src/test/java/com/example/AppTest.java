package com.example;

import static org.junit.Assert.assertTrue;

import java.time.Duration;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AppTest 
{
    @Test
    public void testing() throws Exception
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.moneycontrol.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("search_str")));
        driver.navigate().refresh();
        driver.findElement(By.xpath("//*[@id=\"search_str\"]")).sendKeys("Reliance Industries");
        Thread.sleep(10000);
        WebElement dy = (new WebDriverWait(driver, Duration.ofSeconds(10))).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"autosuggestlist\"]/ul/li[1]/a")));//implicit wait
        dy.click();
        Thread.sleep(7000);
        String pageSource = driver.getPageSource();
        if (pageSource.contains("Reliance Industries Ltd")) {
            System.out.println("Page contains the term 'Reliance Industries Ltd'.");
        } else {
            System.out.println("Page does not contain the term 'Reliance Industries Ltd'.");
        }
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"common_header\"]/div[1]/div[3]/nav/div/ul/li[10]/a")).click();
        Thread.sleep(5000);
        WebElement dy1 = (new WebDriverWait(driver, Duration.ofSeconds(10))).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"mc3_return\"]/div[1]/ul/li[2]/a")));//implicit wait
        dy1.click();
        Thread.sleep(5000);
        driver.quit();
    }
}
