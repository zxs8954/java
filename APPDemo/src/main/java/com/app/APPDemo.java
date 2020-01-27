package com.app;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class APPDemo {
//    {
//        "deviceName": "HUAWEI",
//            "platformVersion": "10",
//            "automationName": "Appium",
//            "appPackage": "com.tencent.mm",
//            "platformName": "Android",
//            "autoAcceptAlerts": "true",
//            "noReset": "true",
//            "appActivity": "com.tencent.mm.ui.LauncherUI"
//    }
    AndroidDriver<WebElement> driver;
    public static String app = "//android.widget.TextView[@content-desc=\"微信\"]";

    @BeforeTest
    public void setUp() throws MalformedURLException {
        // set up appium
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "WTK7N16C14006883");
        cap.setCapability("platformName", "Android");


        cap.setCapability("deviceName", "127.0.0.1:7555");
        cap.setCapability("platformVersion", "10");
        cap.setCapability("appPackage", "com.tencent.mm");
        cap.setCapability("appActivity",
                "com.tencent.mm.ui.LauncherUI");
        cap.setCapability("appActivity", ".ui.LauncherUI");
        cap.setCapability("sessionOverride", true);
        driver = new AndroidDriver(new URL("HTTP://127.0.0.1:8888/wd/hub"), cap);
    }

    @Test
    public void plus() throws InterruptedException {
        String password="/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.EditText";

        //driver.findElement(By.xpath(app)).click();
        driver.findElement(By.id("com.tencent.mm:id/ene")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("com.tencent.mm:id/b49")).click();
        driver.findElement(By.id("android:id/button1")).click();
        driver.findElement(By.id("com.tencent.mm:id/m7")).sendKeys("15547929160");
        driver.findElement(By.id("com.tencent.mm:id/b2f")).click();
        driver.findElement(By.xpath(password)).sendKeys("zxs136107..");
        driver.findElement(By.id("com.tencent.mm:id/b2f")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("com.tencent.mm:id/b49")).click();
    }
}
