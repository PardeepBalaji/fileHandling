package com.example.demo8;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
@Entity
@Table(name="user_table")
public class Usernew {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int uid;
	@NotBlank(message = "Name Should Not Be Empty or Null")
	private String uname;
	private String ulocation;
		// TODO Auto-generated constructor stub
	
	public Usernew(Object object, String string, String string2) {
		// TODO Auto-generated constructor stub
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public   String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUlocation() {
		return ulocation;
	}
	public void setUlocation(String ulocation) {
		this.ulocation = ulocation;
	}
//	public Usernew(int uid, String uname, String ulocation) {
//		this.uid = uid;
//		this.uname = uname;
//		this.ulocation = ulocation;
//	}

	

}
