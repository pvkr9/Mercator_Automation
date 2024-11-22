package com.home.tests.test.driver.manager;

import com.home.tests.test.configutils.ConfigUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.time.Duration;

public class WebDriverManagerSetup {

    public static WebDriver getDriverDynamic() throws MalformedURLException {
        String defaultBrowser = ConfigUtils.getASpecificProperty("browser");
        WebDriver driver;
        switch (defaultBrowser.toLowerCase()) {
            case "chrome":
                driver = getChromeDriver();
                break;
            case "edge":
                driver = getEdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + defaultBrowser);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        return driver;
    }

    public static WebDriver getChromeDriver() {
        WebDriverManager.chromedriver().setup();
        RemoteWebDriver driver=new ChromeDriver();
        return driver;
    }

    public static WebDriver getEdgeDriver() {
        WebDriverManager.edgedriver().setup();
        RemoteWebDriver driver=new EdgeDriver();
        return driver;
    }
}
