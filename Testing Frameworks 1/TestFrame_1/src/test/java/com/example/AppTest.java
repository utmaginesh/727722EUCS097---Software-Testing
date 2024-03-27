package com.example;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import io.github.bonigarcia.wdm.WebDriverManager;


public class AppTest 
{
    
    @Test
    public void shouldAnswerWithTrue() throws Exception
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://dbankdemo.com/bank/login");
        Thread.sleep(5000);
        File fobj=new File("Keywords.xls");
        FileInputStream fis=new FileInputStream(fobj);
        Workbook wb=new HSSFWorkbook(fis);
        @SuppressWarnings("rawtypes")
        Sheet sh= wb.getSheet("Sheet1");
        int rowcount=sh.getLastRowNum()-sh.getFirstRowNum()+1;
        Thread.sleep(5000);
        for(int row=0;row<rowcount;row++)
        {
            Row r=sh.getRow(row);
            for(int col=0;col<r.getLastCellNum();col+=2)
            {
                //Cell s=r.getCell(0);
                WebElement w=driver.findElement(By.id("username"));
                Thread.sleep(5000);
                w.sendKeys(r.getCell(col)+"");
                Thread.sleep(5000);
                
                WebElement x=driver.findElement(By.id("password"));
                Thread.sleep(5000);
                x.sendKeys(r.getCell(col+1)+"");
                Thread.sleep(5000);
                driver.findElement(By.id("submit")).click();
                Thread.sleep(5000);
                String cur=driver.getCurrentUrl();
                // System.out.println(cur);
                if(cur.contains("home"))
                {
                    System.out.println("Successful login");
                    driver.findElement(By.id("deposit-menu-item")).click();
                    Thread.sleep(5000);
                    WebElement element1=driver.findElement(By.id("selectedAccount"));
                    element1.click();
                    Select dropdown = new Select(element1);
                    dropdown.selectByVisibleText("Individual Checking (Standard Checking)");
                    Thread.sleep(5000);
                    WebElement ele2= driver.findElement(By.id("amount"));
                    ele2.sendKeys("5000");
                    Thread.sleep(5000);
                    Thread.sleep(5000);
                    driver.findElement(By.id("withdraw-menu-item")).click();
                    Thread.sleep(5000);
                    driver.findElement(By.xpath("//*[@id=\"selectedAccount\"]")).click();
                    Thread.sleep(3000);
                    driver.findElement(By.xpath("//*[@id=\"selectedAccount\"]/option[2]")).click();
                    Thread.sleep(5000);
                    WebElement ele4= driver.findElement(By.id("amount"));
                    ele4.sendKeys("3000");
                    Thread.sleep(3000);
                    driver.findElement(By.xpath("//*[@id=\"right-panel\"]/div[2]/div/div/div/div/form/div[2]/button[1]")).click();
                    Thread.sleep(5000);


                }          
            }
            wb.close();
            fis.close();
            Thread.sleep(10000);
            driver.quit();
    }
}}