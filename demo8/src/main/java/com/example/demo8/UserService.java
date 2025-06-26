package com.example.demo8;

//import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

//	List<Usernew> userList = new ArrayList<Usernew>();
	
	@Autowired
	private UserRepository UR;
	public List<Usernew> getUser(){
//		return userList;
		return UR.findAll();
	}
	
	public ResponseEntity<String> saveUser(Usernew user){
//		userList.add(user);
		UR.save(user);
		
		return ResponseEntity.ok("User is created");
	}
	
//	public Usernew getUser(int Uid) {
//		for(Usernew user : userList) {
//			if(user.getUid() == Uid) {
//				return user;
//			}
//		}
//		return null;
//	}
	public Optional <Usernew> getUserById(int uid){
		return UR.findById(uid);
	}
	
//	public ResponseEntity<Object> updateUser(int Uid,Usernew user){
////		for(Usernew u : userlist) {
//		for(Usernew u : UR) {
//			if(user.getUid() == Uid) {
//				u.setUname(user.getUname());
//			}
//		}
//		return ResponseEntity.ok("Updated");
//	}

//	
	
//	public Optional <Usernew>
	public void deleteUser(int uid) {
		UR.deleteById(uid);
	}
	
	// Update Employee
    public Usernew updateUser(int uid, Usernew updateUser) {
        Optional<Usernew> Option = UR.findById(uid);
        if (Option.isPresent()) {
            Usernew User = Option.get();
            User.setUname(updateUser.getUname());
            User.setUlocation(updateUser.getUlocation());
            return UR.save(User);
        }
        return null;
    }

	
    
}
