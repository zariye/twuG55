package com.twu.biblioteca;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by zgebru on 12/04/2017.
 */
public class Menu {

  private List<String> menuItems;

  Menu() {
    menuItems = Arrays.asList("[0] quit", "[1] list books", "[2] checkout", "[3] return book");
  }

  void drawMenu() {
    for (String item : menuItems) {
      System.out.println(item);
    }
  }

  int readInput() {
    Scanner scanner = new Scanner(System.in);
    return scanner.nextInt();
  }

}