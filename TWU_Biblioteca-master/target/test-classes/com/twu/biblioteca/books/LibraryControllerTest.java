package com.twu.biblioteca.books;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;

/**
 * Created by buzzer on 13.04.17.
 */
public class LibraryControllerTest {

    LibraryController libraryController;

    @Mock
    LibraryViewInterface libraryView;

    @Before
    public void setup() {
        libraryController = new LibraryController(libraryView);
    }

    @Test
    public void testGetMenuItems() {
        List<String> menuItems = libraryController.getMenuItems();
        assertThat(menuItems, CoreMatchers.hasItem("[0] quit"));
        assertThat(menuItems, CoreMatchers.hasItem("[1] list books"));
        assertThat(menuItems, CoreMatchers.hasItem("[2] checkout"));
        assertThat(menuItems, CoreMatchers.hasItem("[3] return book"));
    }

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();


    @Test
    public void testListBooksCommand() {
        int command = 1;
        libraryController.executeCommand(command);
        verify(libraryView).listBooks(new BookService().getAvailableBooks());
    }




}
