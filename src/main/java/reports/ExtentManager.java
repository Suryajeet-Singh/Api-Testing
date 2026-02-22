package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {

        if (extent == null) {

            ExtentSparkReporter spark =
                    new ExtentSparkReporter("test-output/ExtentReport.html");

            spark.config().setReportName("API Automation Report");
            spark.config().setDocumentTitle("Rest Assured Results");

            extent = new ExtentReports();
            extent.attachReporter(spark);
        }

        return extent;
    }
}