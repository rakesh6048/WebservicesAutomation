package com.WebServisesAutomation;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;

public class PostAPIUsingPojo {

	public static void main(String[] args) {

		EmployeePojo emp = new EmployeePojo("morpheus", "leader", new String[] {"java", "c"}, "XYZ", "morpheus@xyz.com");
		
	 Response postResponse = given()
				                .auth().none()
				                .header("Content-Type","appliaction/json")
				                .contentType(ContentType.JSON)
				                .when()
				                .body(emp).log().all()
				                .post("https://reqres.in/api/users");
	 
	                           //Vrify the header
	                            postResponse.getHeaders();
	                            System.out.println("All the headers are " +postResponse.getHeaders());
	                            System.out.println("Header-Content-Type " +postResponse.header("Content-Type"));
	                            System.out.println("Header-Date " +postResponse.header("Date"));
	                            
	                            System.out.println("All the cookies are " +postResponse.getCookies());
	                            System.out.println("All the Content Type are " +postResponse.getContentType());
	                            
	                            
	 
	                             Assert.assertEquals(postResponse.getBody().path("name"), "morpheus");
	                             Assert.assertEquals(postResponse.getBody().path("job"), "leader");
	                             Assert.assertEquals(postResponse.getBody().path("skills[0]"), "java");
	                             Assert.assertEquals(postResponse.getBody().path("skills[1]"), "c");
	                             Assert.assertEquals(postResponse.getBody().path("details.companyName"), "xyz");
	                             Assert.assertEquals(postResponse.getBody().path("details.emailId"), "morpheus@xyz.com");
	                             
	                             Assert.assertEquals(postResponse.jsonPath().get("name"), "morpheus");
	                             Assert.assertEquals(postResponse.jsonPath().get("job"), "leader");
	                             Assert.assertEquals(postResponse.jsonPath().get("kills[0]"), "java");
	                             Assert.assertEquals(postResponse.jsonPath().get("skills[1]"), "c");
	                             Assert.assertEquals(postResponse.jsonPath().get("details.companyName"), "xyz");
	                             Assert.assertEquals(postResponse.jsonPath().get("details.emailId"), "morpheus@xyz.com");
	                             
		                        /*.then().log().all()
		                        .body("name", equalTo("morpheus"), 
		                        	  "job" ,equalTo("leader"), 
		                        	  "skills[0]", equalTo("java"), 
		                        	  "skills[1]", equalTo("c"), 
		                        	  "details.companyName", equalTo("XYZ"), 
		                        	  "details.emailId", equalTo("morpheus@xyz.com"));*/
		                        
		                        
	}

}
