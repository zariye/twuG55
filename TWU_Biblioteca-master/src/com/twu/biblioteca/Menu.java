package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by zgebru on 12/04/2017.
 */
public class Menu {

  private List<String> menuItems;

  public Menu() {
    menuItems = Arrays.asList("[1] list books");
  }

  public void drawMenu() {
    System.out.println(menuItems.get(0));
  }

  public int readInput() {
    Scanner scanner = new Scanner(System.in);
    return scanner.nextInt();
  }

}