package com.home.tests.pages;

import com.home.tests.test.configutils.ConfigUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class SauceLabsPage {

	private WebDriver driver;

	@FindBy(css = "#user-name")
	private WebElement userName;

	@FindBy(css = "#password")
	private WebElement password;

	@FindBy(css = "#login-button")
	private WebElement loginButton;

	@FindBy(xpath = "//*[@id='header_container']/div/span[text()='Products']")
	private WebElement productLabel;

	@FindBy(css = "#inventory_container>div.inventory_list>div.inventory_item")
	private List<WebElement> inventoryItemList;

	@FindBy(css = "#shopping_cart_container>a>span.shopping_cart_badge")
	private WebElement itemAddedToShoppingCart;

	public SauceLabsPage(WebDriver driver) {
		ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver, 30);
		PageFactory.initElements(finder, this);
		this.driver = driver;
	}

	public void gotoSauceLabsHomePage() {
		driver.get(ConfigUtils.getWebEndPoint());
	}

    public void enterUserName(String userNameText){
        userName.sendKeys(userNameText);

	}

    public void enterPassword(String passwordText){
        password.sendKeys(passwordText);
    }

    public void clickLoginBtn(){
        loginButton.click();
    }

	public boolean isProdcutItemsListDisplayed(){
		 if(inventoryItemList.size() > 0 )
		      return true;
		 else return false;
	}

	public boolean getCostliestProductItemsAndAddToBasket() throws InterruptedException {
		String priceVal;
		String actPriceVal;
		boolean costliestPrice = false;
		boolean lowestPrice = false;

		ArrayList<Float> priceList = new ArrayList<Float>();
		for(int i=1; i<=inventoryItemList.size(); i++){
			priceVal = driver.findElement(By.cssSelector("#inventory_container>div.inventory_list>div.inventory_item:nth-child("+i+") div.pricebar>div.inventory_item_price")).getText();
			priceVal = priceVal.replace("$","");
			float price = Float.parseFloat(priceVal);
			priceList.add(price);
		}

		Collections.sort(priceList);

		for(int j=1;j<=priceList.size(); j++){
			WebElement addToCartElement = driver.findElement(By.cssSelector("#inventory_container>div.inventory_list>div.inventory_item:nth-child("+j+") div.pricebar>button.btn_primary.btn_inventory"));
			actPriceVal = driver.findElement(By.cssSelector("#inventory_container>div.inventory_list>div.inventory_item:nth-child("+j+") div.pricebar>div.inventory_item_price")).getText();
			actPriceVal = actPriceVal.replace("$","");
			float actPrice = Float.parseFloat(actPriceVal);

			//costliest item
			float expPrice = priceList.get(priceList.size()-1);

			if(actPrice==expPrice){
				addToCartElement.click();
				if (itemAddedToCart()>0){
					costliestPrice =true;
				}
			}
		}
		return costliestPrice;
	};


	public int itemAddedToCart(){
		String itemAdded = itemAddedToShoppingCart.getText();
		int noOfitemsAdded = Integer.parseInt(itemAdded);
		return noOfitemsAdded;
	};

	public void enterUserNameObj(String userNameText){
		userName.sendKeys(userNameText);
	}
}