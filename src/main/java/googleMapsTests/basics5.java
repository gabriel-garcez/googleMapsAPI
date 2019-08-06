package googleMapsTests;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import googleAPIResources.Path;
import googleAPIResources.ReusableMethods;
import googleAPIResources.URLs;

public class basics5 {

	@Test
public void extractingNamesAPI()
{
		// TODO Auto-generated method stub

		//BaseURL or Host
		RestAssured.baseURI=URLs.baseURLGoogleMaps();
		
		// Given
		Response response = given().
		       param("location","-33.8670522,151.1957362").
		       param("radius","500").
		       param("key","AIzaSyDIQgAh0B4p0SdyYkyW8tlG-y0yJMfss5Y").
		       when(). //when
		       get(Path.nearbysearchPath()).
		       then(). //then
		       assertThat().statusCode(200).and(). //validate staus code
		       body("results[0].name",equalTo("Sydney")).and(). //validations
		       body("results[0].place_id", equalTo("ChIJP3Sa8ziYEmsRUKgyFmh9AQM")).and().
		       extract().response(); //Mostra o Response
		
           //Get the response to interact		
		   JsonPath jsonPathEvaluator = ReusableMethods.rawToJson(response);
		   
		   //Get the nearby Places in the response
		   int count = jsonPathEvaluator.get("results.size()");
		   for(int i=0;i<count;i++) {
			  System.out.println(jsonPathEvaluator.get("results["+i+"].name"));
		   }
		   System.out.println(count);	    
		       
}

}
