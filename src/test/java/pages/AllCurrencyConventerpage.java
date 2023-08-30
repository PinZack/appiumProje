package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class AllCurrencyConventerpage {

    public AllCurrencyConventerpage(){

        PageFactory.initElements((WebDriver)Driver.getAndroidDriver(),this);
    }

    @FindBy(id = "com.smartwho.SmartAllCurrencyConverter:id/buttonRefresh")
    public WebElement updateButton;

    @FindBy(id = "com.smartwho.SmartAllCurrencyConverter:id/EditTextCurrencyB")
    public WebElement result;
}
