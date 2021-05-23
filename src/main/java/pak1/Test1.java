package pak1;



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1 {

	
public static void main(String[] args) throws InterruptedException {
System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
WebDriver driver= new ChromeDriver();

//driver.get("https://www.makemytrip.com/flights");
//Thread.sleep(2000);
driver.get("https://www.makemytrip.com/flight/search?itinerary=MAA-DEL-08/06/2021_DEL-MAA-10/06/2021&tripType=R&paxType=A-1_C-0_I-0&intl=false&cabinClass=E&ccde=IN&lang=eng");
//driver.findElement(By.xpath("//span[text()='Flights']")).click();
//driver.findElement(By.xpath("//li[text()='Round Trip']")).click();
//
//driver.findElement(By.id("fromCity")).click();
//driver.findElement(By.xpath("//div[@class='hsw_autocomplePopup autoSuggestPlugin']//input")).sendKeys("chennai");
//driver.findElement(By.xpath("//div[@class='hsw_autocomplePopup autoSuggestPlugin']//p[text()='Chennai, India']")).click();
//
//driver.findElement(By.xpath("//div[@class='hsw_autocomplePopup autoSuggestPlugin']//input")).sendKeys("Delhi");
//Thread.sleep(1000);
//driver.findElement(By.xpath("//div[@class='hsw_autocomplePopup autoSuggestPlugin']//p[text()='Delhi, India']")).click();
//Thread.sleep(5000);
//driver.findElement(By.xpath("//div[text()='June']")).click();
//Thread.sleep(2000);
//driver.findElement(By.xpath("(//div[@class='DayPicker-Months']//p[text()='8'])[2]")).click();
//Thread.sleep(5000);
//
//Thread.sleep(2000);
//driver.findElement(By.xpath("(//div[@class='DayPicker-Months']//p[text()='10'])[2]")).click();
//Thread.sleep(5000);
//driver.findElement(By.xpath("//a[text()='Search']")).click();
//Thread.sleep(5000);
driver.findElement(By.xpath("//p[text()='Stops From Chennai']/parent::div//span[@class='check']")).click();
Thread.sleep(5000);

driver.findElement(By.xpath("//p[text()='Stops From New Delhi']/parent::div//span[@class='check']")).click();
Thread.sleep(5000);
List<WebElement> list1=driver.findElements(By.xpath("(//div[@class='listingCardWrap'])[1]//label"));
int no1=list1.size();
System.out.println("Total number of flights from chennai to mumbai is :" +no1);

//find min price value
List<WebElement> price1=driver.findElements(By.xpath("(//div[@class='listingCardWrap'])[1]//label//div[@class='makeFlex priceInfo ']//p"));

//put all the prices into array list and get the lowest prices
ArrayList<Integer> prices=new ArrayList<Integer>();
for(int i=0;i<price1.size();i++){
Integer priceInt = Integer.valueOf(price1.get(i).getText().replaceAll("[^a-zA-Z0-9]", ""));
prices.add(priceInt);
}
Integer minPrice = Collections.min(prices);
System.out.println("Min Price is "+minPrice);

//compare all the prices with lowest price and click the corresponding book button
List<WebElement> price2=driver.findElements(By.xpath("(//div[@class='listingCardWrap'])[1]//label//div[@class='makeFlex priceInfo ']//p"));
for(int i=0;i<price2.size();i++){
Integer priceInt1 = Integer.valueOf(price2.get(i).getText().replaceAll("[^a-zA-Z0-9]", ""));
//System.out.println(priceInt1);
if(priceInt1.equals(minPrice)){
price2.get(i).click();
System.out.println("Then flight with short duration and cheap price is selected");
break;
}
}


List<WebElement> list2=driver.findElements(By.xpath("(//div[@class='listingCardWrap'])[2]//label"));
int no2=list2.size();
System.out.println("Total number of flights from mumbai to chennai is :" +no2);

//find min price value
List<WebElement> price3=driver.findElements(By.xpath("(//div[@class='listingCardWrap'])[2]//label//div[@class='makeFlex priceInfo ']//p"));

//put all the prices into array list and get the lowest prices
ArrayList<Integer> prices1=new ArrayList<Integer>();
for(int i=0;i<price3.size();i++){
Integer priceInt = Integer.valueOf(price3.get(i).getText().replaceAll("[^a-zA-Z0-9]", ""));
prices1.add(priceInt);
}
Integer minPrice1 = Collections.min(prices1);
System.out.println("Min Price is "+minPrice1);

//compare all the prices with lowest price and click the corresponding book button
List<WebElement> price4=driver.findElements(By.xpath("(//div[@class='listingCardWrap'])[2]//label//div[@class='makeFlex priceInfo ']//p"));

for(int i=0;i<price4.size();i++){
Integer priceInt1 = Integer.valueOf(price4.get(i).getText().replaceAll("[^a-zA-Z0-9]", ""));
// System.out.println(priceInt1);
if(priceInt1.equals(minPrice1)){
price4.get(i).click();
System.out.println("Then flight with short duration and cheap price is selected");
break;
}
}

}



		
		
		
}


