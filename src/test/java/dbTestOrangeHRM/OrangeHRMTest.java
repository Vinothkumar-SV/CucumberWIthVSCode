package dbTestOrangeHRM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class OrangeHRMTest {

    public static String EmpId;

    @Test
    public void CreateEmployee() throws Exception {

        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("http://localhost/orangehrm-5.7/web/index.php/auth/login");//30 -128 sec igno 
        driver.findElement(By.name("username")).sendKeys("admin");//30 
        driver.findElement(By.name("password")).sendKeys("AdminTL@09");//30
        driver.findElement(By.xpath("//button[text()=' Login ']")).click();
        Thread.sleep(3000);
        // Verify Dashboard
        WebElement dashboardText = driver.findElement(By.xpath("//span[text()='Dashboard']"));
        dashboardText.click();
        String dashboard = driver.findElement(By.xpath("//span[@class='oxd-topbar-header-breadcrumb']/h6")).getText();

        if (dashboard.contains("Dashboard")) {
            System.out.println("Dashboard Verified Succesfully");
        } else {
            System.out.println("Dashboard is not Verified Succesfully");

        }

        driver.findElement(By.xpath("//span[text()='PIM']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[text()=' Add ']")).click();
        Thread.sleep(2000);

        // Add Employee Details
        driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Harini");
        driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("P");

        // driver.findElement(By.xpath("//label[text()='Employee
        // Id']//following::div")).clear();
        driver.findElement(By.xpath("//button[text()=' Save ']")).click();

        // Verify success message
        // WebElement successMsg =
        // driver.findElement(By.xpath("//p[contains(text(),'Successfully Saved')]"));
        WebElement successMsg1 = driver.findElement(
                By.xpath("//p[@class='oxd-text oxd-text--p oxd-text--toast-message oxd-toast-content-text']"));
        String text = successMsg1.getText();
        if (text.contains("Succesfully")) {
            System.out.println("Employee added Succesfully");
        }

        driver.findElement(By.xpath("//span[text()='PIM']")).click();

        // Search for Employee
        driver.findElement(By.xpath("//input[@placeholder='Type for hints...']")).sendKeys("Harini");
        Thread.sleep(500);
        driver.findElement(By.xpath("//div[@class='oxd-autocomplete-option']//span")).click();
        driver.findElement(By.xpath("//button[text()=' Search ']")).click();
        Thread.sleep(500);

        EmpId = driver
                .findElement(By.xpath(
                        "//div[text()='Id']//following::div[@class='oxd-table-cell oxd-padding-cell' and @style]"))
                .getText();

        System.out.println(EmpId);

        MySQLConnection db = new MySQLConnection();
        db.Database(EmpId); // (EmpID);

        driver.quit();
//
//		// Click on the Employee
//	
//
//		// Edit Employee Details
//		driver.findElement(By.xpath("//button[@class='oxd-icon-button oxd-table-cell-action-space']/i")).click();
//		Thread.sleep(500);
//		driver.findElement(By.xpath("//input[@name='middleName']")).sendKeys("M");
//		Thread.sleep(500);
//		driver.findElement(By.xpath("//button[text()=' Save ']")).click();
//		
//
//		// Verify success message
//		//WebElement successMsg = driver.findElement(By.xpath("//p[contains(text(),'Successfully Saved')]"));
//
//		WebElement successMsg2 = driver.findElement(
//				By.xpath("//p[@class='oxd-text oxd-text--p oxd-text--toast-message oxd-toast-content-text']"));
//		String editMsg = successMsg2.getText();
//
//		if (editMsg.contains("Succesfull")) {
//			System.out.println("Employee added Succesfully");
//		}
//		driver.findElement(By.xpath("//img[@class='oxd-userdropdown-img']")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//a[text()='Logout']")).click();
//		Thread.sleep(3000);
//
//		// Verify login page is displayed
//		WebElement loginButton = driver
//				.findElement(By.xpath("//h5[@class='oxd-text oxd-text--h5 orangehrm-login-title']"));
//		if (loginButton.isDisplayed()) {
//			System.out.println("Login Verified");
//		}

    }

}
