package com.example.hello.customer;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class CustomerCreateRequest{

	@NotBlank(message = "Can not empty")
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
