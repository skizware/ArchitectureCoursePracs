package com.skizware.steps;

import com.skizware.calc.StringCalculator;
import com.skizware.calc.exception.StringCalculatorException;
import junit.framework.Assert;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class MySteps {

    public static final String INCORRECT_RETURN_VALUE = "Incorrect return value";
    StringCalculator stringCalculator;
    int returnedVal;
    Exception caughtException;

    @Given("a string calculator")
    public void givenAStringCalculator() {
        stringCalculator = new StringCalculator();
    }

    @When("I have an empty string input")
    public void whenIHaveAnEmptyStringInput() {
        returnedVal = stringCalculator.add("");
    }

    @Then("I shall return 0")
    public void thenIShallReturn0() {
        Assert.assertEquals("Invalid return value",returnedVal, 0);
    }


    @When("I have single string input")
    public void whenIHaveSingleStringInput() {
        returnedVal = stringCalculator.add("1");
    }

    @Then("I shall return the same value")
    public void thenIShallReturnTheSameValue() {
        Assert.assertEquals(INCORRECT_RETURN_VALUE, returnedVal, 1);
    }

    @When("input is $input")
    public void whenInputIs(String input) {
        returnedVal = -1;
        caughtException = null;
        try{
            returnedVal = stringCalculator.add(input);
        } catch(StringCalculatorException ex){
            caughtException = ex;
        }
    }

    @Then("I shall return $output")
    public void thenIShallReturn(int output) {
        assert output == returnedVal;
    }

    @Then("a StringCalculatorException should be thrown")
    public void thenAStringCalculatorExceptionShouldBeThrown() {
        assert caughtException != null;
    }

    @Then("the message should contain the $message message")
    public void thenTheMessageShouldContainTheNegativesNotAllowedMessage(String message) {
        assert caughtException.getMessage().contains(message);
    }
}
