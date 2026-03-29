package amoltrainee.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import amoltrainee.Abstractcomponents.abstractcompoenet;

public class prodcutcatalog extends abstractcompoenet {

    WebDriver driver;

    public prodcutcatalog(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // PageFactory elements
    @FindBy(css = ".mb-3")
    List<WebElement> products;

    @FindBy(css = ".ng-animating")
    WebElement animation;

    // By locators
    By productsby = By.cssSelector(".mb-3");
    By addToCartButton = By.cssSelector(".card-body button:last-of-type");
    By tostmessage = By.cssSelector("#toast-container");

    public List<WebElement> getproductlist() {
        publicwebelement(productsby);
        return products;
    }

    public void publicwebelement(By productsby2) {
		// TODO Auto-generated method stub
		
	}

	public WebElement getProductByName(String productname) {

   WebElement prod = getproductlist().stream().filter(product ->product.findElement(By.cssSelector("b")).getText().equals(productname)).findFirst().orElse(null);

        return prod;
   }

    public void productToCart(String productname) throws InterruptedException {

        WebElement prod = getProductByName(productname);

        if (prod == null) {
            throw new RuntimeException("Product not found: " + productname);
        }

        prod.findElement(addToCartButton).click();
        publicwebelement(tostmessage);
        Disappear(animation);
    }
}
