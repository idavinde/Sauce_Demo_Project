package com.ui.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pojo.User;

@Listeners(com.ui.listeners.TestListner.class)
public class LoginTest extends TestBase {

	@Test(dataProviderClass = com.ui.dataProvider.LoginDataProvider.class, dataProvider = "JSONLoginDataProvider") //jkhkhkjhlih
	public void loginTest(User user) {

	 assertEquals(login.loginWith(user.getUSERNAME(), user.getPASSWORD()).getTitle(), "Products", "Title is not matched test fail");
	}

	@Test(dataProviderClass = com.ui.dataProvider.LoginDataProvider.class, dataProvider = "CSVLoginDataProvider", enabled = false)
	public void loginTest1(User user) {

		assertEquals(login.loginWith(user.getUSERNAME(), user.getPASSWORD()).getTitle(), "Products", "Title is not matched test fail");
	}

	@Test(dataProviderClass = com.ui.dataProvider.LoginDataProvider.class, dataProvider = "ExcelLoginDataProvider",enabled = false)
	public void loginTest2(User user) {

		assertEquals(login.loginWith(user.getUSERNAME(), user.getPASSWORD()).getTitle(), "Products", "Title is not matched test fail");
	}

}
