package tests;

import Support.AppiumBaseClass;
import Support.AppiumController;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.MainPage;

public class BaseTestClass extends AppiumBaseClass {


    MainPage main;

    // initialize driver enviroment before test
    @BeforeMethod
    public void setUp() throws Exception {
        AppiumController.instance.start();
        switch (AppiumController.executionOS) {
            case ANDROID:
            case ANDROID_BROWSERSTACK:
                main = new MainPage((AndroidDriver<MobileElement>) driver());
                break;

        }
    }


    @AfterMethod
    public void tearDown() {
        AppiumController.instance.stop();
    }
}