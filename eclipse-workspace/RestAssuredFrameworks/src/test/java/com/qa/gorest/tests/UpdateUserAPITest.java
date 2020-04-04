package com.qa.gorest.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.client.RestClient;
import com.qa.pojo.Users;

import io.restassured.response.Response;

public class UpdateUserAPITest {
	
	
	String baseURI = "https://gorest.co.in";
	String basePath = "/public-api/users/";
	String token = "_FWTKt73f0EeVrfWj7d3sKoLMnw_9dqVcs0k";
	
	
	@Test()
	public void createUserAPIPUTTest_withConstructor() {
		
		//create a user : using POST
		
	 	Users user = new Users("Ashu", "Singh", "Male", "01-01-1990","+1-994-294-0172", "ashu3@gmail.com","http://www.google.com", "test address", "active");
	 	
		System.out.println("==Creating A new User====");
	 	
		Response response =  RestClient.doPost("JSON", baseURI, basePath, token, true, user);
		System.out.println(response.getStatusCode());
		System.out.println(response.prettyPrint());
		String id = response.jsonPath().getString("result.id");
		System.out.println("new user id is "+ id);
		
		System.out.println("==========");
		
		//update the same user : using PUT :
		
		  user = new Users("Ashu", "Singh", "Male", "01-01-1990","+1-994-294-0172", "ashu3@gmail.com","http://www.google.com", "test address", "inactive");
		  Response responseupdate =  RestClient.doPUT("JSON", baseURI, basePath + "/" + id, token, true, user);
		  System.out.println(responseupdate.prettyPrint());
		  
		  String updatedId = responseupdate.jsonPath().getString("result.id");
		  Assert.assertEquals(updatedId, id);
		    
	}
	
	
	@Test()
	public void createUserAPIPUTTest_withSetter() {
		
		//create a user : using Put
		
	 	/*Users user = new Users("Ashu", "Singh", "Male", "01-01-1990","+1-994-294-0172", "ashu3@gmail.com","http://www.google.com", "test address", "active");*/
	 	
		
		
		System.out.println("==Creating A new User====");
		
		
		Users user = new Users();
		user.setFirst_name("Gulnaz");
		user.setLast_name("Musa");
		user.setGender("female");
		user.setDob("29-03-1980");
		user.setEmail("gulnaz1@gmail.com");
		user.setPhone("+1-222-333-4444");
		user.setWebsite("http://www.xyz.com");
		user.setAddress("test Address");
		user.setStatus("active");
		
		
		
		
		
	 	
		Response response =  RestClient.doPost("JSON", baseURI, basePath, token, true, user);
		System.out.println(response.getStatusCode());
		System.out.println(response.prettyPrint());
		String id = response.jsonPath().getString("result.id");
		System.out.println("new user id is "+ id);
		
		System.out.println("==========");
		
		//update the same user : using PUT :
		
		 /*user = new Users("Ashu", "Singh", "Male", "01-01-1990","+1-994-294-0172", "ashu3@gmail.com","http://www.google.com", "test address", "inactive");*/
		 
		user.setPhone("+1-999-999-8777");
		user.setStatus("inactive");
		
		 
		 Response responseupdate =  RestClient.doPUT("JSON", baseURI, basePath + "/" + id, token, true, user);
		  System.out.println(responseupdate.prettyPrint());
		  
		  String updatedId = responseupdate.jsonPath().getString("result.id");
		  Assert.assertEquals(updatedId, id);
		    
	}
	
	
	
	

}
