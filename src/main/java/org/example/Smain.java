package org.example;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.concurrent.TimeUnit;

public class Smain {
    // The Class contains the methods web-operations
    WebDriver driver;
    public void launchbrowser(){
        System.setProperty("webdriver.edge.driver","C:\\Users\\akshaypa\\IdeaProjects\\Syncronized\\drivers\\msedgedriver.exe");
        driver=new EdgeDriver();
        driver.manage().window().maximize();
        //driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //Sample Login URL Found over the net
        driver.get("https://www.saucedemo.com/");
    }

    synchronized void login(String Username, String Password, Integer qty){
        //To perform Login based on the Username
        System.out.println("Current User:"+Username);
        // System.out.println("Current Thread ID: "+Thread.currentThread().getId());
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(Username);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(Password);
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        //To perform Logout
        driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).click();
        driver.findElement(By.xpath("//a[@id='logout_sidebar_link']")).click();
        System.out.println(Username+" Logged off");
        //System.out.println(driver.getTitle());
    }
     public void quit(){
        driver.quit();
     }
}
