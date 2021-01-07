package Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

@Listeners(Utilities.TestListener.class)
public class TestBase {

	public static WebDriver driver;

	public static CommonUtilities oCommUtil = new CommonUtilities();
	public static BrowserUtilities oBrowsUtil = new BrowserUtilities();
	public static Constants oCons = new Constants();

	public static ExtentReports reports;
	public static ExtentTest logger;

	public void InitializeReport() {
		System.out.println(System.getProperty("user.dir") + "/report/");
		reports = new ExtentReports(System.getProperty("user.dir") + "/report/"
				+ new SimpleDateFormat("'ZooplaReport_'YYYYMMddHHmmss'.html'").format(new Date()));
	}

	// @BeforeSuite
	@BeforeClass
	public void InitializeDependencies() throws IOException {

		try {
			oCommUtil.loadPropertyFiles(
					System.getProperty("user.dir") + "/src/main/java/Configurations/Config.properties");
			System.out.println("current environment :" + System.getProperty("Environment"));
			oCommUtil.loadLog4jProperty(
					System.getProperty("user.dir") + "/src/main/java/Configurations/log4j.properties");
			driver = oBrowsUtil.launchBrowser(System.getProperty("Browser"));
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		InitializeReport();
	}

	public static String takeScreenshot() throws Exception {
		TakesScreenshot srcShot = ((TakesScreenshot) driver);
		File srcFile = srcShot.getScreenshotAs(OutputType.FILE);
		String imagePath = System.getProperty("user.dir") + "/report/" + "ScreenShots/"
				+ new SimpleDateFormat("'Image_'YYYYMMddHHmmss'.png'").format(new Date());
		File destFile = new File(imagePath);
		FileUtils.copyFile(srcFile, destFile);
		return imagePath;
	}

	@AfterClass
	public void ShuttingDownAllDependencies() {
		reports.flush();
		driver.quit();
	}
	/*
	 * @AfterSuite public void ShuttingDownAllDependencies() { driver.quit(); }
	 */
}
