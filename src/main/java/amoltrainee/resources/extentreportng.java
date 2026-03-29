package amoltrainee.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extentreportng {
	
	public static ExtentReports getreportobject()
	{
		{
			//ExtendsReports , Extendssparkreports
				String path = System.getProperty("user.dir") + "\\reports\\index.html";
				ExtentSparkReporter reporter = new ExtentSparkReporter(path);
				reporter.config().setReportName("Web Automation Result");
				reporter.config().setDocumentTitle("TestReult");
				
				ExtentReports extent = new ExtentReports();
				extent.attachReporter(reporter);
				extent.setSystemInfo("tester", "amol");
		        return extent;  
				

		 }
	}

}
