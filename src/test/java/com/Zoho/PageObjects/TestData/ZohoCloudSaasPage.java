package com.Zoho.PageObjects.TestData;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZohoCloudSaasPage {
	
	
	@FindBy(xpath="(//li[@class='zp-main-apps zp-main-books']//a//label//following-sibling::em[text()='Learn More'])[1]")
	WebElement booklink;
	
	public ZohoCloudSaasPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void click() {
		booklink.click();
	}

}
