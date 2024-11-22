package com.home.tests.steps;

import com.home.tests.pages.SauceLabsPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;


public class SauceLabsSteps extends CommonSteps {

	public SauceLabsPage sauceLabsPage;
	
	public SauceLabsSteps(){
		sauceLabsPage = new SauceLabsPage(driver);
	}

	@Given("^I login to Sauce labs home page with \"([^\"]*)\" and \"([^\"]*)\"$")
	public void iLoginToSauceLabsHomePageWithAnd(String userNameVal, String passwordVal) throws Throwable {
		sauceLabsPage.gotoSauceLabsHomePage();
		sauceLabsPage.enterUserName(userNameVal);
		sauceLabsPage.enterPassword(passwordVal);
		sauceLabsPage.clickLoginBtn();

	}

	@Given("^I login to Sauce labs home page with \"([^\"]*)\" and \"([^\"]*)\" and finishs$")
	public void iLoginToSauceLabsHomePageWithAndAndFinishs(String strUsename, String strPasswd) throws Throwable {
		sauceLabsPage.enterUserNameObj(strUsename);
		sauceLabsPage.enterPassword(strPasswd);
		sauceLabsPage.clickLoginBtn();
	}

	@Then("^I verify the product list is displayed in the home page$")
	public void iVerifyTheProductListIsDisplayedInTheHomePage() {
	   Assert.assertTrue(sauceLabsPage.isProdcutItemsListDisplayed());
	}

	@Then("^I add highest price item to the cart$")
	public void iAddHighestPriceItemToTheCart() throws InterruptedException {
		Assert.assertTrue(sauceLabsPage.getCostliestProductItemsAndAddToBasket());
	}
}
