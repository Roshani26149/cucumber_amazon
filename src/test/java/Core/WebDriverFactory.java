package Core;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {
	private static final Logger logger = LogManager.getLogger(WebDriverFactory.class);
	private static WebDriver driver=null;

	public static WebDriver getWebBrowser(String Browser) throws Exception {
		switch(Browser.toLowerCase()) {
		case "chrome":
			driver=new ChromeDriver();
			logger.info("chrome browser invoked");
			break;

		case "firefox":
			driver=new FirefoxDriver();
			logger.info("firefox browser invoked");
			break;
		case "headless":
			ChromeOptions option =new ChromeOptions();
			option.addArguments("headless");
			option.addArguments("window size=1200*600");
			driver=new ChromeDriver(option);
			logger.info("headless browser invoked");
			break;
		default:
			logger.fatal("no such browser exist i.e. "+Browser);
			throw new Exception("no such browser is implemented.browser name sent:"+Browser);
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		logger.info("driver maximized and inplicit time set for 30 second");
		return driver;

	}

	public static void NavigateToUrl(String Url) {
		driver.get(Url);
		logger.info("driver navigate to Url-"+Url);
	}
	public static void quitBrowser() {
		driver.quit();
		logger.info("driver closed");
	}

	public static void SwitchBrowserToTab() {

		Set<String> handles=driver.getWindowHandles();
		logger.info("list of window found "+handles.size());
		logger.info("List of Window :"+handles.toString());
		Iterator<String> it=handles.iterator();
		String original=it.next();//parent window
		String nexttab=it.next();//child window

		driver.switchTo().window(nexttab);
		logger.info("switch to the new tab");
	}

	public static String getbrowsername() {
		String browserDefault="chrome";
		String browserSendFromCMD=System.getProperty("Browser");

		if(browserSendFromCMD==null) {
			return(browserDefault);
		}
		else {
			return browserSendFromCMD;
		}
}

	public static void quitDriver() {

driver.quit();
		
	}

	
	}

