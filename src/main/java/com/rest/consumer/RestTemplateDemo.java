package com.rest.consumer;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.rest.consumer.model.ConsumerModel;

public class RestTemplateDemo {

	
	public static void main(String args[]) {
		
		//Post Example
		
		//URL
		String URL="http://localhost:8080/studentInfo" ;
		
		RestTemplate restTemplate = new RestTemplate();
		
		//Model object
		ConsumerModel consumerModel = new ConsumerModel();
		consumerModel.setAge(45);
		consumerModel.setEmail("sateeshkumar65@gmail.com");
		consumerModel.setName("Hello1");
		
		//Headers
		HttpHeaders headers = new HttpHeaders();

		HttpEntity requestEntityBody = new HttpEntity(consumerModel,headers);
		
		//Invoke Rest Webservice
		ResponseEntity<ConsumerModel> result =restTemplate.exchange(URL, HttpMethod.POST, requestEntityBody, ConsumerModel.class);
		System.out.println("Age is" + result.getBody().getAge());
		System.out.println("Name is" + result.getBody().getName());
		System.out.println("Email is" + result.getBody().getEmail());
		System.out.println("Id is" + result.getBody().getId());
		
		
		//GET Example
		//Model object will be populated by GET Response.
				ConsumerModel consumerModel1 = new ConsumerModel();
				consumerModel1.setId(1);
				
		
		String url ="http://localhost:8080/studentInfo/"+consumerModel1.getId();
		
		RestTemplate restTemplateObj = new RestTemplate();
		
		
		
		//HTTPHeaders
		HttpHeaders headersObj = new HttpHeaders();
		HttpEntity<ConsumerModel> requestEntityObj = new HttpEntity<ConsumerModel>(consumerModel1,headersObj);
		ResponseEntity<ConsumerModel> resultObj=restTemplateObj.exchange(url, HttpMethod.GET, requestEntityObj, ConsumerModel.class);
		System.out.println(resultObj.getBody());
		System.out.println(resultObj.getStatusCode());
		
		if(resultObj.getStatusCodeValue() == 200) {
			if(resultObj.getBody() != null) {
				System.out.println(resultObj.getBody().getAge());
				System.out.println(resultObj.getBody().getEmail());
			}
		}
		
		
		//DELETE Example
		//Model object will be populated by GET Response.
		ConsumerModel consumerModel2 = new ConsumerModel();
		consumerModel2.setId(2);
		

		String deleteUrl ="http://localhost:8080/studentInfo/delete/"+consumerModel2.getId();

		RestTemplate restTemplateObject = new RestTemplate();
		
		//HTTPHeaders
		HttpHeaders headersObject = new HttpHeaders();
		HttpEntity<ConsumerModel> requestEntityObject = new HttpEntity<ConsumerModel>(consumerModel2,headersObject);
		ResponseEntity<Void> resultObject=restTemplateObject.exchange(deleteUrl, HttpMethod.DELETE, requestEntityObject, Void.class);

		System.out.println("Delete status code is" +resultObject.getStatusCode());
		
	}
}
