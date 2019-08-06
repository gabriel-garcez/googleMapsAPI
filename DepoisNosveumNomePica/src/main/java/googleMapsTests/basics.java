package googleMapsTests;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class basics {

	@Test
public void getPlaceAPI()
{

		//BaseURL or Host
		RestAssured.baseURI="https://maps.googleapis.com";
		
        RequestSpecification httpRequest = RestAssured.given().
        		param("location","-33.8670522,151.1957362").
 		        param("radius","500").
 		        param("key","AIzaSyDIQgAh0B4p0SdyYkyW8tlG-y0yJMfss5Y");
		
		Response response = httpRequest.request(Method.GET, "/maps/api/place/nearbysearch/json");
		JsonPath jsonPathEvaluator = response.jsonPath();
		
		//Take the fields that you want to validate
		String city = jsonPathEvaluator.get("results[0].name");
		String place_id = jsonPathEvaluator.get("results[0].place_id");
		int statusCode = response.getStatusCode();
		
		//Validate them 
		Assert.assertEquals(statusCode, 200);
		Assert.assertEquals(city, "Sydney");
		Assert.assertEquals(place_id, "ChIJP3Sa8ziYEmsRUKgyFmh9AQM");
		
			       
}

}
