package com.exam.examserver.CustomException;

public class userFoundException  extends Exception{
	
	public userFoundException(String msg)
	{
		 
	}
	
	public String getMessage()
	{
		String str="user with this UserName already present";
		return str;
	}

	@Override
	public String toString() {
		return "userFoundException []"+getMessage();
	}
	
	

}
