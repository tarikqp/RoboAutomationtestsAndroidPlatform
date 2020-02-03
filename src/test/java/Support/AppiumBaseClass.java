package Support;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;


public abstract class AppiumBaseClass {

    protected static AndroidDriver<MobileElement> driver;

    protected AppiumDriver driver() {
        return AppiumController.instance.driver;
    }
}