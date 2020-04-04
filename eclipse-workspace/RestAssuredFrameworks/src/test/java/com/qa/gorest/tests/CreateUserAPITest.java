package com.qa.gorest.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.client.RestClient;
import com.qa.pojo.Users;
import com.qa.util.ExcelUtil;

import io.restassured.response.Response;

public class CreateUserAPITest {
	
	String baseURI = "https://gorest.co.in";
	String basePath = "/public-api/users/";
	String token = "_FWTKt73f0EeVrfWj7d3sKoLMnw_9dqVcs0k";
	
	
	
	@DataProvider
	
	public Object[][] getUserData() {
		
		Object userData[][] = ExcelUtil.getTestData("createuser");
		return userData;
		
	}
	
	
	@Test(dataProvider = "getUserData")
	public void createUserAPIPOSTTest(String firstname, String lastname, String gender, String dob, String mail, String phonenumber, String website, String address, String status) {
		
		Users user = new Users(firstname, lastname,  gender, dob,  mail, phonenumber,  website,  address, status);	
		Response response =  RestClient.doPost("JSON", baseURI, basePath, token, true, user);
		System.out.println(response.getStatusCode());
		System.out.println(response.prettyPrint());
		
	}
	
	
	
	

}
