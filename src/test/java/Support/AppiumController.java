
package Support;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by Thomas on 2016-06-15.
 */
public class AppiumController {
    protected static AndroidDriver<MobileElement> driver;

    //Browserstack setup
    private static String BS_USERNAME = "<your bs mame>";
    private static String BS_ACCESSKEY = "<your bs key>";
    private static String DEVICE_NAME = "<your emulator or real device ID>";
    private static String PLATFORM_VERSION = "9.0";
    private static String BROWSERSTACK_APPURL = "<Your app url>";
    

    // Choose execution enviroment
    public static OS executionOS = OS.ANDROID;


    // Possible enviroments where user can run tests
    public enum OS {
        ANDROID,
        ANDROID_BROWSERSTACK,

    }
    public static AppiumController instance = new AppiumController();

    public void start() throws MalformedURLException {
        if (driver != null) {
            return;
        }
        DesiredCapabilities capabilities = new DesiredCapabilities();
        switch(executionOS){
            // Emulated or real android device.
            case ANDROID:
                File classpathRoot = new File(System.getProperty("user.dir"));
                File appDir = new File(classpathRoot, "/apps/Android");
                File app = new File (appDir, "robo.apk");
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME);
                capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
                capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, PLATFORM_VERSION);
                capabilities.setCapability("app", app.getAbsolutePath());
                capabilities.setCapability("appPackage", "co.teltech.callblocker");
                capabilities.setCapability("appActivity", "co.teltech.callblocker.activities.MainActivity");
                capabilities.setCapability("autoGrantPermissions", true);

                driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
                break;
            // Browserstack device farm
            case ANDROID_BROWSERSTACK:
                capabilities.setCapability("device", "Samsung Galaxy S8");
                capabilities.setCapability("os_version", "7.0");
                capabilities.setCapability("project", "My First Project");
                capabilities.setCapability("build", "My First Build");
                capabilities.setCapability("name", "Bstack-[Java] Sample Test");
                capabilities.setCapability("app", BROWSERSTACK_APPURL);
                capabilities.setCapability("autoGrantPermissions", true);
                driver = new AndroidDriver<MobileElement>(new URL("https://" + BS_USERNAME + ":" + BS_ACCESSKEY + "@hub-cloud.browserstack.com/wd/hub"), capabilities);
                break;

        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    //Stop driver after test is completed
    public void stop() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
