package com.qa.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestUtil {
	
	/**
	 * this method is used to conver pojo to json string
	 * @param obj
	 * @return
	 */
	

	public static String getSerializedJson(Object obj) {
	
		String jsonString = null;
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			jsonString = mapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return jsonString;
		}
		
		
		return jsonString;
	}
	
	
	
	
	
}
