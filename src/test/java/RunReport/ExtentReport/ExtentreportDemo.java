package RunReport.ExtentReport;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentreportDemo
{
	ExtentReports extent;
	
	@BeforeTest
	public void config() 
	{
		//ExtentSparkReporter Class:
		String path = System.getProperty("user.dir") + "\\Reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Reports");
		reporter.config().setDocumentTitle("Extent Reports");
		
		//ExtentReports Class:
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Sachin");
	}
	
	
	@Test
	public void initialDemo()
	{
		ExtentTest test = extent.createTest("Initial Demo");
		WebDriver driver = new ChromeDriver();
		driver.get("http://rahulshettyacademy.com/");
		System.out.println(driver.getTitle());
		driver.close();
//		test.fail("Result do not match");		//Explicit failing
		extent.flush();		//mandatory to generate report, Add it at the last of all your test cases.

	}

}
