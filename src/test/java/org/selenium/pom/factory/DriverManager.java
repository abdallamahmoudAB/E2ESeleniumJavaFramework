package org.selenium.pom.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.selenium.pom.utils.ConfigLoader;

import java.time.Duration;

public class DriverManager {

    public WebDriver initializeDriver(){
        WebDriver driver = new ChromeDriver();
        driver.get(ConfigLoader.getInstance().getBaseUrl());
//        driver.get("https://askomdch.com/");
        driver.manage().window().maximize();
        return driver;
    }
}
