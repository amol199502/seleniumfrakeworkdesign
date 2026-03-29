package amoltrainee.Abstractcomponents;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import amoltrainee.Abstractcomponents.abstractcompoenet;

public class orderpage extends abstractcompoenet{
	
	WebDriver driver;
	
	@FindBy(css= ".totalRow button")
	WebElement checkoutele;
	
	@FindBy(css= "tr td:nth-child(3)")
	private List <WebElement> productName;
	
	public orderpage(WebDriver driver)
	
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		
	}
	
	public  boolean verfiyorderdisplay(String prodcutname)
	{
		boolean match = productName.stream().anyMatch(cp->cp.getText().equalsIgnoreCase(prodcutname));
		return match;
		
	}
     public checkoutpage goTocheckout()
     {
    	 checkoutele.click();
    	 
    	 return new checkoutpage(driver);
    	 
     }
	
	
		
		
			
	
	
	
	
}
