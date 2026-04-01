package base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {

	private static final ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

	public void setDriver(WebDriver driver) {
		tlDriver.set(driver);
	}

	public WebDriver getDriver() {
		return tlDriver.get();
	}

	public void launchBrowser() {
		setDriver(new ChromeDriver());
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	public void loadUrl(String url) {
		getDriver().get(url);
	}

	public WebElement locate(By by) {
		return getDriver().findElement(by);
	}

	public WebElement waitForElement(By by) {
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public void type(By by, String data) {
		waitForElement(by).sendKeys(data);
	}

	public void typeAndEnter(By by, String data) {
		waitForElement(by).sendKeys(data, Keys.ENTER);
	}

	public void click(By by) {
		waitForElement(by).click();
	}

	public String getText(By by) {
		return locate(by).getText();
	}

	public void switchTab() {
		for (String win : getDriver().getWindowHandles()) {
			getDriver().switchTo().window(win);
		}
	}

	public int cleanPrice(String price) {
		return Integer.parseInt(price.replaceAll("[^0-9]", ""));
	}

	public void quit() {
		getDriver().quit();
	}
}