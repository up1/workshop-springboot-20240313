package com.example.hello.customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CustomerCreateRequest{
	@NotNull
	private String fname;

	@NotNull
	@Size(min = 3, max = 20)
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
