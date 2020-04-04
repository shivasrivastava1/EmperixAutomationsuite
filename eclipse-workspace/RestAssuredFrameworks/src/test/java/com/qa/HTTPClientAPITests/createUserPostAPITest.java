package com.qa.HTTPClientAPITests;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.pojo.Users;
import com.qa.util.TestUtil;

public class createUserPostAPITest {
	
	
	
	
	@Test
	public void createUserAPITest() {
		
		CloseableHttpResponse response = null;
		
		
		CloseableHttpClient httpclient = HttpClientBuilder.create().build();
		
		//1. create a Post Request with URL
		
		HttpPost postRequest = new HttpPost("https://gorest.co.in/public-api/users/");
		
		//2. Add address
		
		postRequest.addHeader("Authorization", "Bearer _FWTKt73f0EeVrfW7d3sKoLMnw_9dqVcs0k");
		//postRequest.addHeader("Content-Type,"application/json" );
		
		//3. add the Json PayLoad Body
		Users user =  new Users("Varun", "S" , "male" , "01-01-1995" , "varuns@gmail.com" , "+1-222-333-2323" , "http://www.google.com", "test address", "active");
		
		
		String entity = TestUtil.getSerializedJson(user);
		System.out.println(entity);
		
		
		StringEntity userEntity = null;
		try {
				userEntity = new StringEntity(entity);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		postRequest.setEntity(userEntity);
		
		
		
		//4. hit the api with Execute Method
		try {
			response =  httpclient.execute(postRequest);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//5. get the status code :
		
		int statusCode = response.getStatusLine().getStatusCode();
		System.out.println("status code from response: "+ statusCode);
		Assert.assertEquals(statusCode, 200);
		
		
		
		
	}
}



