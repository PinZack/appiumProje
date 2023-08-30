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
import pages.KiwiPage;
import utils.Driver;
import utils.ReusableMethods;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class KiwiApp {


    AndroidDriver<AndroidElement> driver = Driver.getAndroidDriver();
    TouchAction action = new TouchAction<>(driver);
    KiwiPage kiwiPage = new KiwiPage();

   /* @BeforeTest
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

    */

    @Test
    public void kiwiAppTest() throws InterruptedException {


        // uygulamanin yuklendigi dogrulanir
        Assert.assertTrue(driver.isAppInstalled("com.skypicker.main"));
        // uygulamanin basariyla acildigi dogrulanir
        Assert.assertTrue(kiwiPage.misafirOlarakDevamEt.isDisplayed());
        // misafir olarak devam et e tiklanir
        kiwiPage.misafirOlarakDevamEt.click();
        // ardinda gelecek olan 3 adimada yesil butona basilarak devam edilir
        //538,1689
        Thread.sleep(1000);
        kiwiPage.ilkSayfaGecisleri();
        // Trip type,one way olarak secilir
        ReusableMethods.koordinatTiklama(303,624,1000);
        ReusableMethods.koordinatTiklama(535,1444,1000);

        // kalkis ulkesi secenegine tiklanir ve default olan ulke kaldirilir
        ReusableMethods.koordinatTiklama(526,774,1000);
        ReusableMethods.koordinatTiklama(1013,138,1000);
        // kalkis yapilacak ulke/sehir girilir ve sec e tiklanir
        if (driver.isKeyboardShown()){
            driver.getKeyboard().pressKey("istanbul");
        }else
            kiwiPage.fromTextBox.sendKeys("Ankara");

        ReusableMethods.koordinatTiklama(465,288,1000);
        kiwiPage.chooseButon.click();

        // varis ulkesi secenegine tiklanir ve gidilecek ulke girilir
        ReusableMethods.koordinatTiklama(465,912,1000);
        if (driver.isKeyboardShown()){
            driver.getKeyboard().pressKey("nice");
        }else
            kiwiPage.fromTextBox.sendKeys("stockholm");

        ReusableMethods.koordinatTiklama(465,288,1000);
        kiwiPage.chooseButon.click();

        // gidis tarihi eylul ayinin 21 i olarak secilir ve set date e tiklanir
        ReusableMethods.koordinatTiklama(465,1052,1000);
        //471,1371,480,187
        ReusableMethods.screenScrollDownToUp(471,1371,850,471,187);
        //ReusableMethods.screenScrollDown(1000);
        ReusableMethods.koordinatTiklama(685,805,1000);
        // search butonuna tiklanir
        kiwiPage.setDateButonu.click();
        Thread.sleep(500);
        kiwiPage.aramaButonu.click();
        // en  ucuz ve aktarmasiz filtrelemeleri yapilir
        ReusableMethods.koordinatTiklama(254,257,500);
        ReusableMethods.koordinatTiklama(502,578,500);
        ReusableMethods.koordinatTiklama(523,257,500);
        ReusableMethods.koordinatTiklama(514,1456,500);

        // gelen bilet fiyati kaydedilir ve kullanicin telefonuna sms olarak gonderilir
        String fiyatSon=kiwiPage.fiyatSonucu.getText();
        driver.sendSMS("5555555555","son fiyat ektedir"+fiyatSon);

    }


}



