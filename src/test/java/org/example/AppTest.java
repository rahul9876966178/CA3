package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.ResourceBundle;


/**
 * Unit test for simple App.
 */
public class AppTest
{
    WebDriver driver;
    @BeforeClass
    @Parameters({"browser","url"})
    void setup(String browser,String link)
    {
        if(browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
        }
        else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver=new EdgeDriver();
        }

        driver.get(link);
        driver.manage().window().maximize();

    }
    @Test
    public void login() throws InterruptedException {
        ResourceBundle r=ResourceBundle.getBundle("config");
        String username=r.getString("username");
        String password=r.getString("password");
        driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys(username);
        driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getTitle(), "Gmail");
        //driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
      //  driver.findElement(By.xpath("//span[normalize-space()='Next']")).click();

    }

}