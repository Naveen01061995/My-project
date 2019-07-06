package com.Zoho.PageObjects.TestData;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZohoMail {

	@FindBy(xpath="//*[@id='wrapper']/div[1]/div[1]/a[1]")
	WebElement zohoHome;

	public ZohoMail(WebDriver driver) {

		PageFactory.initElements(driver, this);

	}

	public void zohoHomeBtnClick() {
		zohoHome.click();
	}

}
