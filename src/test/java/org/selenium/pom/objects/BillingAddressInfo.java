package org.selenium.pom.objects;

public class BillingAddressInfo {

    private String firstName;
    private String lastName;
    private String addressLineOne;
    private String city;
    private String postalCode;
    private String email;
    public String getFirstName() {
        return firstName;
    }

    public BillingAddressInfo setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public BillingAddressInfo setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getAddressLineOne() {
        return addressLineOne;
    }

    public BillingAddressInfo setAddressLineOne(String addressLineOne) {
        this.addressLineOne = addressLineOne;
        return this;
    }

    public String getCity() {
        return city;
    }

    public BillingAddressInfo setCity(String city) {
        this.city = city;
        return this;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public BillingAddressInfo setPostalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public BillingAddressInfo setEmail(String email) {
        this.email = email;
        return this;
    }


}
