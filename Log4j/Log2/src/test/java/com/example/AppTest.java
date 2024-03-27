package com.example;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AppTest 

{
    public static Logger logger = LogManager.getLogger(AppTest.class);

    @Test 
    public void testRun() throws Exception{
        File fobj=new File("Book1.xls");
        FileInputStream fis = new FileInputStream(fobj);
        Workbook wb = new HSSFWorkbook(fis);
        Sheet sh= wb.getSheet("Sheet1");
        Row r=sh.getRow(0);
        String location = r.getCell(0).getStringCellValue();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.opentable.com");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement search = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"home-page-autocomplete-input\"]")));
        search.sendKeys(location);
        search.sendKeys(Keys.ENTER);
        WebElement asian = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mainContent\"]/div/section/div[6]/div/label[4]/span[2]")));
        asian.click();
        WebElement far = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mainContent\"]/div/div/div[2]/div/div[2]/div[1]/div[1]/a/h6")));
        far.click();
        Thread.sleep(10000);
        File screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot, new File("screenshot.png"));

        WebElement drop = driver.findElement(By.xpath("//*[@id=\"restProfileSideBarDtpPartySizePicker\"]"));
        Select sel = new Select(drop);
        sel.selectByVisibleText("4 people");
        

    }
    
    
}