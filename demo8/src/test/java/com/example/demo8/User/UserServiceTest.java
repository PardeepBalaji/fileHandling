package com.example.demo8.User;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import com.example.demo8.UserRepository;
import com.example.demo8.UserService;
import com.example.demo8.Usernew;

public class UserServiceTest {
	
	@InjectMocks
	private UserService Userservice;
	
	@Mock
	private UserRepository userrepository;

//	@BeforeEach
//	public void setup() {
//		MockitoAnnotations.openMocks(this);
//	}
	  private Usernew user1;
	    private Usernew user2;

	    @BeforeEach
	    public void setUp() {
	        // Create some sample Usernew objects
	        user1 = new Usernew(1, "John Doe", "john.doe@example.com");
	        user2 = new Usernew(2, "Jane Doe", "jane.doe@example.com");
	    }
	    @Test
	    public void testGetUser() {
	        // Arrange: Mock the UserRepository to return a list of users
	        when(userrepository.findAll()).thenReturn(Arrays.asList(user1, user2));

	        // Act: Call the method we want to test
	        List<Usernew> users = Userservice.getUser();

	        // Assert: Check that the result is correct
	        assertNotNull(users);
	        assertEquals(2, users.size());
	        assertEquals("John Doe", users.get(0).getUname());
	        assertEquals("Jane Doe", users.get(1).getUname());
	    }
}
