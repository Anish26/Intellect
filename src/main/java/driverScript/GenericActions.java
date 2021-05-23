package driverScript;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import utility.Reports;

public class GenericActions extends Reports {
	
	public static RemoteWebDriver driver;
	
	public void startApp(String browser, String url) {
		try {
			if(browser.equalsIgnoreCase("chrome")){
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("firefox")){
				System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
				driver = new FirefoxDriver();
			}
			driver.get(url);
			driver.manage().window().maximize();
			reportStep("The browser: "+browser+" launched successfully", "pass");
		} catch (WebDriverException e) {			
			reportStep("The browser: "+browser+" could not be launched", "fail");
		}
	}
	
	public void type(WebElement ele, String data) {
		try {
			ele.clear();
			ele.sendKeys(data);
			reportStep("The data: "+data+" entered successfully in the field :"+ele, "pass");
		} catch (InvalidElementStateException e) {
			reportStep("The data: "+data+" could not be entered in the field :"+ele,"fail");
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while entering "+data+" in the field :"+ele, "fail");
		}
		finally {
			takeSnap();
		}
	}
	
	public void click(WebElement ele) {
		String text = "";
		try {			
			text = ele.getText();
			ele.click();
			reportStep("The element "+text+" is clicked", "pass");
		} catch (InvalidElementStateException e) {
			reportStep("The element: "+text+" could not be clicked", "fail");
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while clicking in the field :", "fail");
		} 
	}

	public String getText(WebElement ele) {	
		String bReturn = "";
		try {
			bReturn = ele.getText();
		} catch (WebDriverException e) {
			reportStep("The element: "+ele+" could not be found.", "fail");
		}
		return bReturn;
	}

	public void verifySelected(WebElement ele) {
		try {
			if(ele.isSelected()) {
				reportStep("The element "+ele+" is selected","pass");
			} else {
				reportStep("The element "+ele+" is not selected","fail");
			}
		} catch (WebDriverException e) {
			reportStep("WebDriverException : "+e.getMessage(), "fail");
		}
	}

	

	@Override
	public long takeSnap() {
		long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L; 
		try {
			FileUtils.copyFile(driver.getScreenshotAs(OutputType.FILE) , new File("./reports/images/"+number+".jpg"));
		} catch (WebDriverException e) {
			System.out.println("The browser has been closed.");
		} catch (IOException e) {
			System.out.println("The snapshot could not be taken");
		}
		return number;
	}
	

	public void closeBrowser() {
		try {
			driver.close();
			reportStep("The browser is closed","pass");
		} catch (Exception e) {
			reportStep("The browser could not be closed","fail");
		}
	}

	public void closeAllBrowsers() {
		try {
			driver.quit();
			reportStep("The opened browsers are closed","pass");
		} catch (Exception e) {
			reportStep("Unexpected error occured in Browser","fail");
		}
	}
}
