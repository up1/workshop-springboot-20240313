package com.example.hello.customer;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CustomerCreateRequest{

	@NotBlank(message = "Can not empty")
	@Size(min = 3, max = 20, message = "The fname must be from 3 to 20 characters.")
	private String fname;

	private String lname;

	public void setFname(String fname){
		this.fname = fname;
	}

	public String getFname(){
		return fname;
	}

	public void setLname(String lname){
		this.lname = lname;
	}

	public String getLname(){
		return lname;
	}

	@Override
 	public String toString(){
		return 
			"CustomerCreateRequest{" + 
			"fname = '" + fname + '\'' + 
			",lname = '" + lname + '\'' + 
			"}";
		}
}
