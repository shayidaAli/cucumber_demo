package com.cybertek.step_definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

public class table_sd {
    private List<Integer> numbers;

    private int sum;
    @Given("a list of numbers")
    public void a_list_of_numbers(io.cucumber.datatable.DataTable dataTable) {
        this.numbers = numbers;
    }

    @When("I summarize them")
    public void i_summarize_them() {
        for (Integer number : numbers) {
            sum += number;
        }
    }

    @Then("should I get {int}")
    public void should_I_get(Integer int1) {
        System.out.println("dsdsd");
    }

}
