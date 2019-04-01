/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author hailongluu
 */
public class DemoSelenium {
    static WebDriver driver =null;
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "I:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("google.com.vn");
    }
}
