package googleMapsTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import googleAPIResources.Path;
import googleAPIResources.ReusableMethods;
import googleAPIResources.URLs;

import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.Matchers.equalTo;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
public class basics4 {

	
	@Test
	public void postDataXML() throws IOException {
		
		String postdata = ReusableMethods.GenerateStringFromResource("C:\\Users\\Gabriel Garcez\\eclipse-workspace\\RESTAssuredTest2\\src\\main\\java\\googleAPIResources\\postData.xml");
		
		//Base URL
		RestAssured.baseURI=URLs.baseURL();
		
		//Request - Params, Header, Body and Method
		RequestSpecification request = RestAssured.given().
		queryParam("key","AIzaSyDIQgAh0B4p0SdyYkyW8tlG-y0yJMfss5Y");		
		request.header("Content-Type", "application/xml");
		request.body(postdata);
		Response response = request.post(Path.placePostXMLPath());
		
		//Get Response
		XmlPath xmlPathEvaluator = ReusableMethods.rawToXML(response);
		System.out.println(xmlPathEvaluator);
		
		//Take and Validate the fields that you want to validate
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		String placeid = xmlPathEvaluator.get("PlaceAddResponse.place_id");
		
}
	
}
