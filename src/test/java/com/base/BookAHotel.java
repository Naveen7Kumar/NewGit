package com.base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookAHotel extends BaseClass{

	public BookAHotel() {
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "(//*[@class = 'reg_input'])[1]")
	private WebElement firstName;
	@FindBy(xpath = "//*[@id = 'last_name']")
	private WebElement lastName;
	@FindBy(xpath = "//*[@id = 'address']")
	private WebElement billingAddress;
	@FindBy(id = "cc_num")
	private WebElement cardNumber;
	@FindBy(id = "cc_type")
	private WebElement cardType;
	@FindBy(id = "cc_exp_month")
	private WebElement expiryMonth;
	@FindBy(id = "cc_exp_year")
	private WebElement expiryYear;
	@FindBy(id = "cc_cvv")
	private WebElement cardCvv;
	@FindBy(id = "book_now")
	private WebElement bookIt;
	@FindBy(xpath = "//*[text()='Booking Confirmation ']")
	private WebElement orderConfirm;
	

	

	public WebElement getOrderConfirm() {
		return orderConfirm;
	}

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getBillingAddress() {
		return billingAddress;
	}

	public WebElement getCardNumber() {
		return cardNumber;
	}

	public WebElement getCardType() {
		return cardType;
	}

	public WebElement getExpiryMonth() {
		return expiryMonth;
	}

	public WebElement getExpiryYear() {
		return expiryYear;
	}

	public WebElement getCardCvv() {
		return cardCvv;
	}

	public WebElement getBookIt() {
		return bookIt;
	}

}