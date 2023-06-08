package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;

public class StorePage extends BasePage {
    public StorePage(WebDriver driver) {
        super(driver);
    }

    private final By searchField = By.id("woocommerce-product-search-field-0");
    private final By searchbutton = By.cssSelector("button[value='Search']");
    private final By title = By.cssSelector(".woocommerce-products-header__title.page-title");

    //static element
//    private final By addToCartButton = By.cssSelector("a[aria-label='Add “Blue Shoes” to your cart']");
    private final By viewCartLink = By.cssSelector("a[title='View cart']");

    public StorePage enterTextInSearchField(String text){
        driver.findElement(searchField).sendKeys(text);
        return this;
    }

    public StorePage search(String text){
       enterTextInSearchField(text).clickSearchButton();
        return this;
    }

    public StorePage clickSearchButton(){
        driver.findElement(searchbutton).click();
        return this;
    }

    public String getTitle(){
       return driver.findElement(title).getText();
    }

    // Dynamic element
    private By getAddToCartButtonElement(String productName){
        return By.cssSelector("a[aria-label='Add “" + productName + "” to your cart']");
    }

    public StorePage clickAddToCartButton(String productName){
       By addToCartButton = getAddToCartButtonElement(productName);
        driver.findElement(addToCartButton).click();
        return this;
    }

    public CartPage clickViewCart(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(viewCartLink)).click();
//        driver.findElement(viewCartLink).click();
        return new CartPage(driver);
    }

}
