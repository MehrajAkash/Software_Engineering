# Software_Engineering

package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class testClass {
	
	private UserRegistration regi;
	private User user;
	
	@BeforeEach
	void setUp(){
		regi = new UserRegistration();
		user = new User("Mehraj", "mehraj@gmail.com", "23456");
		
	}

	@Test
	void addValidUser() {
		assertTrue(regi.addUser(user));
	}
	
	@Test
	void addNullUser() {
		IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, ()->regi.addUser(null));
		
		assertEquals("User cannot be null", ex.getMessage());
	}
	
	@Test
	void addEmptyName() {
		User u = new User("", "akah@gmail.com", "35");
		IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, ()->regi.addUser(u));
		assertEquals("Name cannot be null", ex.getMessage());
	}
	
	@Test
	void FindUser() {
		
		User us = new User("meh", "meh@gmail", "3445");
		regi.addUser(us);
		
		assertFalse(regi.login("akash","333"));
		
		assertNotNull( regi.findUser("meh@gmail") );
	
	}
	
	@Test
	void findUser_WhenEmailIsEmpty_ThrowsIllegalArgumentException() {
	    assertThrows(IllegalArgumentException.class, () -> {
	        regi.findUser("");
	    });
	}
	
	
	
	
	

}
