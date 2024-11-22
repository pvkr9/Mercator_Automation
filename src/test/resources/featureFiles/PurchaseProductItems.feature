@regression
Feature: Purchase costliest product from the list
  
  Scenario Outline: Login and add costliest product to the basket to purchase it
	Given I login to Sauce labs home page with "<username>" and "<password>"
    Then I verify the product list is displayed in the home page
	Then I add highest price item to the cart

	Examples:
		| username      | password     |
		| standard_user | secret_sauce |


	