
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
		
		
		
		
		
	}

}
