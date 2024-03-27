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

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void testing() throws Exception
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("https://economictimes.indiatimes.com/et-now/results");
        Thread.sleep(10000);
        driver.findElement(By.xpath("//*[@id=\"topnav\"]/div[10]/a")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"sideBar\"]/div[4]/h2")));
        WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"amcSelection\"]"));
        Thread.sleep(5000);
        dropdown.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"amcSelection\"]/option[10]")));
        Thread.sleep(5000);
        WebElement option = driver.findElement(By.xpath("//*[@id=\"amcSelection\"]/option[10]"));
        option.click();
        Thread.sleep(5000);
        WebElement dropdown1 = driver.findElement(By.xpath("//*[@id=\"schemenm\"]"));
        Thread.sleep(5000);
        dropdown1.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"canara-robeco-bluechip-equity-fund-direct-plan\"]")));
        WebElement option1 = driver.findElement(By.xpath("//*[@id=\"canara-robeco-bluechip-equity-fund-direct-plan\"]"));
        option1.click();
        Thread.sleep(6000);
        driver.findElement(By.xpath("//*[@id=\"anchor3\"]")).click();
        Thread.sleep(10000);
        driver.get("https://economictimes.indiatimes.com/canara-robeco-bluechip-equity-fund-direct-plan/mffactsheet/schemeid-15765.cms");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"installment_type\"]/li")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"installment_type\"]/li/ul/li[1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"installment_amt\"]/li")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"installment_amt\"]/li/ul/li[3]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"installment_period\"]/li")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"installment_period\"]/li/ul/li[4]/span")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"mfNav\"]/div/ul/li[2]")).click();
        Thread.sleep(3000);
        String a = driver.findElement(By.xpath("//*[@id=\"mfReturns\"]/div[2]/div[2]/ul/li[1]/table/tbody/tr[1]")).getText();
        System.out.println(a);
        driver.quit();
    }
}
