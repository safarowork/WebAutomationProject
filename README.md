# Selenium Web Automation Project(with Java)

### Author: Sana Anwar Farooqui
   
![WebAutomationFlow](https://github.com/user-attachments/assets/6438745c-9018-4c54-988e-3d4c574ac91a)

### Framework important components
- Framework Type: Selenium-TestNG Hybrid framework
 - Tools and techniques used: Java, Maven, Selenium, TestNG, Page Object Model
 - To manage Data - Excel/Properties files - Apache POI
 - Log42j for logging with logging level info, debug and Warn
 - Reports: TestNG reports and Extent reports 
 - Screenshot upon test failure using ITestListener interface
 - Retry executing failed test cases for three times using 'IRetryAnalyzer' and 'IAnnotationTransformer' interface
 - Base class with Before and After Methods for setUp and tearDown.
 - setUp method to run the test cases localy and remote via Selenium Grid and Docker(docker-compose.yml)
 - Continous Integration to Jenkins and execute tests via Jenkins
 -  Functionalities Automated: Account Registration, Signin, Account Deletion, Search and Cart


![ConsoleOutput](https://github.com/user-attachments/assets/9823d53b-8e78-4e02-b590-b72fe4712d49)

![ExtentReport](https://github.com/user-attachments/assets/02eaa02c-66e8-49a5-b077-96b9843b834b)

### Base Class setup to launch Driver to execute tests locally and remote
  
```bash
public class BaseClass {
  WebDriver driver;

  @Parameters({"browser", "os"}) //parameters supplied from testng.xml file
  @BeforeClass(alwaysRun = true)
  public void setUp(String browser, String os){

  if(prop.getProperty("execution_env").equals("local")) {
			switch(browser.toLowerCase()) {
			case "chrome" : driver = new ChromeDriver(); break;
			case "edge" :driver = new EdgeDriver(); break;
			case "firefox" : driver = new FirefoxDriver(); break;
			default: System.out.println("Invalid browser"); return;
			}
		}
  else if(prop.getProperty("execution_env").equals("remote")) {
    MutableCapabilities options;

      switch (browser.toLowerCase()) {
      case "chrome": options = new ChromeOptions(); break;
      case "edge": options = new EdgeOptions(); break;
      case "firefox": options = new FirefoxOptions(); break;
      case "safari": options = new SafariOptions(); break;
      default:System.out.println("Invalid browser");return;
      }

      switch (os.toLowerCase()) {
      case "windows": options.setCapability("platformName", "windows"); break;
      case "mac": options.setCapability("platformName", "mac"); break;
      case "linux": options.setCapability("platformName", "linux"); break;
      default: System.out.println("Invalid OS"); return;
      }
          
      URL url = new URI("http://localhost:4444/wd/hub").toURL();
      driver = new RemoteWebDriver(url, options);	
   }
 }
}

```

### Remote Execution using Selenium Grid(Standalone configuration)
- Start Selenium server in standalone mode to run tests remotely

```bash
  java -jar selenium-server-4.27.0.jar standalone
```

- Confirm test execution

![image](https://github.com/user-attachments/assets/98b6699b-9869-4bb3-b536-cc42eacfd2c6)

