package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import driverScript.Driver;
import driverScript.GenericActions;


public class SearchPage extends Driver {

	public SearchPage() {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//span[text()='Flights']")
	WebElement flights;
	public SearchPage clickFlights() {
		driver.findElement(By.xpath("//div[@class='headerOuter']")).click();
		click(flights);
		return this;
	}
	
	@FindBy(xpath="//li[text()='Round Trip']")
	WebElement roundtrip;
	public SearchPage clickRoundTrip() {
		click(roundtrip);
		return this;
	}
	
	@FindBy(id="fromCity")
	WebElement from;
	public SearchPage from() {
		click(from);
		return this;
	}
	
	@FindBy(xpath="//div[@class='hsw_autocomplePopup autoSuggestPlugin']//input")
	WebElement input1;
	public SearchPage input(String from) {
		type(input1, from);
		return this;
	}
	
	@FindBy(xpath="//div[@class='hsw_autocomplePopup autoSuggestPlugin']//p[text()='Chennai, India']")
	WebElement source;
	public SearchPage source() throws InterruptedException {
		click(source);
		Thread.sleep(2000);
		return this;
	}
	
	@FindBy(xpath="//div[@class='hsw_autocomplePopup autoSuggestPlugin']//input")
	WebElement input2;
	public SearchPage input2(String to) {
		type(input2, to);
		return this;
	}
	
	@FindBy(xpath="//div[@class='hsw_autocomplePopup autoSuggestPlugin']//p[text()='Delhi, India']")
	WebElement dest;
	public SearchPage dest() throws InterruptedException {
		click(dest);
		Thread.sleep(2000);
		return this;
	}
	
	@FindBy(xpath="//div[text()='June']")
	WebElement month;
	public SearchPage month() throws InterruptedException {
		click(month);
		Thread.sleep(2000);
		return this;
	}
	
	@FindBy(xpath="(//div[@class='DayPicker-Months']//p[text()='8'])[2]")
	WebElement ondate;
	public SearchPage onDate() throws InterruptedException {
		click(ondate);
		Thread.sleep(2000);
		return this;
	}
	
	@FindBy(xpath="(//div[@class='DayPicker-Months']//p[text()='10'])[2]")
	WebElement backdate;
	public SearchPage backDate() throws InterruptedException {
		click(backdate);
		Thread.sleep(2000);
		return this;
	}
	
	@FindBy(xpath="//a[text()='Search']")
	WebElement search;
	public ResultPage clickSearch() throws InterruptedException {
		click(search);
		Thread.sleep(5000);
		return new ResultPage();
		
	}
}
