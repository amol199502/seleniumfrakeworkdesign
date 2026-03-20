package amoltrainee.test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import amoltrainee.Abstractcomponents.cartpage;
import amoltrainee.Abstractcomponents.checkoutpage;
import amoltrainee.Abstractcomponents.confrimpage;
import amoltrainee.pageobject.Landingpage;
import amoltrainee.pageobject.prodcutcatalog;
import amoltrainee.testcomponents.Basetest;
import amoltrainee.testcomponents.retry;
import io.github.bonigarcia.wdm.WebDriverManager;

public class errorvalidation extends Basetest {
@Test(groups= {"errorhandling"}, retryAnalyzer=retry.class)

public void loginerrorvalidation() throws IOException, InterruptedException
{
		String productname = "ZARA COAT 3";
		//Landingpage landingpage = luanchapplication();
	
		 landingpage.loginApplication("chaudhariamol17@gmail.com", "Chaudhari@199502");
		AssertJUnit.assertEquals("Incorrect email or password.",landingpage.errorvalidation());        
          
	}
@Test
public void producterrorvalidation() throws IOException, InterruptedException
{
		String productname = "ZARA COAT 3";
		//Landingpage landingpage = luanchapplication();
	
		 prodcutcatalog prodcutcatalogs= landingpage.loginApplication("neha.chaudhari@gmail.com", "Neha@111");
		 List <WebElement> product = prodcutcatalogs.getproductlist();
		 prodcutcatalogs.productToCart(productname);
		 cartpage cartpage = prodcutcatalogs.goToCardpage();
		 Boolean match = cartpage.verfiyprodcutdisplay("ZARA COAT 33");
		 Assert.assertFalse(match);
		 
		  

          
          
	}



}

