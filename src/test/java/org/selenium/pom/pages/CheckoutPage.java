package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.selenium.pom.base.BasePage;
import org.selenium.pom.objects.BillingAddress;

public class CheckoutPage extends BasePage {
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    private final By firstNameField = By.id("billing_first_name");
    private final By lastNameField = By.id("billing_last_name");
    private final By addressLineOneField = By.id("billing_address_1");
    private final By billingCityField = By.id("billing_city");
    private final By billingPostCodeField = By.id("billing_postcode");
    private final By billingEmailField = By.id("billing_email");
    private final By placeOrderButton = By.cssSelector("#place_order");
    private final By successNotice = By.cssSelector(".woocommerce-notice");

    private final By loginLink = By.className("showlogin");
    private final By userNameField = By.cssSelector("#username");
    private final By passwordField = By.cssSelector("#password");
    private final By loginButton = By.name("login");
    private final By overlay = By.cssSelector(".blockUI.blockOverlay");

    private final By countryDropDown = By.id("billing_country");
    private final By stateDropDown = By.id("billing_state");



    public CheckoutPage enterFirstName(String firstName){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField));
        element.clear();
        element.sendKeys(firstName);
//        driver.findElement(firstNameField).clear();
//        driver.findElement(firstNameField).sendKeys(firstName);
        return this;
    }
    public CheckoutPage enterLastName(String lastName){
        driver.findElement(lastNameField).clear();
        driver.findElement(lastNameField).sendKeys(lastName);
        return this;
    }

    public CheckoutPage selectCountry(String countryName){
        Select select = new Select(driver.findElement(countryDropDown));
        select.selectByVisibleText(countryName);
        return this;
    }

    public CheckoutPage selectState(String stateName){
        Select select = new Select(driver.findElement(stateDropDown));
        select.selectByVisibleText(stateName);
        return this;
    }

    public CheckoutPage enterAddressLineOne(String addressLineOne){
        driver.findElement(addressLineOneField).clear();
        driver.findElement(addressLineOneField).sendKeys(addressLineOne);
        return this;
    }
    public CheckoutPage enterCity(String city){
        driver.findElement(billingCityField).clear();
        driver.findElement(billingCityField).sendKeys(city);
        return this;
    }
    public CheckoutPage enterPostCode(String postCode){
        driver.findElement(billingPostCodeField).clear();
        driver.findElement(billingPostCodeField).sendKeys(postCode);
        return this;
    }
    public CheckoutPage enterEmail(String email){
        driver.findElement(billingEmailField).clear();
        driver.findElement(billingEmailField).sendKeys(email);
        return this;
    }

    public CheckoutPage setBillingAddress(BillingAddress billingAddress){
       return enterFirstName(billingAddress.getFirstName())
                .enterLastName(billingAddress.getLastName())
               .selectCountry(billingAddress.getCountry())
                .enterAddressLineOne(billingAddress.getAddressLineOne())
                .enterCity(billingAddress.getCity())
               .selectState(billingAddress.getState())
                .enterPostCode(billingAddress.getPostalCode())
                .enterEmail(billingAddress.getEmail());
    }
    public CheckoutPage placeOrder(){
      waitForOverlaysToDisappear(overlay);
        driver.findElement(placeOrderButton).click();
        return this;
    }
    public String getNotice(){
       return wait.until(ExpectedConditions.visibilityOfElementLocated(successNotice)).getText();
//        return driver.findElement(successNotice).getText();
    }

    public CheckoutPage clickLoginLink(){
        driver.findElement(loginLink).click();
        return this;
    }

    public CheckoutPage enterUserName(String userName){
      wait.until(ExpectedConditions.visibilityOfElementLocated(userNameField)).sendKeys(userName);
//        driver.findElement(userNameField).sendKeys(userName);
        return this;
    }

    public CheckoutPage enterPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public CheckoutPage clickLoginButton(){
        driver.findElement(loginButton).click();
        return this;
    }

    public CheckoutPage login(String userName, String password){
        return enterUserName(userName)
                .enterPassword(password)
                .clickLoginButton();
    }
}
