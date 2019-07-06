package com.Zoho.TestCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Zoho.PageObjects.TestData.LoginZohoAccounts;
import com.Zoho.lib.ExecllMethods;

public class TestValidLogin extends BaseClass {

	@Test(dataProvider = "ExcelValues")
	public void testvalidLogin(String uname, String pwd) throws InterruptedException {

		LoginZohoAccounts page = new LoginZohoAccounts(driver);
		page.setUsername(uname);
		page.setPassword(pwd);
		page.clickSignUPBtn();

		Thread.sleep(10000);
	}

	@DataProvider(name = "ExcelValues")
	public Object[][] getExcelData() {
		Object[][] values = ExecllMethods.getAllCellValue("ZohoLoginData", "ValidData");
		return values;
	}
}
