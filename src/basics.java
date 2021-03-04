
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import files.payload;

public class basics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
// validate if add place API is working as expected 
		
		//GIVEN - all input details
		//WHEN- submit the API, HTTP method and resource goes under the WHEN ALWAYS
		// THEN - Validate the response 
		
		RestAssured.baseURI= "https://rahulshettyacademy.com";
	
		given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
		.body(payload.AddPlace()).when().post("maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP"))
		.header("Server","Apache/2.4.18 (Ubuntu)" );
		
		// Add - place -> Update Place with new Address 
		//-> Get place to validate if the new address is present in response
		// 03/03/2021 2:07 am, we will finish this work tomorrow
		//calling it for the night ? btw this is tomorrow but we didn't finish this work lol
		// we focused a bit on databases with the group we will get back here tomorrow yes if we are not in 
		//yesterday's tomorrow now it will be tomorrow's tomorrow we will finish this stuff up 
		//just felt like typing some stuff here and use the git bash to send it to my remote repo
		//so if u are reading this and laughing already thinking that I'm crazy !!
		//you bett ure ass I'm crazy allez bonne nuit les amis @ demain :D 
		
		
		
		
		
	}

}
