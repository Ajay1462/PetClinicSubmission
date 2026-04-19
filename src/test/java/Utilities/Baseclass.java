package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class Baseclass {
    public WebDriver driver;
    public Properties prop;

    public Properties loadProperties() throws IOException {
        prop = new Properties();
        FileInputStream fis = new FileInputStream(
                System.getProperty("user.dir") + "/src/test/resources/Global.properties");
        prop.load(fis);
        return prop;
    }

    public WebDriver initializeDriver() throws IOException {
        if (prop == null) {
            loadProperties();
        }
        String url = prop.getProperty("URL");
        String browser = prop.getProperty("Browser");
        if (driver == null) {
            if (browser != null && browser.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
            } else if (browser != null && browser.equalsIgnoreCase("edge")) {
                throw new RuntimeException("Not Yet implemented");
            }
            if (url != null && !url.isEmpty()) {
                driver.get(url);
            } else {
                throw new RuntimeException("URL not Found");
            }
        }
        return driver;
    }
}
