package com.sda.service.cucumber;

import com.sda.service.StringCalculator;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class StringCalculatorSteps {

    private String value;

    private int result;

    private StringCalculator calculator = new StringCalculator();

    @Given("^I initialize stringCalculator$")
    public void i_initialize_stringCalculator() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        this.calculator = new StringCalculator();
    }

   @Given("^I pass single number value$")
    public void I_pass_single_number_value(){
        this.value = "5";
    }

    @Given("^I initialize 2 numbers$")
    public void I_initialize_2_numbers(){
        this.value = "2,3";
    }

    @And("^I pass null value$")
    public void I_pass_null_value(){
        this.value = null;
    }

    @And("^I pass empty value$")
    public void I_pass_empty_value(){
        this.value = "";
    }

    @And("^I pass two numbers value$")
    public void I_pass_two_numbers_value(){
        this.value = "2;7";
    }

    @And("^I pass multiple numbers value$")
    public void I_pass_multiple_numbers_value(){
        this.value = "2;3;4";
    }

    @And("^I pass multiple numbers with whitespaces value$")
    public void I_pass_multiple_numbers_with_whitespaces_value(){
        this.value = "2   ;3    ;  \n4";
    }



    @When("^I trigger calculate function$")
    public void I_trigger_calculate_function(){
        this.result = calculator.calculate(value);
    }

    @Then("^I get 5 as a result$") // absercja czyli sprawdzenie
    public void I_get_5_as_a_result(){
        Assert.assertEquals(5, result);
    }

    @Then("^I get 0 as a result$")
    public void I_get_0_as_a_result(){
        Assert.assertEquals(0, result);
    }
    @Then("^I get 9 as a result$")
    public void I_get_9_as_a_result(){
        Assert.assertEquals(9, result);
    }


}
