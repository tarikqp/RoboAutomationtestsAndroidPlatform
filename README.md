# RoboAutomationtestsAndroidPlatform
 
 
 An Appium (java) example project for cross platform testing of an Android and an iOS application

Instructions:

Download and setup Appium (see http://appium.io/docs/en/about-appium/getting-started/)

Import this project as a maven project in e.g. IntelliJ or Eclipse.

Set the executionOS variable in the AppiumController class (src/test/java/AppiumSupport/AppiumController.java) to Android Emulator or Browserstack depending on what platform you want to execute the example test on. 




Start the appium server and run the example test “sampleTest” in /src/test/java/tests/SampleTest.java

Browserstack:

It's also possible to run the tests against Browserstack (www.browserstack.com). To do this you need to do the following.

Enter your Browserstack credentials in the AppiumController class (BS_USERNAME and BS_ACCESSKEY).

Upload the applications to Browserstack add your APP url

Run the example test “searchContact” in src/test/java/Test/Test_ContactSearch.jav
