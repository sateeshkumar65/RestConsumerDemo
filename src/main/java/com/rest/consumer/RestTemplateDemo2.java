package com.rest.consumer;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.rest.consumer.model.ConsumerModel;

public class RestTemplateDemo2 {

	public static void main(String[] args) {
      
		// postForObject method.
		
		ConsumerModel consumerModel = new ConsumerModel();
		consumerModel.setAge(11);
		consumerModel.setEmail("abcdefgh@gmail.com");
		consumerModel.setName("PostForUrl");
		
		String URL="http://localhost:8080/studentInfo";
		
		RestTemplate template = new RestTemplate();
		
		//ConsumerModel response =template.postForObject(URL, consumerModel, ConsumerModel.class);
		//System.out.println(response);
		
		// GetForObject method.
		
		String getUrl="http://localhost:8080/studentInfo/{Id}";
		
		Map<String,Integer> variables = new HashMap<String,Integer>();
		variables.put("Id", 14) ;
		
		RestTemplate templateObject = new RestTemplate();
		ConsumerModel getResponse =templateObject.getForObject(getUrl, ConsumerModel.class, variables);
		System.out.println(getResponse.getEmail());
		
		//GetForObject method to retrieve List of values.
		String getAllUrl="http://localhost:8080/studentInfo/getAll";
		
		//Map<String,Integer> variables = new HashMap<String,Integer>();
		//variables.put("Id", 14) ;
		
		RestTemplate allTemplateObject = new RestTemplate();
		ConsumerModel[] getAllResponse =allTemplateObject.getForObject(getAllUrl, ConsumerModel[].class);
		System.out.println(getAllResponse);
		if(getAllResponse != null) {
			for(ConsumerModel consumerModelObj :getAllResponse) {
				System.out.println(consumerModelObj.getAge());
				System.out.println(consumerModelObj.getName());
				System.out.println(consumerModelObj.getEmail());
			}
		}
		
		//Delete approach.
		String deleteUrl="http://localhost:8080/studentInfo/delete/{Id}";
		
		Map<String,Integer> mapVariables = new HashMap<String,Integer>();
		mapVariables.put("Id", 17) ;
		
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(deleteUrl, mapVariables);
		
		
		
		
		

	}

}
