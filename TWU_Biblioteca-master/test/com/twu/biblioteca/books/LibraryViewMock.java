package com.twu.biblioteca.books;

import java.util.List;

/**
 * Created by buzzer on 13.04.17.
 */
public class LibraryViewMock implements LibraryViewInterface {

    private int intInput;

    private String stringInput;

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void listBooks(List<Book> books) {

    }

    @Override
    public void drawMenu(List<String> menuItems) {

    }

    @Override
    public int readInt() {
        return intInput;
    }

    @Override
    public String readLine() {
        return stringInput;
    }

    public int getIntInput() {
        return intInput;
    }

    public void setIntInput(int intInput) {
        this.intInput = intInput;
    }

    public String getStringInput() {
        return stringInput;
    }

    public void setStringInput(String stringInput) {
        this.stringInput = stringInput;
    }
}
