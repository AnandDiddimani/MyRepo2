package com.abc.TestScript;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestScript {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		
		FileInputStream fis = new FileInputStream("D:\\ENGINEERING\\practice\\selenium workspace\\DataDrivenFramework\\src\\com\\abc\\PropertyFile\\Data.properties");
		
		Properties p = new Properties();
		
		p.load(fis);
		
		String urldata = p.getProperty("url");
		
		String emaildata = p.getProperty("email");
		
		String passdata = p.getProperty("password");
		
		
		
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.get(urldata);
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.id("email")).sendKeys(emaildata);
		driver.findElement(By.id("pass")).sendKeys(passdata);
		driver.findElement(By.id("send2")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Log Out"))).click();
		
		
		//driver.findElement(By.linkText("Log Out")).click();
		
		Thread.sleep(3000);
		
		driver.quit();


	}

}
