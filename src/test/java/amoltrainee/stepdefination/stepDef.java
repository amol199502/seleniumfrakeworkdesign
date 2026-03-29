package amoltrainee.stepdefination;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import amoltrainee.Abstractcomponents.cartpage;
import amoltrainee.Abstractcomponents.checkoutpage;
import amoltrainee.Abstractcomponents.confrimpage;
import amoltrainee.pageobject.Landingpage;
import amoltrainee.pageobject.prodcutcatalog;
import amoltrainee.testcomponents.Basetest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepDef extends Basetest {
	public Landingpage landingpage;
	public prodcutcatalog prodcutcatalogs;
	public confrimpage confrimpage;
	public cartpage cartpage;
	@Given("i landed on Ecommerce page")
	
	public void i_landed_on_Ecommerce_page() throws IOException
	{
		landingpage=luanchapplication();
	}
	
	@Given("^logged in with username (.+) and password (.+)$")
	
	public void logged_in_username_and_password(String username,String password)
	
	{
		  prodcutcatalogs= landingpage.loginApplication(username,password);

	}
	
	@When("i add product {string} to cart")   // ✅ CORRECT	
	public void i_add_product_to_cart(String productname) throws InterruptedException
	{
		List <WebElement> product = prodcutcatalogs.getproductlist();
		 prodcutcatalogs.productToCart(productname);
	}
	
	@When("Checkout {string} and submit the order")
	public void Checkout_and_submit_the_order(String productname)
	{
	     cartpage = prodcutcatalogs.goToCardpage();
	     Boolean match = cartpage.verfiyprodcutdisplay(productname);
	     Assert.assertTrue(match);
	     
	     checkoutpage checkoutpage = cartpage.goTocheckout();
	     checkoutpage.selectcountry("india");                         
	     confrimpage = checkoutpage.submitorder();
	}
  
	@Then("{string} message is displayed on confrimationpage")
	
	public void message_is_displayed_on_confrimationpage(String string)
	{
		 String confrimpage1 = confrimpage.getConfirmationMessage();
         Assert.assertTrue(confrimpage1.equalsIgnoreCase(string));
		  
	}
}
