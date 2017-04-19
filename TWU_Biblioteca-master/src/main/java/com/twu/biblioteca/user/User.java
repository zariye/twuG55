package com.twu.biblioteca.user;

import java.util.Objects;

/**
 * Created by zgebru on 18.04.17.
 */
public class User {

  private String ID;
  private String password;
  private boolean loggedIn;
  private String name;

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public String getNumber() {
    return number;
  }

  private String email;
  private String number;

  public User(String ID, String password) {
    this(ID, password, false, "hans", "user@info", "004917689");
  }

  public User(String ID, String password, boolean loggedIn, String name, String email, String number) {
    this.ID = ID;
    this.password = password;
    this.loggedIn = loggedIn;
    this.name = name;
    this.email = email;
    this.number = number;
  }

  @Override
  public boolean equals(Object object) {
    User user = (User)object;

    return user.ID.equals(this.ID) && user.password.equals(this.password);
  }

  public boolean isLoggedIn() {
    return loggedIn;
  }

  public void setLoggedIn(boolean loggedIn) {
    this.loggedIn = loggedIn;
  }

  public String getID() {
    return ID;
  }

  public String getPassword() {
    return password;
  }

}
