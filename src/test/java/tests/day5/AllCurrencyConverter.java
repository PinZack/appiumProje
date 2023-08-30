package tests.day5;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllCurrencyConventerpage;
import utils.Driver;
import utils.ReusableMethods;

import java.io.File;
import java.io.IOException;

public class AllCurrencyConverter {


    AndroidDriver<AndroidElement> driver = Driver.getAndroidDriver();
    AllCurrencyConventerpage all=new AllCurrencyConventerpage();

    @Test
    public void allCurrencyTest() throws InterruptedException, IOException {

        // all currency uygulamasinin yuklendigi dogulanir
        Assert.assertTrue(driver.isAppInstalled("com.smartwho.SmartAllCurrencyConverter"));
        // uygulamanin acildigi dogrulanir
        all.updateButton.isDisplayed();
        // cevirmek istedigimiz para birimi zloty olarak secilir
        ReusableMethods.koordinatTiklama(438,337,1000);
        ReusableMethods.scrollWithUiScrollableClick("PLN");
        // cevirelecek olan para birimi Tl olarak secilir
        ReusableMethods.koordinatTiklama(428,490,1000);
        ReusableMethods.scrollWithUiScrollableClick("Turkish Lira");
        ReusableMethods.scrollWithUiScrollableClick("1");
        ReusableMethods.scrollWithUiScrollableClick("0");
        ReusableMethods.scrollWithUiScrollableClick("0");
        ReusableMethods.scrollWithUiScrollableClick("0");
        // cevrilen tutar screenShot olarak kaydedilir
        /*File ekranKaydi =driver.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(ekranKaydi,new File("CeviriSonuc.jpg"));
         */
        ReusableMethods.getScreenshot("ZlotiToTL");
        // Ardindan zloty nin tl karsiligi olan tl degeri kaydedilir
        String exchangeResult=all.result.getText();
        driver.sendSMS("5555555555",exchangeResult);
        // bu islem dolar tl, sweden kron-tl, Japon yeni- tl olarak tekrarlanir ve kullaniciya sms olarak bildirilir

    }
}
