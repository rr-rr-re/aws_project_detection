package python.http;

import java.net.URL;
import java.net.HttpURLConnection;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;

import javax.net.ssl.HttpsURLConnection;

public class PythonHttpConnection {
	
	//private final String USER__AGENT = "Mozilla/5.0";
	
	public static void main(String[] args) throws Exception {

		    PythonHttpConnection http = new PythonHttpConnection();

	        System.out.println("Testing 1 - Send Http GET request");
	        http.sendGet();

	    }
		//HTTP GET request
		public static void sendGet() throws Exception {
			String url = "http://ruiiizumi.work:5000/ok-api";
		//	String url = "http://localhost:5000/ok-api";

	        URL obj = new URL(url);
	        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

	       //optional default is GET
	        con.setRequestMethod("GET");
	        
	      //add request header
	      //  con.setRequestProperty("User-Agent", USER__AGENT);

	        int responseCode = con.getResponseCode();
	        System.out.println("\nSending 'GET' request to URL : " + url);
	        System.out.println("Response Code : " + responseCode);

	        BufferedReader in = new BufferedReader(
	                new InputStreamReader(con.getInputStream()));
	        String inputLine;
	        StringBuffer response = new StringBuffer();

	        while ((inputLine = in.readLine()) != null) {
	            response.append(inputLine);
	        }
	        in.close();
	        
	      //print result
	        System.out.println(response.toString());

		}
}

	
