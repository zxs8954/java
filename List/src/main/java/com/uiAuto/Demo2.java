package com.uiAuto;


import com.google.common.io.Files;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

public class Demo2 {
    public WebDriver driver;
    public static Logger log = Logger.getLogger(Demo2.class);

    @BeforeTest
    public void InitDriver() {
        log.info("\n\n\n\n\n");
        log.info(System.currentTimeMillis());
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.imooc.com/user/newlogin/from_url");
        driver.manage().window().maximize();
        log.info("设置驱动路径,创建谷歌驱动对象额;打开慕课网首页;最大化浏览器窗口");
    }

    @Test
    public void login() {
        driver.get("https://www.imooc.com/user/newlogin/from_url");
        log.info("请输入账号密码");
        String user = driver.findElement(By.name("email")).getAttribute("placeholder");
        driver.findElement(By.name("email")).sendKeys("15547929160");
        String passwd = driver.findElement(By.name("password")).getAttribute("placeholder");
        driver.findElement(By.name("password")).sendKeys("zxs123..");
        driver.findElement(By.xpath("//*[@id=\"signup-form\"]/div[5]/input")).click();
        log.info(user);
        log.info(passwd);
        log.info("登陆成功");
        System.out.println("123");
    }

    @Test(dependsOnMethods = "login")
    public void search() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("后端开发")));

        driver.findElement(By.linkText("后端开发")).click();
        driver.findElement(By.className("search-input")).sendKeys("测试");
        driver.findElement(By.className("icon-search")).click();
        log.info("搜索测试相关内容");
        driver.findElement(By.linkText("慕课网首页")).click();
        log.info("进入慕课网首页");
        WebElement element = driver.findElement(By.xpath("//*[@id=\"nav\"]/ul"));
        List<WebElement> elements = element.findElements(By.tagName("li"));
        elements.get(5).click();
        log.info("点击进入猿问");
    }

    @Test(dependsOnMethods = "search")
    public void radioBox() {
        driver.get("https://www.imooc.com/user/setprofile");
        String info = driver.findElement(By.className("common-title")).getText();
        log.info("进入页面" + info);
        driver.findElement(By.linkText("编辑")).click();
        //driver.findElement(By.xpath("//*[@id=\"profile\"]/div[4]/div/label[3]")).click();
        List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"profile\"]/div[4]/div/label"));

        for (WebElement radio : elements) {
            boolean b = radio.isSelected();
            System.out.println(radio);
            if (b == false) {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                }
                radio.click();
            } else {
                log.info(radio + "已被选中了");
            }
        }
    }

    @Test
    public void checkBox() {
        WebElement check = driver.findElement(By.id("auto-signin"));
        log.info("是否选中了那" + check.isSelected());
        log.info("是否有效" + check.isEnabled());
        check.click();
    }

    @Test
    public void button() {
        WebElement login = driver.findElement(By.xpath("//*[@id=\"signup-form\"]/div[5]/input"));
        log.info("是否有效" + login.isEnabled());
        log.info(login.getAttribute("value"));
        login.click();
    }

    @Test
    public void webForm() {
        WebElement form = driver.findElement(By.id("signup-form"));
        driver.findElement(By.id("signup-form")).submit();
    }

    /*
     * 上传文件
     * */
    @Test(dependsOnMethods = "login")
    public void upHeader() {
        try {
            Thread.sleep(4000);
        } catch (Exception e) {
        }
        driver.get("https://www.imooc.com/user/setprofile");
        String js = "document.getElementsByClassName('update-avator')[0].style.bottom='10px';";
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript(js);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"main\"]/div/div[1]/div[1]/div[1]/div/p/a")));
        driver.findElement(By.linkText("更换头像")).click();
        //driver.findElement(By.linkText("换一换")).click();
        driver.findElement(By.id("upload")).sendKeys("C:\\java\\List\\a.jpg");
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
        }
        File file = ((RemoteWebDriver) driver).getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(file, new File("C:\\java\\List\\screen.jpg"));
        } catch (Exception e) {
        }
        driver.findElement(By.linkText("确定")).click();
        System.out.println("123");
        driver.quit();
    }

    /*
     * 下拉框选择
     * */
    @Test(dependsOnMethods = "login")
    public void xiaLa() {
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
        }
        driver.get("https://www.imooc.com/user/setprofile");
        driver.findElement(By.linkText("编辑")).click();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
        }
        WebElement formElement = driver.findElement(By.id("profile"));
        WebElement job = formElement.findElement(By.id("job"));
        Select downList = new Select(job);
        downList.selectByIndex(3);
    }

    /*
     * 鼠标点击：Actions ac=new Actions(driver) action.click.perform();
     * 右击：action.contextClick().perform
     * 双击：action.doubleClick.perform();
     * 悬停：action.moveToElement.perform();
     * */
    @Test
    public void mouse() {
        driver.get("https://www.imooc.com");
//        driver.findElement(By.id("js-signin-btn")).click();
        Actions actions = new Actions(driver);
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
        }
//        actions.click(driver.findElement(By.xpath("/html/body/div[9]/div[2]/div/form/div[5]/input"))).perform();
//        actions.doubleClick(driver.findElement(By.xpath("/html/body/div[9]/div[2]/div/form/div[5]/input"))).perform();
        Actions s = actions.moveToElement(driver.findElement(By.linkText("运维 / 测试 / 数据库")));
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
        }
    }

}
