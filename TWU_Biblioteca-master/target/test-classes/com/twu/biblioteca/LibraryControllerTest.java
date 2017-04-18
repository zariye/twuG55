package com.twu.biblioteca;

import com.twu.biblioteca.LibraryController;
import com.twu.biblioteca.LibraryView;
import com.twu.biblioteca.books.Book;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.List;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by buzzer on 13.04.17.
 */
public class LibraryControllerTest {

    LibraryController libraryController;

    @Mock
    LibraryView libraryView;

    @Before
    public void setup() {
        libraryController = new LibraryController(libraryView);
    }

    @Test
    public void testGetMenuItems() {
        List<String> menuItems = libraryController.getMenuItems();
        assertThat(menuItems, hasItem("[0] quit"));
        assertThat(menuItems, hasItem("[1] list books"));
        assertThat(menuItems, hasItem("[2] checkout"));
        assertThat(menuItems, hasItem("[3] return book"));
    }

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Test
    public void testListBooksCommand() {
        int command = 1;
        libraryController.executeCommand(command);
        verify(libraryView).listBooks(libraryController.getAvailableBooks());
    }

    @Test
    public void testGetAvailableBooks() {
        List<Book> availableBooks = libraryController.getAvailableBooks();
        assertNotNull(availableBooks);
    }

    @Test
    public void testCheckoutBook() {
        List<Book> books = libraryController.getAvailableBooks();
        Book rmBook = books.get(1);
        libraryController.checkoutBook(1);
        assertFalse(libraryController.getAvailableBooks().contains(rmBook));
    }

    @Test
    public void testUnsuccessfulCheckoutBook() {
        boolean result = libraryController.checkoutBook(100);
        assertFalse(result);
    }

    @Test
    public void testCheckoutBookCommand() {
        int bookIndex = 1;
        int command = 2;
        when(libraryView.readInt()).thenReturn(bookIndex);
        libraryController = spy(libraryController);

        libraryController.executeCommand(command);

        verify(libraryController).checkoutBook(bookIndex);
        verify(libraryView).showMessage("Please choose you book while writing the index:");
        verify(libraryView).showMessage("Thank you! Enjoy the book");
    }

    @Test
    public void testUnsuccessfullCheckoutBookCommand() {
        when(libraryView.readInt()).thenReturn(100);
        int command = 2;
        libraryController.executeCommand(command);

        verify(libraryView).showMessage("Please choose you book while writing the index:");
        verify(libraryView).showMessage("That book is not available.");
    }

    @Test
    public void testReturnBook() {
        int bookIndex = 1;
        Book book = libraryController.getAvailableBooks().get(bookIndex);
        libraryController.checkoutBook(bookIndex);

        boolean result = libraryController.returnBook(book);
        assertTrue(result);
        assertThat(libraryController.getAvailableBooks(), hasItem(book));
    }

    @Test
    public void testUnsuccessfulReturnBook() {
        Book book = null;
        boolean result = libraryController.returnBook(book);
        assertFalse(result);
    }

    @Test
    public void testReturnBookCommand() {
        when(libraryView.readLine()).thenReturn("Head First Java");
        int command = 3;
        libraryController.executeCommand(command);

        verify(libraryView).showMessage("Thank you for returning the book.");
    }

    @Test
    public void testUnsuccessfulReturnBookCommand() {
        when(libraryView.readLine()).thenReturn("Batman");
        int command = 3;
        libraryController.executeCommand(command);

        verify(libraryView).showMessage("That is not a valid book to return.");
    }



}
