package PageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageObjects {
	
	private static final Logger logger = LogManager.getLogger(HomePageObjects.class);
	
	private WebDriver driver;
	
	private By SignInSecurly =By.linkText("Sign in securely");
	
	public HomePageObjects(WebDriver driver) {
		this.driver=driver;
	}
	
	
	public void clicklinkSignIn() {
		driver.findElement(SignInSecurly).click();
		logger.info("click on sign in");
	}

}
