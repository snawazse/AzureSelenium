package com.qa.opencart.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.Constants.AppConstants;
import com.qa.opencart.Utils.ElementUtil;

public class RegisterPage {

	private final WebDriver driver;
	private final ElementUtil eleUtil;

	private final By firstName = By.id("input-firstname");
	private final By lastName = By.id("input-lastname");
	private final By email = By.id("input-email");
	private final By telephone = By.id("input-telephone");
	private final By password = By.id("input-password");
	private final By confirmpassword = By.id("input-confirm");

	private final By agreeCheckBox = By.name("agree");
	private final By continueButton = By.xpath("//input[@type='submit' and @value='Continue']");

	private final By subscribeYes = By.xpath("//label[normalize-space()='Yes']/input[@type='radio']");
	private final By subscribeNo = By.xpath("//label[normalize-space()='No']/input[@type='radio']");

	private final By registerSuccessMesg = By.cssSelector("div#content h1");

	private final By logoutLink = By.linkText("Logout");
	private final By registerLink = By.linkText("Register");

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	
	
	public boolean registerUser(String firstName, String lastName, 
			String email, String telephone, String password, String subscribe) {
		
		eleUtil.waitForElementVisible(this.firstName, AppConstants.DEFAULT_SHORT_TIME_OUT).sendKeys(firstName);
		eleUtil.doSendKeys(this.lastName, lastName);
		eleUtil.doSendKeys(this.email, email);
		eleUtil.doSendKeys(this.telephone, telephone);
		eleUtil.doSendKeys(this.password, password);
		eleUtil.doSendKeys(this.confirmpassword, password);
		
			if(subscribe.equalsIgnoreCase("yes")) {
				eleUtil.doClick(subscribeYes);
			}
			else {
				eleUtil.doClick(subscribeNo);
			}
		eleUtil.doActionsCick(agreeCheckBox);
		eleUtil.doClick(continueButton);
		
		String successMesg = eleUtil.waitForElementVisible(registerSuccessMesg, AppConstants.DEFAULT_MEDIUM_TIME_OUT).getText();
		System.out.println("user reg success messg : " + successMesg);
		
		if(successMesg.contains(AppConstants.USER_REG_SUCCESS_MESSG)) {
			eleUtil.doClick(logoutLink);
			eleUtil.doClick(registerLink);
			return true;
		}
		return false;
	}
	
	
	
	
	
	
	
	
	
	

}
