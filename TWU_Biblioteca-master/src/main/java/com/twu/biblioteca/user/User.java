package com.twu.biblioteca.user;

import java.util.Objects;

/**
 * Created by zgebru on 18.04.17.
 */
public class User {

  public String getID() {
    return ID;
  }

  public String getPassword() {
    return password;
  }

  private String ID;
  private String password;
  private boolean loggedIn;

  public User(String ID, String password) {
    this.ID = ID;
    this.password = password;
    this.loggedIn = false;
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
}
