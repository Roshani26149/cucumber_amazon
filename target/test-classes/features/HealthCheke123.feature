Feature: Ecommererce Project WebSite HealthCheck

  Background: Navigate to URL
    Given user is navigate to Home Page URL

  Scenario: User is open the browser and navigate to URL and search for product
    When User search for product "Laptop"
    Then Search result page is displayed

  Scenario: User is click on product and check product details
    When User search for product "earphones"
    And Click on any product
    Then Product description is displyed in new tab

  Scenario Outline: User is able to see multiple browser
    When User search for product "<productName>"
    Then Search result is displyed

    Examples: 
      | productName |
      | laptops     |
      | Earphones   |
      | Computer    |
