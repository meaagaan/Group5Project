package mochi;

import static org.junit.Assert.*;
import org.junit.Test;

public class UserTest {
	public UserTest() {
		User user = new User();
	}

	@Test
	// Test if the username is modified correctly.
	public void checkUsername() {
		User.setUsername("username");
		assertEquals("username", User.getUsername());
	}

	@Test
	public void checkFirstname() {
		User.setFirstname("firstname");
		assertEquals("firstname", User.getFirstname());
	}

	@Test
	public void checkLastname() {
		User.setLastname("lastname");
		assertEquals("lastname", User.getLastname());
	}

	@Test
	public void checkEmail() {
		User.setEmail("email");
		assertEquals("email", User.getEmail());
	}

	@Test
	public void checkVerified() {
		User.setVerified(1);
		assertEquals(1, (int)User.getVerified());
	}
}