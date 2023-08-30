package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;
import utils.ReusableMethods;

import javax.xml.xpath.XPath;

public class KiwiPage {

    public KiwiPage(){
        PageFactory.initElements((WebDriver)Driver.getAndroidDriver(),this);


    }

    @FindBy(xpath="//*[@text='Continue as a guest']")
    public WebElement misafirOlarakDevamEt;

    @FindBy(xpath = "(//*[@class='android.view.View'])[4]")
    public WebElement fromTextBox;

    @FindBy(xpath = "(//*[@class='android.view.View'])[8]")
    public WebElement fromBoxIlkSecenek;

    @FindBy(xpath = "//*[@text='Choose']")
    public WebElement chooseButon;

    @FindBy(xpath = "//*[@text='Set date']")
    public WebElement setDateButonu;

    @FindBy(xpath = "//*[@text='Search']")
    public WebElement aramaButonu;

    @FindBy(xpath = "//*[@class='(//*[@class='android.widget.TextView'])[12]']")
    public WebElement fiyatSonucu;





    public void ilkSayfaGecisleri() throws InterruptedException {

        for (int i = 0; i <3 ; i++) {
            ReusableMethods.koordinatTiklama(538,1689,2000);

        }

    }
}
