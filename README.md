# RoboAutomationtestsAndroidPlatform
 
This is automation tests are buil using:
- [Appium](https://github.com/appium/appium)
- [TestNG](https://github.com/cbeust/testng)
 
----------------------------------------------------------- 
 
Appium is an open source, cross-platform test automation tool for native, hybrid and mobile web and desktop apps. We support simulators (iOS), emulators (Android), and real devices (iOS, Android, Windows, Mac).

Download and setup Appium (see http://appium.io/docs/en/about-appium/getting-started/)

**Why Appium?**

- You don't have to recompile your app or modify it in any way, due to use of standard automation APIs on all platforms.
- You can write tests with your favorite dev tools using any WebDriver-compatible language such as Java, Objective-C, JavaScript (Node), PHP, Python, Ruby, C#, Clojure, or Perl with the Selenium WebDriver API and language-specific client libraries.
- You can use any testing framework.
- Appium has built-in mobile web and hybrid app support. Within the same script you can switch seamlessly between native app automation and webview automation, all using the WebDriver model that's already the standard for web automation.

-----------------------------------------------------------

TestNG is an open-source test automation framework for Java. It is developed on the same lines of JUnit and NUnit. Few advanced and useful features provided by TestNG makes it a more robust framework compared to its peers. The NG in TestNG stands for ‘Next Generation’. 

**Why TestNg?**

- In TestNG we can have dependency between methods, while in JUnit it is not possible.
- TestNG allows us to create **parallel tests.**
- TestNG support for multi threaded testing.
- No need to extend any classes.
- Supports unit testing as well as integration testing.
- Provides more annotations as compared to JUnit.



_**How to set up the project**_


- Import this project as a maven project in e.g. IntelliJ or Eclipse.

- Set the executionOS variable in the AppiumController class (src/test/java/AppiumSupport/AppiumController.java) to Android Emulator or Browserstack depending on what platform you want to execute the example test on. 


- Start the appium server and run the example test “sampleTest” in /src/test/java/tests/SampleTest.java. Make sure your default server is set to **127.0.0.1:4723**

- If you are going to use Android Emulator, you have to instal Android Studio and create emulator. Check here: https://developer.android.com/studio/run/emulator how to create Android Emulator and make sure to you are set desired capabilities for your device in AppiumController class (src/test/java/AppiumSupport/AppiumController.java). By defult it is set for 9.0 Android version. At same place you can add your real device. Note that your real device may not accept makeGSMcall() by Appium. It dependes on USB debugging and limitation of certion phone. In Emulators this works perfectly fine.

**How to run tests on Browserstack:*

It's also possible to run the tests against Browserstack (www.browserstack.com). To do this you need to do the following.

- Enter your Browserstack credentials in the AppiumController class (BS_USERNAME and BS_ACCESSKEY).

- Upload the applications to Browserstack add your APP url in AppiumContoller Call

- Run the example test “searchContact” in src/test/java/Test/Test_ContactSearch.jav


By defult setting of Appium Contoller class are set for Samsung S8 + Android 7.0, but that can be changed based on your preferences.
