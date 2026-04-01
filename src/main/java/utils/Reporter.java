package utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.remote.UnreachableBrowserException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.leafBot.selenium.api.base.DriverInstance;

public abstract class Reporter extends DriverInstance {
		private static ExtentReports extent;
		private static final ThreadLocal<ExtentTest> parentTest = new ThreadLocal<>();
		private static final ThreadLocal<ExtentTest> test = new ThreadLocal<>();
		private static final ThreadLocal<String> testName = new ThreadLocal<>();
		public static ExtentTest child;
		public static String incidentNumber;
		private static final String FILE_NAME = "result.html";
		private static final String DATE_PATTERN = "dd-MMM-yyyy HH-mm-ss";
		public String testcaseName, testDescription, authors, category, dataFileName, dataFileType, excelFileName;
		public static String folderName = "";

		@BeforeSuite(alwaysRun = true)
		public synchronized void startReport() {
			String date = new SimpleDateFormat(DATE_PATTERN).format(new Date());
			folderName = "reports/" + date;

				File reportFolder = new File("./" + folderName);
				if (!reportFolder.exists()) {
					reportFolder.mkdir();
				}
			ExtentSparkReporter sparkReporter = new ExtentSparkReporter("./" + folderName + "/" + FILE_NAME);
			sparkReporter.config().setDocumentTitle("Leaftaps");
			sparkReporter.config().setReportName("Leaftaps");
			sparkReporter.config().setEncoding("utf-8");
			extent = new ExtentReports();
			extent.attachReporter(sparkReporter);
		}

	@BeforeClass(alwaysRun = true)
	public synchronized void startTestCase() {
		ExtentTest parent = extent.createTest(testcaseName, testDescription);
		parent.assignCategory(category);
		parent.assignAuthor(authors);
		parentTest.set(parent);
		testName.set(testcaseName);
	}

	public synchronized void setNode() {
		child = parentTest.get().createNode(getTestName());
		test.set(child);
	}

	public abstract long takeSnap();

		public void reportStep(String desc, String status, boolean bSnap) {
			synchronized (test) {
				if (bSnap && !(status.equalsIgnoreCase("INFO") || status.equalsIgnoreCase("skipped"))) {
					long snapNumber = takeSnap();
					String imgPath = "./../../" + folderName + "/images/" + snapNumber + ".jpg";
					if (status.equalsIgnoreCase("pass")) {
						test.get().pass(desc, MediaEntityBuilder.createScreenCaptureFromPath(imgPath).build());
					} else if (status.equalsIgnoreCase("fail")) {
						test.get().fail(desc, MediaEntityBuilder.createScreenCaptureFromPath(imgPath).build());
						throw new RuntimeException("See the reporter for details.");
					} else if (status.equalsIgnoreCase("warning")) {
						test.get().warning(desc, MediaEntityBuilder.createScreenCaptureFromPath(imgPath).build());
					} else if (status.equalsIgnoreCase("skipped")) {
						test.get().skip("The test is skipped due to dependency failure");
					} else if (status.equalsIgnoreCase("INFO")) {
						test.get().info(desc);
					}
				} else {
					if (status.equalsIgnoreCase("pass")) {
						test.get().pass(desc);
					} else if (status.equalsIgnoreCase("fail")) {
						test.get().fail(desc);
						throw new RuntimeException("See the reporter for details.");
					} else if (status.equalsIgnoreCase("warning")) {
						test.get().warning(desc);
					} else if (status.equalsIgnoreCase("skipped")) {
						test.get().skip("The test is skipped due to dependency failure");
					} else if (status.equalsIgnoreCase("INFO")) {
						test.get().info(desc);
					}
				}
			}
		}

	public void reportStep(String desc, String status) {
		reportStep(desc, status, true);
	}

	// To log Rest Steps
		public static void reportStatus(String desc, String status) {
			if (status.equalsIgnoreCase("PASS")) {
				test.get().pass(desc);
			} else if (status.equalsIgnoreCase("FAIL")) {
				test.get().fail(desc);
				throw new RuntimeException();
			} else if (status.equalsIgnoreCase("WARNING")) {
				test.get().warning(desc);
			} else {
				test.get().info(desc);
			}
		}

	@AfterSuite(alwaysRun = true)
	public synchronized void endResult() {
		try {
			if (getDriver() != null) {
				getDriver().quit();
			}
		} catch (UnreachableBrowserException e) {
		}
		extent.flush();
	}

	public String getTestName() {
		return testName.get();
	}

	public Status getTestStatus() {
		return parentTest.get().getModel().getStatus();
	}

}
