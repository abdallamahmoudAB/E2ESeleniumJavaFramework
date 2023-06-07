package org.selenium;

import org.selenium.pom.base.BaseTest;
import org.selenium.pom.objects.BillingAddress;
import org.selenium.pom.pages.CartPage;
import org.selenium.pom.pages.CheckoutPage;
import org.selenium.pom.pages.HomePage;
import org.selenium.pom.pages.StorePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase extends BaseTest {

    @Test
    public void guestCheckoutUsingDirectBankTransfer() throws InterruptedException {

        BillingAddress billingAddress = new BillingAddress();
        billingAddress.setFirstName("demo")
        .setLastName("user")
        .setAddressLineOne("San Francisco")
        .setCity("San Francisco")
        .setPostalCode("95455")
        .setEmail("lerewa7361@wnpop.com");

        StorePage storePage = new HomePage(driver) // fluent interface
                            .clickStoreMenuLink()

                // structual page object - Builder Pattern
//                            .enterTextInSearchField("Blue")
//                            .clickSearchButton();

                // functional page object
                        .search("Blue");
        Assert.assertEquals(storePage.getTitle(), "Search results: “Blue”");

        storePage.clickAddToCartButton("Blue Shoes");
        Thread.sleep(3000);
        CartPage cartPage = storePage.clickViewCart();
        Assert.assertEquals(cartPage.getProductName(), "Blue Shoes");

        CheckoutPage checkoutPage = cartPage.clickCheckoutButton();

        checkoutPage.setBillingAddress(billingAddress);
        Thread.sleep(3000);
        checkoutPage.placeOrder();
        Thread.sleep(3000);
        Assert.assertEquals(checkoutPage.getNotice(), "Thank you. Your order has been received.");

    }

    @Test
    public void loginAndCheckoutUsingDirectBankTransfer() throws InterruptedException {

        StorePage storePage = new HomePage(driver)
                                .clickStoreMenuLink()
                                    .search("Blue");
        Assert.assertEquals(storePage.getTitle(), "Search results: “Blue”");

        storePage.clickAddToCartButton("Blue Shoes");
        Thread.sleep(3000);
        CartPage cartPage = storePage.clickViewCart();
        Assert.assertEquals(cartPage.getProductName(), "Blue Shoes");

        CheckoutPage checkoutPage = cartPage.clickCheckoutButton();
        checkoutPage.clickLoginLink();
        Thread.sleep(3000);
        checkoutPage.login("dummy", "user")

                .enterFirstName("demo")
                .enterLastName("user")
                .enterAddressLineOne("San Francisco")
                .enterCity("San Francisco")
                .enterPostCode("95455")
                .enterEmail("lerewa7361@wnpop.com");

        Thread.sleep(3000);
        checkoutPage.placeOrder();
        Thread.sleep(3000);

        Assert.assertEquals(checkoutPage.getNotice(), "Thank you. Your order has been received.");




    }
}
