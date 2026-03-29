package amoltrainee.testcomponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import amoltrainee.pageobject.Landingpage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Basetest {
	
	public WebDriver driver;
	public Landingpage landingpage;
	
	public WebDriver initalizeDriver() throws IOException
	{
		
		// properties class
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//amoltrainee//resources//GlobalData.properties");
		prop.load(fis);
		String browsername = System.getProperty("browser")!=null ? System.getProperty("browser") :prop.getProperty("browser");
		
		if(browsername.contains("chrome")){
			ChromeOptions options = new ChromeOptions();	
		  WebDriverManager.chromedriver().setup();
		if(browsername.contains("headless")){
		options.addArguments("headless");
		}
		 driver = new ChromeDriver(options);
		 //driver.manage().window().setSize(new Dimension(1440,900));
		}
		else if (browsername.equalsIgnoreCase("firefox"))
			
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\amol\\Downloads\\geckodriver-v0.36.0-win-aarch64");
			  driver = new FirefoxDriver();

			
		} else if (browsername.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver", "edge.exe");
			  driver = new EdgeDriver();
	}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
		
	
    }
	
	public List<HashMap<String,String>> getJsonDataToMap(String string) throws IOException
	{
		//read json to string
		String JsonContent = FileUtils.readFileToString(new File(System.getProperty("user.dir")+"\\src\\test\\java\\amoltrainee\\data\\purchaseorder.json"),StandardCharsets.UTF_8);
		
		//String hashmap jackson databind
		
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String,String>> data = mapper.readValue(JsonContent, new TypeReference<List<HashMap<String,String>>>() {
			
		});
		
		return data;
		}
	public String getscreenshots(String testcasename, WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + testcasename + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports//" + testcasename + ".png";
		}
	
	@BeforeMethod(alwaysRun=true)
	public Landingpage luanchapplication() throws IOException
	{
		driver = initalizeDriver();
		landingpage = new Landingpage(driver);
		 landingpage.goTo();
		 
		 return landingpage;
	}
	
	@AfterMethod(alwaysRun=true)
	public void teardown()
	{
		driver.close();
	}

	

}
