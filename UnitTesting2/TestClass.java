package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserRegistrationTest {

    private UserRegistration registration;
    private User user;

    @BeforeEach
    void setUp() {
        registration = new UserRegistration();
        user = new User("Akash", "akash@gmail.com", "12345");
    }

    // Test 1: Add a valid user
    @Test
    void testAddValidUser() {
        assertTrue(registration.addUser(user));
    }

    // Test 2: Add null user
    @Test
    void testAddNullUser() {
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> registration.addUser(null));

        assertEquals("User cannot be null", ex.getMessage());
    }

    // Test 3: Add user with empty name
    @Test
    void testAddUserWithEmptyName() {
        User u = new User("", "john@gmail.com", "123");

        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> registration.addUser(u));

        assertEquals("Name cannot be empty", ex.getMessage());
    }

    // Test 4: Add user with empty email
    @Test
    void testAddUserWithEmptyEmail() {
        User u = new User("John", "", "123");

        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> registration.addUser(u));

        assertEquals("Email cannot be empty", ex.getMessage());
    }

    // Test 5: Add user with empty password
    @Test
    void testAddUserWithEmptyPassword() {
        User u = new User("John", "john@gmail.com", "");

        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> registration.addUser(u));

        assertEquals("Password cannot be empty", ex.getMessage());
    }

    // Test 6: Search existing user
    @Test
    void testFindExistingUser() {
        registration.addUser(user);

        User found = registration.findUser("akash@gmail.com");

        assertNotNull(found);
        assertEquals("Akash", found.getName());
        assertEquals("akash@gmail.com", found.getEmail());
    }

    // Test 7: Search non-existing user
    @Test
    void testFindNonExistingUser() {
        User found = registration.findUser("unknown@gmail.com");

        assertNull(found);
    }

    // Test 8: Search with empty email
    @Test
    void testFindUserWithEmptyEmail() {
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> registration.findUser(""));

        assertEquals("Email field is empty", ex.getMessage());
    }

    // Test 9: Login success
    @Test
    void testLoginSuccess() {
        registration.addUser(user);

        assertTrue(registration.login("akash@gmail.com", "12345"));
    }

    // Test 10: Login with wrong password
    @Test
    void testLoginWrongPassword() {
        registration.addUser(user);

        assertFalse(registration.login("akash@gmail.com", "wrongpass"));
    }

    // Test 11: Login with unknown email
    @Test
    void testLoginUnknownEmail() {
        assertFalse(registration.login("abc@gmail.com", "12345"));
    }

    // Test 12: Login with empty email
    @Test
    void testLoginWithEmptyEmail() {
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> registration.login("", "12345"));

        assertEquals("Email cannot be empty", ex.getMessage());
    }

    // Test 13: Login with empty password
    @Test
    void testLoginWithEmptyPassword() {
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> registration.login("akash@gmail.com", ""));

        assertEquals("Password cannot be empty", ex.getMessage());
    }
}




























/*

package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestClass {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
*/