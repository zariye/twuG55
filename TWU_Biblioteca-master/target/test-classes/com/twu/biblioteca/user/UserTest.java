package com.twu.biblioteca.user;

import com.twu.biblioteca.user.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;

/**
 * Created by zgebru on 18.04.17.
 */
public class UserTest {

  private User user;

  @Before
  public void setUp() {
    user = new User("000-0001", "abcdef");
  }

  @Test
  public void testIsLoggedIn() {
    assertFalse(user.isLoggedIn());
  }
}
