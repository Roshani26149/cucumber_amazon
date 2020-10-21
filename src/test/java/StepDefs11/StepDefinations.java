package StepDefs11;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import Core.WebDriverFactory;
import PageObjects.CommonPageObjects;
import PageObjects.HomePageObjects;
import PageObjects.ProductDescriptionObjects;
import PageObjects.SearchPageObjects;
import PageObjects.SignInPageObjects;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;

public class StepDefinations {
	
	//********loggerinit**************
	
	 private static final Logger logger = LogManager.getLogger(StepDefinations.class);
	 
	public WebDriver driver;
	 String Url="https://www.amazon.in/";
	 int implicitTime=20;
	 Scenario scn;
	 
	 
	 CommonPageObjects commonpage;
	 HomePageObjects homepage;
	 ProductDescriptionObjects productpage;
	 SearchPageObjects searchpage;
	 SignInPageObjects signinpage;
	 
	 
	 @Before
	    public void setUp(Scenario scn) throws Exception {
	        this.scn = scn; //Assign this to class variable, so that it can be used in all the step def methods

	        //Get the browser name by default it is chrome
	        String browserName = WebDriverFactory.getbrowsername();
	        driver = WebDriverFactory.getWebBrowser(browserName);
	        logger.info("Browser invoked.");

	        //Init Page Object Model Objects
	        commonpage = new CommonPageObjects(driver);
	        homepage = new HomePageObjects(driver);
	        signinpage = new SignInPageObjects(driver);
	        searchpage = new SearchPageObjects(driver);
	        productpage = new ProductDescriptionObjects(driver);
	    }
        
	 
	 @After(order=1)
	    public void cleanUp(){
	        WebDriverFactory.quitBrowser();
	        scn.log("Browser Closed");
	    }
	 
	 @After(order=2)
	    public void takeScreenShot(Scenario s) {
	        if (s.isFailed()) {
	            TakesScreenshot scrnShot = (TakesScreenshot)driver;
	            byte[] data = scrnShot.getScreenshotAs(OutputType.BYTES);
	            scn.attach(data, "image/png","Failed Step Name: " + s.getName());
	        }else{
	            scn.log("Test case is passed, no screen shot captured");
	        }
	    }
	
	
	
	
	@Given("user is navigate to Home Page URL")
	public void user_is_navigate_to_home_page_url() {
		
		WebDriverFactory.NavigateToUrl(Url);
        scn.log("Browser navigated to URL: " +Url);

        String expected = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
       commonpage.validPageTitle(expected);


	}

	@When("User search for product {string}")
	public void user_search_for_product(String product) throws Exception {
		commonpage.SearchTextBox(product);
		scn.log("Product Searched: " + product);


	}

	@Then("Search result page is displayed")
	public void search_result_page_is_displayed() {
		

	}

	@When("Click on any product")
	public void click_on_any_product() {
		searchpage.ClickOnTheProductLink(0);

	}

	@Then("Product description is displyed in new tab")
	public void product_description_is_displyed_in_new_tab() {
		 WebDriverFactory.SwitchBrowserToTab();
	        scn.log("Switched to the new window/tab");


	}

	@Then("Search result is displyed")
	public void search_result_is_displyed() {


	}



}
