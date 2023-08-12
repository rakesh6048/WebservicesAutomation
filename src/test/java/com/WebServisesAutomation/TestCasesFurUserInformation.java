package com.WebServisesAutomation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class TestCasesFurUserInformation {
	
	
	@Test(priority=1)
	public void test_getAllUserDetails() {
		
		
	Response response = given()
	     .param("page", "2")
	     .auth().none()
	
	.when()
	    .get("https://reqres.in/api/users");
	    
	    //.then()
	      //   .statusCode(200)
	        // .body("page", equalTo(2));
	    
	   // response.getTime();
	   // response.getTimeIn(TimeUnit.SECONDS);
	  //  response.time();
	  //  response.timeIn(TimeUnit.SECONDS);
	    
	    System.out.println("1-Time is " +response.getTime());
	    System.out.println("2-Time is " +response.getTimeIn(TimeUnit.SECONDS));
	    System.out.println("3-Time is " +response.time());
	    System.out.println("4-Time is " +response.timeIn(TimeUnit.SECONDS));
	}
	
	//@Test(priority = 2)
	public void test_createUserData() {
		
	  HashMap data =new HashMap();
	  
	  data.put("name", "Rakesh");
	  data.put("job", "Associate Manager");
	  
	  Response res=
			 given()
			    .contentType("application/json")
			    .body(data)
			 .when()
			     .post("https://reqres.in/api/users")
			      
			  .then()
			      .statusCode(200)
			      .log().body()
			      .extract().response();
	  
	     String jsonString = res.asString();
	     System.out.println(jsonString);
	     Assert.assertEquals(jsonString.contains("user created successfully"), true);
	}
	
	//@Test(priority = 3)
    public void test_getParticularUser() {
		
		given()
		
		.when()
		   .get("https://reqres.in/api/users/2")
		   
		.then()
		    .statusCode(200)
		    .log().body();
		   // .body("data.id", equals(""))
		   // .body("data.name", equals("Janet"))
		    
		   
	}
	
	//@Test(priority = 4)
	public void test_UpdateUser() {
		
		HashMap data = new HashMap();
		
		data.put("name", "Sohan");
		data.put("job", "Lead");
		
		given()
		    .contentType("application/json")
		    .body(data)
		.when()
		    .put("https://reqres.in/api/users/2")
		 .then()
		     .statusCode(200)
		     .log().body();
		  //.body("data.name", equals("rakesh"))
		// .body("data.job", equals("IT"))
	}
	
	//@Test(priority = 5)
	public void test_DeleteUser() {
		
		Response res=
		given()
		  .when()
		      .delete("https://reqres.in/api/users/2")
		   .then()
		      .statusCode(200)
		      .log().body()
		      .extract().response();
		      
		 String jsonString = res.asString();
		 //Assert.assertEquals(jsonString.contains(jsonString), true);
		
	}
	
}
