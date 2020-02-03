package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.GsmCallActions;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MainPage extends BasePOM {

    public MainPage (AndroidDriver<MobileElement> driver) {
        super(driver);
    }


    @CacheLookup
    @AndroidFindBy(id ="action_bar")
    public AndroidElement headerBar;

    @CacheLookup
    @AndroidFindBy(xpath ="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.TextView")
    public AndroidElement headerBarText;

    @CacheLookup
    @AndroidFindBy(id = "switchBlockCalls")
    public AndroidElement filterButton;

    @CacheLookup
    @AndroidFindBy(id = "counterBlockedCalls")
    public AndroidElement blockedCalls;

    @CacheLookup
    @AndroidFindBy(id = "counterSuspiciousCalls")
    public AndroidElement suspiciousCalls;

    @CacheLookup
    @AndroidFindBy(id= "filterOptionsContainer")
    public AndroidElement filterContainer;

    @CacheLookup
    @AndroidFindBy(id= "radioOptionSpamOnly")
    public AndroidElement spamOnlyCheckbox;

    @CacheLookup
    @AndroidFindBy(id= "radioOptionNotContacts")
    public AndroidElement notForMyContactsCheckbox;

    @CacheLookup
    @AndroidFindBy(id= "radioOptionBlacklist")
    public AndroidElement blackListCheckbox;

    @CacheLookup
    @AndroidFindBy(id= "radioOptionWhitelist")
    public AndroidElement whitelistCheckbox;

    @CacheLookup
    @AndroidFindBy(xpath = "//android.widget.Toast[1]")
    public AndroidElement toastMessage;

    @CacheLookup
    @AndroidFindBy(id = "counterSuspiciousCalls")
    public AndroidElement numberSuspiciousCalls;

    @CacheLookup
    @AndroidFindBy(id = "counterBlockedCalls")
    public AndroidElement numberBlockedCalls;




    public void pressFilterButton() {
        filterButton.click();
    }


    public void pageLoading() {
        headerBar.isDisplayed();
        blockedCalls.isDisplayed();
        suspiciousCalls.isDisplayed();
        filterButton.isDisplayed();
    }

    public void filterContainerElementsLoading()
    {
        filterContainer.isDisplayed();
        notForMyContactsCheckbox.isDisplayed();
        spamOnlyCheckbox.isDisplayed();
        blackListCheckbox.isDisplayed();
        whitelistCheckbox.isDisplayed();
    }

    public void assertToastMessage (String toastExpectedText) {
        String text = toastMessage.getText();
        Assert.assertEquals(text , toastExpectedText);
    }

    public void assertIncrementOfBlockedCalls(int num2) {
        String num1 = numberBlockedCalls.getText();
        int result = Integer.parseInt(num1);
        Assert.assertEquals(result, num2+1);
    }

    public void assertIncrementOfSuspiciousCalls(int num) {
        String num1 = numberSuspiciousCalls.getText();
        int result = Integer.parseInt(num1);
        Assert.assertEquals(result, num+1);
    }

    public void makeCall(String number) {
        driver.makeGsmCall(number, GsmCallActions.CALL);
    }

    public void cancelCall(String number) {
        driver.makeGsmCall(number, GsmCallActions.CANCEL);
    }


}
