package tests;

import Support.AppiumBaseClass;

//import Support.TestListener;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.GsmCallActions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.MainPage;

//@Listeners(TestListener.class)
public class SampleTest extends BaseTestClass {


    // Verify that elements of the app appearing
    @Test
    public void assertMainAppElemenets() throws InterruptedException {

        main.pageLoading();
        main.pressFilterButton();
        Thread.sleep(1000);
        main.filterContainerElementsLoading();
    }


    // Verify that your friend can call you and that app won't block regular call
    @Test
    public void verifyFriendCall() throws InterruptedException {

        main.pressFilterButton();
        String blck = main.numberSuspiciousCalls.getText();
        String sus = main.numberBlockedCalls.getText();
        int blocked = Integer.parseInt(blck);
        int suspicious = Integer.parseInt(sus);
        main.makeCall("+38761077961");
        Thread.sleep(3000);
        main.cancelCall("+38761077961");
        Assert.assertEquals(0, blocked);
        Assert.assertEquals(0, suspicious);
    }

    // Verify that app will warn you about Suspicions call and register that call
    @Test
    public void verifySuspicionCall() throws InterruptedException {

        main.pressFilterButton();
        Thread.sleep(2000);
        String str1 = main.suspiciousCalls.getText();
        int num1 = Integer.parseInt(str1);
        main.makeCall("4259501212");
        main.assertToastMessage("Beware! Suspicious caller.");
        Thread.sleep(2000);
        main.cancelCall("4259501212");
        main.assertIncrementOfSuspiciousCalls(num1);

    }


    //Verify that app will block span call and register that call
    @Test
    public void verifySpamCall() throws InterruptedException {

        main.pressFilterButton();
        Thread.sleep(2000);
        String str2 = main.numberBlockedCalls.getText();
        int num2 = Integer.parseInt(str2);
        main.makeCall("2539501212");
        main.assertToastMessage("Blocking this call");
        Thread.sleep(3000);
        main.cancelCall("2539501212");
        main.assertIncrementOfBlockedCalls(num2);
    }


    // This test is set tu faile to see how iTestListener works
    @Test
    public void failedTest() {
        MainPage main = new MainPage(driver);
        String headerText = main.headerBarText.getText();
        Assert.assertEquals(headerText, "This test is set to fail");

    }

}

