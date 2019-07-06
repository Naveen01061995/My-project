package com.Zoho.TestCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Zoho.PageObjects.TestData.LoginZohoAccounts;
import com.Zoho.lib.ExecllMethods;

public class InvalidTestCase extends BaseClass {

	@Test(dataProvider = "ExcelValues")
	public void testvalidLogin(String uname, String pwd) throws InterruptedException {

		LoginZohoAccounts page = new LoginZohoAccounts(driver);
		page.setUsername(uname);
		page.setPassword(pwd);
		page.clickSignUPBtn();
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(3000);
		if (driver.getTitle().equals("Zoho Accounts")) {

			Assert.assertTrue(false);
		}

	}

	@DataProvider(name = "ExcelValues")
	public Object[][] getExcelData() {
		Object[][] values = ExecllMethods.getAllCellValue("InvalidZohologin", "invalidData");
		return values;
	}

}
