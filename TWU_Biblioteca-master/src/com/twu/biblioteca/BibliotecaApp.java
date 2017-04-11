package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        new BibliotecaApp().start();
    }

    private void start() {
        greetUser();
    }

    private void greetUser() {
        System.out.println("Hello user welcome to the Bibliotheka App");
    }
}
