package org.calci.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
	public static WebDriver driver;

	public static WebDriver browser_LaunchIgnoreCase(String browserName) throws Exception {
		try {
			if (browserName.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\Driver\\chromedriver.exe");
				driver = new ChromeDriver();
			}

			else if (browserName.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.geiko.driver",
						System.getProperty("user.dir") + "\\Driver\\geckodriver.exe");
				driver = new FirefoxDriver();
			}
			if (browserName.equalsIgnoreCase("ie")) {
				System.setProperty("webdriver.ie.driver",
						System.getProperty("user.dir") + "\\Driver\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Is not a valid browser");
		}
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		return driver;
	}

	public static void launchURL(String url) throws Exception {
		try {
			driver.get(url);
			driver.manage().window().maximize();
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("URL is incorrect");
		}
	}

	public static boolean elementIsDisplayed(WebElement element) throws Exception {
		try {
			boolean displayed = element.isDisplayed();
			return displayed;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Element is not displayed");
		}
	}

	public static boolean elementIsEnabled(WebElement element) throws Exception {
		try {
			boolean enabled = element.isEnabled();
			return enabled;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Element is not enabled");
		}
	}

	public static boolean elementIsSelected(WebElement element) throws Exception {
		try {
			boolean selected = element.isSelected();
			return selected;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Element is not selected");
		}
	}

	public static void waitUntilElementVisibility(WebElement element) throws Exception {
		try {
			WebDriverWait w = new WebDriverWait(driver, 90);
			w.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Element is not visible");
		}
	}

	public static void elementClick(WebElement element) throws Exception {
		try {

			element.click();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Element is not clickable");
		}
	}

	public static void elementClear(WebElement element) throws Exception {
		try {
			waitUntilElementVisibility(element);
			if (elementIsDisplayed(element) && elementIsEnabled(element)) {
				element.clear();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Unable to clear the text in the webelement");
		}
	}

	public static void elementSendKeys(WebElement element, String value) throws Exception {
		try {
			waitUntilElementVisibility(element);
			if (elementIsDisplayed(element) && elementIsEnabled(element)) {
				element.sendKeys(value);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Unable to send keys to the webelement");
		}
	}

	public static String getElementText(WebElement element) throws Exception {
		try {
			String text = element.getText();
			return text;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Unable to get the text from the webelement");
		}
	}

	public static String getElementAttribute(WebElement element, String value) throws Exception {
		try {
			String attribute = element.getAttribute(value);
			return attribute;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Unable to get the text from the webelement");
		}
	}

	public static void selectDropDown(WebElement element, String options, String value) throws Exception {

		try {
			Select sc = new Select(element);
			if (options.equals("value")) {
				sc.selectByValue(value);
			} else if (options.equals("index")) {
				sc.selectByIndex(Integer.parseInt(value));
			} else if (options.equals("visibletext")) {
				sc.selectByVisibleText(value);
			}
		} catch (NumberFormatException e) {

			e.printStackTrace();
			throw new Exception("Unable to select from dropdown");
		}

	}

	public static void moveToElement(WebElement element) throws Exception {
		try {
			waitUntilElementVisibility(element);
			if (elementIsDisplayed(element) && elementIsEnabled(element)) {
				Actions a = new Actions(driver);
				a.moveToElement(element).build().perform();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Unable to move to the webelement");
		}
	}

	public static void actionClickElement(WebElement element) throws Exception {
		try {
			waitUntilElementVisibility(element);
			if (elementIsDisplayed(element) && elementIsEnabled(element)) {
				Actions a = new Actions(driver);
				a.click(element).build().perform();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Unable to move to the webelement");
		}
	}

	public static void actionSendKeysElement(WebElement element, String value) throws Exception {
		try {
			waitUntilElementVisibility(element);
			if (elementIsDisplayed(element) && elementIsEnabled(element)) {
				Actions a = new Actions(driver);
				a.sendKeys(element, value).build().perform();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Unable to send text to the webelement");
		}
	}

	public static void dragAndDrop(WebElement source, WebElement target) throws Exception {
		try {
			Actions a = new Actions(driver);
			a.dragAndDrop(source, target).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Unable to send text to the webelement");
		}
	}

	public static void doubleClickElement(WebElement element) throws Exception {
		try {
			waitUntilElementVisibility(element);
			if (elementIsDisplayed(element) && elementIsEnabled(element)) {
				Actions a = new Actions(driver);
				a.doubleClick(element).build().perform();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Unable to move to the webelement");
		}
	}

	public static void contextClickElement(WebElement element) throws Exception {
		try {
			waitUntilElementVisibility(element);
			if (elementIsDisplayed(element) && elementIsEnabled(element)) {
				Actions a = new Actions(driver);
				a.contextClick(element).build().perform();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Unable to move to the webelement");
		}
	}

	public static void waitUntilAlertPresent() throws Exception {
		try {
			WebDriverWait w = new WebDriverWait(driver, 20);
			w.until(ExpectedConditions.alertIsPresent());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Alert is not present");
		}
	}

	public static void acceptAlert() throws Exception {
		try {
			Alert a = driver.switchTo().alert();
			a.accept();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Unable to accept the alert");
		}
	}

	public static void dismissAlert() throws Exception {
		try {
			Alert a = driver.switchTo().alert();
			a.dismiss();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Unable to dismiss the alert");
		}
	}

	public static void sendKeysToAlert(String value) throws Exception {
		try {
			Alert a = driver.switchTo().alert();
			a.sendKeys(value);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Unable to send keys to the alert");
		}
	}

	public static void scrollusingcoordinates(int width, int height) throws Exception {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(" + width + "," + height + ")");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}

	public static void scrollusingElements(WebElement Element) throws Exception {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", Element);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}

	public static void scrolltoBottomofPage() throws Exception {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}

	public static void refreshWebPage() throws Exception {
		try {
			driver.navigate().refresh();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}

	public static void navigateToUrl(String url) throws Exception {
		try {
			driver.navigate().to(url);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}

	public static void navigateBack() throws Exception {
		try {
			driver.navigate().back();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}

	public static void navigateForward() throws Exception {
		try {
			driver.navigate().forward();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}

	public static File takeScreenShot(String fileName) throws Exception {
		File f = null;
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
			f = new File(System.getProperty("user.dir") + "src\\test\\java\\org\\cucumber\\resources\\" + fileName);
			FileUtils.copyFile(screenshotAs, f);

		} catch (WebDriverException e) {
			e.printStackTrace();
			throw new Exception();
		}
		return f;
	}

	public static String getPageTitle() throws Exception {
		try {
			String title = driver.getTitle();
			return title;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}

	public static String getCurrenturl() throws Exception {
		try {
			return driver.getCurrentUrl();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}

}
