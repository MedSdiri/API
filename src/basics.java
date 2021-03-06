
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.Assert;
import files.*;

public class basics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
// validate if add place API is working as expected 
		
		//GIVEN - all input details
		//WHEN- submit the API, HTTP method and resource goes under the WHEN ALWAYS
		// THEN - Validate the response 
		
		// Add - place -> Update Place with new Address 
				//-> Get place to validate if the new address is present in response
		
		RestAssured.baseURI= "https://rahulshettyacademy.com";
	
		String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
		.body(payload.AddPlace()).when().post("maps/api/place/add/json")
		.then().assertThat().statusCode(200).body("scope", equalTo("APP"))
		.header("Server","Apache/2.4.18 (Ubuntu)" ).extract().response().asString();
		

		//System.out.println(response);
		
		JsonPath js = Utilities.rawToJson(response);
		String placeId = js.getString("place_id"); //for parsing Json 
		
	
		System.out.println(placeId);
		
		// Update place
		
		String newAddress ="Collins St, Alrington, Tx";
		
       given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
        .body("{\r\n"
        		+ "\"place_id\":\""+placeId+"\",\r\n"
        		+ "\"address\":\""+newAddress+"\",\r\n"
        		+ "\"key\":\"qaclick123\"\r\n"
        		+ "}").
        when().put("maps/api/place/update/json")
        .then().assertThat().log().all().statusCode(200).body("msg", equalTo("Address successfully updated"));
       
        //Get place 
		System.out.println("++++++++++++++++---+++++++++++++");

		String getPlaceResponse =given().log().all().queryParam("key", "qaclick123")
		.queryParam("place_id", placeId)
		.when().get("maps/api/place/get/json")
		.then().assertThat().log().all().statusCode(200).extract().response().asString();
		
		JsonPath js1 = Utilities.rawToJson(getPlaceResponse);
		String actualAddress = js1.getString("address");
		
		System.out.println(actualAddress);
		
		Assert.assertEquals(actualAddress, newAddress, "you Failed Call RAMIZ the SM");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
