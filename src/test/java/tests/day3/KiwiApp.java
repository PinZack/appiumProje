package tests.day3;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class KiwiApp {


    AndroidDriver<AndroidElement> driver;

    @BeforeTest
    public void setup() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "PIXEL 2");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        //capabilities.setCapability(MobileCapabilityType.APP,"C:\\Users\\cahit\\IdeaProjects\\appiumKontrol\\Apps\\arabam.com_4.8.0_Apkpure.apk");
        capabilities.setCapability("appPackage", "com.skypicker.main");
        // Hangi uygulam uzerinde calıimak istiyorsak
        // Apk infodan uygulama bigisine ulasabiliriz
        capabilities.setCapability("appActivity", "com.kiwi.android.feature.splash.impl.ui.SplashActivity");
        // Kullanacak oldugumuz belirledikten sonra o uygulaminin hangi sayfasindan baslamak istiyorsak
        // onun degerini avtivites kisminda bularak appActivity degiskenin karsisina parametre olarak giriyoruz
        capabilities.setCapability(MobileCapabilityType.NO_RESET, false);

        // Egerki bir uygulamada uygulamanin onbelligini her testten sonra sifirlamak istiyorsak NoRESET FALSE olmalidir !!
        // İstemiyorsan NoRESET TRUE kullaniriz


        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    @Test
    public void kiwiAppTest() throws InterruptedException {


        // uygulamanin yuklendigi dogrulanir
        Assert.assertTrue(driver.isAppInstalled("com.skypicker.main"));
        // uygulamanin basariyla acildigi dogrulanir
        AndroidElement devamETButonu=driver.findElementByXPath("//*[@text='Continue as a guest']");
        Assert.assertTrue(devamETButonu.isDisplayed());
        // misafir olarak devam et e tiklanir
        devamETButonu.click();
        // ardinda gelecek olan 3 adimada yesil butona basilarak devam edilir
        //538,1689
        TouchAction action =new TouchAction(driver);
        Thread.sleep(1000);
        for (int i = 0; i <3 ; i++) {
            action.press(PointOption.point(538,1689)).release().perform();
            Thread.sleep(1000);
        }
        // Trip type,one way olarak secilir
        // kalkis ulkesi secenegine tiklanir ve default olan ulke kaldirilir
        // kalkis yapilacak ulke/sehir girilir ve sec e tiklanir
        // varis ulkesi secenegine tiklanir ve gidilecek ulke girilir
        // gidis tarihi eylul ayinin 21 i olarak secilir ve set date e tiklanir
        // search butonuna tiklanir
        // en  ucuz ve aktarmasiz filtrelemeleri yapilir
        // gelen bilet fiyati kaydedilir ve kullanicin telefonuna sms olarak gonderilir


    }


}
