package tests.day2;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class arabamcom {

    AndroidDriver<AndroidElement> driver;
    @BeforeTest

    public void setup() throws MalformedURLException {
        DesiredCapabilities capabilities=new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"PIXEL 2");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        //capabilities.setCapability(MobileCapabilityType.APP,"C:\\Users\\cahit\\IdeaProjects\\appiumKontrol\\Apps\\arabam.com_4.8.0_Apkpure.apk");
        capabilities.setCapability("appPackage","com.dogan.arabam");
        // Hangi uygulam uzerinde calıimak istiyorsak
        // Apk infodan uygulama bigisine ulasabiliriz
        capabilities.setCapability("appActivity","com.dogan.arabam.presentation.feature.home.HomeActivity");
        // Kullanacak oldugumuz belirledikten sonra o uygulaminin hangi sayfasindan baslamak istiyorsak
        // onun degerini avtivites kisminda bularak appActivity degiskenin karsisina parametre olarak giriyoruz



        driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }


    @Test
    public void arabamTest() throws InterruptedException {
        //driver.activateApp("com.dogan.arabam"); bir uygulamayi aktif hele getirmek icin


        Assert.assertTrue(driver.isAppInstalled("com.dogan.arabam"));

        AndroidElement headerKontrol =driver.findElementById("com.dogan.arabam:id/tvShowroomInfo");
        Assert.assertTrue(headerKontrol.isDisplayed());

        // Arabam kac para bolumune tiklayalim
        driver.findElement(By.xpath("//*[@text=\"Arabam kaç para?\"]")).click();
        // Aracimin fiyatini merak ediyorum bolumunetiklayalim
        driver.findElement(By.xpath("//*[@text=\"Aracımın fiyatını merak ediyorum\"]")).click();
        // Wolkswagen markasini secelim
        TouchAction action = new TouchAction<>(driver);

        //535,1726   535,240
        action.press(PointOption.point(535,1726)) // Telefondaki ilk tiklama islemini yaptigimiz yer
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))) // 1 ve 2 adimdaki mesafesini zaman aralıgı
                .moveTo(PointOption.point(535,240)) // Telefondaki kaydirma islemini gerceklestirecegimiz yer
                .release() // Ekrandan parmagını kaldirma
                .perform(); // action in gorevleri yerine getir emrini verdigimiz kisim
        // Eger ki wait actiondaki sure milisaniye olarak artılırsa ekranin asagıya kayma hizimiz yavaslar ve daha az mesafe kat ederiz
        // Eger ki wait acitondaki sure milisaniye olarak azaltilirsa akranin asagıya kayma hizi artar ve daha fazla mesafe kat ederiz
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@text=\"Volkswagen\"]")).click();

        // yil secimi yapalim
        driver.findElement(By.xpath("//*[@text=\"2018\"]")).click();
        // model secimi yapalim
        driver.findElement(By.xpath("//*[@text=\"Passat\"]")).click();
        // govde tipini secelim
        driver.findElement(By.xpath("//*[@text=\"Sedan\"]")).click();
        // yakit tipini secelim
        driver.findElement(By.xpath("//*[@text=\"Benzin\"]")).click();
        // vites tipini secelim
        driver.findElement(By.xpath("//*[@text=\"Yarı Otomatik\"]")).click();
        // Versiyon secimi yapalim
        //456 618
        Thread.sleep(1000);
        action.press(PointOption.point(456,618))
                .release()
                .perform();
        // aracin km bilgilerini girelim
        AndroidElement kmBox=driver.findElementById("com.dogan.arabam:id/et_km");
        if (!driver.isKeyboardShown()){
            driver.getKeyboard().pressKey("150000");

        }else {
            kmBox.sendKeys("100000");
        }
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@text=\"Devam\"]")).click();
        // aracin rengini secelim
        driver.findElement(By.xpath("(//*[@class='android.widget.TextView'])[16]")).click();

        // opsiyel donanim (varsa) seecelim
        driver.findElement(By.xpath("//*[@text=\"Devam\"]")).click();
        // degisen bilgisi ekleyerek tramer kaydi belirtelim
        Thread.sleep(1000);
        action.press(PointOption.point(538,795)).release().perform();
        action.press(PointOption.point(233,1609)).release().perform();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@text=\"Devam\"]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@text=\"Tramer kaydı yok\"]")).click();
        driver.findElement(By.xpath("//*[@text=\"Devam\"]")).click();

        // aracimizin fiyatinin 500.000 tl den fazla oldugunu test edelim
        AndroidElement ortalamaFiyatSonucuLocate=driver.findElementById("com.dogan.arabam:id/tvAveragePrice");
        String ortalamaSonSonuc=ortalamaFiyatSonucuLocate.getText();

        System.out.println(ortalamaSonSonuc); // 1.159.000
        ortalamaSonSonuc=ortalamaSonSonuc.replaceAll("\\D","");
        System.out.println(ortalamaSonSonuc);//1159000

        Assert.assertTrue(Integer.parseInt(ortalamaSonSonuc)>500000);
        // uygulamayi kapatalim
        driver.closeApp();


    }
}
