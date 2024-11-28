package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.github.javafaker.Faker;

public class BaseClass {

	public WebDriver driver;
	public Properties prop;
	public Faker faker;

	@BeforeClass(alwaysRun = true)
	public void setUp() throws IOException {

		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/config.properties");
		prop= new Properties();
		prop.load(fis);

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(prop.getProperty("url"));
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}

	public String captureScreen(String tname) {
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.ss").format(new Date()); //TimeStamp	

		TakesScreenshot ts = (TakesScreenshot)driver;
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);

		String targetFilePath = System.getProperty("user.dir")+"\\screenshots\\"+ tname +"_"+ timestamp+".png";

		File targetFile = new File(targetFilePath);

		sourceFile.renameTo(targetFile);
		return targetFilePath;
	}
	
	public Faker fakerData() {
		return faker = new Faker();
	}
	
}
