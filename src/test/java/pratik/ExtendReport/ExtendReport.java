package pratik.ExtendReport;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ExtendReport {

	ExtentReports reports;
	@BeforeMethod
	public void Extends() {
		String path=System.getProperty("user.dir")+"\\Report\\index.html";
		ExtentSparkReporter extent = new ExtentSparkReporter(path);
		extent.config().setReportName("Web Automation Report");
		extent.config().setDocumentTitle("Test Result");
		
		 reports = new ExtentReports ();
		reports.attachReporter(extent);
		reports.setSystemInfo("tester", "pratik meher");
	}
	
	
	@Test
	public void test1(){
		ExtentTest test=reports.createTest("demo1");
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\pratik\\OneDrive\\Desktop\\Planit Activities\\Drivers exe\\geckodriver-v0.32.1-win32\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		driver.close();
		test.fail("Result do not match");
		reports.flush();
	}
}
