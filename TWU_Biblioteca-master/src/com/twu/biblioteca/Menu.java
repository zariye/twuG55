package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zgebru on 12/04/2017.
 */
public class Menu {

  private List<String> menuItems;

  public Menu() {
    menuItems = Arrays.asList("list books");
  }

  public void drawMenu() {

    System.out.println(menuItems.get(0));
  }
}
