package week4.day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HandleAlertandFrame {
	
	/*
	 * 1. Load https://buythevalue.in/ 
	 * 2. Click on first product (eg: Hamdard Hing - 50GM) 
	 * //Handle Frame 
	 * 3. Close chat widget 
	 * 4. Enter the pincode 
	 * 5. Click on Check 
	 * 6. Click on ADD TO CART 
	 * 7. Click on View 
	 * 8. Click on CHECK OUT 
	 * //Handle alert 
	 * 9. Accept the alert
	 */

	
	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.navigate().to("https://buythevalue.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.switchTo().frame("dummy-chat-button-iframe");
		WebElement chatwidget = driver.findElement(By.xpath("//button[contains(@class,'chat-toggle')]"));
		chatwidget.click();
		
		driver.switchTo().frame("ShopifyChat");
		WebElement closewidget = driver.findElement(By.xpath("//button[contains(@class,'chat-app')]"));
		closewidget.click();
		
		driver.switchTo().defaultContent();		
		WebElement firstproduct = driver.findElement(By.xpath("(//a[@class='product-title'])[1]"));
		firstproduct.click();
		
		WebElement pincodebox = driver.findElement(By.id("wk_zipcode"));
		pincodebox.sendKeys("600040");
		
		WebElement pincodecheck = driver.findElement(By.className("wk_zipfinder_btn"));
		pincodecheck.click();
		
		WebElement addbtn = driver.findElement(By.id("product-add-to-cart"));
		addbtn.click();
		
		WebElement viewcart = driver.findElement(By.xpath("(//a[contains(text(),'View Cart')])[2]"));
		viewcart.click();
		
		WebElement checkoutbtn = driver.findElement(By.id("checkout"));
		checkoutbtn.click();
		
		Alert alert = driver.switchTo().alert();
		System.out.println("Alert text is : " +alert.getText());
		alert.accept();
		
		driver.close();
		
		
	}
}
