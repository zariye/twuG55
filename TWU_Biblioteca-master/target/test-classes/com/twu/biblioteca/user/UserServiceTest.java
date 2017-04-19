package com.twu.biblioteca.user;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Created by zgebru on 18.04.17.
 */
public class UserServiceTest {

  private UserService userService;

  @Before
  public void setUp() {
    userService = new UserService();
  }

  @Test
  public void testValidUser() {
    assertTrue( userService.verifyUser("000-0004", "lolo"));
  }

  @Test

  public void testLogin() {
    User user = userService.getUserById("000-0004");

    assertFalse(user.isLoggedIn());
    userService.login(user.getID(), user.getPassword());

    assertEquals(user, userService.getCurrentUser());

    assertTrue(user.isLoggedIn());
  }

  @Test
  public void testShowUserInfo() {
    userService.login("000-0003", "lala");
    assertEquals("hans: user@info, 004917689", userService.getUserInfo());
  }
}
