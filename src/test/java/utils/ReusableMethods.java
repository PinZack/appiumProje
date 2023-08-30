package utils;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import java.time.Duration;

public class ReusableMethods {

    public static void koordinatTiklama(int xDegiskeni, int yDegiskeni, int bekleme) throws InterruptedException {

        TouchAction action = new TouchAction<>(Driver.getAndroidDriver());
        action.press(PointOption.point(xDegiskeni, yDegiskeni)).release().perform();
        Thread.sleep(bekleme);

    }

    public static void screenScrollDownToUp(int xPress, int yPress, int wait, int moveX, int moveY) {
        TouchAction action = new TouchAction<>(Driver.getAndroidDriver());
        action.press(PointOption.point(xPress, yPress))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(wait)))
                .moveTo(PointOption.point(moveX, moveY))
                .release()
                .perform();
    }

    public static void screenScrollDown(int wait) {
        TouchAction action = new TouchAction<>(Driver.getAndroidDriver());
        action.press(PointOption.point(471, 1371))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(wait)))
                .moveTo(PointOption.point(471, 186))
                .release()
                .perform();
    }


    public static void screenScrollUp(int wait) {
        TouchAction action = new TouchAction<>(Driver.getAndroidDriver());
        action.press(PointOption.point(471, 186))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(wait)))
                .moveTo(PointOption.point(471, 1371))
                .release()
                .perform();
    }

    public static void screenScrollRight(int wait) {
        TouchAction action = new TouchAction<>(Driver.getAndroidDriver());
        action.press(PointOption.point(1052, 1016))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(wait)))
                .moveTo(PointOption.point(31, 1016))
                .release()
                .perform();
    }

    public static void screenScrollLeft(int wait) {
        TouchAction action = new TouchAction<>(Driver.getAndroidDriver());
        action.press(PointOption.point(31, 1016))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(wait)))
                .moveTo(PointOption.point(1052, 1016))
                .release()
                .perform();
    }

    public static void scrollWithUiScrollable(String elementText) {
        AndroidDriver driver = (AndroidDriver) Driver.getAndroidDriver();
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + elementText + "\"))");
        driver.findElementByXPath("//*[@text='" + elementText + "']").click();

    }
}