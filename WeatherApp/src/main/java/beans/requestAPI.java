package beans;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;

public class requestAPI {
	
	private static String apiKey = "4a975126ae125961022e8b621d97d23e";
	private String request = "api.openweathermap.org/data/2.5/weather?q={city name}&appid={API key}";
	
	private static JSONObject json = new JSONObject();
	
	private static HttpURLConnection  connection;


	public static JSONObject getRapport(String ville) {
		
		BufferedReader reader;
		String line;
		StringBuffer responseContent = new StringBuffer();
		
		try {
			URL url = new URL("https://api.openweathermap.org/data/2.5/weather?q="+ville+"&appid="+apiKey);
			connection = (HttpURLConnection) url.openConnection();
			
			connection.setRequestMethod("GET");
			connection.setConnectTimeout(5000);
			connection.setReadTimeout(5000);
			
			int status = connection.getResponseCode();
			
			if(status > 299) {
				reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
				while((line = reader.readLine()) != null) {
					responseContent.append(line);
				}
				reader.close();
			}else {
				reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				while((line = reader.readLine()) != null) {
					responseContent.append(line);
				}
				reader.close();
			}
			
			String str = responseContent.toString();  
			JSONObject json = new JSONObject(str);
			
			return json;
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			connection.disconnect();
		}
		return json;
		
		
		
	}
	
}
