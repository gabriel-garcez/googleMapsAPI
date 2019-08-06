package googleMapsTests;

import java.io.FileInputStream;

import googleAPIResources.Path;
import googleAPIResources.ReusableMethods;
import googleAPIResources.payLoad;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


import org.apache.logging.log4j.*;


import org.json.simple.JSONObject;
import org.testng.Assert;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import googleMapsTests.basics3;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


//@SuppressWarnings("unused")
public class basics3  {
	
	private static Logger log =LogManager.getLogger(basics3.class.getName());
	//Bring the txt document variabes
	Properties prop = new Properties();
	@BeforeTest
	public void getData() throws IOException {
		
		FileInputStream info = new FileInputStream("C:\\Users\\Gabriel Garcez\\eclipse-workspace\\DepoisNosveumNomepica\\src\\main\\java\\googleAPIResources\\info.properties");
		prop.load(info);
	}

	@Test
	public void AddandDeletePlace()
	{
		
		//Task 1- Grab the response
		log.info(prop.getProperty("HOST"));
		RestAssured.baseURI= prop.getProperty("HOST");
		RequestSpecification request = RestAssured.given().
		queryParam("key",prop.getProperty("KEY"));
		
		

		request.header("Content-Type", "application/json");
		request.body(payLoad.getPostData().toJSONString());
		Response response = request.post(Path.placePostPath());
				
		//Get Response 
		JsonPath jsonPathEvaluator = ReusableMethods.rawToJson(response);
		log.info(jsonPathEvaluator);
		
	
		////Take the fields that you want to validate
		int statusCode = response.getStatusCode();
		String status = jsonPathEvaluator.get("status");
				
		//Validate them
		Assert.assertEquals(status, "OK");
		Assert.assertEquals(statusCode, 200);
		
				
		// Task 2- Grab the Place ID from response
		
		String responseString = response.asString();
		JsonPath js = new JsonPath(responseString);
		String placeid = js.get("place_id");
		log.info(placeid);
		
		
		//Task 3 place this place id in the Delete request
		RequestSpecification requestDelete = RestAssured.given().
		
		given().
		queryParam("key", prop.getProperty("KEY"));
		
		requestDelete.header("Content-Type", "application/json");
		requestDelete.body(payLoad.getDeleteData(placeid).toJSONString());
		
		Response responseDelete= request.post(Path.placeDeletePath());
		JsonPath jsonPathEvaluatorDelete = response.jsonPath();
		
		
		//Show Response
		String responseStringDelete = response.asString();
		System.out.println(responseStringDelete);
		System.out.println(responseStringDelete);
		
		////Take the fields that you want to validate
		int statusCodeDelete = responseDelete.getStatusCode();
		String StringDelete = jsonPathEvaluatorDelete.get("status");
		
		//Validate them
		Assert.assertEquals(StringDelete, "OK");
		Assert.assertEquals(statusCodeDelete, 200);

		
	}
}
