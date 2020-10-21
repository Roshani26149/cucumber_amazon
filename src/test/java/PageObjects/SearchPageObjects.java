package PageObjects;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPageObjects {
	
	 private static final Logger logger = LogManager.getLogger(SearchPageObjects.class);
	 private WebDriver driver;
	 
	 private By product_link_list=By.xpath("//a[@class='A-link-normal a-text-normal']");
	 
	 public SearchPageObjects(WebDriver driver) {
		 this.driver=driver;
	 }
	 
	 public String ClickOnTheProductLink(int productIndex){
	       
	        List<WebElement> listOfProducts = driver.findElements(product_link_list);
	        logger.info("Number of products searched: " + listOfProducts.size());
	        listOfProducts.get(productIndex).click();
	        logger.info("Clicked on the Link in the List with index: " + productIndex +
	                ". Link Text: " + listOfProducts.get(productIndex).getText());
            return listOfProducts.get(productIndex).getText();

	    }

}
