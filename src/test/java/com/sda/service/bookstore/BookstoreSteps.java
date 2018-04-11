package com.sda.service.bookstore;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class BookstoreSteps {
    private String value;
    private String result;


    private Bookstore bookstore;
    private Book book;

    @Given("^I instantiate bookstore$")
    public void I_instantiate_bookstore() {
         this.bookstore = new Bookstore();
    }

    @And("^I create book$")
    public void I_create_book(){
        this.book = new Book("Ogniem i mieczem", 800, "Henryk Sienkiewicz", "abc123");
    }

    @And("^I edit title of book$")
    public void I_edit_title_of_book(){
        this.bookstore.updateTitle(book, "Krzyżacy");
    }

    @When("^I add book to bookstore$")
    public void I_add_book_to_bookstore(){
        this.bookstore.add(this.book);
    }
    @Then("^Book is present in bookstore$")
    public void Book_is_present_in_bookstroe(){
        Assert.assertEquals(1, this.bookstore.getBooks().size());
    }
    @Then("^Book is title has changed$")
    public void Book_is_title_has_changed(){
        Assert.assertEquals("Krzyżacy",this.bookstore.getBooks().get(0).getTitle() );
    }

}
