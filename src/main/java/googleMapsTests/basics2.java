package googleMapsTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.Matchers.equalTo;
import org.json.simple.JSONObject;

public class basics2 {

	
	@Test
	public void createPlaceAPI()
	{
		RestAssured.baseURI="http://216.10.245.166";
		RequestSpecification request = RestAssured.given().
				queryParam("key","20qaclick123");
		
		request.header("Content-Type", "application/json");
		JSONObject requestParams = new JSONObject();
		
		JSONObject list = new JSONObject();
        list.put("lat", -33.8669710);
        list.put("lng", 151.1958750);
        requestParams.put("location", list);
        
		requestParams.put("accuracy", 50);		 
		requestParams.put("name", "Google Shoes!");
		requestParams.put("phone_number", "(02) 9374 4000)");
		requestParams.put("address",  "48 Pirrama Road, Pyrmont, NSW 2009, Australia");
		requestParams.put("types",  "shoe_store");
		requestParams.put("website",  "http://www.google.com.au/");
		requestParams.put("language",  "en-AU");
		
		request.body(requestParams.toJSONString());
		
		Response response = request.post("/maps/api/place/add/json");
			
		//Show Response
		String responseString = response.asString();
		System.out.println(responseString);
		
		
		//Take the fields that you want to validate
		int statusCode = response.getStatusCode();
		
		//Validate them 
		Assert.assertEquals(statusCode, 200);
			
	}
}
