package com.qa.HTTPClientAPITests;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;

public class goRestGetUserAPITest {

	
	@Test
	public void goRestGetUserAPITest() {
		
		CloseableHttpResponse response = null;
		
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		
		
		//1. Create a get request with URL
		HttpGet getRequest = new HttpGet("https://gorest.co.in/public-api/users");
		
		//2. Add address
		
		getRequest.addHeader("Authorization", "Bearer _FWTKt73f0EeVrfW7d3sKoLMnw_9dqVcs0k");
		
		//3. execute the API
		
		try {
			response = httpClient.execute(getRequest);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int statusCode = response.getStatusLine().getStatusCode();
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200);
		
		
	}
	
}
