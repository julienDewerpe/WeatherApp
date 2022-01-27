package beans;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import datatype.DateType;
import datatype.HumidityType;
import datatype.LocationType;
import datatype.TemperatureType;
import datatype.WeatherType;
import datatype.WindType;

public class rapportMeteo {
	
	private JSONObject json = new JSONObject();
	
	public rapportMeteo(JSONObject json){
		this.json = json;
	}
	
	public HumidityType getInJsonHumidity() throws JSONException {
		JSONObject main = json.getJSONObject("main");
		double humidity = main.getDouble("humidity");
		HumidityType humidityType = new HumidityType(humidity);
		return humidityType;
	}
	
	public TemperatureType getInJsonTemperature() throws JSONException {
		JSONObject main = json.getJSONObject("main");
		double temp = main.getDouble("temp");
		double feels = main.getDouble("feels_like");
		TemperatureType temperatureType = new TemperatureType(temp, temp, feels, feels);
		return temperatureType;
	}
	
	public DateType getDate() {
		DateType laDate = new DateType();
		return laDate;
	}
	
	public WindType getInJsonWind() throws JSONException {
		JSONObject wind = json.getJSONObject("wind");
		double speed = wind.getDouble("speed");
		double degree = wind.getDouble("deg");
		WindType windType = new WindType(degree, speed);
		return windType;
	}
	
	public LocationType getInJsonLocation() throws JSONException {
		String name = json.getString("name");
		JSONObject sys = json.getJSONObject("sys");
		String country = sys.getString("country");
		JSONObject coord = json.getJSONObject("coord");
		double lon = coord.getDouble("lon");
		double lat = coord.getDouble("lat");
		LocationType location = new LocationType(name, country, lon, lat);
		return location;
	}
	
	public WeatherType getInJsonWeather() throws JSONException {
		JSONArray weather = json.getJSONArray("weather");
		JSONObject jsonWeather = (JSONObject) weather.get(0);
		String main = jsonWeather.getString("main");
		String desc = jsonWeather.getString("description");
		String icon = jsonWeather.getString("icon");
		WeatherType weatherType = new WeatherType(main, desc, icon);
		return weatherType;
		
	}
	
}
