package com.Zoho.TestCases;


import org.testng.annotations.Test;

import com.Zoho.PageObjects.TestData.ZohoMail;

public class zohoHomeTest extends BaseClass {

	@Test
	public void Validation() throws InterruptedException {
		ZohoMail mail = new ZohoMail(driver);
		mail.zohoHomeBtnClick();
		//WebDriver wait = new Web
		Thread.sleep(10000);

		/*if (driver.getTitle().contains("Cloud Software Suite")) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}*/

	}

}
