package PageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPageObjects {
	
	 private static final Logger logger = LogManager.getLogger(SignInPageObjects.class);
	 
	 private WebDriver driver;
	 
	 private By inputTextBox=By.id("Ap_email");
	 
	 public SignInPageObjects(WebDriver driver) {
		 this.driver=driver;
	 }

	 
	 public void validateEmailInputTextBoxIsDisplayed(){
	        if (driver.findElement(inputTextBox).isDisplayed()){
	            Assert.assertTrue(true);
	            logger.info("Email input box is displayed");
	        }else{
	            logger.fatal("Email input box not displayed");
	            Assert.fail("Email text box does not appear for login after clicking on Sign in button");
	        }
	    }

	    public void enterTextInEmailTextBox(String text){
	        logger.info("Text entered in email id: " + text);
	        driver.findElement(inputTextBox).sendKeys(text);
	    }

}
