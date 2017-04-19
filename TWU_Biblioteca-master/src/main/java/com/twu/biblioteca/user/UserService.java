package com.twu.biblioteca.user;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zgebru on 18.04.17.
 */
public class UserService {

  private List<User> users;

  private User currentUser;

  public UserService() {
    users = new ArrayList<>();

    users.add(new User("000-0001", "abcd"));
    users.add(new User("000-0002", "xyz"));
    users.add(new User("000-0003", "lala"));
    users.add(new User("000-0004", "lolo"));
    users.add(new User("000-0005", "star"));
    currentUser = null;
  }


  public User getUserById(String ID) {
    for(User user : users) {
      if (user.getID().equals(ID)) {
        return user;
      }
    }
    return null;
  }

  public void login(String ID, String password) {
    if(verifyUser(ID, password)) {
      currentUser = getUserById(ID);
      currentUser.setLoggedIn(true);
    }
  }

  public boolean verifyUser(String ID, String password) {
    User user = getUserById(ID);
    return user != null && user.getPassword().equals(password);
  }

  public User getCurrentUser() {
    return currentUser;
  }

  public String getUserInfo() {
    return currentUser != null ? currentUser.getName() + ": " + currentUser.getEmail() + ", " + currentUser.getNumber() : null;

  }
}
