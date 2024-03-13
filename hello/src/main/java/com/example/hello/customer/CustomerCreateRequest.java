package com.example.hello.customer;

public class CustomerCreateRequest{
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
