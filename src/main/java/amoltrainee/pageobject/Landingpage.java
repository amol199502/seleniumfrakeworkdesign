package amoltrainee.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import amoltrainee.Abstractcomponents.abstractcompoenet;

public class Landingpage extends abstractcompoenet {
	
	WebDriver driver;
	
	public Landingpage(WebDriver driver)
	
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		
	}
	
	//WebElement useremails = driver.findElement(By.id("userEmail"));
	
	//pagefactory
	@FindBy(id="userEmail")
	WebElement userEmails;
	
	@FindBy(id="userPassword")
	WebElement passwords;
	
	@FindBy(id="login")
	WebElement submit;
	
	@FindBy(css = "div[aria-label='Incorrect email or password.']")
	WebElement errorToast;
	
	
	
public prodcutcatalog loginApplication(String email,String password)
{
	userEmails.sendKeys(email);
	passwords.sendKeys(password);
	submit.click();
	
	prodcutcatalog prodcutcatalogs =new prodcutcatalog(driver);
	return prodcutcatalogs;
	
	
}
	public String errorvalidation()
	{
		waitForWebElementToAppear(errorToast);
		return errorToast.getText();
		
	}
private void waitForWebElementToAppear(String errorvalidation2) {
		// TODO Auto-generated method stub
		
	}
public void goTo()
{
	 driver.get("https://rahulshettyacademy.com/client");

}
}
