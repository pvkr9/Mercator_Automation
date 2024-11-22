package com.home.tests.steps;


import com.home.tests.test.driver.manager.WebDriverManagerSetup;
import org.openqa.selenium.WebDriver;

public class CommonSteps {

    public static WebDriver driver;
    public CommonSteps() {
        if (driver == null) {
            try {
                driver = WebDriverManagerSetup.getDriverDynamic();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

}