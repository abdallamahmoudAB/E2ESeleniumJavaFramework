package org.selenium.pom.tests;

import org.selenium.pom.base.BaseTest;
import org.selenium.pom.objects.BillingAddress;
import org.selenium.pom.pages.CartPage;
import org.selenium.pom.pages.CheckoutPage;
import org.selenium.pom.pages.HomePage;
import org.selenium.pom.pages.StorePage;
import org.selenium.pom.utils.ConfigLoader;
import org.selenium.pom.utils.JacksonUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;


public class TestCase extends BaseTest {

    @Test
    public void guestCheckoutUsingDirectBankTransfer() throws IOException {

       BillingAddress billingAddress = JacksonUtils.deserializeJson("myBillingAddress.json", BillingAddress.class);

//        BillingAddress billingAddress = new BillingAddress();
//        billingAddress.setFirstName("demo")
//        .setLastName("user")
//        .setAddressLineOne("San Francisco")
//        .setCity("San Francisco")
//        .setPostalCode("95455")
//        .setEmail("lerewa7361@wnpop.com");

        StorePage storePage = new HomePage(getDriver()) // fluent interface
                            .clickStoreMenuLink()

                // structual page object - Builder Pattern
//                            .enterTextInSearchField("Blue")
//                            .clickSearchButton();

                // functional page object
                        .search("Blue");
        Assert.assertTrue(storePage.getTitle().contains( "Search results: "));

        storePage.clickAddToCartButton("Blue Shoes");

        CartPage cartPage = storePage.clickViewCart();
        Assert.assertEquals(cartPage.getProductName(), "Blue Shoes");

        CheckoutPage checkoutPage = cartPage.clickCheckoutButton();

        checkoutPage.setBillingAddress(billingAddress)
                .selectDirectBankTransfer()
                .placeOrder();

        Assert.assertEquals(checkoutPage.getNotice(), "Thank you. Your order has been received.");

    }

    @Test
    public void loginAndCheckoutUsingDirectBankTransfer()  {

        StorePage storePage = new HomePage(getDriver())
                                .clickStoreMenuLink()
                                    .search("Blue");
        Assert.assertEquals(storePage.getTitle(), "Search results: “Blue”");

        storePage.clickAddToCartButton("Blue Shoes");

        CartPage cartPage = storePage.clickViewCart();
        Assert.assertEquals(cartPage.getProductName(), "Blue Shoes");

        CheckoutPage checkoutPage = cartPage.clickCheckoutButton();
        checkoutPage.clickLoginLink();

        checkoutPage.login(ConfigLoader.getInstance().getUsername(), ConfigLoader.getInstance().getPassword())

//        checkoutPage.login("dummy", "user")

                .enterFirstName("demo")
                .enterLastName("user")
                .selectCountry("United States (US)")
                .enterAddressLineOne("San Francisco")
                .enterCity("San Francisco")
                .selectState("Colorado")
                .enterPostCode("95455")
                .enterEmail("lerewa7361@wnpop.com");

        checkoutPage.selectDirectBankTransfer();
        checkoutPage.placeOrder();


        Assert.assertEquals(checkoutPage.getNotice(), "Thank you. Your order has been received.");




    }
}
