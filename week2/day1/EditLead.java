package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class EditLead {

	/*
	 * Assignment 2:Edit Lead 
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
	 * 16. Click on edit button 
	 * 17. Clear the Description Field using .clear() 
	 * 18. Fill ImportantNote Field with Any text 
	 * 19. Click on update button 
	 * 20. Get the Title of Resulting Page. 
	 * refer the video using driver.getTitle()
	 */
 
	
	public static void main(String[] args) {
		
		EdgeDriver driver = new EdgeDriver();
		
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
		
		WebElement editBtn = driver.findElement(By.linkText("Edit"));
		
		editBtn.click();
		System.out.println("Edit button is clicked");
		
		WebElement updateDescription = driver.findElement(By.id("updateLeadForm_description"));
		WebElement importantNote = driver.findElement(By.name("importantNote"));
		WebElement updateBtn = driver.findElement(By.className("smallSubmit"));
		
		updateDescription.clear();
		importantNote.sendKeys("Lead details are updated");
		updateBtn.click();
		System.out.println("Lead details are updated");
		
		String title = driver.getTitle();
		System.out.println("Title of the page is : " +title);
		
		driver.close();
		
	}
}
