package amoltrainee.Abstractcomponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class abstractcompoenet {
	WebDriver driver;
	public abstractcompoenet(WebDriver driver) {
		
		this.driver= driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath="//button[@routerlink='/dashboard/cart']")
	WebElement Cart;
	
	@FindBy(xpath="//button[@routerlink='/dashboard/myorders']")
	WebElement headerorder;
	
	
	public void waitForWebElementToAppear(WebElement FindBy) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	    wait.until(ExpectedConditions.visibilityOf(FindBy));
	}


public void publicwebelement(By FindBy)
	{
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	wait.until(ExpectedConditions.visibilityOfElementLocated(FindBy));
	}
	
	public cartpage goToCardpage()
	{
		Cart.click();
		 cartpage cartpage = new cartpage(driver);
          return cartpage;
	}
	
	public orderpage goToOrderpage()
	{
		headerorder.click();
		 orderpage orderpages = new orderpage(driver);
          return orderpages;
	}
	
	public void Disappear(WebElement ele) throws InterruptedException
	{
	
	Thread.sleep(1000);
	}


}
