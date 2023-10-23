import java.util.Iterator;

import java.util.Set;

import org.openqa.selenium.By;

import org.openqa.selenium.Keys;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;

public class PrintLinksCountLimitWebElement {
	public static void main(String[] args) throws InterruptedException {
	      System.setProperty("webdriver.chrome.driver","..\\chromedriver_win32\\chromedriver.exe");
	       WebDriver driver=new ChromeDriver();
	       driver.manage().window().maximize();
	       driver.get("https://AutomationPractice/");
	       System.out.println(driver.findElements(By.tagName("a")).size());
	       //Making a child driver from main or parent driver this is called limiting web driver scope
		WebElement FooterDriver=driver.findElement(By.id("gf-BIG"));
	        System.out.println(FooterDriver.findElements(By.tagName("a")).size());
		WebElement columnDriver= FooterDriver.findElement(By.xpath("//tbody/tr/td/ul"));
		System.out.println(columnDriver.findElements(By.tagName("a")).size());
		int Number=columnDriver.findElements(By.tagName("a")).size();
		Actions a= new Actions(driver);
		for(int i=1;i<Number;i++) {
			String ClickKeyboard= Keys.chord(Keys.CONTROL,Keys.ENTER);
		columnDriver.findElements(By.tagName("a")).get(i).sendKeys(ClickKeyboard);

		}
		Set<String> GetTabTitle = driver.getWindowHandles();
		
		Iterator<String> itr = GetTabTitle.iterator();
		
		driver.switchTo().window(itr.next());
		
		while(itr.hasNext()) {
			
			Thread.sleep(2000);
			
			driver.switchTo().window(itr.next());
			
			Thread.sleep(2000);
			
			System.out.println(driver.getTitle());
			
		}
		
	}

}
