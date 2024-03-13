package com.example.hello.customer;

public class CustomerResponse{
	private String fullName;
	private int id;

	public void setFullName(String fullName){
		this.fullName = fullName;
	}

	public String getFullName(){
		return fullName;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"CustomerResponse{" + 
			"full_name = '" + fullName + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}
