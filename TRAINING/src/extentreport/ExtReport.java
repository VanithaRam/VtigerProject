package extentreport;

import java.io.File;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtReport  {
	ExtentReports report;
	
	@BeforeSuite
	public void configER()
	{
		report = new ExtentReports("./advanceReport.html");
		report.loadConfig(new File("./extent-config.xml"));
	}
		
	@Test
	public void createOrg()
	{
		ExtentTest logger = report.startTest("createOrgTest");
		logger.log(LogStatus.INFO, "login to app");
		logger.log(LogStatus.INFO, "navigate to Org Page");
		logger.log(LogStatus.INFO, "create Org");
		logger.log(LogStatus.INFO, "Verify the Org");
		if("HDFC".equals("HDFC"))
		{
			logger.log(LogStatus.PASS, "org is verified");
		}else {
			logger.log(LogStatus.FAIL, "Org is not verified");
		}
		report.endTest(logger);
		}

	@AfterSuite
	public void configAS()
	{
		report.flush();
		report.close();
	}
}
