package com.Zoho.TestCases;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.google.common.io.Files;

public class BaseClass implements CommonPaths {

	public static WebDriver driver;
	public static FileInputStream fis;
	public static Properties prop;

	static {
		System.setProperty(CHROME_KEY, CHROME_PATH);
		System.setProperty(FIREFOX_KEY, FIREFOX_PATH);
		System.setProperty(IE_KEY, IE_PATH);

	}

	@BeforeSuite
	public void Setup() {
		try {
			if (driver == null) {

				prop = new Properties();
				fis = new FileInputStream(CONFIG_PROP);
				prop.load(fis);

				if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
					driver = new ChromeDriver();

				} else if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
					driver = new FirefoxDriver();
				}

				else if (prop.getProperty("browser").equalsIgnoreCase("ie")) {
					driver = new InternetExplorerDriver();
				}

			}
			driver.manage().window().maximize();
			driver.get(prop.getProperty("URL"));
			driver.manage().timeouts().implicitlyWait(Long.parseLong(prop.getProperty("ImplicitWait")),
					TimeUnit.SECONDS);

		} catch (Exception e) {

		}

	}

	@AfterMethod
	public void FailureScreenShot(ITestResult res) {
		try {
			if (ITestResult.FAILURE == res.getStatus()) {
				TakesScreenshot screenShot = (TakesScreenshot) driver;
				File temp = screenShot.getScreenshotAs(OutputType.FILE);
				String replacedDate = new Date().toString().replaceAll(":", "_");
				File file = new File(SCREENSHOT + res.getName() + replacedDate + ".png");
				System.out.println(file);
				Files.copy(temp, file);
			}
		} catch (Exception e) {

		}

	}

	@AfterSuite
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
