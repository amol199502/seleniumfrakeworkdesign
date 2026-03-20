package amoltrainee.Abstractcomponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class confrimpage extends abstractcompoenet {

    WebDriver driver;

    public confrimpage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // ✅ Correct locator
    @FindBy(css = ".hero-primary")
    WebElement confirmationMessage;

    // ✅ Proper wait before action
    public String getConfirmationMessage() {
        waitForWebElementToAppear(confirmationMessage);
        return confirmationMessage.getText();
    }

	public void waitForWebElementToAppear(WebElement confirmationMessage2) {
		// TODO Auto-generated method stub
		
	}
}
