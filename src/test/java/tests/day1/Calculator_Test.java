package tests.day1;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Calculator_Test {


    AndroidDriver<AndroidElement> driver; //android cihazlarin driveri

    //  AppiumDriver<MobileElement> appiumDriver; //hem android de hem de ios da calisir

    @Test
    public void deneme1() throws MalformedURLException {

        DesiredCapabilities capabilities=new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"PIXEL 2");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.APP,"C:\\Users\\cahit\\IdeaProjects\\appiumKontrol\\Apps\\Calculator_8.4 (503542421)_Apkpure.apk");

        driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        //uygulamanın yuklendigini dogrular(ısInstalled)
        Assert.assertTrue(driver.isAppInstalled("com.google.android.calculator"));
        //uygulamanin acildigini dogrular
        AndroidElement acButonu=driver.findElementById("com.google.android.calculator:id/clr");
        Assert.assertTrue(acButonu.isDisplayed());

        //carpma,bolme,toplama,cikarma islemleri yaparak sonuclari dorular
        //100 un 5 katinin 500 oldugunu hesap makinesinde dogrulayin
        driver.findElementByAccessibilityId("1").click();
        driver.findElementByAccessibilityId("0").click();
        driver.findElementByAccessibilityId("0").click();
        driver.findElementByAccessibilityId("multiply").click();
        driver.findElementByAccessibilityId("5").click();
        driver.findElementByAccessibilityId("equals").click();

        String actualResult =driver.findElementById("com.google.android.calculator:id/result_final").getText();
        int expectedResult=500;
        Assert.assertEquals(Integer.parseInt(actualResult),expectedResult);






    }



    }