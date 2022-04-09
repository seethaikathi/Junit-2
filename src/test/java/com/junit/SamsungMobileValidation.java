package com.junit;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SamsungMobileValidation {
	
	static WebDriver driver;
	static long start;
	static String name;
	
	@BeforeClass
	public static void beforeClass() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	@AfterClass
	public static void afterClass() {
		driver.quit();
	}
	@Before
	public void before() {
		
		start = System.currentTimeMillis();
	}
	@After
	public void after() {
		
		long end = System.currentTimeMillis();
		System.out.println("Timetaken is :"+(end - start));
		
	}
	@Test
	public void method1() {
		WebElement loginButton = driver.findElement(By.xpath("//button[text()='✕']"));
		loginButton.click();
	}
	@Test
	public void method2() {
		WebElement search = driver.findElement(By.name("q"));
		search.sendKeys("Samsung",Keys.ENTER);
	}
	@Test
	public void method3() {
		WebElement mobilesearch = driver.findElement(By.xpath("(//div[contains(text(),'SAMSUNG ')])[1]"));
	    name = mobilesearch.getText();
		System.out.println(name);
		mobilesearch.click();

	}
	@Test
	public void method4() {
		String parent = driver.getWindowHandle();
		
		Set<String> children = driver.getWindowHandles();
        for (String x : children) {
        	
        	if (!parent.equals(x)) {
        		driver.switchTo().window(x);			
        	}	
        }	
		}
	@Test
	public void method5() {
		WebElement mobilename = driver.findElement(By.xpath("(//span[contains(text(),'SAMSUNG ')])"));
		
		Assert.assertTrue(mobilename.isDisplayed());
		String name2 = mobilename.getText();
		System.out.println(name2);
		
		Assert.assertEquals(name, name2);
	}
	@Test
	public void method6() throws IOException {
	    TakesScreenshot sc = (TakesScreenshot)driver;
	    File source = sc.getScreenshotAs(OutputType.FILE);
	    File target = new File("C:\\Users\\ADMIN\\eclipse-workspace\\junit\\screnshot\\flp.png");
	    
	    FileUtils.copyFile(source, target);
	    
	}
	
		
	}
	

	


