package amoltrainee.test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import amoltrainee.Abstractcomponents.cartpage;
import amoltrainee.Abstractcomponents.checkoutpage;
import amoltrainee.Abstractcomponents.confrimpage;
import amoltrainee.Abstractcomponents.orderpage;
import amoltrainee.pageobject.Landingpage;
import amoltrainee.pageobject.prodcutcatalog;
import amoltrainee.testcomponents.Basetest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class submitordertest extends Basetest {
	
	String productname = "ZARA COAT 3";

@Test(dataProvider="getData",groups={"purchase"})

public void submitordertest(HashMap<String,String> input) throws IOException, InterruptedException
{
		//Landingpage landingpage = luanchapplication();
	
		 prodcutcatalog prodcutcatalogs= landingpage.loginApplication(input.get("email"), input.get("password"));
		 List <WebElement> product = prodcutcatalogs.getproductlist();
		 prodcutcatalogs.productToCart(input.get("product"));
		 cartpage cartpage = prodcutcatalogs.goToCardpage();
		 Boolean match = cartpage.verfiyprodcutdisplay(input.get("product"));
		 Assert.assertTrue(match);
		 checkoutpage checkoutpage = cartpage.goTocheckout();
		 checkoutpage.selectcountry("india");                         
		  confrimpage confrimpage = checkoutpage.submitorder();
		  String confrimpage1 = confrimpage.getConfirmationMessage();
          //Assert.assertTrue(confrimpage1.equalsIgnoreCase(" Thankyou for the order."));
		  Assert.assertEquals( confrimpage1.trim(), "THANKYOU FOR THE ORDER.");
	          
	}

@Test(dependsOnMethods= {"submitordertest"})
public void orderhistorytest()
{
	 prodcutcatalog prodcutcatalogs= landingpage.loginApplication("chaudhariamol173@gmail.com", "Chaudhari@199502");
	 
	 orderpage orderpages = prodcutcatalogs.goToOrderpage();
	 Assert.assertTrue(orderpages.verfiyorderdisplay(productname));
	 
}


@DataProvider
public Object[][] getData() throws IOException {

    List<HashMap<String, String>> data =
            getJsonDataToMap(System.getProperty("user.dir")
                    + "\\src\\test\\java\\amoltrainee\\data\\purchaseorder.json");

    return new Object[][] {
            { data.get(0) },
            { data.get(1) }
    };
}
//HashMap<String,String> map= new HashMap<String,String>();
	//map.put("email", "chaudhariamol173@gmail.com");
	//map.put("password", "Chaudhari@199502");
	//map.put("product", "ZARA COAT 3");
		
	//HashMap<String,String> map1= new HashMap<String,String>();
	//map1.put("email", "chaudhariamol173@gmail.com");
	//map1.put("password", "Chaudhari@199502");
	//map1.put("product", "ZARA COAT 3");

}

