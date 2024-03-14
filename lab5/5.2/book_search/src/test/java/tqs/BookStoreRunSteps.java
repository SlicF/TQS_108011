package tqs;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BookStoreRunSteps {

    private BookStore store;
    private List<Book> foundBooks;
    
    @Before
    public void setUp() {
        store = new BookStore();
        foundBooks = new ArrayList<>();
    }

    // When & Then definitions ...
    @Given("the following books are available")
    public void the_following_books_are_available(List<Book> books) {
        store.addAllBooks(books);
    }

    @When("the customer searches for books by {string}")
    public void the_customer_searches_for_books_by(String author) {
        foundBooks = store.booksByAuthor(author);
    }

    @Then("{int} books should have been found")
    public void books_should_have_been_found(int booksFound) {
        assertEquals(booksFound, foundBooks.size());
    }

    @Then("Book {int} should have the title {string}")
    public void book_should_have_the_title(int bookNumber, String title) {
        assertEquals(title, foundBooks.get(bookNumber - 1).getTitle());
    }

    @Then("Book {int} should have the author {string}")
    public void book_should_have_the_author(int bookNumber, String author) {
        assertEquals(author, foundBooks.get(bookNumber - 1).getAuthor());
    }

    @Then("Book {int} should have the title {string} and the author {string}")
    public void book_should_have_the_title_and_the_author(int bookNumber, String title, String author) {
        assertEquals(title, foundBooks.get(bookNumber - 1).getTitle());
        assertEquals(author, foundBooks.get(bookNumber - 1).getAuthor());
    }
    
}