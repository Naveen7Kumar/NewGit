package com.steps;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.base.BaseClass;
import com.base.BookAHotel;
import com.base.LoginPage;
import com.base.SearchHotel;
import com.base.SelectHotel;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition extends BaseClass {

	@Given("User is on Adactin page")
	public void user_is_on_adactin_page() throws IOException {

		browserLaunch("https://adactinhotelapp.com/index.php");

	}

	@When("User enter the username , password and clicks on login")
	public void user_enter_the_username_password_and_clicks_on_login() throws IOException {
		LoginPage l = new LoginPage();
		inputText(l.getUser(), stringData(1, 0));
		Assert.assertEquals(stringData(1, 0), "Abinesh1990");
		inputText(l.getPass(), stringData(1, 1));
		Assert.assertEquals(stringData(1, 1), "Abinesh123");
		l.getLoginbtn().click();
		System.out.println("Login page Hard Assert passed successfully");

	}

	@When("User enter the location , hotels, room type , number of rooms , adults per room, children per room and clicks on search in the Search Hotel page")
	public void user_enter_the_location_hotels_room_type_number_of_rooms_adults_per_room_children_per_room_and_clicks_on_search_in_the_search_hotel_page()
			throws IOException {

		SearchHotel s = new SearchHotel();
		drpDown(s.getLoc(), stringData(1, 2));
		Assert.assertEquals(stringData(1, 2), "Sydney");
		drpDown(s.getHotel(), stringData(1, 3));
		Assert.assertEquals(stringData(1, 3), "Hotel Creek");
		drpDown(s.getRoomType(), stringData(1, 4));
		Assert.assertEquals(stringData(1, 4), "Deluxe");
		drpDown(s.getNoOfRooms(), stringData(1, 5));
		Assert.assertEquals(stringData(1, 5), "3 - Three");
		drpDown(s.getAdultRoom(), stringData(1, 6));
		Assert.assertEquals(stringData(1, 6), "3 - Three");
		drpDown(s.getChildPerRoom(), stringData(1, 7));
		Assert.assertEquals(stringData(1, 7), "3 - Three");
		s.getSearch().click();
		System.out.println("Search Hotel page Hard Assert passed successfully");

	}

	@When("User clicks on select radio button and clicks on continue in the Select Hotel page")
	public void user_clicks_on_select_radio_button_and_clicks_on_continue_in_the_select_hotel_page() {
		SelectHotel s1 = new SelectHotel();
		s1.getCheckBox().click();
		s1.getClick().click();

	}

	@When("User enter the first name, last name , billing address, credit card no , credit card type, expiry date, cvv number and clicks on book now in the Book A Hotel page")
	public void user_enter_the_first_name_last_name_billing_address_credit_card_no_credit_card_type_expiry_date_cvv_number_and_clicks_on_book_now_in_the_book_a_hotel_page()
			throws IOException {

		BookAHotel b = new BookAHotel();
		inputText(b.getFirstName(), stringData(1, 8));
		Assert.assertEquals(stringData(1, 8), "Naveen");
		inputText(b.getLastName(), stringData(1, 9));
		Assert.assertEquals(stringData(1, 9), "Kumar");

		inputText(b.getBillingAddress(), stringData(1, 10));
		Assert.assertEquals(stringData(1, 10), "No.29 bjdsbidsuidsguds");

		inputText(b.getCardNumber(), numericData(1, 11));
		Assert.assertEquals(numericData(1, 11), "1234567891234560");

		drpDown(b.getCardType(), stringData(1, 12));
		Assert.assertEquals(stringData(1, 12), "VISA");

		drpDown(b.getExpiryMonth(), stringData(1, 13));
		Assert.assertEquals(stringData(1, 13), "March");

		drpDown(b.getExpiryYear(), numericData(1, 14));
		Assert.assertEquals(numericData(1, 14), "2022");

		inputText(b.getCardCvv(), numericData(1, 15));
		Assert.assertEquals(numericData(1, 15), "222");

		b.getBookIt().click();
		System.out.println("Book A Hotel page Hard Assert passed successfully");

	}

	@Then("User verify the error message")
	public void user_verify_the_error_message() throws InterruptedException, IOException {
		Thread.sleep(6000);
		BookAHotel b = new BookAHotel();
		WebElement text = b.getOrderConfirm();
		String value = text.getText();
		Assert.assertEquals(value, "Booking Confirmation");


	TakesScreenshot t = (TakesScreenshot) driver;
	File screenshot = t.getScreenshotAs(OutputType.FILE);
	File f = new File("F:\\Adactin\\AdactinOrderNO.jpeg");
	FileUtils.copyFile(screenshot, f);
	
	quitBrowser();
	}
	
}
