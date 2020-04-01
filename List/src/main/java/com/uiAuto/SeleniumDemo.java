package com.uiAuto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

/*
 * 元素定位的10大方法：id name tagName className linkTest partialLinkText xpath cssSelector 表格定位 层级定位
 * */
public class SeleniumDemo {


    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.imooc.com/user/newlogin/from_url");
        driver.findElement(By.name("email")).sendKeys("15547929160");
        driver.findElement(By.name("password")).sendKeys("zxs123..");
        driver.findElement(By.xpath("//*[@id=\"signup-form\"]/div[5]/input")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("后端开发")).click();
        driver.findElement(By.className("search-input")).sendKeys("测试");
        driver.findElement(By.className("icon-search")).click();
        driver.findElement(By.linkText("慕课网首页")).click();
        WebElement element = driver.findElement(By.xpath("//*[@id=\"nav\"]/ul"));
        List<WebElement> elements = element.findElements(By.tagName("li"));
        elements.get(5).click();
        Thread.sleep(5000);
    }

}
