package com.twu.biblioteca.book;

import com.twu.biblioteca.books.Book;
import com.twu.biblioteca.books.BookService;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by buzzer on 13.04.17.
 */
public class BookServiceTest {

    BookService bookService;

    @Before
    public void setup() {
        bookService = new BookService();
    }

    @Test
    public void getBookByNameTest() {
        Book headFirstJava = new Book("Head First Java", "1940", "Moritz");
        Book foundBook = bookService.getBookByName(headFirstJava.getName());
        assertEquals(headFirstJava, foundBook);
    }

    @Test
    public void getAllBooksTest() {
        List<Book> allBooks = bookService.getAllBooks();
        assertThat(allBooks, CoreMatchers.hasItem(new Book("Head First Java", "1940", "Moritz")));
    }

    @Test
    public void getAvailableBooksTest() {
        List<Book> availableBooks = bookService.getAvailableBooks();
        assertNotNull(availableBooks);
    }

    @Test
    public void checkoutBookTest() {
        int index = 1;
        Book bookToCheckout = bookService.getAllBooks().get(index);
        bookService.checkoutBook(index);

        List<Book> availableBooks = bookService.getAvailableBooks();
        assertThat(availableBooks, CoreMatchers.not(CoreMatchers.hasItem(bookToCheckout)));
    }

    @Test
    public void testReturnBookSuccess() {
        Book book = new Book("Head First Java","1940", "Moritz");
        boolean result = bookService.returnBook(book);
        List<Book> books = bookService.getAvailableBooks();

        assertThat(books, CoreMatchers.hasItem(book));
        assertTrue(result);
    }
}
