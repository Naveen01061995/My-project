package com.Zoho.PageObjects.TestData;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginZohoAccounts {

	@FindBy(css = "input#lid")
	WebElement userName;

	@FindBy(css = "input#pwd")
	WebElement password;

	@FindBy(css = "div#signin_submit")
	WebElement LoginBtn;

	public LoginZohoAccounts(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void setUsername(String userName) {
		this.userName.sendKeys(userName);

	}

	public void setPassword(String password) {
		this.password.sendKeys(password);

	}

	public void clickSignUPBtn() {

		LoginBtn.click();
	}

}
