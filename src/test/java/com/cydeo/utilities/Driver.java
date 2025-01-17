package com.cydeo.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class Driver {

    public static WebDriver environmentMethod(String environment){
//        Change environment within maven command for test execution

        String env = System.getProperty("environment");

        if (env != null) {
            switch (env) {
                case "qa":
                    Driver.getDriver().get(ConfigurationReader.getProperty("qaEnvironment"));
                    break;
                case "dev":
                    Driver.getDriver().get(ConfigurationReader.getProperty("devEnvironment"));
                    break;
                case "stage":
                    Driver.getDriver().get(ConfigurationReader.getProperty("stageEnvironment"));
                    break;
            }
        } else {
            String url = environment;
//            String url = ConfigurationReader.getProperty("environment");
            Driver.getDriver().get(url);
        }
        return null;
    }

    /*
    Creating a private constructor, so we are closing
    access to the object of this class from outside the class
     */
    private Driver(){}

    /*
    We make WebDriver private, because we want to close access from outside the class.
    We make it static because we will use it in a static method.
     */
    //private static WebDriver driver; // value is null by default

    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();

    /*
    Create a re-usable utility method which will return same driver instance when we call it
     */
    public static WebDriver getDriver(){

        if (driverPool.get() == null){

            /*
            We read our browserType from configuration.properties.
            This way, we can control which browser is opened from outside our code, from configuration.properties.
             */
            String browserType;
/**            browserType = ConfigurationReader.getProperty("browser");         */

                if (System.getProperty("BROWSER") == null) {
                    browserType = ConfigurationReader.getProperty("browser");
                } else {
                    browserType = System.getProperty("BROWSER");
                }
                System.out.println("Browser Type : " + browserType);

            /*
                Depending on the browserType that will be return from configuration.properties file
                switch statement will determine the case, and open the matching browser
            */

            switch (browserType.toLowerCase()){
                case "chrome":
//                    WebDriverManager.chromedriver().setup();    // After Selenium 4 we don't need this line anymore
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--lang=en-GB");
                    chromeOptions.addArguments("--disable-notifications");
                    chromeOptions.addArguments("--disable-extensions");
                    chromeOptions.addArguments("--ignore-certificate-errors");

//                    chromeOptions.addArguments("--lang= locale-of-choice");
//                    chromeOptions.addArguments("headless");
//                    chromeOptions.addArguments("no-sandbox");
//                    chromeOptions.addArguments("window-size=1200x600");
//                    chromeOptions.addArguments(
//                            "--verbose",
//                            "--headless",
//                            "--disable-web-security",
//                            "--ignore-certificate-errors",
//                            "--allow-running-insecure-content",
//                            "--allow-insecure-localhost",
//                            "--no-sandbox",
//                            "--disable-gpu"
//                    );
                    driverPool.set(new ChromeDriver(chromeOptions));
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;


                case "chrome-locale":
//                    WebDriverManager.chromedriver().setup();            // After Selenium 4 we don't need this line anymore
                    chromeOptions = new ChromeOptions();
                    Map<String, Object> prefs = new HashMap<>();
                    chromeOptions.addArguments("--disable-notifications");
                    prefs.put("intl.accept_languages", "en-GB");
                    chromeOptions.setExperimentalOption("prefs", prefs);
                    driverPool.set(new ChromeDriver(chromeOptions));
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;

                case "chrome-incognito":
//                    WebDriverManager.chromedriver().setup();            // After Selenium 4 we don't need this line anymore
//                    chromeOptions = new ChromeOptions();
                    chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--incognito");  // ChromeOptions for starting chrome in incognito mode
                    chromeOptions.addArguments("--disable-notifications");
                    chromeOptions.addArguments("--lang=en-GB");
//                    DesiredCapabilities capabilitiesChrome = new DesiredCapabilities();
//                    capabilitiesChrome.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
                    chromeOptions.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
                    chromeOptions.merge(chromeOptions);
//                    chromeOptions.merge(capabilitiesChrome);
                    driverPool.set(new ChromeDriver(chromeOptions));
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;

//                DesiredCapabilities - a class that is used for Webdriver configuration.
//                Based on the property "browserName" Selenium Grid knows which browser you want to use for testing.
//                We can also specify the platform, version, browser version, and other parameters for testing.

                case "remote-chrome":
                    try {
                        // assign your grid server address : 54.235.53.73. ==> 54.89.242.106  ==> 184.72.110.69 "3.82.116.209"
                        String gridAddress = "3.86.220.209"; // put your own Linux grid IP here
                        URL url = new URL("http://"+gridAddress+":4444/wd/hub");
                        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                        desiredCapabilities.setBrowserName("chrome");
                        driverPool.set(new RemoteWebDriver(url,desiredCapabilities));
                        driverPool.get().manage().window().maximize();
                        driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//                        driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    break;

//                case "chrome-headless":
////                    WebDriverManager.chromedriver().setup();            // After Selenium 4 we don't need this line anymore
//                    driverPool.set(new ChromeDriver(new ChromeOptions().setHeadless(true)));
//                    break;


                case "chrome-headless":
                    chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--headless=new");
//                    chromeOptions.setHeadless(true);
                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver(chromeOptions));
                    break;


                case "saucelab-chrome":
                    try{
                        URL url = new URL("https://oauth-sdetoscar-844c8:66e7117f-390e-4556-8105-07af96a01f7a@ondemand.eu-central-1.saucelabs.com:443/wd/hub");
                        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                        desiredCapabilities.setBrowserName("chrome");
                        driverPool.set(new RemoteWebDriver(url,desiredCapabilities));
                        driverPool.get().manage().window().maximize();
                        driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//                        driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    }catch (MalformedURLException e){
                        e.printStackTrace();
                    }
                    break;

                case "firefox":

//                    WebDriverManager.firefoxdriver().setup();            // After Selenium 4 we don't need this line anymore
                    driverPool.set(new FirefoxDriver());

                    FirefoxOptions optionsFirefox = new FirefoxOptions();
                    FirefoxProfile firefoxProfile = new FirefoxProfile();
                    optionsFirefox.setProfile(firefoxProfile);
                    firefoxProfile.setPreference("intl.accept_languages", "en-GB");

                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;

                case "firefox-private":
//                    WebDriverManager.firefoxdriver().setup();            // After Selenium 4 we don't need this line anymore
                    optionsFirefox = new FirefoxOptions();
                    optionsFirefox.addArguments("-private");  // FirefoxOptions for starting firefox in incognito mode
                    DesiredCapabilities capabilitiesFirefox = new DesiredCapabilities();
                    capabilitiesFirefox.setCapability(FirefoxOptions.FIREFOX_OPTIONS, optionsFirefox);
                    optionsFirefox.merge(capabilitiesFirefox);
                    driverPool.set(new FirefoxDriver(optionsFirefox));
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;

                case "remote-firefox":
                    try {
                        // assign your grid server address : 54.89.242.106
                        String gridAddress = "33.86.220.209"; // put your own Linux grid IP here
                        URL url = new URL("http://"+gridAddress+":4444/wd/hub");
                        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                        desiredCapabilities.setBrowserName("firefox");
                        driverPool.set(new RemoteWebDriver(url,desiredCapabilities));
                        driverPool.get().manage().window().maximize();
                        driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//                        driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    break;

//                case "firefox-headless":
////                    WebDriverManager.firefoxdriver().setup();            // After Selenium 4 we don't need this line anymore
//                    driverPool.set(new FirefoxDriver(new FirefoxOptions().setHeadless(true)));
//                    break;

                case "safari":
                    if (System.getProperty("os.name").toLowerCase().contains("windows")) {
                        throw new WebDriverException("Your operating system does not support the SAFARI browser");
                    }
//                    WebDriverManager.safaridriver().setup();            // After Selenium 4 we don't need this line anymore
                    driverPool.set(new SafariDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;

                case "ie":
                    if (System.getProperty("os.name").toLowerCase().contains("mac")) {
                        throw new WebDriverException("Your operating system does not support the IE browser");
                    }
//                    WebDriverManager.iedriver().setup();            // After Selenium 4 we don't need this line anymore
                    driverPool.set(new InternetExplorerDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;

                case "edge":
                    if (System.getProperty("os.name").toLowerCase().contains("mac")) {
                        throw new WebDriverException("Your operating system does not support the EDGE browser");
                    }
//                    WebDriverManager.edgedriver().setup();            // After Selenium 4 we don't need this line anymore
                    driverPool.set(new EdgeDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;

                case "saucelab-edge":
                    EdgeOptions browserOptions = new EdgeOptions();
                    browserOptions.setCapability("platformName", "Windows 11");
                    browserOptions.setCapability("browserVersion", "latest");
                    Map<String, Object> sauceOptions = new HashMap<>();
                    sauceOptions.put("build", "<your build id>");
                    sauceOptions.put("name", "<your test name>");
                    browserOptions.setCapability("sauce:options", sauceOptions);

                    URL url = null;
                    try {
                        url = new URL("https://oauth-sdetoscar-844c8:66e7117f-390e-4556-8105-07af96a01f7a@ondemand.eu-central-1.saucelabs.com:443/wd/hub");
                        driverPool.set(new RemoteWebDriver(url,browserOptions));
                        driverPool.get().manage().window().maximize();
                        driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//                        driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    break;

                case "opera":
//                    WebDriverManager.operadriver().setup();            // After Selenium 4 we don't need this line anymore
//                    driverPool.set(new OperaDriver());
//                    driverPool.get().manage().window().maximize();
//                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//                    break;

//                case "opera":
//                    WebDriverManager.operadriver().setup();
//                    OperaOptions operaOptions = new OperaOptions();
//                    // You can add specific OperaOptions here if needed
//                    driverPool.set(new OperaDriver(operaOptions));
//                    driverPool.get().manage().window().maximize();
//                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//                    break;


            }

        }


        return driverPool.get();

    }

    /*
    This method will make sure our driver value is always null after using quit() method
     */
    public static void closeDriver(){
        if (driverPool.get() != null){
            driverPool.get().quit(); // this line will terminate the existing session. value will not even be null
            driverPool.remove();
        }
    }

}
