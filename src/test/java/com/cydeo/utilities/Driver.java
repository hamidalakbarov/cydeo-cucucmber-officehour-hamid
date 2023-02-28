package com.cydeo.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {

    private Driver() {

    }

    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();

    public static WebDriver getDriver() {

        String browserType = ConfigurationReader.getProperty("browser");

        if (driverPool.get()==null) {

            switch (browserType.toLowerCase()) {
                case "chrome":
                    driverPool.set(new ChromeDriver());
                    break;
                case "firefox":
                    driverPool.set(new FirefoxDriver());

            }
            driverPool.get().manage().window().maximize();
            driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
        return driverPool.get();
    }

    public static void closeDriver() {
        if (driverPool.get()!=null) {
            driverPool.get().quit();
            driverPool.remove();
        }
    }


}
