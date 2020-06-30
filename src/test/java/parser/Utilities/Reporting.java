package parser.Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter {
	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	
	public void onStart(ITestContext tc)
	{
		//String timestamp = new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss").format(new Date());
		String reportname= "Propine Date Parser_Test Report"+".html";
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-reports/"+reportname);
		htmlReporter.loadConfig(System.getProperty("user.dir")+"/extent-config.xml");
		
		extent= new ExtentReports();
		
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host", "LocalHost");
		extent.setSystemInfo("Enviroment", "Dev");
		extent.setSystemInfo("Browser", "Chrome");
		extent.setSystemInfo("User", "Aamir");
		
		htmlReporter.config().setDocumentTitle("Date_Parser_TestReport");
		htmlReporter.config().setReportName("Unit_TestReport");	
		htmlReporter.config().setTheme(Theme.DARK);		
		
	}
	 
	public void onTestSuccess(ITestResult tr)
	{
		logger=extent.createTest(tr.getName());
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
		
	}
	
	public void onTestFailure(ITestResult tr)
	{
		logger=extent.createTest(tr.getName());
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss").format(new Date());
		String screenshotpath= System.getProperty("user.dir")+"\\ScreenShots\\"+tr.getName()+timestamp+".png";
		
		File file =new File(screenshotpath);
		
		if(file.exists())
		{
			try {
				logger.fail("Check Screenshot"+ "  "+logger.addScreenCaptureFromPath(screenshotpath));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public void onTestSkipped(ITestResult tr)
	{
		logger=extent.createTest(tr.getName());
		logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.BROWN));
		
	}
	
	public void onFinish(ITestContext textcontext)
	{
		extent.flush();
		
	}
	
	
}


