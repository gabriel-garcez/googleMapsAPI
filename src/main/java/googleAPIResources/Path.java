package googleAPIResources;

public class Path {

	public static String placePostPath() {
		
		String res = "/maps/api/place/add/json";
		return res;
	}
	
   public static String placeDeletePath() {
		
		String res = "/maps/api/place/delete/json";
		return res;
	}
   
   public static String placePostXMLPath() {
		
 		String res = "/maps/api/place/add/xml";
 		return res;
 	}
   
   public static String nearbysearchPath() {
		
 		String res = "/maps/api/place/nearbysearch/json";
 		return res;
 	}
   
   
 
}
