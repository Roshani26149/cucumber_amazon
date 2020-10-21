package PageObjects;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;





public class ProductDescriptionObjects {
	
	private static final Logger logger = LogManager.getLogger(ProductDescriptionObjects.class);

	private WebDriver driver;
	private By productTitle =By.id("productTitle");
	private By AddTocardBtn=By.id("add-to-cart-button");
	
	public ProductDescriptionObjects(WebDriver driver) {
		this.driver=driver;
	}
	
	public void ValidProductPageDisplayed() {
		if(driver.findElement(productTitle).isDisplayed()) {
			Assert.assertTrue(true);
			logger.info("product title is displayed ");
		}
		else {
			logger.info("product title not displayed");
		}
	}
		public void ValidateAddToCartButtonIsCorrectlyDisplayed(){
	        if (driver.findElement(AddTocardBtn).isDisplayed()){
	            Assert.assertTrue(true);
	            logger.info("Add to Cart Button is displayed");
	        }else{
	            logger.fatal("Add to Cart Button is not displayed");
	            Assert.fail("Add to Cart Button is not displayed");
	        }
	}
	
	

}
