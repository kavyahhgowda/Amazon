package com.objectrepository.amazon;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class Homepage {
	@FindBy(id = "cartur")
	private WebElement cartLinKtext;

	@FindBys({ @FindBy(xpath = "//a[text()='About us']"), @FindBy(linkText = "About us") })
	private WebElement aboutUsLinkText;

	
	//getters
	public WebElement getCartLinKtext() {
		return cartLinKtext;
	}

	public WebElement getAboutUsLinkText() {
		return aboutUsLinkText;
	}

}