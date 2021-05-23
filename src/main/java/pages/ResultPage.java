package pages;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.FindsByXPath;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import driverScript.Driver;
import driverScript.GenericActions;

public class ResultPage extends Driver {
	
	public Integer minPrice,minPrice1;
	
	public ResultPage(){
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//p[text()='Stops From Chennai']/parent::div//span[@class='check']")
	WebElement nonche;
	public ResultPage nonStopChennai() throws InterruptedException {
		click(nonche);
		Thread.sleep(5000);
		return this;
	}
	
	@FindBy(xpath="//p[text()='Stops From New Delhi']/parent::div//span[@class='check']")
	WebElement nondel;
	public ResultPage nonStopDelhi() throws InterruptedException {
		click(nondel);
		Thread.sleep(5000);
		return this;
	}
	
	 
	@FindAll(@FindBy(xpath="(//div[@class='listingCardWrap'])[1]//label"))
	List<WebElement> li;
	public ResultPage totalFlightsFromChe() {
		List<WebElement> list1=li;
		int no1=list1.size();
		System.out.println("Total number of flights from chennai to delhi is :" +no1);
		return this;
	}
	
	@FindAll(@FindBy(xpath="(//div[@class='listingCardWrap'])[1]//label//div[@class='makeFlex priceInfo ']//p"))
	List<WebElement> li1;	
	public ResultPage onMinPrice() {
		List<WebElement> price1=li1;
		//put all the prices into array list and get the lowest prices
		ArrayList<Integer> prices=new ArrayList<Integer>();
		for(int i=0;i<price1.size();i++){
		Integer priceInt = Integer.valueOf(price1.get(i).getText().replaceAll("[^a-zA-Z0-9]", ""));
		prices.add(priceInt);
		} 
		minPrice = Collections.min(prices);
		System.out.println("The Min Price of flight from chennai to delhi is : "+minPrice);
		return this;
	}
	
	@FindAll(@FindBy(xpath="(//div[@class='listingCardWrap'])[1]//label//div[@class='makeFlex priceInfo ']//p"))
	List<WebElement> li2;
	public ResultPage selectFlightFromChennai() {
		//compare all the prices with lowest price and click the corresponding book button
		List<WebElement> price2=li2;
		for(int i=0;i<price2.size();i++){
		Integer priceInt1 = Integer.valueOf(price2.get(i).getText().replaceAll("[^a-zA-Z0-9]", ""));
		//System.out.println(priceInt1);
		if(priceInt1.equals(minPrice)){
			click(price2.get(i));
			System.out.println("The flight with short duration and cheap price is selected");
			break;
			}
		}
		return this;
	}
	
	
	@FindAll(@FindBy(xpath="(//div[@class='listingCardWrap'])[2]//label"))
	List<WebElement> li3;
	public ResultPage totalFlightsFromDelhi() {
		List<WebElement> list2=li3;
		int no2=list2.size();
		System.out.println("Total number of flights from delhi to chennai is :" +no2);
		return this;
	}
	
	
	@FindAll(@FindBy(xpath="(//div[@class='listingCardWrap'])[2]//label//div[@class='makeFlex priceInfo ']//p"))
	List<WebElement> li4;
	public ResultPage returnMinPrice()  {
		//compare all the prices with lowest price and click the corresponding book button
		List<WebElement> price3=li4;
		//put all the prices into array list and get the lowest prices
		ArrayList<Integer> prices1=new ArrayList<Integer>();
		for(int i=0;i<price3.size();i++){
		Integer priceInt = Integer.valueOf(price3.get(i).getText().replaceAll("[^a-zA-Z0-9]", ""));
		prices1.add(priceInt);
		}
		minPrice1 = Collections.min(prices1);
		System.out.println("The Min Price of flight from delhi to chennai is : "+minPrice1);
		return this;
	}
	
	
	@FindAll(@FindBy(xpath="(//div[@class='listingCardWrap'])[2]//label//div[@class='makeFlex priceInfo ']//p"))
	List<WebElement> li5;
	public ResultPage selectFlightFromDelhi() {
		List<WebElement> price4=li5;

		for(int i=0;i<price4.size();i++){
		Integer priceInt1 = Integer.valueOf(price4.get(i).getText().replaceAll("[^a-zA-Z0-9]", ""));
		// System.out.println(priceInt1);
		if(priceInt1.equals(minPrice1)){
		click(price4.get(i));
		System.out.println("The flight with short duration and cheap price is selected");
		break;
		
		}
		}
		return this;
	}
	
}
