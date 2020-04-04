package com.qa.gorest.tests;

import java.util.ArrayList;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.client.RestClient;
import com.qa.constants.constants;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetUserAPITest {
	
	String baseURI = "https://gorest.co.in";
	String basePath = "/public-api/users/";
	String token = "_FWTKt73f0EeVrfWj7d3sKoLMnw_9dqVcs0k";
	
	@Test
	public void getUserListAPITest() {
		
		Response response = RestClient.doGet("JSON", baseURI, basePath, token, true);
		Assert.assertEquals(RestClient.getStatusCode(response), constants.HTTP_STATUS_CODE_201);
		RestClient.getPrettyResponsePrint(response);
		
		
		JsonPath js = RestClient.getJsonPath(response);
		System.out.println(js.getString("-meta.message"));
		
		/*js.get("result");
		String results = js.get("result");*/
		
		ArrayList results = js.get("result");
		System.out.println(results.size());
		System.out.println(results.get(0));
		
		Map<String, Object>firstuserdata = (Map<String, Object>) results.get(0);
		for(Map.Entry<String, Object> entry : firstuserdata.entrySet())
		{
			
			System.out.println("key = "+entry.getKey() + ", value = " + entry.getKey());
		}
		
	}

}
