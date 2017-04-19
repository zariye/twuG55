package com.twu.biblioteca;

import com.twu.biblioteca.books.Book;
import com.twu.biblioteca.movie.MovieService;
import com.twu.biblioteca.user.UserService;
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
    LibraryView libraryViewMock;

    @Mock
    MovieService movieServiceMock;

    UserService userService;

    @Before
    public void setup() {
        userService = new UserService();
        libraryController = new LibraryController(libraryViewMock, movieServiceMock, userService);
    }

    @Test
    public void testGetMenuItems() {
        List<String> menuItems = libraryController.getMenuItems();
        assertThat(menuItems, hasItem("[0] quit"));
        assertThat(menuItems, hasItem("[1] list books"));
        assertThat(menuItems, hasItem("[2] checkout"));
        assertThat(menuItems, hasItem("[3] return book"));
        assertThat(menuItems, hasItem("[4] list movies"));
        assertThat(menuItems, hasItem("[5] checkout movie"));

    }

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Test
    public void testListBooksCommand() {
        int command = 1;
        libraryController.executeCommand(command);
        verify(libraryViewMock).listBooks(libraryController.getAvailableBooks());
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
        when(libraryViewMock.readInt()).thenReturn(bookIndex);
        libraryController = spy(libraryController);

        libraryController.executeCommand(command);

        verify(libraryController).checkoutBook(bookIndex);
        verify(libraryViewMock).showMessage("Please choose you book while writing the index:");
        verify(libraryViewMock).showMessage("Thank you! Enjoy the book");
    }

    @Test
    public void testUnsuccessfullCheckoutBookCommand() {
        when(libraryViewMock.readInt()).thenReturn(100);
        int command = 2;
        libraryController.executeCommand(command);

        verify(libraryViewMock).showMessage("Please choose you book while writing the index:");
        verify(libraryViewMock).showMessage("That book is not available.");
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
        when(libraryViewMock.readLine()).thenReturn("Head First Java");
        int command = 3;
        libraryController.executeCommand(command);

        verify(libraryViewMock).showMessage("Thank you for returning the book.");
    }

    @Test
    public void testUnsuccessfulReturnBookCommand() {
        when(libraryViewMock.readLine()).thenReturn("Batman");
        int command = 3;
        libraryController.executeCommand(command);

        verify(libraryViewMock).showMessage("That is not a valid book to return.");
    }

    @Test
    public void testListMoviesCommand() {
        int command = 4;
        libraryController.executeCommand(command);
        verify(libraryViewMock).listMovies(libraryController.getAvailableMovies());
    }

    @Test
    public void testCheckoutMovieCommand() {
        int command = 5;
        int movieIndex = 1;
        when(libraryViewMock.readInt()).thenReturn(movieIndex);
        libraryController = spy(libraryController);


        libraryController.executeCommand(command);
        verify(movieServiceMock).tryToCheckoutMovie(movieIndex);
        verify(libraryViewMock).showMessage("Thank you! Enjoy the movie.");
    }

    @Test
    public void testIsUserLoggedIn() {
        when(libraryViewMock.readLine()).thenReturn("000-0001").thenReturn("abcd");
        assertNotNull(libraryController.verifyLogin());
    }

    @Test
    public void testlogINUserWIthWrongCredentials() {
        when(libraryViewMock.readLine()).thenReturn("000-0001").thenReturn("blob");
        assertNull(libraryController.verifyLogin());
    }

    @Test
    public void testLoginBeforeCheckoutBook() {
        int command = 2;
        int bookIndex = 1;

        when(libraryViewMock.readInt()).thenReturn(bookIndex);
        LibraryController libraryControllerSpy = spy(libraryController);

        libraryControllerSpy.executeCommand(command);
        verify(libraryControllerSpy).verifyLogin();

    }

    @Test
    public void testLoginBeforeReturnBook() {
        int command = 3;
        int bookIndex = 1;

        when(libraryViewMock.readInt()).thenReturn(bookIndex);
        LibraryController libraryControllerSpy = spy(libraryController);

        libraryControllerSpy.executeCommand(command);
        verify(libraryControllerSpy).verifyLogin();

    }

    @Test
    public void testLoginBeforeCheckoutMovie() {
        int command = 5;
        int movieIndex = 1;

        when(libraryViewMock.readInt()).thenReturn(movieIndex);
        LibraryController libraryControllerSpy = spy(libraryController);

        libraryControllerSpy.executeCommand(command);
        verify(libraryControllerSpy).verifyLogin();

    }



}
