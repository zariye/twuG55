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
        when(libraryViewMock.readLine()).thenReturn("000-0001").thenReturn("abcd");

        libraryController = spy(libraryController);

        libraryController.executeCommand(command);

        verify(libraryController).checkoutBook(bookIndex);
        verify(libraryViewMock).showMessage("Please choose you book while writing the index:");
        verify(libraryViewMock).showMessage("Thank you! Enjoy the book");
    }

    @Test
    public void testUnsuccessfullCheckoutBookCommand() {
        when(libraryViewMock.readInt()).thenReturn(100);
        when(libraryViewMock.readLine()).thenReturn("000-0001").thenReturn("abcd");

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
        when(libraryViewMock.readLine()).thenReturn("000-0001").thenReturn("abcd").thenReturn("Head First Java");

        int command = 3;
        libraryController.executeCommand(command);

        verify(libraryViewMock).showMessage("Thank you for returning the book.");
    }

    @Test
    public void testUnsuccessfulReturnBookCommand() {
        when(libraryViewMock.readLine()).thenReturn("Batman");
        when(libraryViewMock.readLine()).thenReturn("000-0001").thenReturn("abcd");

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
        when(libraryViewMock.readLine()).thenReturn("000-0001").thenReturn("abcd");

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

    private void checkLogin(int command) {

        LibraryController libraryControllerSpy = spy(libraryController);

        libraryControllerSpy.executeCommand(command);
        verify(libraryControllerSpy).verifyLogin();
    }

    private LibraryController setUpUnsuccessfulLogin(int command) {
        when(libraryViewMock.readLine()).thenReturn("000-0001").thenReturn("blob");
        LibraryController libraryControllerSpy = spy(libraryController);
        libraryControllerSpy.executeCommand(command);
        return libraryControllerSpy;
    }

    @Test
    public void testLoginBeforeCheckoutBook() {
        checkLogin(2);
    }

    @Test
    public void testLoginBeforeReturnBook() {
        checkLogin(3);
    }

    @Test
    public void testLoginBeforeCheckoutMovie() {
        checkLogin(5);
    }

    @Test
    public void unsuccessfulLoginShouldDoNothingForCheckoutBook(){
        int bookIndex = 1;
        LibraryController libraryControllerSpy = setUpUnsuccessfulLogin(2);
        verify(libraryControllerSpy, never()).checkoutBook(bookIndex);
    }

    @Test
    public void unsuccessfulLoginShouldDoNothingForReturnBook(){
        LibraryController libraryControllerSpy = setUpUnsuccessfulLogin(3);
        verify(libraryControllerSpy, never()).returnBook(null);
    }

    @Test
    public void unsuccessfulLoginShouldDoNothingForCheckoutMovie(){
        libraryController.executeCommand(5);
        verify(movieServiceMock, never()).tryToCheckoutMovie(0);
    }


}
