package googleAPIResources;

import org.json.simple.JSONObject;

public class payLoad {

	
	public static JSONObject getPostData() {
	
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
		
		return requestParams;		
	}
	
	public static JSONObject getDeleteData(String place_id) {
		
	    JSONObject requestParams = new JSONObject();		    
		requestParams.put("place_id", place_id);			
		return requestParams;		
	}
	
	
}
