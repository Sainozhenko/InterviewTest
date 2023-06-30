package com.ebay.fw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class AppManager {
    String browser;
    WebDriver driver;
    SelectHelper select;
    ItemHelper item;

    public AppManager(String browser) {
        this.browser = browser;
    }


    public void init() {
        if(browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        }else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            EdgeOptions options = new EdgeOptions();
            options.addArguments("remote-allow-origins=*");
            driver = new EdgeDriver(options);
        }


        driver.get("https://www.ebay.de");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        select = new SelectHelper(driver);
        item = new ItemHelper(driver);
    }

    public void stop() {
        driver.quit();
    }

    public SelectHelper getSelect() {
        return select;
    }

    public ItemHelper getItem() {
        return item;
    }
}
