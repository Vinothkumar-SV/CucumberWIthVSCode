package stepDefinition;

import org.openqa.selenium.By;

import base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PriceSteps extends BaseClass {

	String amazonPrice;
	String flipkartPrice;

	@Given("user launches browser")
	public void user_launches_browser() {
		// handled by Hooks
	}

	@When("user searches iPhone XR 64GB Yellow in Amazon")
	@When("user searches iPhone in Amazon")
	public void searchAmazon() {

		loadUrl("https://www.amazon.in");
		typeAndEnter(By.id("twotabsearchtextbox"), "iphone 17 pro");
		// click(By.id("nav-search-submit-button"));

		click(By.xpath("//span[contains(text(),'iphone 17 pro')]"));
		// switchTab();
	}

	@When("user captures price from Amazon")
	public void captureAmazonPrice() {

		amazonPrice = getText(By.xpath("//span[@class='a-price']"));
		System.out.println("Amazon Price: " + amazonPrice);
	}

	@When("user captures incorrect price element")
	public void captureWrongAmazonPrice() {

		amazonPrice = getText(By.xpath("//span[@class='a-price-symbol']")); // wrong
		System.out.println("Incorrect Amazon Price: " + amazonPrice);
	}

	@When("user searches iPhone XR 64GB Yellow in Flipkart")
	@When("user searches iPhone in Flipkart")
	public void searchFlipkart() {

		loadUrl("https://www.flipkart.com");

		try {
			click(By.xpath("//span[@role='button']"));
		} catch (Exception e) {
		}
		typeAndEnter(By.name("q"), "iphone 17 pro");

	}

	@When("user captures price from Flipkart")
	@When("user captures correct price")
	public void captureFlipkartPrice() {

		flipkartPrice = getText(By.xpath("//div[@class='hZ3P6w DeU9vF']"));
		System.out.println("Flipkart Price: " + flipkartPrice);
	}

	@Then("user compares both prices")
	public void comparePrices() {

		int amazon = cleanPrice(amazonPrice);
		int flipkart = cleanPrice(flipkartPrice);

		if (amazon < flipkart) {
			System.out.println("Amazon cheaper");
		} else if (flipkart < amazon) {
			System.out.println("Flipkart cheaper");
		} else {
			System.out.println("Same price");
		}
	}

	@Then("comparison result should be invalid")
	public void invalidComparison() {

		try {
			int amazon = cleanPrice(amazonPrice);
			int flipkart = cleanPrice(flipkartPrice);

			if (amazon <= 0 || flipkart <= 0) {
				throw new Exception("Invalid data");
			}

		} catch (Exception e) {
			System.out.println("Invalid scenario handled correctly");
			return;
		}

		throw new AssertionError("Invalid scenario failed");
	}
}