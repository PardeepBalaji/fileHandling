package com.example.demo8;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import jakarta.validation.Valid;

@RestController
public class UserController {

	@Autowired
	UserService service;
	
	@GetMapping("/users")
	public List<Usernew> getUser(){
		return service.getUser();
	}
	
	@PostMapping("/saveUser")
	public ResponseEntity<String> saveUser(@Valid @RequestBody Usernew user){
		return service.saveUser(user);
	}
	
	@GetMapping("/user/{Uid}")
	public Optional<Usernew> getUserById(@PathVariable("Uid") int uid){
		return service.getUserById(uid);
	}
//	public Usernew getUser(@PathVariable int Uid) {
//		Usernew user = service.getUser(Uid);
//		if(user == null)
//			throw new UserNotFoundException("User Not Found");
//		return user;
//	}
//	
		
	
//	@PutMapping("/updateUser")
//	public ResponseEntity<Object> updateUser(@RequestParam int Uid,@Valid @RequestBody Usernew user){
//		return service.updateUser(Uid, user);
//	}
	@DeleteMapping("/user/{uid}")
	public void deleteUser(@PathVariable int uid){
	       service.deleteUser(uid);
		
	}
	
	//update user 
	@PutMapping("/user/{uid}")
	public ResponseEntity<Usernew> updateuser(@PathVariable int uid,@RequestBody Usernew updateUser){
		Usernew update=service.updateUser(uid, updateUser);
		if(update!=null) {
			return ResponseEntity.ok(update);
		}
		return ResponseEntity.notFound().build();
	}}
//	@Autowired
//	private RestTemplate resttemplate;
//	private String baseURL="http://localhost:8080/hellow";
//	@GetMapping("/connect")
//public void getObject() {
//		 String response = resttemplate.getForObject(baseURL, String.class);
//
//		
//	}
//}
