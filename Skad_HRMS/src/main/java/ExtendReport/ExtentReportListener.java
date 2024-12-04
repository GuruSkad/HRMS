//package ExtendReport;
//
//import java.io.File;
//import java.util.List;
//import java.util.Map;
//
//import org.apache.commons.lang3.builder.DiffResult;
//import org.apache.logging.log4j.core.pattern.AbstractStyleNameConverter.White;
//import org.testng.IReporter;
//import org.testng.ISuite;
//import org.testng.ISuiteResult;
//import org.testng.ITestContext;
//import org.testng.xml.XmlSuite;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import com.aventstack.extentreports.reporter.configuration.Theme;
//
//public class ExtentReportListener implements IReporter{
//    private ExtentReports extent;
//
//  
//    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
//        // Initialize ExtentReports
//    	extent = new ExtentReports();
//
//		for (ISuite suite : suites) {
//			Map<String, ISuiteResult> result = suite.getResults();
//
//			for (ISuiteResult r : result.values()) {
//				ITestContext context = r.getTestContext();
//
//				buildTestNodes(context.getPassedTests(), LogStatus.PASS);
//				buildTestNodes(context.getFailedTests(), LogStatus.FAIL);
//				buildTestNodes(context.getSkippedTests(), LogStatus.SKIP);
//			}
//        }
//
//        // Write all details to the report
//        extent.flush();
//    }
//@test
//    private void buildTestNodes(ITestContext context, String status) {
//        for (ITestResult result : context.getAllTestMethods()) {
//            ExtentTest test = extent.createTest(result.getMethod().getMethodName());
//
//            test.assignCategory(result.getMethod().getGroups());
//            test.getModel().setStartTime(getTime(result.getStartMillis()));
//            test.getModel().setEndTime(getTime(result.getEndMillis()));
//
//            // Log test status
//            if (result.getThrowable() != null) {
//                test.fail(result.getThrowable());
//            } else if (status.equalsIgnoreCase("PASS")) {
//                test.pass("Test Passed");
//            } else if (status.equalsIgnoreCase("SKIP")) {
//                test.skip("Test Skipped");
//            } else {
//                test.fail("Test Failed");
//            }
//        }
//    }
//
//    private Date getTime(long millis) {
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTimeInMillis(millis);
//        return calendar.getTime();
//    }
//}
