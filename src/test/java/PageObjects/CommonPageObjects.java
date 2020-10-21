package PageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class CommonPageObjects {

	private static final Logger logger = LogManager.getLogger(CommonPageObjects.class);
	WebDriver driver;

	private By SearchText=By.id("twotabsearchtextbox");
	private By AmazonLogo=By.id("//a[@class='nav-logo-link']");
	private By AddToCardBasket= By.id("nav-cart-count");
	private By navLinkPrime =By.id("nav-link-prime");
	private By NavOrder =By.id("nav-orders");
	private By AccoundAndList =By.id("nav-link-accountList");
	private By navHamburgerMenu =By.id("nav-hamburger-menu");

	public CommonPageObjects(WebDriver driver) {
		this.driver=driver;
	}

	public void SearchTextBox(String text) throws Exception {
		WebDriverWait wait =new WebDriverWait(driver,20);
		WebElement search=wait.until(ExpectedConditions.elementToBeClickable(SearchText));
		search.sendKeys(text);

		logger.info("search product enterd "+text);
		Thread.sleep(2000);
		driver.findElement(SearchText).sendKeys(Keys.ENTER);
		logger.info("enter on search product ");
	}

	public void amaonlogoDisplayed() {
		boolean b=driver.findElement(AmazonLogo).isDisplayed();
		Assert.assertEquals("Amazon logo displayed ", b, true);
	}
	public void validPageTitle(String title) {
		String expectedTitle ="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		String actualTitle =driver.getTitle();

		Assert.assertEquals(expectedTitle, actualTitle);
		logger.info("title is matched-"+driver.getTitle());
	}


	public void elementPresentInHeader(String text) throws Exception {
		boolean b=false;
		switch(text.toLowerCase().trim()) {

		case "Hamburger Menu":
			b=driver.findElement(navHamburgerMenu).isDisplayed();
			break;

		case "Amazon logo":
			b=driver.findElement(AmazonLogo).isDisplayed();
			break;

		case "Order logo":
			b=driver.findElement(NavOrder).isDisplayed();
			break;

		case "Prime Link":
			b=driver.findElement(navLinkPrime).isDisplayed();
			break;

		case "Accound And List":
			b=driver.findElement(AccoundAndList).isDisplayed();
			break;

		case "Add To Card Basket":
			b=driver.findElement(AddToCardBasket).isDisplayed();
			break;

		default:
			logger.fatal("header link is not displyed");
			throw new Exception("header link is not displayed ");
		}
		if (b) {
			logger.info("Header Link is displayed: " + text);
			Assert.assertEquals("Header Link displayed",true, b);
		}else {
			logger.fatal("Header Link is not displayed: " + text);
			Assert.fail("Header Link is not displayed: " + text);
		}




	}

}































