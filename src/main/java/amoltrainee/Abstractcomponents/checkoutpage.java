package amoltrainee.Abstractcomponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class checkoutpage extends abstractcompoenet {
	
WebDriver driver;
	
	public checkoutpage(WebDriver driver)
	
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".action__submit")
	WebElement submit1;
	
	@FindBy(css="[placeholder='Select Country']")
	WebElement country;
	
	@FindBy(xpath="(//button[@type='button'])[2]")
	WebElement button;
	
	By result = By.cssSelector(".ta-results");
	

	public void selectcountry(String countryname)
	{
		Actions a = new Actions(driver);
		a.sendKeys(country, countryname).build().perform();
		publicwebelement(result);
		button.click();
				
				
	}
	
	public void publicwebelement(By result2) {
		// TODO Auto-generated method stub
		
	}

	public confrimpage submitorder()
	{
		submit1.click();
		return new confrimpage(driver);
	}
	
}
