package com.sda.bank;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class BankSteps {
    private String name;
    private int pesel;

    private String id;
    private int amount;

    private BankUser user;
    private BankAccount account;

    private Bank bank;

    private boolean userInsertResult;

    @Given("^I instantiate bank$")
    public void iInstantiateBank() {
        this.bank = new Bank();
    }

    @And("^I create user with name '(.*)' and pesel '(.*)'$")
    public void iCreateUserWithNameNameAndPeselPesel(String name, String pesel){
        this.user = new BankUser(name, pesel);
    }

    @When("^I insert user to bank$")
    public void iInsertUserToBank() {
        userInsertResult = bank.addBankUser(user);
    }

    @Then("^User is present in bank$")
    public void userIsPresentInBank() {
        Assert.assertTrue(userInsertResult);
        Assert.assertEquals(1, bank.numberOfUsers());
    }

}
