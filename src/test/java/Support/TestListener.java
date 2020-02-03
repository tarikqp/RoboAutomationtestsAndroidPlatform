package Support;



import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TestListener extends AppiumBaseClass implements ITestListener {


    //onTestFailure method is called on the failure of any Test. It will take a screenshot and store that screenshot in Screenshoot/failure_screenshot with date, time and name of any test

    @Override
    public void onTestFailure(ITestResult result) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yy_hh_mm_ss");

        if (!result.isSuccess()) {


            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath()
                    + "\\Screenshots";

            File destFile = new File((String) reportDirectory + "/failure_screenshots/" + composeTestName(result) + "_"
                    + formater.format(calendar.getTime()) + ".png");

            try {
                FileUtils.copyFile(scrFile, destFile);
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }



    // Creating proper name for screenshot
    private String composeTestName(ITestResult iTestResult) {
        StringBuffer completeFileName = new StringBuffer();
        completeFileName.append(iTestResult.getTestClass().getRealClass().getSimpleName()); // simplified class name
        completeFileName.append("_");
        completeFileName.append(iTestResult.getName()); // method name

        // all the parameters information
        Object[] parameters = iTestResult.getParameters();
        for(Object parameter : parameters) {
            completeFileName.append("_");
            completeFileName.append(parameter);
        }

        // return the complete name and replace : by - (in the case the emulator have port as device name)
        return completeFileName.toString().replace(":", "-");
    }


}
