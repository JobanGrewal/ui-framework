package io.pragra.learning.report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class HtmlReport {
    private ExtentReports reports;

    public HtmlReport() {
        reports = new ExtentReports();
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("report.html");
        reports.attachReporter(sparkReporter);
    }

    public ExtentTest createTest(String testName) {
        return reports.createTest(testName);
    }

    public void closeTest() {
        reports.flush();
    }
}
