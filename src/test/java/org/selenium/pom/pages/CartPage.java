package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    private final By productName = By.cssSelector("td[class='product-name'] a");
    private final By checkoutButton = By.cssSelector(".checkout-button");

    public String getProductName(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productName)).getText();
//       return driver.findElement(productName).getText();
    }

    public CheckoutPage clickCheckoutButton(){
        wait.until(ExpectedConditions.elementToBeClickable(checkoutButton)).click();
//        driver.findElement(checkoutButton).click();
        return new CheckoutPage(driver);
    }
}
