package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DuplicateLead {
	
	/*
	 * Assignment 3:Duplicate Lead 
	 * 1. Launch URL "http://leaftaps.com/opentaps/control/login" 
	 * 2. Enter UserName and Password Using Id Locator 
	 * 3. Click on Login Button using Class Locator 
	 * 4. Click on CRM/SFA Link 
	 * 5. Click on Leads Button 
	 * 6. Click on Create Lead 
	 * 7. Enter CompanyName Field Using id Locator 
	 * 8. Enter FirstName Field Using id Locator
	 * 9. Enter LastName Field Using id Locator 
	 * 10. Enter FirstName(Local) Field Using id Locator 
	 * 11. Enter Department Field Using any Locator of Your Choice
	 * 12. Enter Description Field Using any Locator of your choice 
	 * 13. Enter your email in the E-mail address Field using the locator of your choice 
	 * 14. Select State/Province as NewYork Using Visible Text 
	 * 15. Click on Create Button 
	 * 16. Get the Title of Resulting Page(refer the video) using driver.getTitle() 
	 * 17. Click on Duplicate button 
	 * 18. Clear the CompanyName Field using .clear() And Enter new CompanyName 
	 * 19.Clear the FirstName Field using .clear() And Enter new FirstName 
	 * 20.Click on Create Lead Button 
	 * 21. Get the Title of Resulting Page(refer the video) using driver.getTitle()
	 */

	public static void main(String[] args) {
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		
		WebElement userName = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement loginBtn = driver.findElement(By.className("decorativeSubmit"));
		
		userName.sendKeys("demoSalesManager");
		password.sendKeys("crmsfa");
		loginBtn.click();
		System.out.println("Logged in Sucessfully");
		
		WebElement crmLinkText = driver.findElement(By.partialLinkText("CRM"));
		crmLinkText.click();
		System.out.println("Navigated to CRM page");
		
		WebElement leadsLink = driver.findElement(By.linkText("Leads"));
		leadsLink.click();
		System.out.println("Navigated to Leads page");
		
		WebElement createLeadLink = driver.findElement(By.linkText("Create Lead"));
		createLeadLink.click();
		System.out.println("Navigated to Create Lead page");
		
		WebElement companyName = driver.findElement(By.id("createLeadForm_companyName"));
		WebElement firstName = driver.findElement(By.id("createLeadForm_firstName"));
		WebElement lastName = driver.findElement(By.id("createLeadForm_lastName"));
		WebElement source = driver.findElement(By.id("createLeadForm_dataSourceId"));
		Select sourceDD = new Select(source);
		WebElement firstNameLocal = driver.findElement(By.id("createLeadForm_firstNameLocal"));
		WebElement marketCampaign = driver.findElement(By.id("createLeadForm_marketingCampaignId"));
		Select marketDD = new Select(marketCampaign);
		WebElement ownership = driver.findElement(By.id("createLeadForm_ownershipEnumId"));
		Select ownerDD = new Select(ownership);
		WebElement department = driver.findElement(By.name("departmentName"));
		WebElement description = driver.findElement(By.name("description"));
		WebElement email = driver.findElement(By.id("createLeadForm_primaryEmail"));
		WebElement createLeadBtn = driver.findElement(By.name("submitButton"));		
		WebElement state = driver.findElement(By.name("generalStateProvinceGeoId"));
		Select stateDD = new Select(state);
		
		companyName.sendKeys("Selenium India Pvt Ltd.");
		firstName.sendKeys("Selenium");
		lastName.sendKeys("WebDriver");
		sourceDD.selectByIndex(4);
		firstNameLocal.sendKeys("Selenium 4");
		marketDD.selectByVisibleText("Automobile");
		ownerDD.selectByValue("OWN_SCORP");
		department.sendKeys("Quality Engineering");
		description.sendKeys("Selenium : Week 1 - Day 1 Assignment");
		email.sendKeys("seleniumjun23@testleaf.com");
		stateDD.selectByVisibleText("New York");
		createLeadBtn.click();	
		System.out.println("Provided required details and created new Lead");
		
		String title = driver.getTitle();
		System.out.println("Title of the page is : " +title);
		
		WebElement duplicateLeadBtn = driver.findElement(By.linkText("Duplicate Lead"));
		
		duplicateLeadBtn.click();
		System.out.println("Duplicate Lead button is clicked");
		
		WebElement companyName1 = driver.findElement(By.id("createLeadForm_companyName"));
		WebElement firstName1 = driver.findElement(By.id("createLeadForm_firstName"));
		WebElement createBtn = driver.findElement(By.className("smallSubmit"));
		
		companyName1.clear();
		companyName1.sendKeys("New Selenium India Pvt Ltd.");
		firstName1.clear();
		firstName1.sendKeys("New Selenium");
		createBtn.click();
		System.out.println("Duplicate Lead details are added");
		
		String title1 = driver.getTitle();
		System.out.println("Title of the page is : " +title1);
		
		driver.close();
		
		

	}

}
