package tests.day5;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllCurrencyConventerpage;
import utils.Driver;
import utils.ReusableMethods;

public class AllCurrencyConverter {


    AndroidDriver<AndroidElement> driver = Driver.getAndroidDriver();
    AllCurrencyConventerpage all=new AllCurrencyConventerpage();

    @Test
    public void allCurrencyTest() throws InterruptedException {

        // all currency uygulamasinin yuklendigi dogulanir
        Assert.assertTrue(driver.isAppInstalled("com.smartwho.SmartAllCurrencyConverter"));
        // uygulamanin acildigi dogrulanir
        all.updateButton.isDisplayed();
        // cevirmek istedigimiz para birimi zloty olarak secilir
        ReusableMethods.koordinatTiklama(438,337,1000);
        ReusableMethods.scrollWithUiScrollable("PLN");
        // cevirelecek olan para birimi Tl olarak secilir
        // cevrilen tutar screenShot olarak kaydedilir
        // Ardindan zloty nin tl karsiligi olan tl degeri kaydedilir
        // bu islem dolar tl, sweden kron-tl, Japon yeni- tl olarak tekrarlanir ve kullaniciya sms olarak bildirilir

    }
}
