package dbTestOrangeHRM;

import java.sql.Time;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import dev.failsafe.Timeout;

public class LearnActions {

	public static void main(String[] args) {

		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		WebElement ele = driver.findElement(By.xpath("//span[text()='Prime']"));

		Actions obj=new Actions(driver);
		obj.moveToElement(ele).pause(2000).click().perform();
		
	}

}
