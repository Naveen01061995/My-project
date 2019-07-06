package com.Zoho.TestCases;

import java.util.Set;

import org.testng.annotations.Test;

import com.Zoho.PageObjects.TestData.ZohoCloudSaasPage;

public class TestBookread extends BaseClass {
	
	@Test
	public void testBookLink() throws InterruptedException {
		
		TestValidLogin login = new TestValidLogin();
		login.testvalidLogin("glnaveen06@gmail.com", "Naveen@123");
		zohoHomeTest test = new zohoHomeTest();
		test.Validation();
		String title = driver.getTitle();
		Set<String> window = driver.getWindowHandles();
		for(String win:window) {
			String title1 = driver.switchTo().window(win).getTitle();
			if(title.equals(title1)) {
				driver.switchTo().window(win);
			}
		}
		
		ZohoCloudSaasPage page = new ZohoCloudSaasPage(driver);
		page.click();
		
	}

}
